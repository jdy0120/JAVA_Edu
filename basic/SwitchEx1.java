class SwitchEx1{
	public static void main(String[] args) 
	{
		int n = 2;
		switch (n)
		{
		case 1:
			System.out.println("n�� 1");
			break;
		case 2:
			System.out.println("n�� 2");
			break;
		case 3:
			System.out.println("n�� 3");
			break;
		default:
			System.out.println("n�� ����");
		}
		switch ("abc")
		{
		case "ccc":
			System.out.println("aaa");
			break;
		case "ccc":
			System.out.println("ccc");
			break;
		case "abc":
			System.out.println("abc");
		default:
			System.out.println("???");
		}
	}
}
