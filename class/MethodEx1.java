class MethodEx1{
	public static void main(String[] args) {
		System.out.println("���α׷��� ����");
		testMethod1(23);
		testMethod2(177.8, 75.5);
		System.out.println("Hello World!");
	}
	public static void testMethod1(int age){
		System.out.println("�� ���̴� "+ age + " �Դϴ�.");
	}
	public static void testMethod2(double tall,double weight){
	// �Ű������� ������ �ڷ����̶� ���� ���� �ڷ����� �������ؾ� ��
		System.out.println("�� Ű�� " + tall + "cm �̰�, �����Դ� " + weight + "kg �Դϴ�.");
	}
}
