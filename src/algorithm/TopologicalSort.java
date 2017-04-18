package algorithm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TopologicalSort {

	static final int WHITE=1;
	static final int GRAY=2;
	static final int BLACK=3;
	
	int G[][];//graph
	int node,edge;
	int color[];
	int answer[];
	
	void go(){
		takeInputFromFile("topo.input");
		DFS();
		for(int i=1;i<=node;i++)
			System.out.println(answer[i]);
	}//go
	
	void DFS(){
		for(int i=1;i<=node;i++)
			color[i]=WHITE;
		
		for(int i=1;i<=node;i++)
			if(color[i]==WHITE)
				DFS_VISIT(i);
	}
	
	void DFS_VISIT(int u){
		color[u]=GRAY;
		
		for(int i=1;i<=node;i++){
			
			if(G[u][i]!=1)
				continue;
			
			int v=i;//for each vertex in adj[u]
			if(color[v]==WHITE)
				DFS_VISIT(v);
		}//for
		
		color[u]=BLACK;
		answer[rear--]=u;
	}
	
	int rear;
	void takeInputFromFile(String fileName){
		try {
			Scanner sc=new Scanner(new FileReader(fileName));
			node=sc.nextInt();//node
			edge=sc.nextInt();///edge
			
			G=new int[node+1][node+1];
			color=new int[node+1];
			answer=new int[node+1];
			rear=node;
			for(int i=1;i<=edge;i++){
				int u=sc.nextInt();
				int v=sc.nextInt();
				G[u][v]=1;
			}
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]){
		new TopologicalSort().go();
	}
	
	
}
