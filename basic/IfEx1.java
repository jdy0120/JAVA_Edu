class  IfEx1{
	public static void main(String[] args) {
		int num = 10;
		if (num > 0){
			System.out.println("num은 양수이다.");
		}else{
			System.out.println("num은 음수이거나 0이다.");
		}

		// num의 값이 짝수인지 검사하여 출력
		if (num % 2 == 0)
		{
			System.out.println("num은 짝수이다.");
		} else {
			System.out.println("num은 홀수이다.");
		}
	}
}