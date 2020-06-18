package datamining;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

import java.io.File;
import java.io.IOException;
import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

public class ClusteringClass {

	public static void main(String[] args) {
		try {

			// Loading iris training data set
			Dataset dataset = FileHandler.loadDataset(new File("datasets/iris.data"), 4, ",");

			// Initiate an instance of K-Means algorithm
			// The parameter 3 represents the number of clusters.
			Clusterer km = new KMeans(3);

			// Run the K-Mean Clustering model for the input data,
			// The returned will be an array of data partitions, each partition represents a
			// cluster
			Dataset[] clusters = km.cluster(dataset);
			for (Object cluster : clusters)
				System.out.println(cluster);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
