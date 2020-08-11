import java.util.*;

class HashSetEX2{
	public static void main(String[] args) {
		//1~45 사이의 중복되지 않는 정수 6개를 구하여 HashSet에 저장하고 출력
		Set set = new HashSet();
		Random rand = new Random();
		while (set.size() != 6)	{
			set.add(rand.nextInt(45)+1);
		}
		System.out.println(set);
	}
}
