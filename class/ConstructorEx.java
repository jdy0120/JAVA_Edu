class NumberEx1{
	int num;
	public NumberEx1() {
		num = 10;
		System.out.println("������ ȣ��");
	}
	public int getNum() {return num;}
}

class NumberEx2{
	int num;
	public NumberEx2(int n){
		num = n;
		System.out.println("�Ű����� ���� : " + n);
	}
	public int getNum() {return num;}
}

class ConstructorEx{
	public static void main(String[] args) {
		NumberEx1 num1 = new NumberEx1();
		// NumberEx1() : NumberEx1Ŭ������ ������ ȣ��(�ν��Ͻ� ����)
		System.out.println("NumberEx1�� num : " + num1.getNum());

		NumberEx2 num2 = new NumberEx2(25);
		// �����ڿ��� �Ű�����(��)�� ����� �� ����
		System.out.println("NumberEx2�� num : " + num2.getNum());
	}
}
