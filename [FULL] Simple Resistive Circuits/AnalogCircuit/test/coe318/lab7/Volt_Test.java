package coe318.lab7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Volt_Test {

    private Node_lab7 no1;
    private Node_lab7 no2;
    private Volt_Source volt_s;

    @BeforeEach
    public void setUp() {
        no1 = new Node_lab7();
        no2 = new Node_lab7();
        volt_s = new Volt_Source(10.0, no1, no2);
    }

    @Test
    public void testCons() {
        assertNotNull(volt_s, "VSource should be created");
        assertEquals(1.0, volt_s.voltage_v, 0.01, "Voltage should be 1.0");
        assertSame(no1, volt_s.getAllNodes()[0], "Node 1 same");
        assertSame(no2, volt_s.getAllNodes()[1], "Node 2 same");
    }

    @Test
    public void testGetNo() {
        Node_lab7[] nodes = volt_s.getAllNodes();
        assertNotNull(nodes, "Nodes array not null");
        assertEquals(2, nodes.length, "Nodes array -> 2 elements");
        assertSame(no1, nodes[0], "First node = node1");
        assertSame(no2, nodes[1], "Second node = node2");
    }

    @Test
    public void testToString() {
        String expected = "V1 " + no1 + " " + no2 + " DC  1.0.";
        assertEquals(expected, volt_s.toString(), "toString should match");
    }

    @Test
    public void testToStringWithNegativeVoltage() {
        Volt_Source negativeVSource = new Volt_Source(-1.0, no1, no2);
        String expected = "V2 " + no1 + " " + no2 + " DC  -1.0.";
        assertEquals(expected, negativeVSource.toString(), "toString should match ");
    }

    @Test
    public void testIdIncrement() {
        Volt_Source vSource2 = new Volt_Source(10.0, new Node_lab7(), new Node_lab7());
        Volt_Source vSource3 = new Volt_Source(100.0, new Node_lab7(), new Node_lab7());
        
        String vs2toString=  vSource2.toString();
        String vs3toString = vSource3.toString();
        
        assertTrue(vs2toString.startsWith("V2"), "Second VSource ID V2");
        assertTrue(vs3toString.startsWith("V3"), "Third VSource ID V3");
    }
}
