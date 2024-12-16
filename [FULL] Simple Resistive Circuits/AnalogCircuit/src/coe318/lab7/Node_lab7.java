package coe318.lab7;

/**
 * 
 * @author: afsa nuyeri
 */
public class Node_lab7 {
   
    public static int id_all_cont = 0; 

    public int id_n_all;


    public Node_lab7() {
        this.id_n_all = id_all_cont; 
        id_all_cont++;              
    }
    
    @Override
    public String toString() {
        return " " + this.id_n_all;
    }
}
