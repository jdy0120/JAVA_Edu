class WhileExam{
	public static void main(String[] args) {
		int n = 1;
		int sum = 0;
		while (n <= 100)
		{
			sum += n;
			n++;
		}
		System.out.println("1~100������ �� : " + sum);

		// 100������ ��� �߿��� 2�� 7�� ������� ��� ���Ͽ� ���
		n = 1;
		System.out.print("2�� 7�� ����� :");
		do
		{
			if (n%2 == 0 && n%7 == 0)
			{
				System.out.print(" "+ n);
			}
			n++;
		}while (n <= 100);
	}
}
