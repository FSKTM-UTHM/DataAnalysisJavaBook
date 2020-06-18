package datavisualization;



import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

public class PieChartClass extends JFrame {  
	  private static final long serialVersionUID = 6294689542092367723L;  
	  
	  public PieChartClass(String title) {  
	    super(title);  
	  
	    // Create dataset  
	    PieDataset dataset = createDataset();  
	  
	    // Create chart  
	    JFreeChart chart = ChartFactory.createPieChart(  
	        "Programming Languages Usage",  
	        dataset,  
	        true,   
	        true,  
	        false);  
	  
	    //Format Label  
	    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
	        " {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
	    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
	      
	    // Create Panel  
	    ChartPanel panel = new ChartPanel(chart);  
	    setContentPane(panel);  
	  }  
	  
	  private PieDataset createDataset() {  
	  
	    DefaultPieDataset dataset=new DefaultPieDataset();  
	    dataset.setValue("C", 4);
	    dataset.setValue("C++", 7);
	    dataset.setValue("Java", 42);
	    dataset.setValue("Python", 23);
	    dataset.setValue("R", 14); 
	    dataset.setValue("Other", 10);
	    return dataset;  
	  }  
	  
	  public static void main(String[] args) {  
	    SwingUtilities.invokeLater(() -> {  
	    	PieChartClass example = new PieChartClass("Pie Chart Example");  
	      example.setSize(800, 400);  
	      example.setLocationRelativeTo(null);  
	      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
	      example.setVisible(true);  
	    });  
	  }  
	}  