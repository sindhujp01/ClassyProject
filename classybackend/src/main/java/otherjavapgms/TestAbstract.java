package otherjavapgms;
abstract class Fig{
	public void disp(){
		System.out.println("geometric figure");
	}
	abstract int area();
}
class Square extends Fig{
	int area()
	{
		int a=4;
		System.out.println("area of square is" + a*a);
		return a*a;
	}
}

class Rect extends Fig{
	int area()
	{
		int l=4,b=2;
		System.out.println("area of rect is" + l*b);
		return l*b;
	}
}
public class TestAbstract {
	public static void main(String args[]) {
		Fig f=new Square();
				f.area();
		Rect f1=new Rect();
//		f1.area();
		Fig ref;
		ref=f1;
		System.out.println("area is" + ref.area());
		
	}

}
