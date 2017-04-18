package knightwargrid;

import java.util.LinkedList;


public class KnightMoves {
	private static final int WHITE = 1;
	private static final int GRAY = 2;
	private static final int BLACK = 3;
	
	public static Node grid[][];
	public static int R=3;
	public static int C=3;
	public static int M=2;
	public static int N=1;
	
	void go(){
		new LinkedList<Node>();
		int i,j;
		grid=new Node[R][C];//initialize the graph
		for(i=0;i<R;i++)
			for(j=0;j<C;j++)
				grid[i][j]=new Node(i,j,WHITE,null);//row,column,color,distance and parent
		
		//TAKE USER INPUT FOE TREE//for now sample io
		
		//grid[3][3].hasWater=true;
		//grid[1][1].hasWater=true;
		
		
		//set adjacent moves from a position there are 8 moves per position.at side and corner <8
		
		for(i=0;i<R;i++)
			for(j=0;j<C;j++)
				grid[i][j].calculatePossibleMoves();//creating adjacent vertices 
		
		
		//take user input
		 source=grid[0][0];//create the node
	
	}
	Node source;
	
	
	void tests(){
		
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				//if(grid[i][j].isOdd)
					//odd++;
				System.out.print(" "+grid[i][j].isOdd+" ");
			}
			System.out.println();
		}
		
		System.out.println("even "+even+" odd "+odd);
		
	}
	
	int odd=0;
	int even=0;
	
	void DFS(Node source){
		//for each vertex u in v[g] 
		//if color u is white then
		DFS_Visit(source);
	}//dfs
	
	void DFS_Visit(Node u){
		u.color=GRAY;
		for(int i=0;i<u.adjacentMoves.size();i++)
		{
			Node v=u.adjacentMoves.get(i);
			if(v.color==WHITE)
			{
				v.parent=u;
				DFS_Visit(v);
			}
			
			
		}
		u.color=BLACK;
		if(u.isOdd)
			odd++;
		else even++;
	}
	
	
	
	public static void main(String []args){
	
		KnightMoves km=new KnightMoves();
		//km.input();
		km.go();
		km.DFS(km.source);
		km.tests();
		
	}
	
}