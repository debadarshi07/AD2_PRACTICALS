package Graphs;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {
	public static class Edge{
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
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,5));
		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,5));
		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
		graph[6].add(new Edge(6,5));
	}
	
	public static void BFSconnected(ArrayList<Edge> graph[],int vertices) {
		
		Queue<Integer> q=new LinkedList<>();
		boolean visited[]=new boolean[vertices];
		q.add(0);
		
		while(!q.isEmpty()) {
			int current=q.remove();
			if(visited[current]==false) {
				System.out.print(current+" ");
				visited[current]=true;
				
				for(int i=0;i<graph[current].size();i++) {
					Edge e=graph[current].get(i);
					q.add(e.dist);
				}
			}
		}
	}
	
	public static void BFS(ArrayList<Edge> graph[],int vertices,boolean visited[],int start) {
		Queue<Integer> q=new LinkedList<>();
		
		q.add(start);
		while(!q.isEmpty()) {
			int current=q.remove();
			if(visited[current]==false) {
				System.out.print(current+" ");
				visited[current]=true;
				for(int i=0;i<graph[current].size();i++) {
					Edge e=graph[current].get(i);
					q.add(e.dist);
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int vertices=7;
		
		ArrayList<Edge> graph[]=new ArrayList[vertices];
		createGraph(graph);
		
		// Applicable for only connected graphs.
//		BFSconnected(graph,vertices);
		
		// Applicable for both disconnected and connected graphs.
		boolean visited[]=new boolean[vertices];
		for(int i=0;i<vertices;i++) {
			if(!visited[i]) 
				BFS(graph,vertices,visited,i);
		}
	}
}