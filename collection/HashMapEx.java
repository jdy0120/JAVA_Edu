import java.util.*;

class  HashMapEx{
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("test","1234");
		map.put("abcd","1111");
		map.put("abcd","1234");
		// ������ Ű ���� ������ �� �����Ƿ� ���߿� �Է��� ���� ������ ���� ���� ��

		Scanner sc = new Scanner(System.in);

		while (true){
			System.out.println("ID�� Password�� �Է��ϼ���.");
			System.out.print("ID : ");
			String id = sc.nextLine().trim();
			if (!map.containsKey(id)){
				System.out.println("ID�� �ٸ��ϴ�.");
				continue;
			}
			System.out.print("Password : ");
			String pwd = sc.nextLine().trim();
			if (!pwd.equals(map.get(id))){
				System.out.println("Password�� �ٸ��ϴ�.");
				continue;
			}
			System.out.println("ID�� Password�� ��ġ�մϴ�.");
			System.out.println();
		}
	}
}
