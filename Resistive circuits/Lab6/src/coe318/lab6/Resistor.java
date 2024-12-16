package coe318.lab6;
public class Resistor {
    private double resistance;
    private Node node1, node2;
    private int id;
    private static int next_id = 1;  // Static variable to track the next resistor id

    // Constructor
    public Resistor(double res, Node n1, Node n2) {
        if (res <= 0) {
            throw new IllegalArgumentException("Resistance must be greater than 0.");
        }
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Nodes cannot be null.");
        }
        this.resistance = res;
        this.node1 = n1;
        this.node2 = n2;
        this.id = next_id++;
        Circuit.getInstance().add(this);  // Automatically adds to Circuit upon creation
    }

    // Returns an array of Nodes connected to the resistor
    public Node[] getNodes() {
        return new Node[]{node1, node2};
    }

    // String representation of the Resistor
    @Override
    public String toString() {
        return "R" + id + " " + node1 + " " + node2 + " " + resistance;
    }
}
