package datavisualization;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

public class LineGraphClass extends JFrame {
	  private static final long serialVersionUID = 6294689542092367723L;

	  public LineGraphClass(String title) {
	    super(title);

	    // Creating dataset
	    XYDataset dataset = createDataset();

	    // Creating line chart
	    JFreeChart chart = ChartFactory.createTimeSeriesChart(
	    		"Yearly population growth comparison chart", 
		        "X-Axis", "Y-Axis", dataset,true, true, false );
	    
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
	    	LineGraphClass lineGraph = new LineGraphClass("Time Series Graph");
	    	lineGraph.setSize(1000, 600);
	    	lineGraph.setLocationRelativeTo(null);
	    	lineGraph.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    	lineGraph.setVisible(true);
	    });
	  }
	}
