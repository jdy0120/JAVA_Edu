class Aa{
	public void aaMethod(){ System.out.println("aa's method"); }
	public void ride() { System.out.println("aa's ride method"); }
}

class Bb extends Aa{
	public void bbMethod(){ System.out.println("bb's method"); }
	public void ride() { System.out.println("bb's ride method"); }
}

class RideTest{
	public static void main(String[] args) {
		Aa a = new Aa();
		a.aaMethod();	a.ride();

		Bb b = new Bb();
		b.aaMethod();	b.bbMethod();	b.ride();

		Aa ab = new Bb();
		ab.aaMethod();
//		ab.bbMethod();	//error
		//Aa������ ����Ǿ��� ������ AaŬ������ �޼ҵ常 ��� ����

		ab.ride();
		// ����Ŭ������ Aa������ ����Ǿ�� �������̵��� �޼ҵ�� ����Ŭ������ �޼ҵ带 �����Ŵ
	}
}

