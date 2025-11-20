/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author TEST
 */
public class Q1irisinfo {
    public static void main(String[] args) {
        try{
            DataSource ds = new DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            System.out.println("Data set relation name :"+data.relationName());
            System.out.println("Number of Instances :"+data.numInstances());
            System.out.println("Number of Attributes :"+data.numAttributes());
            if (data.classIndex() == -1){
                data.setClassIndex(data.numAttributes()-1);
            }
            System.out.println("Class Attribute :"+data.classAttribute().name());
            System.out.println("\n First 10 Instances");
            for(int i=0;i<10 && i<data.numInstances();i++){
                System.out.println((i+1)+" : "+data.instance(i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
