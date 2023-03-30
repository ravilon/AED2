/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kruskal.algorithm;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Cria os vértices
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        
        // Cria as arestas
        Edge ab = new Edge(a, b, 5);
        Edge ac = new Edge(a, c, 10);
        Edge bc = new Edge(b, c, 20);
        Edge bd = new Edge(b, d, 6);
        Edge cd = new Edge(c, d, 15);
        Edge ce = new Edge(c, e, 6);
        Edge de = new Edge(d, e, 8);
        
        // Cria o grafo
        Graph graph = new Graph();
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addEdge(ab);
        graph.addEdge(ac);
        graph.addEdge(bc);
        graph.addEdge(bd);
        graph.addEdge(cd);
        graph.addEdge(ce);
        graph.addEdge(de);
        
        // Encontra a árvore geradora mínima usando Kruskal
        List<Edge> minimumSpanningTree = graph.kruskalAlgorithm();
        
        // Imprime as arestas da árvore geradora mínima
        System.out.println("Árvore geradora mínima:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.getSource().getName() + " - " + edge.getDestination().getName() + " (" + edge.getWeight() + ")");
        }
    }
}
