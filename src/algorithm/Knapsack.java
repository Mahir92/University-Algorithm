package algorithm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Knapsack {

	
	ProfitWeight[] o;
	
	void sortByRatio(){
		
		
		for(int i=1;i<o.length;i++){
			
			for(int j=2;j<o.length;j++)
			if(o[j].x>o[j-1].x)
			{
				ProfitWeight temp=o[j];
				
				o[j]=o[j-1];
				o[j-1]=temp;
				
			}//swap
		}//for
	}
	float sum;
	void knapsack(){
		
		
		int i,j;
		takeInputFromFile("input.txt");
//		print();
		sortByRatio();
		print();
		
		
		for(i=1;i<=n;i++)
			o[i].x=0;
		int u=m;
		
		for (i=1;i<=n;i++){
			if(o[i].w>u)
				break;
			
			o[i].x=1.0f;
			
			sum+=o[i].x*o[i].p;
			
			u=u-o[i].w;
			
			
		}///end for
		
		if(i<=n){
			o[i].x=u/(float)o[i].w;
			sum+=o[i].x*o[i].p;
		}
		
		System.out.println("\n\ncapacity m= "+m+" num of obj n= "+n+" profit= "+sum);
	}//go
	
	void print(){
		System.out.println("p    w");
		for(int i=1;i<o.length;i++)
			System.out.println(o[i].p+"   "+ o[i].w);

	}//print
	
	public static void main(String args[]){
		new Knapsack().knapsack();
	}
int m, n;

	void takeInputFromFile(String fileName){
		try {
			Scanner sc=new Scanner(new FileReader(fileName));
			
			m=sc.nextInt();
			n=sc.nextInt();
			
			o=new ProfitWeight[n+1];//n numbers of object
			
			
			for(int i=1;i<=n;i++)
				o[i]=new ProfitWeight(sc.nextInt(),sc.nextInt());
			
			o[0]=new ProfitWeight(32000,1);
			//obj[0].x=0;
			
						
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}//input

}
