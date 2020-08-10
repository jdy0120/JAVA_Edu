class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("�絵 : " + sugar); }
}


class OrangeBox{// ��� ������ ������ ��� Ŭ����
	Orange item;
	// Object�� �����Ͽ��� ������ ��� ������ �����͵� ���� �� ����
	public void store(Orange item) { this.item = item; }
	public Orange pullOut() { return item; }
}

class FruitBoxObject2{
	public static void main(String[] args) {
		OrangeBox fBox1 = new OrangeBox();
		fBox1.store(new Orange(10));
		// OrangeŬ������ �ν��Ͻ��� �����Ͽ� store()�޼ҵ��� �Ű������� ������
		Orange org1 = (Orange)fBox1.pullOut();
		org1.showSugar();
		
		OrangeBox fBox2 = new OrangeBox();
		fBox2.store(new String("������"));
		Orange org2 = (Orange)fBox1.pullOut();
		// fBox2�� ����ִ� ��ü�� String�̹Ƿ� Orange�� ����ȯ�� �Ұ�
		// fBox2�� ����ִ� ��ü�� String�̹Ƿ� Orange�� ����ȯ�� �Ұ�
		org2.showSugar();
	}
}


/*
������
 - store()�޼ҵ带 ���� Orange�� �ƴ� String�� �ν��Ͻ��� ������ ��
 - ����ȯ�� �Ұ����� �ڵ忡�� �����Ͻ� error�� ���� �ʰ� ����� exception�� �߻�

�ذ�å
 - ��Ȯ�� �ڷ����� �ν��Ͻ��� ���� �� �հ� �۾��ؾ� ��
    �߸��� �ڷ����� �ν��Ͻ��� ������ ���ܰ� �ƴ� ������ �߻��ϰ� �ؾ� ��
*/