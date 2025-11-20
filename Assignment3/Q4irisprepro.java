/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.pmml.FieldMetaInfo;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author TEST
 */
public class Q4irisprepro {
    public static void main(String[] args) {
         try{
            ConverterUtils.DataSource ds = new ConverterUtils.DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            if(data.classIndex() == -1){
                data.setClassIndex(data.numAttributes() - 1);
            }
            System.out.println("Original dataset structure");
            System.out.println(data);
            System.out.println("Number of Instances :"+data.numInstances());
            System.out.println("Number of Attributes :"+data.numAttributes());
            
            Discretize dis = new Discretize();
                       
            dis.setBins(5);
            dis.setInputFormat(data);
            Instances disda = Filter.useFilter(data, dis);
            Remove rem = new Remove();
            rem.setAttributeIndices("1");
            rem.setInputFormat(disda);
            Instances finaldata = Filter.useFilter(disda, rem);
             System.out.println("Pre-Processed Dataset Structure :");
             System.out.println(finaldata);
             System.out.println("Number of Instances :"+finaldata.numInstances());
             System.out.println("Number of Attributes :"+finaldata.numAttributes());
            
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
}
