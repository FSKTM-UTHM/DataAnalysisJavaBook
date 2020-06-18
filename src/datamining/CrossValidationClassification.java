package datamining;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClassifier;
import weka.classifiers.functions.SMO;

public class CrossValidationClassification {

	public static void main(String[] args) {
		try {

			// Loading iris training data set
			Dataset dataset = FileHandler.loadDataset(new File("datasets/lung-cancer.data"), 56, ",");

			// Initiating a SVM classifier
			SMO smo = new SMO();

			// Building a SVM classifier using wrapping Weka bridge
			Classifier javaMLsvm = new WekaClassifier(smo);

			/* Initialize cross-validation */
			CrossValidation cv = new CrossValidation(javaMLsvm);
			/* Perform cross-validation */
			Map<Object, PerformanceMeasure> performanceEval = cv.crossValidation(dataset);

			// Print evaluation results for each Class
			System.out.println("...Performance Evaluation...");

			for (Entry<Object, PerformanceMeasure> entry : performanceEval.entrySet()) {
				System.out.println("Class : " + entry.getKey() + entry.getValue());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
