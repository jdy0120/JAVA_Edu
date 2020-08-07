class RuntimeExceptionCase{
	public static void main(String[] args) {
		try{
			int[] arr = new int[3];
			arr[-1] = 10;
		}catch (ArrayIndexOutOfBoundsException e){
		// �迭�� ũ�⸦ ����� ������ �ε����� ������� ���
			System.out.println(e.getMessage());
		}
		try{
			Object obj = new int[10];
			String str = (String)obj;
		}catch (ClassCastException e){
		// �߸��� ����ȯ�� �߻��ϴ� ����
			System.out.println(e.getMessage());
		}
		try{
			int[] arr = new int[-10];
		}catch (NegativeArraySizeException e){
		// �迭�� ũ�⸦ ������ �Է��� ��� �߻��ϴ� ����
			System.out.println(e.getMessage());
		}
		try{
			String str = null;
			int len = str.length();
		}
		catch (NullPointerException e){
		// ����ִ� ��ü�� ������ ��� �߻��ϴ� ����
			System.out.println(e.getMessage());
		}
		try{
			String str = "abcd";
			char c = str.charAt(5);
		}
		catch (StringIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}
}
