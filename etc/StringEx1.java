

class StringEx1{
	public static void main(String[] args) {
		String str1 = new String("test");
		String str2 = "test";
		String str3 = "test";
		// ������ ���ڿ��� �̿��ؼ� �ν��Ͻ��� �����ص� ��� ������ �ν��Ͻ��� ������� ����
		// �׷���, ���ڿ��� �񱳴� '=='�� ���� �ʰ� �޼ҵ带 �̿�
		if (str1 == str2)	System.out.println("str1�� str2�� ����.");
		else	System.out.println("str1�� str2�� �ٸ���.");

		if (str2 == str3)	System.out.println("str2�� str3�� ����.");
		else	System.out.println("str2�� str3�� �ٸ���.");

		if (str3 == str1)	System.out.println("str3�� str1�� ����.");
		else	System.out.println("str3�� str1�� �ٸ���.");

	}
}
