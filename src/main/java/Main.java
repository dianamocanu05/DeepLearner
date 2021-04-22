import DataManipulation.ImportData;
import DataManipulation.PieceOfNews;
import server.Server;

import java.io.IOException;
import java.util.List;


public class Main {
    private static String trainPath = "data\\train.csv";
    private static String testPath = "data\\test.csv";
    public static int trainDataCount;
    public static int testDataCount;
    public static int validDataCount;

    public static void main(String[] args) throws Exception {
        ImportData importer = new ImportData(trainPath);
        importer.getData();
        List<PieceOfNews> trainData = importer.getArticles();
        System.out.println("TRAIN DATA : FOUND " + trainData.size() + " ARTICLES");
        trainDataCount =(int)(0.8* trainData.size());
        Statistics statistics = new Statistics(trainData);
        statistics.createBarChart();
        Utils.serializeXML(trainData);

        importer = new ImportData(testPath);
        importer.getData();
        List<PieceOfNews> testData = importer.getArticles();
        System.out.println("TEST DATA : FOUND " + testData.size() + " ARTICLES");
        testDataCount = testData.size();
        validDataCount =(int)(0.2 * testDataCount);

        Utils.generateReport();
        Server.run();
    }


}