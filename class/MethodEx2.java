class MethodEx2{
	public static void main(String[] args) {
		int n,n2,n3;
		System.out.println("4�� 5�� �� : " + adder(4,5));
		System.out.println("3.5�� ���� : " + square(3.5));
		System.out.println("3�� " + evenOdd(3) + "�� �Դϴ�.");
	}
	public static int adder(int a, int b){
		return a+b;
	}
	public static double square(double a){
		return a*a;
	}
	public static char evenOdd(int a){
		if (a%2 == 0){
			return '¦';
		}else{
			return 'Ȧ';
		}
		// if�� �ȿ��� return�� �Ϸ��� �ݵ�� else���� ����ؼ� return�ؾ� ��
		// else if ������ return�ϴ� �ɷ� ������ JVM�� ���ǿ� �ٶ� return
		// ���� ���� ���� �ִٰ� �Ǵ��Ͽ� 'missing return statement' ������ �߻���Ŵ
	}
}

