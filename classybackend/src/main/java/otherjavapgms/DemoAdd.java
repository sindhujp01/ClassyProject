package otherjavapgms;
class Inherit{
 int x;
 int y;
Inherit(int a,int b)
{
x=a;y=b;
}
int add()
{
return x+y;
}
}
class Demo extends Inherit{
	
public int z;
Demo(int a,int b,int c)
{
	super(a,b);
	z=c;
}

}

public class DemoAdd {
	public static void main(String args[])
	{
	Demo d1=new Demo(10,20,0);

	System.out.println("result:" + d1.add());
	System.out.println("value:" + d1.z);
	}
}
