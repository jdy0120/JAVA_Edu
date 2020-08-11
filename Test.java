class Test{
	public static void main(String[] args) {
		Object obj = new String("test");
		char c = ((String)obj).charAt(0);
		System.out.println(c);
	}
}
