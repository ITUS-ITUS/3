/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author TEST
 */
public class Q6kmeans {
    public static void main(String[] args) throws Exception {
         try{
            DataSource ds = new DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            SimpleKMeans model = new SimpleKMeans();
            model.setNumClusters(3);
            model.setSeed(10);
            model.buildClusterer(data);
            
             System.out.println("Cluster Centroids");
             Instances centroids = model.getClusterCentroids();
             for(int i = 0;i < centroids.numInstances();i++){
                 System.out.println("Clusters"+i+"Centroids:"+centroids.instance(i));
             }
             System.out.println("Cluster Assignment ");
             for(int i = 0;i < centroids.numInstances();i++){
                 int cluster = model.clusterInstance(data.instance(i));
                 System.out.println("Instance"+(i+1)+"->Cluster"+cluster);
             }
         }catch(Exception e){
                     e.printStackTrace();
                     }
         
    }
    
}
