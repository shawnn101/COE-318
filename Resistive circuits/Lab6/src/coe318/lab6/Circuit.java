package coe318.lab6;
import java.util.ArrayList;

public class Circuit {
    private static Circuit instance = null;
    private ArrayList<Resistor> res;

    // Singleton pattern for Circuit class
    private Circuit() {
        res = new ArrayList<>();
    }

    public static Circuit getInstance() {
        if (instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    // Add a resistor to the circuit
    public void add(Resistor r) {
        res.add(r);
    }

    // String representation of the Circuit
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Resistor r : res) {
            sb.append(r).append("\n");
        }
        return sb.toString();
    }
}
