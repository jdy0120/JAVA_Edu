class FinallyTest{
	public static void main(String[] args) {
		boolean divOK = divide(4,2);
		if (divOK)	System.out.println("���� ����");
		else		System.out.println("���� ����");

		divOK = divide(4,0);
		if (divOK)	System.out.println("���� ����");
		else		System.out.println("���� ����");
	}
	public static boolean divide(int n1, int n2){
		try{
			int result = n1/n2;
			System.out.println("������ ��� : " + result);
			return true;
		}
		catch (ArithmeticException e){
			e.printStackTrace();
			return false;
		}finally {
			System.out.println("finally ���� ����");
		}
	}
}
