class WhileDoWhileEx{
	public static void main(String[] args){
		int n = 0;
		while (n < 5){
			System.out.println("Hello World!"+n+" | ");
			n++;
		}
		System.out.println();
		// ���� while������ n�� 5�� �־����� do--while���� Ư���� ������ ���� �ʰ� �� �� �����Ŵ
		do{
			System.out.println("do-while : " + n + " | ");
			n++;
			
		}while(n < 5);
		System.out.println();
	}
}
