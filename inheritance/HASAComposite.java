class Gun{
	int bullet;
	public Gun(int bnum) {bullet = bnum;}
	public void shot() {
		System.out.println("BBANG!!");
		bullet--;
	}
}

class Police{
	int handcuffs;
	Gun pistol;
	public Police(int bnum, int bcuff){
		handcuffs = bcuff;
		if (bnum > 0){
		// bnum�� 0���� ũ��(�Ѿ��� ������ == ���� �����ϴ� �����̸�)
			pistol = new Gun(bnum);
			// ������ ������ ���� �ν��Ͻ� ����
		}else{
		// bnum�� 0�����̸�(�Ѿ��� ������ == ���� ���� �����̸�)
			pistol = null;
			// ���� �����Ƿ� ������ ���� pistol �ν��Ͻ��� null�� �־� ����д�.
			// null : �ƹ��͵� �ƴ� ������ �ַ� ��ü�� ��� �� ����
		}
	}
	public void putHandcuff(){
		System.out.println("SNAP!");
		handcuffs--;
	}
	public void shot(){
		if (pistol == null){// ���� ������
			System.out.println("���� ���µ���.");
		}else {
			pistol.shot();
		}
	}
}

class HASAComposite 
{
	public static void main(String[] args) 
	{
		Police pman1 = new Police(5,3);
		// ���� ���� Police �ν��Ͻ� ����
		pman1.shot();
		pman1.putHandcuff();
		Police pman2 = new Police(0,3);
		// ���� ���� Police �ν��Ͻ� ����
		pman2.shot();
	}
}
