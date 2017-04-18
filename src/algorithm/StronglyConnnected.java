package algorithm;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class StronglyConnnected {
	
	
	
		static final int WHITE=1;
		static final int GRAY=2;
		static final int BLACK=3;
		
		int G[][];//graph
		int G2[][];
		int node,edge,time;
		
		int color[];
		int f[],d[];
		int answer[];

		int count;
		
		void go(){
			takeInputFromFile("SCC.input");
		//	DFS();
			
			
			for(int i=1;i<=node;i++)
				color[i]=WHITE;
			
			for(int i=1;i<=node;i++)
				if(color[i]==WHITE)
					DFS_VISIT(i);
		
		//second DFS	
			
			DFS2();
		//	for(int i=1;i<=node;i++)
			//	System.out.println(answer[i]+" time "+f[i]);
			
			
		}//go
		
		void DFS2(){
			
			time=0;
			G=G2;//reverse edged graph
			int a[]=answer.clone();
			rear=node;
			for(int i=1;i<=node;i++)
				color[a[i]]=WHITE;
		
			int i;
			for( i=1;i<=node;i++)
				if(color[a[i]]==WHITE){
					DFS_VISIT(a[i]);
					count++;
					
					for(int j=1;j<=node;j++)
						if(color[j]==BLACK && found[j]==false){
							System.out.println(j);
							found[j]=true;
							
						}
					
		System.out.println();
				}
			
				
			System.out.println(count);
		
		}
		boolean found[];
		
		
		void DFS_VISIT(int u){
			color[u]=GRAY;
			time++;
			d[u]=time;
			
			for(int i=1;i<=node;i++){
				
				if(G[u][i]!=1)
					continue;
				
				int v=i;//for each vertex in adj[u]
				if(color[v]==WHITE)
					DFS_VISIT(v);
			}//for
			
			color[u]=BLACK;
			f[u]=time=time+1;
			answer[rear--]=u;
		}
		
		int rear;
		void takeInputFromFile(String fileName){
			/*G=new int[4][];
			for(int i=1;i<=edge;i++){
				int u=sc.nextInt();
				int v=sc.nextInt();
				G[u][v]=1;
				G2[v][u]=1;
			}*/
			try {
				Scanner sc=new Scanner(new FileReader(fileName));
				node=sc.nextInt();//node
				edge=sc.nextInt();///edge
				
				G2=new int[node+1][node+1];
				G=new int[node+1][node+1];
				color=new int[node+1];
				answer=new int[node+1];
				f=new int[node+1];
				d=new int[node+1];
				answer=new int[node+1];
				rear=node;
				found=new boolean[node+1];
				for(int i=1;i<=edge;i++){
					int u=sc.nextInt();
					int v=sc.nextInt();
					G[u][v]=1;
					G2[v][u]=1;
				}
					
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static void main(String args[]){
			new StronglyConnnected().go();
		}
		
		
	

}
