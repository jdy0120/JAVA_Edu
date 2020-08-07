class WhileExam{
	public static void main(String[] args) {
		int n = 1;
		int sum = 0;
		while (n <= 100)
		{
			sum += n;
			n++;
		}
		System.out.println("1~100까지의 합 : " + sum);

		// 100이하의 양수 중에서 2와 7의 공배수를 모두 구하여 출력
		n = 1;
		System.out.print("2와 7의 공배수 :");
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
