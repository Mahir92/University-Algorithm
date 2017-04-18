package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightMoves {
	private static final int WHITE = 1;
	private static final int GRAY = 2;
	private static final int BLACK = 3;
	private static final int INFINITY=Integer.MAX_VALUE;
	
	private Queue<Node> Q;
	public static Node grid[][];
	public static int row=5;
	public static int col=5;
	
	void go(){
		Q=new LinkedList<Node>();//create a queue to enque the vertice
		int i,j;
		grid=new Node[row][col];//initialize the graph
		for(i=0;i<row;i++)
			for(j=0;j<col;j++)
				grid[i][j]=new Node(i,j,WHITE,INFINITY,null);//row,column,color,distance and parent
		
		//TAKE USER INPUT FOE TREE//for now sample io
		
		grid[0][2].hasTree=true;
		grid[1][1].hasTree=true;
		grid[1][3].hasTree=true;
		grid[3][0].hasTree=true;
		grid[3][2].hasTree=true;
		grid[3][4].hasTree=true;
		
		
		//set adjacent moves from a position there are 8 moves per position.at side and corner <8
		
		for(i=0;i<row;i++)
			for(j=0;j<col;j++)
				grid[i][j].calculatePossibleMoves();//creating adjacent vertices 
		
		
		//print to check wheather position has successfully calculate the adjacent vertices
		//			for(int k=0;k<grid[4][4].adjacentMoves.size();k++){
			//			Node n=grid[0][4].adjacentMoves.get(k);
			//	System.out.print(n.i+""+n.j+" ");
			//	}		
		//take user input
		 source=grid[4][4];//create the node
		 home=grid[4][4];
		BFS(source);///bfs search		
		tests();
	}
	Node source;
	Node home;
	
	void tests(){
		/*int i,j;
				//prints distance
		for(i=0;i<row;i++){
			for(j=0;j<col;j++)
				System.out.print(grid[i][j].distance+" ");
			System.out.println();
		}//for*/		
				
	//	System.out.println("Knight "+source.i+" "+source.j+"\nhome "+home.i+" "+home.j+"\nMove needed: "+home.distance);
		if(home.distance>0 && home.distance<INFINITY)
			System.out.println("Yes. Knight can reach home in "+home.distance+" steps.the locations are :");
			home.printPath(source);//

	}
	
	void BFS(Node source){
		source.color=GRAY;//discovered
		source.distance=0;//distance from source to source is 0
		source.parent=null;//make the source parent nil
		
		Q.add(source);//enqueue source
		
		//dequeue unitil q is empty
		while(!Q.isEmpty()){
			Node u=Q.remove();//dequee
			//for each vertice v in adjacent u//in algo//the possible moves
			for(Node v:u.adjacentMoves){
				
				if(v.color==WHITE){
					v.color=GRAY;
					v.distance=u.distance+1;//distance[v]=distance[u]+1;
					v.parent=u;//parent[v]=u;
					Q.add(v);
				}//if
				
				u.color=BLACK;
			}//for 
			
		}//while
	}
	
	
	
	public static void main(String []args){
	
		KnightMoves km=new KnightMoves();
		//km.input();
		km.go();
		km.BFS(km.source);
		km.tests();
		
	}
	
	private void input(){
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Dimension of the grid : ");
		row=sc.nextInt();
		col=sc.nextInt();
		
		/** ***************initialize************/
		Q=new LinkedList<Node>();//create a queue to enque the vertice
		int i,j;
		grid=new Node[row][col];//initialize the graph
		for(i=0;i<row;i++)
			for(j=0;j<col;j++)
				grid[i][j]=new Node(i,j,WHITE,INFINITY,null);//row,column,color,distance and parent
		
	//set adjacent moves from a position there are 8 moves per position.at side and corner <8
		
		for(i=0;i<row;i++)
			for(j=0;j<col;j++)
				grid[i][j].calculatePossibleMoves();//creating adjacent vertices 
	
		
		
		//take tree input
		System.out.print("Enter number of Trees : ");
		int treeNum=sc.nextInt();
		
		System.out.println("Enter the postion of Trees :");
		
		for(int k=1;k<=treeNum;k++){
			i=sc.nextInt();
			j=sc.nextInt();
			
			grid[i][j].hasTree=true;
		}//for
		
		System.out.print("Enter Knight's postion : ");
		i=sc.nextInt();
		j=sc.nextInt();
		source=grid[i][j];
		/****** home*********/
		
		System.out.print("Enter Home postion : ");
		
		i=sc.nextInt();
		j=sc.nextInt();
		home=grid[i][j];
		
		
		
	}
	
	
}
