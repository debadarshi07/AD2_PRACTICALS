package Graphs;
import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class GraphRepresentation {
	
	public static class Edge {
		int src,dist,weight;
		
		Edge(int src,int dist,int weight){
			this.src=src;
			this.dist=dist;
			this.weight=weight;
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		
		for(int i=0;i<graph.length;i++) 
			graph[i]=new ArrayList<Edge>();
		
		
		graph[0].add(new Edge(0,2,2));
		
		graph[1].add(new Edge(1,2,10));
		graph[1].add(new Edge(1,3,9));
		
		graph[2].add(new Edge(2,0,2));
		graph[2].add(new Edge(2,1,7));
		graph[2].add(new Edge(2,3,-1));
		
		graph[3].add(new Edge(3,1,3));
		graph[3].add(new Edge(3,2,-2));
		
	}
	public static void main(String[] args) {
	
		int vertices=4;
		
		ArrayList<Edge> graph[]=new ArrayList[vertices];
		createGraph(graph);
		
		for(int i=0;i<vertices;i++) {
			for(int j=0;j<graph[i].size();j++) {
				Edge e=graph[i].get(j);
				System.out.println(e.src+"-->"+e.dist+"	Weight:"+e.weight);
			}
			System.out.println();
		}
	}
}
