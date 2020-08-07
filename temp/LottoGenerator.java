import java.util.*;

class  LottoGenerator{
	public static void main(String[] args) {
		int a[] = new int[6];

		Random r = new Random();
		for (int i = 0; i < 6 ; i++ ){
			a[i] = r.nextInt(45)+1;
			for (int j = 0; j < i ; j++ ){
				if (a[i] == a[j]){
					i --;
					break;
				}
			}
		}
		for (int i = 0; i < 6 ; i++ ){
			System.out.print(a[i] + " ");
		}
	}
}
