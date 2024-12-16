package coe318.lab7;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author: afsa nuyeri
 */
public class MainPro implements Interface {

    String user_in = "";
    
    ArrayList<Object> circuit = new ArrayList<>();
    
    Scanner type_in = new Scanner(System.in);


    public void start_pro() {
        display_pro();  
        run_pro();  
    }


    public void run_pro() {
        while (true) {
            user_in = type_in.nextLine().trim();

            if (user_in.equalsIgnoreCase("end")) {
                end_pro();
                break;
            }
            else if (user_in.equalsIgnoreCase("spice")) {
                spice();
            }
            else {
                String[] value = user_in.split(" ");
                
                if (value.length != 4) {
                    System.out.println("Not Valid");
                } else {
                    if (user_in.toLowerCase().startsWith("v")) {
                        double user_v;
                        Node_lab7 no1 = new Node_lab7();
                        Node_lab7 no2 = new Node_lab7();
                        
                        no1.id_n_all = Integer.parseInt(value[1]);
                        no2.id_n_all = Integer.parseInt(value[2]);
                        user_v = Double.parseDouble(value[3]);

                        Volt_Source v = new Volt_Source(user_v, no1, no2);
                        circuit.add(v);
                    }
                    else if (user_in.toLowerCase().startsWith("r")) {
                        double user_r;
                        Node_lab7 n1 = new Node_lab7();
                        Node_lab7 n2 = new Node_lab7();
                        
                        n1.id_n_all = Integer.parseInt(value[1]);
                        n2.id_n_all = Integer.parseInt(value[2]);
                        user_r = Double.parseDouble(value[3]);
                        
                        Resistor_lab7 r = new Resistor_lab7(user_r, n1, n2);
                        circuit.add(r);
                    }
                }
            }
        }
    }

    public void display_pro() {
        System.out.println("Enter values:");
    }

    public void spice() {
        for (Object obj_in : circuit) {
            System.out.println(obj_in);
        }
    }


    public void end_pro() {
        System.out.println("All done");
    }

    public static void main(String[] args) {
        MainPro m = new MainPro();
        m.start_pro();
    }
}
