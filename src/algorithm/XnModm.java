package algorithm;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class XnModm {

	 int []X,N,M,res;
	final int SIZE;
	
	float timeOn[];
	float timeOlogN[];
	
	
	float totalTimeOn;
	float totalTimeOlogN;
	
	String header="Input X^n%m                 "+"Result         "+"O(n) sec     "+"O(log n) sec \n";
	String total;
	
	public static void main (String args[]){
		new XnModm(1000).go();
	}//main	

	//main method
	void go(){
		
		generateRandom(50000, 1000000);//range of the random numbers	
		loadFromInputFile("inputXnModm.txt");//call it to load input from a textfile other 1000-num of 
											//input from file will be filled with random input 
		long startTime;
		
		for(int i=0;i<SIZE;i++){
			
			startTime=System.nanoTime(); //save start time
			moduloOn(X[i], N[i], M[i]);//calutule x^n mod m
			timeOn[i]=(System.nanoTime()-startTime)/1000000000.0f; //calculate time needed in seccond 
			
			startTime=System.nanoTime(); //save start time
			res[i]=(int)moduloOlogN(X[i], N[i], M[i]);//calutule x^n mod m
			timeOlogN[i]=(System.nanoTime()-startTime)/1000000000.0f; //calculate time needed 					
			
		}//for
		
		
		System.out.println(header);
		writeDataToFile();
		System.out.println(total);
	}//go


	//input size takes as a parameter
	public XnModm(int size){
		X=new int[size];
		N=new int[size];
		M=new int[size];
		res=new int[size];
		timeOn=new float[size];
		timeOlogN=new float[size];
		this.SIZE=size;
	}
	
	/* a function to compute (ab)%c */
	int moduloOn(int x,int n,int m){
	   
		// res is kept as long  because intermediate results might overflow in "int"
	    long  res = 1; 
	    for(int i=0;i<n;i++){
	        res *= x;
	        res %= m; // this step is valid because (a*b)%c = ((a%c)*(b%c))%c ?
	    }
	    
	    
	    return (int)res%m;
	}
	
	
	/* This function calculates (ab)%c */
	long moduloOlogN(long x,long n,long m){
	
		long result;
		if(n==2)
		return (x*x)%m;

		
		if(n==1)
		return x%m;
		
		if(n==0)
			return 1;

		if(n%2==1)//if b is odd
		return x*moduloOlogN(x,n-1,m)%m;

		else//b is even
			{
			result=moduloOlogN(x,n/2,m);
		return (int) (result*result %m);
			}//else

	}//logn

	
	/*************following functions are helper function***************/	

	
	void loadFromInputFile(String fileName){
		
		try {
			Scanner sc=new Scanner(new FileReader(fileName));
			
			int i=0;
			while(sc.hasNext()){
			
				 X[i]=sc.nextInt();
			
				 N[i]=sc.nextInt();
			
				 M[i]=sc.nextInt();
				
				 i++;
	//			System.out.println(x+"^"+n+" % "+m+" = "+moduloOlogN(x,n,m));
			
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//catch
	
	}
	
	
	void generateRandom(int min, int max){
		Random rand=new Random();
		
		int range=max-min+1;
		
		for(int i=0;i<SIZE;i++){
			 X[i]=rand.nextInt(range)+min;
			 N[i]=rand.nextInt(range)+min;
			 M[i]=rand.nextInt(range)+min;
			 
			}//for
		
	}//random


	void writeDataToFile(){
		BufferedWriter writer=null;
		try {
			FileWriter fileWriter=new FileWriter("XnModm.txt");
			
			 writer=new BufferedWriter(fileWriter);//buffered reader for efficient writing
			
			writer.write(header);
			writer.newLine();
			writer.newLine();
			 
			String line=null;
			
			
			for(int i=0;i<SIZE;i++){
				line=getFormatedString(i);
				
				System.out.println(line);
				writer.write(line);
				writer.newLine();
				totalTimeOn+=timeOn[i];
				totalTimeOlogN+=timeOlogN[i];
				
			
			}//for
			
			total="\n				    TOTAL  "+totalTimeOn+"s    "+totalTimeOlogN+"s";
			writer.write(total);
			writer.newLine();
		} catch (IOException e) {
				e.printStackTrace();
		}finally{ 
			try {
				writer.close();
			} catch (IOException e) { e.printStackTrace(); }
		}//finally
		
	}//write to file
	
	
	/** returns a String with alignment of every column for decoration**/	
	String getFormatedString(int i){
		
		String eqn=X[i]+"^"+N[i]+" % "+M[i];
		int len=eqn.length();
		for(int j=28;j>len;j--)
			eqn=eqn+" ";  //leave extra space to align the numbers in result column 
		
		
		String result=res[i]+"";
		len=result.length();
		
		for(int j=15;j>len;j--)//leaving 15 empty space for previous colum of result
			result+=" ";
				
		String On=String.format("%.8f",timeOn[i]);
		len=On.length();
		for(int j=14;j>len;j--)
			On+=" ";
		
		return eqn+result+On+String.format("%.8f", +timeOlogN[i]);
	}//format strin

		
}//class
