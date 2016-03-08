package MyProject;
/** 
 * package MyProject;
 * @author Igor
 *
 */

public class MyClass {

	String str;
	
	public MyClass(String s)
	{
		str = s;
	}

	public void setString(String s)
	{
		str = s;
	}
	
	public String getString()
	{
		return str;
	}
	
	public static void main(String[] args)
	{
		MyClass c1 = new MyClass("ABC"); 
		MyClass c2 = new MyClass("XYZ"); 
		System.out.println("c1:" + c1.getString());
		System.out.println("c2:" + c2.getString());

		System.out.println("-----------------");

		c1 = c2;
		System.out.println("c1:" + c1.getString());
		System.out.println("c2:" + c2.getString());

		System.out.println("-----------------");

		c1.setString("QRS");
		System.out.println("c1:" + c1.getString());
		System.out.println("c2:" + c2.getString());
	}
	
	
}
