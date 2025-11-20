
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ML_java_2 {
    public static void main(String[] args) {
        try {
            ConverterUtils.DataSource ds = new  ConverterUtils.DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            if(data.classIndex()==-1){
                data.setClassIndex(data.numAttributes()-1);
            }
            
            J48 tree = new J48();
            tree.buildClassifier(data);
            
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(tree, data, 10, new Random(1));
            System.out.println("accuray"+String.format("%2f",eval.pctCorrect())+"%");
            
            double[][] confuse = eval.confusionMatrix();
            System.out.println("\n Confusion Matrix");
            for (int i = 0;  i<confuse.length; i++) {
                for (int j = 0; j < confuse[i].length; j++) {
                    System.out.print((int)confuse[i][j]+"\t");
                }
                System.out.println();
            }
            
            
        } catch (Exception e) {
        }
    }
    
}
