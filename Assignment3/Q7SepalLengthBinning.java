/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import java.util.ArrayList;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author TEST
 */
public class Q7SepalLengthBinning {
    public static String covertSepalLength(double value) {
        if(value < 5.0){
            return "Short";
        }
        else if(value <= 6.5){
            return "Medium";
        }
        else{
            return "Tall";
        }
    }
    public static void main(String[] args) {
         try{
            DataSource ds = new DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            if(data.classIndex() == -1){
                data.setClassIndex(data.numAttributes() - 1);
            }
            ArrayList<String> cat = new ArrayList<>();
            cat.add("Short");
            cat.add("Medium");
            cat.add("Tall");
            Attribute sepalLengthCategory = new Attribute("sepalLengthCategory",cat);
            data.insertAttributeAt(sepalLengthCategory,1);
            
            for(int i=0;i<data.numInstances();i++){
                double sepallen = data.instance(i).value(0);
                String category = covertSepalLength(sepallen);
                data.instance(i).setValue(1,category);
            }
             System.out.println("Dataset with Sepal Length Category");
             for(int i=0;i<10;i++){
                 System.out.println(data.instance(i));
             }
         
         }catch(Exception e){
             e.printStackTrace();
         }
    } 
}
