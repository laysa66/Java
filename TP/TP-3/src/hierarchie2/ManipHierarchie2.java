package hierarchie2;

class A {
	public A(int i){}
	public A m0(A a) {System.out.println("je suis m0 de A");return null;}
	public void m1(A a) {System.out.println("je suis m1 de A");}
}
/*
 * \question Ajoutez à la classe B une redéfinition invariante de la méthode m1.

\question Ajoutez à la  classe B une redéfinition covariante sur le type de retour de la méthode m0.

\question Ajoutez à la classe C une surcharge de la méthode m0, sans modifier le nombre de ses paramètres.
 */
class B extends A {

	public B(int i) {
		super(i);
	}

	public void m1(A a) {System.out.println("je masque !");}

	public A m0(A a) {System.out.println("je spécialise ! ");return super.m0(a);}
}

class C extends A {

	public C(int i) {
		super(i);
	}

	public A m0(B a) {System.out.println("je surcharge ! ");return null;}

}

class ManipHierarchie2 {
	public static void main(String[] args) {
		A b=new B(1);
		A c=new C(1);
		b.m0(new A(1));
		b.m0(new B(1));
		c.m0(new A(1));
		c.m0(new B(1));
	}
}