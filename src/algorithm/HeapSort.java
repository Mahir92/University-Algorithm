package algorithm;

public class HeapSort {
	
	int A[]={15,18,-1,1,14,10,8,7,9,3,2,4,16,15};//array to be sorted
	int heapSize=A.length-1;//heapsize
	
	void maxHeapify(int i){
		int l=left(i);//left child
		int r=right(i);//right child
		int largest;
	
		if(l<=heapSize && A[l]>A[i])
			largest=l;
		else
			largest=i;
		
		if(r<=heapSize && A[r]>A[largest])
			largest=r;
		
		if(largest!=i){
			
			//swap
			int temp=A[i];
			A[i]=A[largest];
			A[largest]=temp;
			
			maxHeapify(largest);
		}//if
		
		
	}
	
	int left(int i){
		return i<<1;
	}
	
	int right(int i){
		return (i<<1)+1;
	}
	
	
	void buildMaxHeap(){
		
		for(int i=(A.length-1)>>1 ;i>=0;i--)
			maxHeapify(i);
		
	}//build max heap
	
	
	
	void heapSort(){
	
//	void heapSort(int A[]){
		buildMaxHeap();//build the max heap property
		
		for(int i=A.length-1;i>=1;i--){
			//swap(a[1],a[i])
			int temp=A[0];
			A[0]=A[i];
			A[i]=temp;
			
			
			heapSize--;
			maxHeapify(0);
		}//for
		print(A);
	}//heap sort
	
	
	public static void main(String[] args){
		
		HeapSort hs=new HeapSort();
		hs.heapSort();
		
	}//main
	
	
	void print(int a[]){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}//print

}//class
