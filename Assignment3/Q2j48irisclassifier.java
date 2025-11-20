/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import java.util.Random;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author TEST
 */
public class Q2j48irisclassifier {
    public static void main(String[] args) throws Exception {
        
    
     try{
            ConverterUtils.DataSource ds = new ConverterUtils.DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            if(data.classIndex() == -1){
                data.setClassIndex(data.numAttributes() - 1);
            }
            J48 tree = new J48();
            tree.buildClassifier(data);
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(tree, data, 10, new Random(1));
            System.out.println("Accuracy :"+String.format("%2f",eval.pctCorrect())+"%");
            
            double[][] confuse = eval.confusionMatrix();
            System.out.println("\n Confusion Matrix");
            for(int i = 0;i<confuse.length;i++){
                for(int j = 0;j < confuse[i].length;j++){
                    System.out.print((int)confuse[i][j]+"\t");
                }
                System.out.println();
            }
                
            
        }catch(Exception e){
        }
     
    }
}
