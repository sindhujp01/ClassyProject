package otherjavapgms;

public class Student 
{
	int a;
	String name;
	public Student(int tej,String n){
		a=tej;
		name=n;
	}
	public String toString()//overriding tostring()
	{
		return a+ " "+name;
	}
	public static void main(String []args)
	{
		Student s=new Student(20,"sindhujp");
		Student s1=new Student(10,"sindhu");
		System.out.println(s);//compiler impicitly adds tostring
		System.out.println(s1.toString());
	}
	
	
	

}
