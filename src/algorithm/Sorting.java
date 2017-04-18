package algorithm;

public class Sorting {
	

	
	public static void main(String []args){
		radixTest();
		//	mergeTest();
	}
	
	private static void radixTest(){
		RadixSort rs=new RadixSort();
		int a[]={0,
				 354
				,345
				,646
				,786
				,545
				};
		int d=3;//each element is 3 digits
		rs.radixSort(a, d);
	}
	
	private static void mergeTest() {
		Sorting sort=new Sorting();
		int a[]={10,5,2,4,7,1,3,2,6,4,10};
	
		
		long startTime=System.nanoTime();
		sort.mergeSort(a,0,a.length-1);
		
		System.out.println("total time needed "+(System.nanoTime()-startTime));
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]+"");
		
	}


	public  void mergeSort(int a[],int firstIndex,int lastIndex){
		int middleIndex=(firstIndex+lastIndex)>>1;//average   >>1 is same as /2 but faster
		
		if(firstIndex<lastIndex){//return condition or when merge operation should be 
		mergeSort(a,firstIndex,middleIndex);//sort the left part
		mergeSort(a,middleIndex+1,lastIndex);//sort the right part
		
		merge(a,firstIndex,middleIndex,lastIndex);
		}
	}//merge sort
	
	private void merge(int a[],int firstIndex,int middleIndex,int lastIndex){
		int l1=middleIndex-firstIndex+1;//length of the left array
		int l2=lastIndex-middleIndex;//lenght of the right array middle index is FLOORED so no +1;
		//now copy the contents of the arrray to two separate array i.e. devide
		int L[]=new int[l1+1];//for theory one is extra and another 1 is for an infinity number to be stored
		int R[]=new int[l2+1];
		
		for(int i=0;i<l1;i++)
			L[i]=a[firstIndex+i];
		
		for(int i=0;i<l2;i++)
			R[i]=a[middleIndex+i+1];
		
		
		//save a big number in 
		L[l1]=Integer.MAX_VALUE;
		R[l2]=Integer.MAX_VALUE;
		
		int i=0,j=0;//for theory index start from 1
		for(int k=firstIndex;k<=lastIndex;k++){
			if(L[i]<=R[j])//left element is smaller
				a[k]=L[i++];
			else
				a[k]=R[j++];
		}
	}

}
