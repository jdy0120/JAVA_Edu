// 산술연산자 테스트 클래스
class OpArith {
	public static void main(String[] args) {
		int n1 = 7, n2 = 3;
		System.out.println("덧셈 결과 : " + (n1 + n2));	// 10
		System.out.println("뺄셈 결과 : " + (n1 - n2));	// 4
		System.out.println("곱셈 결과 : " + (n1 * n2));	// 21
		System.out.println("나눗셈 결과 : " + (n1 / n2));	// 2
		System.out.println("나머지 결과 : " + (n1 % n2));	// 1
		// *,/,%은 덧셈보다 연산자 우선순위이므로 연산자 바깥의 괄호가 없어도 된다.
	}
}
