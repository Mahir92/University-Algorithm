package numerical;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Jacobi {

	
	void jacobiIteration(){
		float key=0;
		float sum;
		float X0[]=new float[N+1];
		
		for(int i=1;i<=N;i++)
			X0[i]=B[i]/A[i][i];
		
		while(true){
			
			key=0;
			
		for(int i=1;i<=N;i++){
			sum=B[i];
			
			for(int j=1;j<=N;j++){
				
				if(j!=i)
					sum-=A[i][j]*X0[j];
					
			}//for j
			
			X[i]=sum/A[i][i];
			
			
			if(key==0){
				
				if(Math.abs( (X[i]-X0[i]))/X[i]>0.000001)
					key=1;
			}//if
				
		}//for repeat i
		
			if(key==1)
				for(int i=1;i<=N;i++)
				X0[i]=X[i];
			
			else break;
		}//while	
			
	}//jacobi
	void GaussSiedel(){
		float key=0;
		float sum,temp;
		float X0[]=new float[N+1];
		
		for(int i=1;i<=N;i++)
			X[i]=B[i]/A[i][i];
		
		while(true){
			
			key=0;
			
		for(int i=1;i<=N;i++){
			sum=B[i];
			
			for(int j=1;j<=N;j++){
				
				if(j!=i)
					sum-=A[i][j]*X[j];
					
			}//for j
			
			temp=sum/A[i][i];
			
			
			if(key==0){
				
				if(Math.abs( (temp-X[i]))/temp>0.00001)
					key=1;
				X[i]=temp;
			}//if
				
		}//for repeat i
		
			if(key!=1)
				//for(int i=1;i<=N;i++)
				//X0[i]=X[i];
				break;
		}//while	
			
	}//jacobi
	void takeInput(String fileName){
		
		try {
			Scanner sc=new Scanner(new FileReader(fileName));
			//System.out.print("Enter  number  of equation: ");
			N=sc.nextInt();
			
			A=new float[N+1][N+1];//augmented matrix holding the coefficients
			B=new float[N+1];//right hand side constant matrix
			X=new float[N+1];
			
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++)
					A[i][j]=sc.nextFloat(); 
			
			for(int i=1;i<=N;i++)
				B[i]=sc.nextFloat();
			//now ta
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//try
		
		
	}

	public static void main(String []args){
		Jacobi j=new Jacobi();

		j.takeInput("jacobi.input");
	//	j.printX();
		
		//j.printMatrix();
		//j.printB();
		
		//j.jacobiIteration();
		j.GaussSiedel();
		j.printX();
	}
	
	
	void printMatrix(){
		for(int i=1;i<=N;i++){
		for(int j=1;j<=N;j++)
			System.out.print(A[i][j]+" ");
		System.out.println();
		}//for
	}//pritn

	void printB(){
		for(int i=1;i<=N;i++)
			System.out.println(B[i]);
	}
	
	void printX(){
		System.out.println("REsults");
		for(int i=1;i<=N;i++)
			System.out.println(X[i]);

	}
	float A[][],B[],C[],X[];
	int N;
}
