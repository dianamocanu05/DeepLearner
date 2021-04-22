import DataManipulation.PieceOfNews;
import javafx.util.Pair;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Statistics {
    private List<PieceOfNews> data;
    private DefaultCategoryDataset dataset;

    public Statistics(List<PieceOfNews> data) {
        this.data = data;
        this.dataset = new DefaultCategoryDataset();
    }

    private void createDataset() {

        Pair<Integer,Integer> pair = Utils.getCounts(data);
        dataset.addValue(pair.getKey(),"FAKE NEWS","1");
        dataset.addValue(pair.getValue(),"CORRECT NEWS","2");
    }

    public void createBarChart() throws IOException {
        createDataset();
        JFreeChart chart = ChartFactory.createBarChart("Distribution of data",
                "News", "Number", dataset, PlotOrientation.VERTICAL,
                true, true, false);
        ChartUtils.saveChartAsPNG(
                new File("files\\barchart.png"),
                chart,
                400,
                400
        );
    }
}
