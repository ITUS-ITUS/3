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
public class Q5NaiveBayes {
    public static void main(String[] args) throws Exception {
         try{
            ConverterUtils.DataSource ds = new ConverterUtils.DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            if(data.classIndex() == -1){
                data.setClassIndex(data.numAttributes() - 1);
            }
            NaiveBayes nv = new NaiveBayes();
            nv.buildClassifier(data);
             SerializationHelper.write("naivebayes.model", nv);
             System.out.println("NaiveBased saved as naivebayes.model");
             
            
    }catch(Exception e){
        e.printStackTrace();
    }
    
}}
