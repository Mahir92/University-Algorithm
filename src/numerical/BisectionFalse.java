package numerical;

/*Compare the result of Bisection method and Regula Falsi for same function. Which one is better and why? Briefly Describe."*/
public class BisectionFalse {
//x2-4x-10
	float f(float x){
		return x*x-4*x-10;
	}
	
	void bisection(){
		float x1=-2,x2=1,x0;
		int iteration=0;
		long startTime=System.nanoTime();
		while(true){
			
			x0=(x1+x2)/2;
			System.out.println(x0);
			iteration++;
			if(f(x1)*f(x0)<0)
				x2=x0;
			else if(f(x2)*f(x0)<0)
				x1=x0;
			
			else if(f(x1)*f(x0)==0)
				break;
			
		}//while
		
		System.out.println("bisection: root "+x0+" iteration "+iteration+" time "+(System.nanoTime()-startTime)+" ns");
	}//bisection
	
	void falsePosition(){
		
		float x1=-2,x2=-1,x0;
		int iteration=0;
		long startTime=System.nanoTime();
		
		while(true){
			
			x0=x1-f(x1)*(x1-x2)/(f(x1)-f(x2));
			iteration++;
			System.out.println(x0);
			if(f(x1)*f(x0)<0)
				x2=x0;
			else if(f(x2)*f(x0)<0)
				x1=x0;
			
			else if(f(x1)*f(x0)==0)
				break;
			
					
		}//while
		System.out.println("falsi    : root "+x0+" iteration "+iteration+" time "+(System.nanoTime()-startTime)+" ns");
		
	}
	
	public static void main (String []args){
		BisectionFalse bf=new BisectionFalse();
		bf.bisection();
		bf.falsePosition();
	}
	
}//class
