class MethodExam {
	public static void main(String[] args) {
		absDiff(10,20);
		absDiff(35,20);
	}
	// �� ������ �Է¹޾� �� ���� ���� ���밪���� ���Ͽ� ����ϴ� �޼ҵ带 �ۼ�

	public static void absDiff(int a,int b){
		System.out.print(a + ", " + b + "�� ���� ");
		if (b > a)
		{
			System.out.println(b-a);
		}else{
			System.out.println(a-b);
		}
	}
}
