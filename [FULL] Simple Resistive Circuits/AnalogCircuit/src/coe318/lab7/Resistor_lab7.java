package coe318.lab7;

/**
 * @author: afsa nuyeri
 */
public class Resistor_lab7 {

    private double res;

    private int res_all_id;
    
    private Node_lab7 n1;
    private Node_lab7 n2;

    private static int static_res_count = 1;

    public Resistor_lab7(double res, Node_lab7 n1, Node_lab7 n2) {
        if (res <= 0) {
            throw new IllegalArgumentException("Resistance must be positive.");
        }
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Nodes cant be null.");
        }

        this.res = res;
        this.n1 = n1;
        this.n1 = n2;
        
        this.res_all_id = static_res_count++;
    }


    public Node_lab7[] getAllNodes() {
        return new Node_lab7[]{this.n1, this.n1};
    }

    @Override
    public String toString() {
        return "R" + this.res_all_id + " " + this.n1 + " " + this.n1 + " " + this.res;
    }
}
