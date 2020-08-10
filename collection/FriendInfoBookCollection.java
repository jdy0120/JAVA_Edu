/*
java/inheri/FriendInfoBook.java를 collections를 사용하여 품
*/

import java.util.*;

class Friend{
	String name,phone,addr; // 기본정보를 저장할 변수들
	public Friend(String name,String phone,String addr){
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showData(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + addr);
	}
	public void showBasicInfo(){} // 하위클래스에서 오버라이딩하기 위해 선언된 메소드
}

class HighFriend extends Friend{
	String work;	// 고교친구 전용 정보
	public HighFriend(String name,String phone,String addr,String job){
		super(name,phone,addr);
		work = job;
	}
	public void showData(){
		super.showData();
		System.out.println("직업 : " + work);
	}
	public void showBasicInfo(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
	}
}

class UnivFriend extends Friend{
	String major;	// 대학친구 전용 정보
	public UnivFriend(String name,String phone,String addr,String major){
		super(name,phone,addr);
		this.major = major;
	}
	public void showData(){
		super.showData();
		System.out.println("전공 : " + major);
	}
	public void showBasicInfo(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("전공 : " + major);
	}
}

class Friendhandler{
	private ArrayList<Friend> friends = new ArrayList<Friend>();
	public void addFriendInfo(Friend fren){
		friends.add(fren);
	}
	public void addFriend(int choice){
		String name, phone, addr, work, major;

		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");	name = sc.nextLine();
		System.out.print("전화 : ");	phone = sc.nextLine();
		System.out.print("주소 : ");	addr = sc.nextLine();

		if (choice == 1){
			System.out.print("직업 : ");	 work = sc.nextLine();
			addFriendInfo(new HighFriend(name,phone,addr,work));
		}else{
			System.out.print("전공 : ");	 major = sc.nextLine();
			addFriendInfo(new UnivFriend(name,phone,addr,major));
		}
		System.out.println("입력 완료\n");
	}
	public void showAllData(){
		for (int i = 0 ; i < friends.size() ; i++ ){
			friends.get(i).showData();
			System.out.println();
		}
	}
	public void showBasicData(){
		for (int i = 0 ; i < friends.size() ; i++ ){
			friends.get(i).showBasicInfo();
			System.out.println();
		}
	}
}

class FriendInfoBookCollection{
	public static void main(String[] args) {
		Friendhandler handler = new Friendhandler();
		while (true){
			System.out.println("***메뉴 선택***");
			System.out.println("1. 고교 친구 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch(choice){
				case 1: case 2:
					handler.addFriend(choice);	break;

				case 3:
					handler.showAllData();		break;

				case 4:
					handler.showBasicData();	break;

				case 5:
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}
	}
}
