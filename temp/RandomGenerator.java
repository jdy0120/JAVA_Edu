import java.util.*;

class RandomGenerator{
	public static void main(String[] args) {
		Random rand = new Random();

		for (int i = 0; i < 3 ; i++ ){
			System.out.println(rand.nextDouble());
			// 0이상 1미만의 실수를 무작위로 출력
		}

		for (int i = 0; i < 5 ; i++ ){
			System.out.print(rand.nextInt(20) + " ");
			// 0이상 20미만의 정수를 무작위로 출력
		}
	}
}
