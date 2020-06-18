package datavisualization;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

public class BarGraphClass extends JFrame {  
	  
	  private static final long serialVersionUID = 1L;  
	  
	  public BarGraphClass(String appTitle) {  
	    super(appTitle);  
	  
	    // Create Dataset  
	    CategoryDataset dataset = createDataset();  
	      
	    //Create chart  
	    JFreeChart chart=ChartFactory.createBarChart(  
	        "Bar Chart Example", //Chart Title  
	        "Year", // Category axis  
	        "Population in Million", // Value axis  
	        dataset,  
	        PlotOrientation.VERTICAL,  
	        true,true,false  
	       );  
	  
	    ChartPanel panel=new ChartPanel(chart);  
	    setContentPane(panel);  
	  }  
	  
	  private CategoryDataset createDataset() {  
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
	  
	    // Population of different countries in 2005  
	    dataset.addValue(22, "Indonesia", "2005");
	    dataset.addValue(18, "Malaysia", "2005");
	    dataset.addValue(10, "Singapore", "2005"); 
	    dataset.addValue(20, "Thailand", "2005");  
	  
	    // Population of different countries in 2010  
	    dataset.addValue(32, "Indonesia", "2010");  
	    dataset.addValue(25, "Malaysia", "2010"); 
	    dataset.addValue(15, "Singapore", "2010"); 
	    dataset.addValue(25, "Thailand", "2010");  
	  
	    // Population of different countries in 2015  
	    dataset.addValue(45, "Indonesia", "2015");  
	    dataset.addValue(30, "Malaysia", "2015");  
	    dataset.addValue(18, "Singapore", "2015"); 
	    dataset.addValue(30, "Thailand", "2015");  
	  
	    return dataset;  
	  }  
	  
	  public static void main(String[] args) throws Exception {  
	    SwingUtilities.invokeAndWait(()->{  
	    	BarGraphClass example=new BarGraphClass("Bar Graph Example");  
	    	
	    	// size of window that will be appear for chart
	      example.setSize(800, 400);  
	      example.setLocationRelativeTo(null);  
	      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
	      example.setVisible(true);
	    });  
	  }  
	}  	