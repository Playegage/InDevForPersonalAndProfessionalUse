package extra_utils;

public class SimpleCalculatorBecauseReasons {
	public static void main(String[] args){
		double[] nums={4,24};
		String operation="3";//0=add 1=sub 2=multi 3=divide
		
		switch(operation){
			case"0":
				System.out.println("x+y="+((double)nums[0]+(double)nums[1]));
				break;
			case"1":
				System.out.println("x-y="+Math.abs((double)nums[0]-(double)nums[1]));
				break;
			case"2":
				System.out.println("x*y="+((double)nums[0]*(double)nums[1]));
				break;
			case"3":
				System.out.println("x/y="+((double)nums[0]/(double)nums[1]));
				break;
			case"4":
				break;
		}
		
	}
}
