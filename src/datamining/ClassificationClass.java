package datamining;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

import java.io.File;
import java.io.IOException;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;

public class ClassificationClass {

	public static void main(String[] args) {

		try {

			// Loading iris training data set
			Dataset trainingData = FileHandler.loadDataset(new File("datasets/iris.data"), 4, ",");

			// Initiating a kNN classifier that uses 3 neighbors to make a decision.
			Classifier kNearestNeighbors = new KNearestNeighbors(3);
			
			// Building a kNN classifier using training data
			kNearestNeighbors.buildClassifier(trainingData);

			// Loading iris testing data set
			Dataset testingData = FileHandler.loadDataset(new File("datasets/iris.data"), 4, ",");

			// Counters for correctly and misclassified instances. */
			int c_classified = 0, m_classified = 0;

			// Classify all testing data instances
			for (Instance instance : testingData) {
				Object predictedClass = kNearestNeighbors.classify(instance);
				Object realClass = instance.classValue();
				if (predictedClass.equals(realClass))
					c_classified++;
				else
					m_classified++;
			}

			// Print the evaluation results
			System.out.println("Correctly Classified  " + c_classified);
			System.out.println("Misclassified " + m_classified);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
