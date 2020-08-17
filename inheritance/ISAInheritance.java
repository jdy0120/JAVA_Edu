class Computer {
	String owner;
	public Computer(String name) { owner = name; }
	public void calculate() { System.out.println("��û ������ ����մϴ�."); }
}

class Notebook extends Computer {
// 'Notebook' is a 'Computer'�� ���谡 �����ϹǷ� ����� �޴� �� �ƹ��� ������ ����
// NotebookŬ���������� Computer�� ��� ��� ����� �� �����Ƿ� Notebook������ �ʿ��� ����� �����ϸ� ��
	int battery;
	public Notebook(String name, int init) {
		super(name);
		battery = init;
	}
	public void charging() { battery += 5; }
	public void movingCal() {
		if (battery < 1) {
			System.out.println("������ �ʿ��մϴ�.");		return;
		}

		System.out.print("�̵��ϸ鼭 ");
		calculate();
		// ���� �۾��κ��̳� ����Ŭ������ ������ �޼ҵ尡 �����Ƿ� ����Ŭ������ �޼ҵ带 ȣ��
		battery -= 1;
	}
}

class Tablet extends Notebook {
// Notebook�� ��ӹ������ν� Notebook�� ����Ŭ������ Computer�� ��ɱ��� Tablet���� ����� �� ����
// ��, Computer�� �����(calculate())�� Notebook�� �޴���(movingCal())�� ��� Tablet���� ��밡��
	String regPen;
	public Tablet(String name, int init, String pen) {
		super(name, init);
		regPen = pen;
	}
	public void write(String pen) {
		if (battery < 1) {
			System.out.println("������ �ʿ��մϴ�.");		return;
		}
		if (!regPen.equals(pen)) {
			System.out.println("��ϵ� ���� �ƴմϴ�.");		return;
		}

		System.out.println("�ʱ� ������ ó���մϴ�.");
		battery--;
	}
}

class ISAInheritance {
	public static void main(String[] args) {
		Notebook nb = new Notebook("ȫ�浿", 5);
		Tablet tb = new Tablet("����ġ", 5, "ISE-12345");

		nb.movingCal();		tb.write("ISE-12345");
	}
}
