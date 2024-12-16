package coe318.lab7;

/**
 * @author: afsa nuyeri
 */
public class Volt_Source {
    
    double voltage_v;
    private static int static_count = 1;

    private int id_node_v;

    private Node_lab7 no1;
    private Node_lab7 no2;

    public Volt_Source(double voltage, Node_lab7 no1, Node_lab7 no2) {
        this.id_node_v = static_count;
        static_count++;     
        this.no1 = no1;    
        this.no2 = no2;         
        this.voltage_v = voltage;                        
    }

    public Node_lab7[] getAllNodes() {
        Node_lab7[] nodes = new Node_lab7[2];
        nodes[0] = this.no1;
        nodes[1] = this.no2; 
        return nodes;
    }

    @Override
    public String toString() {
        if (this.no1.id_n_all < this.no2.id_n_all) {
            return "V" + this.id_node_v + " " + this.no1 + " " + this.no2 + " DC  -" + this.voltage_v + ".";
        } else {
            return "V" + this.id_node_v + " " + this.no1 + " " + this.no2 + " DC  " + this.voltage_v + ".";
        }
    }
}
