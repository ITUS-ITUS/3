
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ml_java_1 {
    
    public static void main(String[] args) {
        try {
            
            DataSource ds = new DataSource("/Users/home/Downloads/java/data/iris.arff");
            Instances data = ds.getDataSet();
            
            System.out.println("dataset relation name:-"+data.relationName());
            System.out.println("dataset no of attribute:-"+data.numAttributes());
            System.out.println("dataset no of instances:-"+data.numInstances());
            if(data.classIndex()==-1){
                data.setClassIndex(data.numAttributes()-1);
            }
            System.out.println("dataset class attribute name:-"+data.classAttribute().name());
            System.out.println("First 10 instances");
            for (int i = 0; i < 10 && i<data.numInstances(); i++) {
                System.out.println((i+1)+":"+data.instance(i));
                
            }
            
            
            
        } catch (Exception e) {
        }
    }
    
    
    
}
