package knightwargrid;

import static knightwargrid.KnightMoves.C;
import static knightwargrid.KnightMoves.grid;
import static knightwargrid.KnightMoves.R;
import static knightwargrid.KnightMoves.M;
import static knightwargrid.KnightMoves.N;


import java.util.ArrayList;
import java.util.Stack;

public class Node {
	int i;
	int j;
	int color;
	boolean hasWater;
	Node parent;
	public ArrayList<Node> adjacentMoves;
	boolean isOdd;
//	private Number move;
	
	public Node(int i,int j,int color,Node parent){
		adjacentMoves=new ArrayList<Node>();
		this.i=i;
		this.j=j;
		this.color=color;
		this.parent=parent;
	}

//	public enum Number {	ODD,	EVEN;}
	public void calculatePossibleMoves() {
		//8 moves possible.if not outside the board
		//left
		if(j-M>=0)
		{
			if(i-N>=0 && !grid[i-N][j-M].hasWater)//up
				adjacentMoves.add(grid[i-N][j-M]);
			if(i+N<R && !grid[i+N][j-M].hasWater)//down
				adjacentMoves.add(grid[i+N][j-M]);
		}
		
		
		//right
		if(j+M<C)
		{
			if(i-N>=0 && !grid[i-N][j+M].hasWater)//up
				adjacentMoves.add(grid[i-N][j+M]);
			
			if(i+N<R && !grid[i+N][j+M].hasWater)//down
				adjacentMoves.add(grid[i+N][j+M]);
	
		}
		
		//up
		
		
		if(i-M>=0)
		{
			if(j-N>=0 && !grid[i-M][j-N].hasWater)//left
				adjacentMoves.add(grid[i-M][j-N]);
			if(j+N<C && !grid[i-M][j+N].hasWater)//right 
				adjacentMoves.add(grid[i-M][j+N]);
		}
		
		//down
				if(i+M<R)
				{
					if(j-N>=0 && !grid[i+M][j-N].hasWater)//left
						adjacentMoves.add(grid[i+M][j-N]);
					if(j+N<C && !grid[i+M][j+N].hasWater)//right
						adjacentMoves.add(grid[i+M][j+N]);
			
				}
			
		//calc if this node has odd or even number moves
		
		if(adjacentMoves.size()%2==0)
			isOdd=false;
		else isOdd=true;
		
	}//calc move
	

}