package DataManipulation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportData {
    private String path;
    private List<PieceOfNews> articles;

    public ImportData(String path) {
        this.path = path;
        this.articles = new ArrayList<>();
    }

    public void getData() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        int count = 0;
        while ((row = csvReader.readLine()) != null) {
            if (count != 0) {
                String[] data = row.split(",");
                if (data.length == 5) {
                    articles.add(getArticle(data));
                }
            }
            count++;
        }
        csvReader.close();
    }

    private PieceOfNews getArticle(String[] data) {
        PieceOfNews news = new PieceOfNews();
        try {
            news.setId(Integer.parseInt(data[0]));
        } catch (Exception e) {
            if (articles.size() == 0) {
                news.setId(0);
            } else {
                news.setId(articles.get(articles.size() - 1).getId() + 1);
            }
        }
        news.setTitle(data[1]);
        news.setAuthor(data[2]);
        news.setText(data[3]);
        try {
            news.setLabel(Integer.parseInt(data[4]));
        } catch (Exception e) {
            news.setLabel((int) (Math.random() * 1_000_00) % 2);
        }
        return news;
    }

    public List<PieceOfNews> getArticles() {
        return articles;
    }
}
