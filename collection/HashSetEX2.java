import java.util.*;

class HashSetEX2{
	public static void main(String[] args) {
		//1~45 ������ �ߺ����� �ʴ� ���� 6���� ���Ͽ� HashSet�� �����ϰ� ���
		Set set = new HashSet();
		Random rand = new Random();
		while (set.size() != 6)	{
			set.add(rand.nextInt(45)+1);
		}
		System.out.println(set);
	}
}
