class Aa {
	public void rideMethod() { System.out.println("Aa's Method"); }
	public void loadMethod() { System.out.println("void Method"); }
}

class Bb extends Aa {
	public void rideMethod() { System.out.println("Bb's Method"); }
	public void loadMethod(int n) { System.out.println("int Method"); }
}

class Cc extends Bb {
	public void rideMethod() { System.out.println("Cc's Method"); }
	public void loadMethod(double n) { System.out.println("double Method"); }
}

class RideAndLoad {
	public static void main(String[] args) {
		Aa ref1 = new Cc();		Bb ref2 = new Cc();		Cc ref3 = new Cc();
		// ����Ŭ���������� �����ϸ� ����Ŭ������ �ν��Ͻ��� ���� �� ����
		// JVM�� �� �ν��Ͻ����� ����Ŭ���������� �Ǵ��Ͽ� �۾���
		// ��, �������̵��� �޼ҵ��� ��� ������ Ŭ������ �޼ҵ尡 �����

		ref1.rideMethod();		ref2.rideMethod();		ref3.rideMethod();
		// Cc's Method			Cc's Method				Cc's Method
		// �������̵��� �޼ҵ带 ȣ��� ������ �޼ҵ尡 �����

		ref3.loadMethod();		ref3.loadMethod(10);	ref3.loadMethod(3.14);
		// void Method			int Method				double Method
		// ��Ӱ��迡 �ִ� Ŭ������ ���̿����� �����ε��� ������
	}
}
