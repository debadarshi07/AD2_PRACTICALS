package Graphs;
import java.util.ArrayList;

public class PrintAllPaths {
	public static class Edge {
		int src,dist;
		Edge(int src,int dist){
			this.src=src;
			this.dist=dist;
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) 
			graph[i]=new ArrayList<Edge>();
	
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		
//		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		
//		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		
//		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));
		
//		graph[4].add(new Edge(4,2));
//		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		
//		graph[5].add(new Edge(5,3));
//		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
		
//		graph[6].add(new Edge(6,5));
	}
	
	public static void printAllPaths(ArrayList<Edge> graph[],int current,int destination,boolean visited[],String path) {
		if(current==destination) System.out.println(path);
		
		for(int i=0;i<graph[current].size();i++) {
			Edge e=graph[current].get(i);
			if(!visited[e.dist]) {
				visited[e.dist]=true;
				printAllPaths(graph,e.dist,destination,visited,path+e.dist);
				visited[current]=false;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int vertices=7;
		
		ArrayList<Edge> graph[]=new ArrayList[vertices];
		createGraph(graph);
		
		boolean visited[]=new boolean[vertices];
		int source=1,destination=6;
		printAllPaths(graph,source,destination,visited,String.valueOf(source));	
	}
}