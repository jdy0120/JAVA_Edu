class MethodExam {
	public static void main(String[] args) {
		absDiff(10,20);
		absDiff(35,20);
	}
	// 두 정수를 입력받아 두 수의 차를 절대값으로 구하여 출력하는 메소드를 작성

	public static void absDiff(int a,int b){
		System.out.print(a + ", " + b + "의 차는 ");
		if (b > a)
		{
			System.out.println(b-a);
		}else{
			System.out.println(a-b);
		}
	}
}
