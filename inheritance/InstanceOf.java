class BasicBox {
	public void basicWrap() { System.out.println("basic wrap"); }
}

class PaperBox extends BasicBox {
	public void paperWrap() { System.out.println("paper wrap"); }
}

class GoldBox extends PaperBox {
	public void goldWrap() { System.out.println("gold wrap"); }
}

class InstanceOf {
	public static void main(String[] args) {
		BasicBox box1 = new BasicBox();
		PaperBox box2 = new PaperBox();
		GoldBox box3 = new GoldBox();

		wrapBox(box1);	wrapBox(box2);	wrapBox(box3);
	}
	public static void wrapBox(BasicBox box) {
	// �Ű������� �ڷ����� ����Ŭ������ ���������Ƿ� ����Ŭ������ �ν��Ͻ��鵵 ���� �� �ְ� ��
	// ��, ����Ŭ���������� �޾ұ� ������ �Ű������� ��� ����Ŭ���������� �νĵǾ� 
	// ����Ŭ������ �޼ҵ常 ����� �� ����
	// ����Ŭ������ �޼ҵ带 ����Ϸ��� �Ű������� ���� �ν��Ͻ��� ����Ŭ���������� ����ȯ�ؾ� ��
		if (box instanceof GoldBox) {
		// box�� GoldBox�� ����ȯ�� �����ϴٸ�(GoldBox������ ����� ���� �ƴ�)
			((GoldBox)box).goldWrap();
			// box�� GoldBox������ ����ȯ �� goldWrap()�޼ҵ带 ȣ��
		} else if (box instanceof PaperBox) {
			((PaperBox)box).paperWrap();
		} else {
			box.basicWrap();
		}
		// instanceof�� ����ؼ� ����ȯ �� �۾��� �Ϸ��� �ݵ�� ������Ŭ���� ���� ������ ��� ��
	}
}
