package algorithm.mstunchanged;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class MSTUnchanged {


		void go(){
			//node=7;//no of nodes
			//takeInput();
			
			takeInputFromFile("MSTUnchanged.input");
			System.out.println("\nminimum cost is "+prims());
			
			printMST();
			///update k,l first**/
			
			actualMST=t.clone();//save the previous answer/or real answer
			for(int i=1;i<node;i++){
					inMST[t[i][1]][t[i][2]]=true;
					inMST[t[i][2]][t[i][1]]=true;
			}
			
			int u=4;//scan for query
			int v=6;
			
			query(u,v);
			
			System.out.println("AFTER Query "+u+" "+v+" cost is	"+	prims());//after this t should be changed atleast in one index
			printMST();
			//System.out.println("ans is	"+checkChangedIndex());//now check which index of the answer array has changed the changed index cost is the result
			System.out.println("ans iss "+result());
		}//go
		
		int result(){
			int i;
			
			for( i=1;		inMST[t[i][1]][t[i][2]]==true || inMST[t[i][2]][t[i][1]]==true		;i++);
	//		System.out.println(i);
			return cost[t[i][1]][t[i][2]];
			
		}
		

		void query(int u,int v){
		//int u,v;
		
	
	/********delete the query node and do prims again************/		
			cost[u][v]=INFINITY;
			cost[v][u]=INFINITY;
			minCost=INFINITY;
		}//query
		
				void takeInputFromFile(String fileName){
			int edge;
			
			try {
				Scanner sc=new Scanner(new FileReader(fileName));
				
				//System.out.print("Enter number of Nodes :");
				node=sc.nextInt();//node number
				//System.out.println(node);
				
				//System.out.print("Enter number of Edges :");
				
				edge=sc.nextInt();//edge number
				//System.out.println(edge);
				
				
				
				//now initialize costs
				cost=new int[node+1][node+1]; //index starts from `1
				inMST=new boolean[node+1][node+1];

				
				for(int i=1;i<=node;i++)
					for(int j=1;j<=node;j++)
						cost[i][j]=INFINITY;
				
				
				for(int i=1;i<=node;i++)
					cost[i][i]=0; //own cost is 0
				
				
			//	System.out.println("Enter Edges with weights :");
				//now read from file
				int u,v,w;//first vertex,2nd vertex,cost/wieght
				for(int i=1;i<=edge;i++){
					u=sc.nextInt();//read the next int in the input file
					v=sc.nextInt();
					w=sc.nextInt();
				//	System.out.println(u+" "+v+" "+w);
					
					cost[u][v]=w;
					cost[v][u]=w;//undirected graph so vice versa connected
					
					
					
					if(w<minCost)
					{
						minCost=cost[u][v];
						k=u;
						l=v; //find these by looping while taking input
						
					}//if
					
				}//for
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}//input
		
		
		int prims(){
			
			t=new int[node][3];//answer array which holds the traversal 	

			minCost=cost[k][l];//the lowest weighted edge will always be in the mst
			
			t[1][1]=k; 
			t[1][2]=l; 
			
			
			
			int i,j,minIndex=-1;
			
			int near[]=new int[node+1];//keep tracks of the minimum cost vertices from the index vertex
			
			//create the near array
			for( i=1;i<=node;i++)
			
				if(cost[i][l]<cost[i][k]) //cheking if the edges from 1 and 6 which is minimum to their nearest
					near[i]=l;//that means  edge from 6 is less than theedge from 1 
				else 
					near[i]=k;
			
			//end for
			
			near[k]=0;
			near[l]=0; //we have already found near of 1 and 6 
			
			for(i=2;i<node;i++){
				
				//find the lowest cost vertex
				int minimumCost=INFINITY;
				
				for( j=1;j<=node;j++){
					
					if(near[j]!=0 && cost[j][near[j]]<minimumCost){ //find min cost index 
						
						minimumCost=cost[j][near[j]];//new minmum
						minIndex=j;//save it in another variable beacuse j will be always n after this loop
					
					}//if
					
					
				}//for
		
				j=minIndex;
				
				t[i][1]=j;
				t[i][2]=near[j];
				
			
				minCost=minCost+cost[j][near[j]];
				near[j]=0;
				
				
				//update the near array
				for(int k=1;k<=node;k++)
					
					if(near[k]!=0 && cost[k][j]<cost[k][near[k]])
						near[k]=j;
			}//for
			return minCost;
		}//prim
		
		
		void printMST(){
		
			for(int i=1;i<=node-1;i++)
				System.out.println(t[i][1]+" "+t[i][2]);
		}
		
		
		public static void main(String []args){
			new MSTUnchanged().go();
		}
	
		int [][]cost;
		
		int node,k,l;
		
		final int INFINITY=Integer.MAX_VALUE;
		int minCost=INFINITY;
		
		int t[][];//answer array
		
		int actualMST[][];
		boolean inMST[][];
}
