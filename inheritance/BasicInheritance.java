class Man {
	private String name;
	public Man(String name) { this.name = name; }
	public void tellYourName() { System.out.println("My name is " + name); }
}

class BusinessMan extends Man {
// extends Man : ManŬ������ ��ӹ޾� Man�� ����� ����ϰڴٴ� �ǹ�
	private String company, position;
	public BusinessMan(String name, String company, String position) {
		super(name);
		// ����Ŭ������ �����ڿ����� ���� ù�ٿ� ����Ŭ������ �����ڸ� ȣ���ؾ� ��
		this.company = company;
		this.position = position;
	}
	public void tellYourInfo() {
		System.out.println("My company is " + company);
		System.out.println("My position is " + position);
		tellYourName();
		// ����Ŭ������ �޼ҵ��̹Ƿ� �����Ӱ� ȣ��
	}
}

class BasicInheritance {
	public static void main(String[] args) {
		BusinessMan man1 = new BusinessMan("Mr, Hong", "Hybrid 3D ELD", "Staff Eng.");
		BusinessMan man2 = new BusinessMan("Mr, Lee", "Hybrid 3D ELD", "Assist Eng.");

		System.out.println("1st man info............");
		man1.tellYourName();
		// ManŬ������ ��ӹ��� BusinessManŬ������ �ν��Ͻ��̹Ƿ� ManŬ������ ����� �����Ӱ� ȣ��
		man1.tellYourInfo();
		System.out.println("2nd man info............");
		man2.tellYourInfo();
	}
}
