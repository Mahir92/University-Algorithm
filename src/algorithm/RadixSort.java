package algorithm;

public class RadixSort {
	
	/**A is the array to be sorted and d is the digits of each element in the array**/
	void radixSort(int a[],int d){
		print(a);
		int divider=1;
		int maxValue;//store the current column max digit
		
		for(int I=1;I<=d;I++){
			maxValue=0;
			int countA[]=new int[a.length];
			int countC[]=new int[10];//0-9 at most
			
			
			for(int i=1;i<a.length;i++){//elements of A
				
				int rem=(a[i]/divider)%10;//get the lsb 
				//now insert it i
				countA[i]=rem;
				countC[rem]++;
				
				if(rem>maxValue)//save the max value so c array doesnt have to iterate more
					maxValue=rem;
				
			}//for
			 divider*=10;//first time %10 2nd time %100 third %1000 to find the reminder
				a=countSort(countA,countC,a,maxValue);
				print(a);
		}//for
	}//radix Sort
	
	/** c array is taken for optimization**/
	int [] countSort(int a[],int c[],int mainA[],int maxValue){		
		int B[]=new int[a.length];
	
		for(int i=1;i<=maxValue;i++)
			c[i]=c[i]+c[i-1];
		
		
	
		for(int j=a.length-1;j>=1;j--){
			B[c[a[j]]]=mainA[j];
			//System.out.println("a[j] "+a[j]+" mainA[j] "+mainA[j]+" B "+c[a[j]]);
			c[a[j]]--;
		}
		
		//mainA=B;
	//	print(mainA);
		return B;
		
	}//count sort
	
	void print(int a[]){
		for(int i=1;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();

	}
}
