package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			demo();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Dupa demo()");
		
	}
	
	public static void demo() throws Exception{
		System.out.println("Hello World...!");
		throw new ArithmeticException("This is not valid");
		//int i = 1/0;
		//System.out.println("Completed");
	}

}
