class  VariableEx1 {
	public static void main(String[] args) {
		boolean b1; // boolean형 변수 b1을 선언 및 생성
		b1 = false; // 변수에 처음 값을 넣는 행위를 '초기화'라고 함
		// 될 수 있으면 변수의 초기화는 빨리 할수록 좋다.

		char c1 = 'a'; // 변수 선언과 동시에 초기화를 함 수도 있음

		int i1 = 10, i2 = 20, i3; // 같은 자료형의 변수는 쉼표로 구분하여 여러 개를 한 줄에 선언할 수 있음
		i3 = i1+i2;
		System.out.println("b1 : "+ b1);
		System.out.println("c1 : "+ c1);
		System.out.println("i1 : "+ i1);
		System.out.println("i2 : "+ i2);
		System.out.println("i3 : "+ i3);

	}
}
