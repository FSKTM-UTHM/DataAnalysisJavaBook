package datavisualization;



import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

public class ScatterGraphClass extends JFrame {
	  private static final long serialVersionUID = 6294689542092367723L;

	  public ScatterGraphClass(String title) {
	    super(title);

	    // Generate readable dataset
	    XYDataset dataset = createDataset();

	    // Create chart
	    JFreeChart chart = ChartFactory.createScatterPlot(
	        "Yearly population growth comparison chart", 
	        "X-Axis", "Y-Axis", dataset);

	    
	    //Changing background color
	    XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(new Color(255,255,255));
	    XYItemRenderer renderer = plot.getRenderer();
	    
	    //changing the size of series shape
	    double size = 20.0;
	    double delta = size / 2.0;
	    Shape shape0 = new Rectangle2D.Double(-delta, -delta, size, size);
	    Shape shape1 = new Ellipse2D.Double(-delta, -delta, size, size);
	    Shape shape2 = new RoundRectangle2D.Double(-delta, -delta, size, size, size, size);
	    Shape shape3 = new Rectangle2D.Double(-delta, -delta, size, size);
	    
	    
	    renderer.setSeriesShape(0, shape0);
	    renderer.setSeriesShape(1, shape1);
	    renderer.setSeriesShape(2, shape2);
	    renderer.setSeriesShape(3, shape3);
	    renderer.setSeriesPaint(3, new Color(0,0,0));
	    
	    plot.setRenderer(renderer);
	    
	    // Creating Panel
	    ChartPanel panel = new ChartPanel(chart);
	    setContentPane(panel);
	  }

	  private XYDataset createDataset() {
	    XYSeriesCollection dataset = new XYSeriesCollection();

	    //population series
	    XYSeries series1 = new XYSeries("Malaysia");
	    series1.add(2011, 51.9);
	    series1.add(2012, 54.6);
	    series1.add(2013, 57.9);
	    series1.add(2014, 57);
	    series1.add(2015, 60.1);
	    series1.add(2016, 62.5);
	    series1.add(2017, 64.9);
	    series1.add(2018, 65.3);
	    series1.add(2019, 67.8);
	    series1.add(2020, 80.4);

	    dataset.addSeries(series1);
	    
	  //population series
	    XYSeries series2 = new XYSeries("Indonesia");
	    series2.add(2011, 70.5);
	    series2.add(2012, 80.1);
	    series2.add(2013, 87.2);
	    series2.add(2014, 94.5);
	    series2.add(2015, 101.4);
	    series2.add(2016, 107.4);
	    series2.add(2017, 112.8);
	    series2.add(2018, 118.2);
	    series2.add(2019, 122.9);
	    series2.add(2020, 123.4);
	    dataset.addSeries(series2);

	  //population series
	    XYSeries series3 = new XYSeries("Thailand");
	    series3.add(2011, 67.9);
	    series3.add(2012, 76.6);
	    series3.add(2013, 82.9);
	    series3.add(2014, 89);
	    series3.add(2015, 98.1);
	    series3.add(2016, 102.5);
	    series3.add(2017, 109.9);
	    series3.add(2018, 115.3);
	    series3.add(2019, 119.8);
	    series3.add(2020, 122.4);
	    dataset.addSeries(series3);
	    
	  //population series
	    XYSeries series4 = new XYSeries("Singapore");
	    series4.add(2011, 25.9);
	    series4.add(2012, 27.6);
	    series4.add(2013, 28.9);
	    series4.add(2014, 29);
	    series4.add(2015, 31.1);
	    series4.add(2016, 31.5);
	    series4.add(2017, 32.9);
	    series4.add(2018, 34.3);
	    series4.add(2019, 36.8);
	    series4.add(2020, 40.4);
	    dataset.addSeries(series4);
	    
	    return dataset;
	  }

	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	    	ScatterGraphClass scatterGraph = new ScatterGraphClass("Scatter Chart Example");
	    	scatterGraph.setSize(800, 400);
	    	scatterGraph.setLocationRelativeTo(null);
	    	scatterGraph.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    	scatterGraph.setVisible(true);
	    });
	  }
	}