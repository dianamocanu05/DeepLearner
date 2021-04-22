import DataManipulation.PieceOfNews;
import javafx.util.Pair;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;


import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

public class Utils {
    public static final String SERIALIZED_FILE_PATH ="files\\articles.xml";
    public static final String VELOCITY_HTML_PATH = "web\\template.vm";
    public static final String REPORT_PATH = "web\\report.html";
    public static final String PDF_PATH = "files\\report.pdf";
    public static void serializeXML(List<PieceOfNews> news) throws FileNotFoundException {
        XMLEncoder encoder = null;
        encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_PATH)));
        encoder.writeObject(news);
        encoder.close();
    }

    public static Pair<Integer,Integer> getCounts(List<PieceOfNews> news){
        int fakeCount = 0;
        for(PieceOfNews pieceOfNews : news){
            if(pieceOfNews.getLabel() == 0){
                fakeCount++;
            }
        }
        return new Pair<>(fakeCount,news.size()-fakeCount);
    }

    public static void generateReport() throws IOException {
        String template = "web\\template.vm";
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("testData",Main.testDataCount);
        context.put("trainData",Main.trainDataCount);
        context.put("validData",Main.validDataCount);
        Writer writer = new FileWriter(new File(REPORT_PATH));
        Velocity.mergeTemplate(template,"UTF-8",context,writer);

        writer.flush();
        writer.close();
        System.out.println("Generated HTML report at "+ REPORT_PATH);
    }


}
