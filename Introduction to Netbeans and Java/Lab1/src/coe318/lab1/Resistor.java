/**
 * A Resistor models an ideal resistor that obeys Ohm's Law.
 *
 * @author Shawn Nuguid
 */
package coe318.lab1;

public class Resistor {
    //Instance (state) variables
    private double resistance_Val;
    private double voltage_Val;
    /**
     * @param resistance resistance in Ohms
     */

    public Resistor(double resistance) {
        // Set values of state variables
        this.resistance_Val = resistance;
        this.voltage_Val = 0.0;
        /**
         * Returns the value of the resistor in Ohms.
         * @return the resistance
         */
    }

    public double getResistance_Val() {
        return this.resistance_Val;
        /**
         * @return the resistance
         */
    }

    public double getVoltage_Val() {
        return this.voltage_Val;
        /**
         * @param voltage the voltage to set
         */
    }

    public void setVoltage_Val(double voltage) {
        this.voltage_Val = voltage;
        /**
         * @return the current
         */
    }

    public double getCurrent_Val() {
        return this.voltage_Val / this.resistance_Val; // I = V/R
        /**
         *
         * @param current the current to set
         */
    }

    public void setCurrent_Val(double current) {
        this.voltage_Val = current * this.resistance_Val; // V = IR
    }

    public double getPower_Val() {
        return this.voltage_Val * this.getCurrent_Val(); // P = VI
        /**
         *
         * @return the power
         */
    }

    public static void main(String[] args) {
        Resistor r1, r2;
        System.out.println("Creating a 50 Ohm resistor (r1)");
        r1 = new Resistor(50.0);
        System.out.println("Its resistance is " + r1.getResistance_Val() + " Ohms");
        System.out.println("Its current is " + r1.getCurrent_Val() + " Amps");
        System.out.println("Its voltage is " + r1.getVoltage_Val() + " Volts");
        System.out.println("Its power is " + r1.getPower_Val() + " Watts");

        System.out.println("Creating a 100 Ohm resistor (r2)");
        r2 = new Resistor(100.0);
        System.out.println("Its resistance is " + r2.getResistance_Val() + " Ohms");

        System.out.println("Setting r1's current to 2 Amps");
        r1.setCurrent_Val(2.0);
        System.out.println("Its current is " + r1.getCurrent_Val() + " Amps");
        System.out.println("Its voltage is " + r1.getVoltage_Val() + " Volts");
        System.out.println("Its power is " + r1.getPower_Val() + " Watts");

        System.out.println("Setting r1's voltage to 50 Volts");
        r1.setVoltage_Val(50.0);
        System.out.println("Its current is " + r1.getCurrent_Val() + " Amps");

        System.out.println("Setting r2's current to 3 Amps");
        r2.setCurrent_Val(3.0);
        System.out.println("Its voltage is " + r2.getVoltage_Val() + " Volts");
    }
}

