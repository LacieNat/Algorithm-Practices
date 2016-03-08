import java.io.*;
import java.util.*;
import java.lang.Integer;

public class Solution {
    
    public static class Vertex {
        int index;
        int value;
        ArrayList<Edge> edges;
        
        public Vertex(int index, int value) {
            edges = new ArrayList<Edge>();
            this.index = index;
            this.value = value;
        }
        
        public void addEdge(int dest, int value) {
            edges.add(new Edge(dest, value));
        }
    }
    
    public static class Edge {
        int dest;
        int value;
        
        public Edge(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }
    }
    
    public static class MST {
        int numNodes;
        int numEdges;
        int sourceNode;
        int sum;
        HashSet<Vertex> visited;
        PriorityQueue<Vertex> notVisited;
        Vertex[] nodes;
        
        
        public MST(int numNodes, int numEdges) {
            this.numNodes = numNodes;
            this.numEdges = numEdges;
            sum = 0;
            
            visited = new HashSet<Vertex>();
            nodes = new Vertex[numNodes];
            populateVertex();
        }
        
        public void populatePQ() {
            notVisited = new PriorityQueue<Vertex>(11, new Comparator<Vertex>() {
               public int compare(Vertex v1, Vertex v2) {
                   
                   return new Integer(v1.value).compareTo(new Integer(v2.value));
               } 
            });
            
            for(int i=0; i<numNodes; i++) {
                notVisited.add(nodes[i]);
            }
        }
        
        public void populateVertex() {
            for(int i=0; i<numNodes; i++) {
                nodes[i] = new Vertex(i, Integer.MAX_VALUE);
            }
        }
        
        public void setSource(int source) {
            this.sourceNode = source;
        }
        
        public void addEdge(int src, int dest, int value) {
            nodes[src].addEdge(dest, value);
            nodes[dest].addEdge(src, value);
        }
        
        public void prim() {
            //set source node value to 0
            nodes[sourceNode].value = 0;
            visited.add(nodes[sourceNode]);
            populatePQ();
            
            //while not all nodes are in visited
            while(visited.size()!=numNodes) {
                Vertex v = notVisited.poll();
                sum+=v.value;
                ArrayList<Edge> adj = v.edges;
                
                for(Edge e: adj) {
                    if(!visited.contains(nodes[e.dest]) && e.value<nodes[e.dest].value){
                        nodes[e.dest].value = e.value;
                        notVisited.remove(nodes[e.dest]);
                        notVisited.add(nodes[e.dest]);
                    }
                }
                
                visited.add(v);
            }
            
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numNodes = sc.nextInt();
        int numEdges = sc.nextInt();
        
        MST mst = new MST(numNodes, numEdges);
        
        for(int i=0; i<numEdges; i++) {
            mst.addEdge(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt());
        }
        
        mst.setSource(sc.nextInt()-1);
        mst.prim();
    }
}