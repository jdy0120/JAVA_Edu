import java.util.*;

class  HashMapEx{
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("test","1234");
		map.put("abcd","1111");
		map.put("abcd","1234");
		// 동일한 키 값은 존재할 수 없으므로 나중에 입력한 것이 기존의 것을 덮어 씀

		Scanner sc = new Scanner(System.in);

		while (true){
			System.out.println("ID와 Password를 입력하세요.");
			System.out.print("ID : ");
			String id = sc.nextLine().trim();
			if (!map.containsKey(id)){
				System.out.println("ID가 다릅니다.");
				continue;
			}
			System.out.print("Password : ");
			String pwd = sc.nextLine().trim();
			if (!pwd.equals(map.get(id))){
				System.out.println("Password가 다릅니다.");
				continue;
			}
			System.out.println("ID와 Password가 일치합니다.");
			System.out.println();
		}
	}
}
