package algorithm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BellmanFord {
	

	public static void main (String []args){
		BellmanFord bf=new BellmanFord();
		bf.takeInput("bellmanFord.input");
		int source=1;			//or take user input
		
		if(bf.bellManFord(source))//if path is exists print all the distance from source
		{
			System.out.println("node\tdistance from source ("+source+")");
			for(int i=1;i<=bf.node;i++)
				System.out.println(i+"\t\t"+bf.d[i]);
		}//if
	
	}//main
	
	
	boolean bellManFord(int source){
		initializeSingleSource(source);
		
		for (int i = 1; i <= node - 1; i++){
			
        for (int j = 1; j <= edge; j++)
            relax(edges[j].u, edges[j].v,edges[j].w);         
            
        }//i loop
	
	for(int i=1;i<=edge;i++)
            if (d[edges[i].u] + edges[i].w < d[edges[i].v])
               return false;		//no path 
	
	
	return true;	
	}//bellman
	
	
	void relax(int u,int v,int w){
		if(d[u]+w<=d[v]){
			d[v]=d[u]+w;
			parent[v]=u;
		}//if
	}//relax
	
	void initializeSingleSource(int s){
		for(int v=1;v<d.length;v++){
			d[v]=INFINITY;
			parent[v]=NIL;		//nil=-1
		}
		d[s]=0;					//source to source distance is 0
	}//init
	
	/**takes user input and creates the graph**/
	void takeInput(String fileName){
		Scanner sc=null;
		try {
			sc=new Scanner(new FileReader(fileName));
			//sc=new Scanner(System.in);//remove comment of this line to get input from keyboard otherwise input will be taken from fileName
		} catch (FileNotFoundException e){ 
			System.out.println("file not found "+fileName); 
			}
		
		/******take integer inputs from file**/
		
		node=sc.nextInt();		//take number of nodes
		edge=sc.nextInt();		//number of edges in the graph
		
		edges=new Edge[edge+1];		//for simplicity index starts from 1
		d=new int[node+1];
		parent=new int[node+1];
		
		
		for(int i=1;i<=edge;i++){
			edges[i]=new Edge();
			edges[i].u=sc.nextInt();
			edges[i].v=sc.nextInt();
			edges[i].w=sc.nextInt();
		}//for
		
	}//takeInput
	
	
	/** a helper class that represents a weighted edge of a graph**/
	class Edge{
		int u;
		int v;
		int w;//weight of the edge
		
	}//class
	
	int edge;//num of edges
	int node;//num of nodes/vertex
	Edge edges[];//structure array of edge
	int d[];//distance array represents distance from source
	static final int INFINITY=Integer.MAX_VALUE;
	static final int NIL=-1;
	int parent[];
}//class
