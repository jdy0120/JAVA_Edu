class Aa{
	public String toString() { return "class Aa"; }
	// ObJECTŬ������ �޼ҵ�� �������̵� �س���
	// �ν��Ͻ� ��½� �ڵ����� ȣ��Ǵ� �޼ҵ�
}

class Bb{
	public String toString() { return "class Bb"; }
}

class InstanceTypeShower{
	int showCnt = 0;
	public <T> void showInstType(T inst){
	// �� �޼ҵ� ȣ��� �Ű������� �ڷ�����  T�� ������ �ڷ������� �۾��϶�� �ǹ�
		System.out.println(inst);
		showCnt++;
	}
	void showPrintCnt() {System.out.println("show count : " + showCnt); }
}

class GenericMethod1{
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();
		InstanceTypeShower shower = new InstanceTypeShower();
		shower.<Aa>showInstType(a);
		shower.<Bb>showInstType(b);
		shower.showInstType(a);
		shower.showInstType(b);
		// ���׸����� ������ �ڷ����� �����ص� ���������� ������
		// �Ű������� �ڷ����� �ٰŷ� ���׸� �ڷ��� ������ �̸� �Ǵ��� ����
		shower.showPrintCnt();
	}
}
