class ForDup {
	public static void main(String[] args) {
		for (int i = 1; i < 4 ; i++ ){
			System.out.println("*** i : "+i);
			for (int j = 1; j < 4 ; j++ ){
				System.out.println("j : " + j);
			}
		}
		/* ±¸±¸´Ü
		2 X 1 = 2  3 X 1 = 3  4 X 1 = 4  5 X 1 = 5
		2 X 2 = 4  3 X 2 = 6
		...
		2 X 9 = 18
		*/
		for (int i = 1; i < 10 ; i++ ){
			for (int j = 2; j < 6 ; j++ ){
				System.out.print(j + " X " + i + " = " + (j*i) + "  ");
				if (i*j<10) System.out.print(" ");
			}
			System.out.println();
		}
	}
}
