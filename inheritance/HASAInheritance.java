class Gun{
	int bullet;
	public Gun(int bnum) {bullet = bnum;}
	public void shot() {
		System.out.println("BBANG!!");
		bullet--;
	}
}

class Police extends Gun{
// Police�� Gun�� has-a�����̹Ƿ� ��� Police�� Gun�� �����ϰ� �־�� ��Ȯ�� ����� �̷�� ��
// ������ Gun�� �����ϰ� ���� ���� Police�� ���� ��� ǥ���� �� ���� ����
	int handcuffs;
	public Police(int bnum, int bcuff){
		super(bnum);
		handcuffs = bcuff;
	}
	public void putHandcuff(){
		System.out.println("SNAP!");
		handcuffs--;
	}
}

class HASAInheritance{
	public static void main(String[] args) {
		Police pman = new Police(5,3);
		// 5���� �Ѿ˰� 3���� ������ ���� ���� �ν��Ͻ� ����
		pman.shot();
		pman.putHandcuff();

		// ���� Ŭ���������� ���� ���� ������ �ν��Ͻ��� ������ �� ����
		// �׷��Ƿ� ���� ���� ������ ������ ��� Police�� Gun�� ����� �߸��� ����� ��
	}
}
