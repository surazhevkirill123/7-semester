import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DrawingGraph extends JFrame {
    public DrawingGraph(String title, TreeMap<Double,Double> empiricalFunction) {
        super(title);

        // Create dataset
        XYDataset dataset = createDataset(empiricalFunction);

        // Create chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Эмпирическая функция распределения",
                "X-Axis", "Y-Axis", dataset);

        //Changes background color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255,228,196));

        List<Double> x = new ArrayList(empiricalFunction.keySet());
        List<Double> y = new ArrayList(empiricalFunction.values());
        Shape rectangle0 = new Rectangle2D.Double(x.get(0)-2, 0, 2, 0.0000001);
        XYShapeAnnotation shapeAnnotation0 = new XYShapeAnnotation(rectangle0, new BasicStroke(2.f), Color.GREEN);
        plot.addAnnotation(shapeAnnotation0);
        for (int i = 0; i < empiricalFunction.size()-1; i++) {
            Shape rectangle = new Rectangle2D.Double(x.get(i), y.get(i), x.get(i+1)-x.get(i), 0.0000001);
            XYShapeAnnotation shapeAnnotation = new XYShapeAnnotation(rectangle, new BasicStroke(2.f), Color.GREEN);
            plot.addAnnotation(shapeAnnotation);
        }
        Shape rectangleLast = new Rectangle2D.Double(x.get(x.size()-1), 1.0, 8, 0.0000001);
        XYShapeAnnotation shapeAnnotationLast = new XYShapeAnnotation(rectangleLast, new BasicStroke(2.f), Color.GREEN);
        plot.addAnnotation(shapeAnnotationLast);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset(TreeMap<Double,Double> empiricalFunction) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Значение функции");

        List<Double> x = new ArrayList(empiricalFunction.keySet());
        List<Double> y = new ArrayList(empiricalFunction.values());

        for(int i=0;i<empiricalFunction.size();i++){
            series.add(x.get(i),y.get(i));
        }
        dataset.addSeries(series);

        return dataset;
    }

    public static void doGraph(TreeMap<Double,Double> empiricalFunction) {
        SwingUtilities.invokeLater(() -> {
            DrawingGraph example = new DrawingGraph("Лаба1", empiricalFunction);
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}