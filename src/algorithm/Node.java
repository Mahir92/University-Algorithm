package algorithm;

import static algorithm.KnightMoves.col;
import static algorithm.KnightMoves.grid;
import static algorithm.KnightMoves.row;

import java.util.ArrayList;
import java.util.Stack;

public class Node {
	int i;
	int j;
	int color;
	int distance;
	boolean hasTree;
	Node parent;
	public ArrayList<Node> adjacentMoves;

	
	public Node(int i,int j,int color,int distance,Node parent){
		adjacentMoves=new ArrayList<Node>();
		this.i=i;
		this.j=j;
		this.color=color;
		this.distance=distance;
		this.parent=parent;
	}

	public void calculatePossibleMoves() {
		//8 moves possible.if not outside the board
		//left
		if(j-2>=0)
		{
			if(i-1>=0 && !grid[i-1][j-2].hasTree)//up
				adjacentMoves.add(grid[i-1][j-2]);
			if(i+1<row && !grid[i+1][j-2].hasTree)//down
				adjacentMoves.add(grid[i+1][j-2]);
		}
		
		//right
		if(j+2<col)
		{
			if(i-1>=0 && !grid[i-1][j+2].hasTree)//up
				adjacentMoves.add(grid[i-1][j+2]);
			
			if(i+1<row && !grid[i+1][j+2].hasTree)//down
				adjacentMoves.add(grid[i+1][j+2]);
	
		}
		
		//up
		
		
		if(i-2>=0)
		{
			if(j-1>=0 && !grid[i-2][j-1].hasTree)//left
				adjacentMoves.add(grid[i-2][j-1]);
			if(j+1<col && !grid[i-2][j+1].hasTree)//right 
				adjacentMoves.add(grid[i-2][j+1]);
		}
		
		//down
				if(i+2<row)
				{
					if(j-1>=0 && !grid[i+2][j-1].hasTree)//left
						adjacentMoves.add(grid[i+2][j-1]);
					if(j+1<col && !grid[i+2][j+1].hasTree)//right
						adjacentMoves.add(grid[i+2][j+1]);
			
				}
			
		
		
	}//calc move
	
	/**prints the path from the source to this node**/
	 void printPath(Node source){
		if(source==this)//source and dest. same
			System.out.println("Source and destination same");
		else if(parent==null)//no path from destination//couldnt reach this node
			System.out.println("no path from source");
		else
		{
			Stack<Node> s=new Stack<Node>();
			Node p=this;
			while(p.parent!=null){
				s.push(p);
				p=p.parent;
				
			}
			
			while(!s.isEmpty()){
				p=s.pop();
				System.out.println(p.i+" "+p.j);
			}
			
		}
	}
}
