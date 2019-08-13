/**
 * GraphDriver.java
 *
 * 
 * COMP 2231 Assignment 5 Question 2
 *
 * Driver
 */
package assignment_5b;

public class GraphDriver {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("              GRAPH              ");
        System.out.println("=================================");

        Graph<String> graph = new Graph();

        System.out.println("-----------EMPTY GRAPH-----------");
        System.out.println();

        try {
            System.out.println("Is the Graph empty: " + graph.isEmpty());
            System.out.println("Size of Graph: " + graph.size());
            System.out.println("Is the Graph connected: " + graph.isConnected());
            graph.removeEdge(0, 1);
            graph.removeVertex(0);
        }//end try 
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }//end catch
        System.out.println();

        System.out.println("-----Adding Vertexes & Edges-----");
        System.out.println();

        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addEdge("0", "1");
        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "0");

        System.out.println(graph);
        System.out.println("Is the Graph empty: " + graph.isEmpty());
        System.out.println("Size of Graph: " + graph.size());
        System.out.println("Is the Graph connected: " + graph.isConnected());
        System.out.println();

        System.out.println("----Removing Vertexes & Edges----");
        System.out.println();

        graph.removeVertex(4);
        graph.removeEdge(0, 1);

        System.out.println(graph);
        System.out.println("Is the Graph empty: " + graph.isEmpty());
        System.out.println("Size of Graph: " + graph.size());
        System.out.println("Is the Graph connected: " + graph.isConnected());
        System.out.println();

        System.out.println("Get vertex 0: " + graph.getIndex("0"));
        System.out.println("Get vertex 2: " + graph.getIndex("2"));

        System.out.println("Is index 0 valid: " + graph.indexIsValid(0));
        System.out.println("Is index 1 valid: " + graph.indexIsValid(1));
        System.out.println("Is index 2 valid: " + graph.indexIsValid(2));
        System.out.println("Is index 3 valid: " + graph.indexIsValid(3));
        System.out.println("Is index 4 valid: " + graph.indexIsValid(4));
        
    }//end main
}//end GraphDriver
