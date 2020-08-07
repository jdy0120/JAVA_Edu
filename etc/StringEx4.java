class StringEx4{
	public static void main(String[] args) {
		String num1 = "880515-1234567";
		String num2 = "8905152234567";
		
		showBirth(num1);	showBirth(num2);
		showGender(num1);	showGender(num2);
	}
	public static void showBirth(String num){
		char y = num.charAt(0);
		String year = "19"+num.substring(0,2);
		String month = num.substring(2,4);
		String day = num.substring(4,6);
		System.out.println(year + "-" + month + "-" + day);
	}
	public static void showGender(String num){
		String c_num = num.replace("-","");
		
		String gen = c_num.substring(6,7);
		if (gen.equals("1"))	System.out.println("남자");
		else					System.out.println("여자");
	}
}
