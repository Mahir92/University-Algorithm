package numerical;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GaussJordan {

	
void elimination(){
	float PIVOT,FACTOR,SUM;
	for(int k=1;k<=N-1;k++){
		
		PIVOT=A[k][k];
		/******
		 * return if status
		 *******/
		
		for(int i=k+1;i<=N;i++){
			FACTOR=A[i][k]/PIVOT;
			
			for(int j=k+1;j<=N;j++){
				A[i][j]=A[i][j]-FACTOR*A[k][j];  //???
				
			}//for
			
			B[i]=B[i]-FACTOR*B[k];
		}//for
	}//k loop
	///**********back substitution began************/
	X[N]=B[N]/A[N][N];
	
	for(int k=N-1;k>=1;k--){
		SUM=0;
		for(int j=k+1;j<=N;j++)
			SUM+=A[k][j]*X[j];
		
		X[k]=(B[k]-SUM)/A[k][k];
	}//k
	
}
	
void takeInput(String fileName){
	
	try {
		Scanner sc=new Scanner(new FileReader(fileName));
		//System.out.print("Enter  number  of equation: ");
		N=sc.nextInt();
		
		//System.out.println("\nInput coefficient row wise");
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


public static void main(String args[]){
		GaussJordan gauss=new GaussJordan();
		gauss.takeInput("Gauss.input");
		gauss.printMatrix();
		gauss.printB();
		gauss.elimination();
		
		//gauss.printMatrix();
		for(int i=1;i<=gauss.N;i++)
			System.out.println(gauss.X[i]);
	}//main
	
void printMatrix(){
	for(int i=1;i<=N;i++){
	for(int j=1;j<=N;j++)
		System.out.print(A[i][j]+" ");
	System.out.println();
	}//for
}//pritn

void printB(){
	for(int i=1;i<B.length;i++)
		System.out.println(B[i]);
}
/**number of equation**/
int N;
 float A[][];//augmented matrix
 float B[];
float X[];	
	
}
