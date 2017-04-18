package numerical;

public class NewtonRaphson {

	//x2-3x+2
	static float f(float x){
		return x*x-3*x+2;
	}
		
	static float df(float x){
		return 2*x-3;
	}
	
	public static void main(String []args){
		float x1,x2;
		x1=0;//initial value fx1 must not be 0 
		
		while(true){
		
			
			x2=x1-f(x1)/df(x1);
			System.out.println("root is : "+x2);
			if(x2>=1.0f)
				break;
			x1=x2;
		}//while
		
		
	}
}
