

class StringEx1{
	public static void main(String[] args) {
		String str1 = new String("test");
		String str2 = "test";
		String str3 = "test";
		// 동일한 문자열을 이용해서 인스턴스를 생성해도 모두 동일한 인스턴스로 취급하지 않음
		// 그래서, 문자열의 비교는 '=='로 하지 않고 메소드를 이용
		if (str1 == str2)	System.out.println("str1과 str2는 같다.");
		else	System.out.println("str1과 str2는 다르다.");

		if (str2 == str3)	System.out.println("str2과 str3는 같다.");
		else	System.out.println("str2과 str3는 다르다.");

		if (str3 == str1)	System.out.println("str3과 str1는 같다.");
		else	System.out.println("str3과 str1는 다르다.");

	}
}
