class Speaker{
	private int volume;
	public void showCurrentState(){
		System.out.println("���� ũ�� : " + volume);
	}
	public void setVolume(int vol) {volume = vol;}
}

class BaseSpeaker extends Speaker{
	private int base;
	public void showCurrentState(){		// �������̵��� �޼ҵ�
		super.showCurrentState();
		// ����Ŭ������ �������̵� ���� �޼ҵ带 ȣ���Ϥ����� super Ű���带 �̿��ؼ� ȣ���ؾ� ��
		System.out.println("���̽� ũ�� : " + base);
	}
	public void setBase(int base) { this.base = base; }
}

class Overriding{
	public static void main(String[] args) {
		BaseSpeaker bs = new BaseSpeaker();
		bs.setVolume(10);
		bs.setBase(20);
		bs.showCurrentState();
		// �������̵��� �޼ҵ带 ȣ���ϸ� ������ ����Ŭ������ �޼ҵ尡 �����
		// �������̵��� ���¿��� ����Ŭ������ ���� �޼ҵ带 �����Ϸ��� �ν��Ͻ��δ� �Ұ����ϰ�,
		// ����Ŭ������ �������̵��� �޼ҵ忡�� super�� �̿��Ͽ� ȣ���ؾ���

	}
}
