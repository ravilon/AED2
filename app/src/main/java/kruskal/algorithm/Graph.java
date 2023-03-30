package kruskal.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;
    
    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
    
    public List<Vertex> getVertices() {
        return vertices;
    }
    
    public List<Edge> getEdges() {
        return edges;
    }
    
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }
    
    public void addEdge(Edge edge) {
        edges.add(edge);
        // Adiciona a aresta aos vértices de origem e destino
        edge.getSource().addEdge(edge);
        edge.getDestination().addEdge(edge);
    }
    
    // Algoritmo de Kruskal
    public List<Edge> kruskalAlgorithm() {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        // Ordena as arestas pelo peso
        Collections.sort(edges, Comparator.comparingInt(Edge::getWeight));
        // Cria um conjunto para cada vértice
        List<List<Vertex>> disjointSets = new ArrayList<>();
        for (Vertex vertex : vertices) {
            List<Vertex> set = new ArrayList<>();
            set.add(vertex);
            disjointSets.add(set);
        }
        // Percorre as arestas ordenadas
        for (Edge edge : edges) {
            Vertex source = edge.getSource();
            Vertex destination = edge.getDestination();
            // Encontra o conjunto ao qual pertencem os vértices da aresta
            List<Vertex> sourceSet = null;
            List<Vertex> destinationSet = null;
            for (List<Vertex> set : disjointSets) {
                if (set.contains(source)) {
                    sourceSet = set;
                }
                if (set.contains(destination)) {
                    destinationSet = set;
                }
            }
            // Se os vértices estão em conjuntos diferentes, une os conjuntos
            if (sourceSet != destinationSet) {
                minimumSpanningTree.add(edge);
                sourceSet.addAll(destinationSet);
                disjointSets.remove(destinationSet);
            }
        }
        return minimumSpanningTree;
    }
}
