/*
java/inheri/FriendInfoBook.java�� collections�� ����Ͽ� ǰ
*/

import java.util.*;

class Friend{
	String name,phone,addr; // �⺻������ ������ ������
	public Friend(String name,String phone,String addr){
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showData(){
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phone);
		System.out.println("�ּ� : " + addr);
	}
	public void showBasicInfo(){} // ����Ŭ�������� �������̵��ϱ� ���� ����� �޼ҵ�
}

class HighFriend extends Friend{
	String work;	// ��ģ�� ���� ����
	public HighFriend(String name,String phone,String addr,String job){
		super(name,phone,addr);
		work = job;
	}
	public void showData(){
		super.showData();
		System.out.println("���� : " + work);
	}
	public void showBasicInfo(){
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phone);
	}
}

class UnivFriend extends Friend{
	String major;	// ����ģ�� ���� ����
	public UnivFriend(String name,String phone,String addr,String major){
		super(name,phone,addr);
		this.major = major;
	}
	public void showData(){
		super.showData();
		System.out.println("���� : " + major);
	}
	public void showBasicInfo(){
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phone);
		System.out.println("���� : " + major);
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
		System.out.print("�̸� : ");	name = sc.nextLine();
		System.out.print("��ȭ : ");	phone = sc.nextLine();
		System.out.print("�ּ� : ");	addr = sc.nextLine();

		if (choice == 1){
			System.out.print("���� : ");	 work = sc.nextLine();
			addFriendInfo(new HighFriend(name,phone,addr,work));
		}else{
			System.out.print("���� : ");	 major = sc.nextLine();
			addFriendInfo(new UnivFriend(name,phone,addr,major));
		}
		System.out.println("�Է� �Ϸ�\n");
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
			System.out.println("***�޴� ����***");
			System.out.println("1. �� ģ�� ����");
			System.out.println("2. ���� ģ�� ����");
			System.out.println("3. ��ü ���� ���");
			System.out.println("4. �⺻ ���� ���");
			System.out.println("5. ���α׷� ����");
			System.out.print("���� >> ");

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
					System.out.println("���α׷��� �����մϴ�.");
					return;
			}
		}
	}
}
