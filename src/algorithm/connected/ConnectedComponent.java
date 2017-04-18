package algorithm.connected;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class ConnectedComponent {

	public static int WHITE=1;
	
	public static int GRAY=2;
	public static int BLACK=3;
	
	int G[][];
	int color[];
	int parent[];
	int n;
	
	void go(){
		
		takeInputFromFile("connectedComponent.input");
		//printGraph();
		System.out.println(DFS());
		
	}
	
	void takeInputFromFile(String fileName){
		int edge;
		try {
			Scanner sc=new Scanner(new FileReader(fileName));
			
			//System.out.print("Enter number of Nodes :");
			n=sc.nextInt();//node number
			G=new int[n+1][n+1];
			color=new int[n+1];
			parent=new int[n+1];
			
			
			edge=sc.nextInt();//edge number
			
			
			
			int u,v;
			for(int i=1;i<=edge;i++){
				u=sc.nextInt();
				v=sc.nextInt();
				
				G[u][v]=1;
				G[v][u]=1;
			}//for
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}//input

	


int DFS(){
	int count=0;
	for(int i=1;i<=n;i++)
		color[i]=WHITE;
	
	
	for(int i=1;i<=n;i++)
		if(color[i]==WHITE){
	DFS_Visit(i);
	count++;
		}
	
	return count;
}//dfs

void DFS_Visit(int u){
	color[u]=GRAY;
	
	for(int i=1;i<=n;i++)
	{	
		if(G[u][i]==0)
		continue;
		
		int v=i;//for each vertex in adj[u]
		if(color[v]==WHITE)
		{
			parent[v]=u;
			DFS_Visit(v);
		}
	
		
	}
	color[u]=BLACK;

}
public static void main(String []args){
	new ConnectedComponent().go();
	}

void printGraph(){
for(int i=1;i<=n;i++){
	for(int j=1;j<=n;j++)
		System.out.print(G[i][j]+" ");
	System.out.println();
}
}
}

