class MethodReturn {
	public static void main(String[] args) {
		divide(6,2);
		divide(0,2);
		divide(6,0);
	}
	public static void divide(int n1, int n2){
		if (n2 == 0){
			System.out.println("0���δ� ���� �� �����ϴ�.");
			return;
			// void�޼ҵ忡�� return�� ����ϸ� �� ��� �޼ҵ带 ������ �����Ŵ
		}
		System.out.println("������ ��� : " + (n1/n2));		
		
	}
}
