package DataManipulation;

public class PieceOfNews {
    private int id;
    private String title;
    private String author;
    private String text;
    private int label;

    public PieceOfNews(){};
    public PieceOfNews(int id, String title, String author, String text,int label) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.text = text;
        this.label = label;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLabel(int value){
        this.label = value;
    }

    public int getLabel(){
        return label;
    }


}
