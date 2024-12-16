package coe318.lab7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Node_Test {

    @BeforeEach
    void resetId() {
        Node_lab7.id_all_cont = 0;
    }

    @Test
    public void testIncrement() {
        Node_lab7 test1 = new Node_lab7();
        Node_lab7 test2 = new Node_lab7();
        Node_lab7 test3 = new Node_lab7();

        // Verify that IDs are assigned incrementally
        assertEquals(1, test1.id_n_all, "First = 1");
        assertEquals(2, test2.id_n_all, "Second = 2");
        assertEquals(3, test3.id_n_all, "Third = 3");
    }

    @Test
    public void testToString() {
        Node_lab7 node_new = new Node_lab7();
        assertEquals(" 0", node_new.toString(), "output is incorrect");
    }

    @Test
    public void testNodeToString() {
        // Create multiple nodes
        Node_lab7 test11 = new Node_lab7();
        Node_lab7 test22 = new Node_lab7();
        Node_lab7 test33 = new Node_lab7();

        // Verify toString output for multiple nodes
        assertEquals(" 1", test11.toString(), "Node 1 toString() is incorrect");
        assertEquals(" 2", test22.toString(), "Node 2 toString() is incorrect");
        assertEquals(" 3", test33.toString(), "Node 3 toString() is incorrect");
    }
}
