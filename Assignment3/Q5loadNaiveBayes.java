/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author TEST
 */
public class Q5loadNaiveBayes {
    public static void main(String[] args) {
         try{
            ConverterUtils.DataSource ds = new ConverterUtils.DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            if(data.classIndex() == -1){
                data.setClassIndex(data.numAttributes() - 1);
            }
            NaiveBayes nv = (NaiveBayes)SerializationHelper.read("naivebayes.model");
            double classIndex = nv.classifyInstance(data.instance(0));
            String predictedClass = data.classAttribute().value((int)classIndex);
             System.out.println("First Instances :"+data.instance(0));
             System.out.println("Predicted Class :"+predictedClass);
                }catch(Exception e){
                e.printStackTrace();
            }
    }
    
}
