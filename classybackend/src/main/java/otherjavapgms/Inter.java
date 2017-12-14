package otherjavapgms;

public interface Inter {
void show();
}

class Inter1 implements Inter{
	public void show(){
		System.out.println("sindhu");
	}
public static void main(String []args)
{
	Inter1 i=new Inter1();
	i.show();
}
}