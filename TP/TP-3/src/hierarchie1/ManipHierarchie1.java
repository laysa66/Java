package hierarchie1;

public class ManipHierarchie1 {
	public static void main(String[] args) {
		A a=new B();
		//B b=new A();
		a=new A();
		a.m1();
		a=new B();
		a.m1();
		//a.m2();
		//a.m3();
	}
}
