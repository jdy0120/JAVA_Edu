import java.awt.*;
import javax.swing.*;

class FirstSwing {
	public static void main(String[] args) {
		JFrame frm = new JFrame("First Swing");
		// �������� Ÿ��Ʋ�ٿ��� ������ ���ڿ��� �Ű������� �Ͽ� ������ ����

		frm.setBounds(120, 120, 400, 100);
		// setBounds() : �������� ��ġ�� ũ�⸦ �����ϴ� �޼ҵ� (X��ǥ, Y��ǥ, ����, ����)
		frm.setLayout(new FlowLayout());
		// ������ ������ ������Ʈ���� ��ġ�ϴ� ����� ����

		JButton btn1 = new JButton("1st Button");
		JButton btn2 = new JButton("2nd Button");
		JButton btn3 = new JButton("3rd Button");
		// ��ư�� ĸ�ǰ� �Բ� ����

		frm.add(btn1);		frm.add(btn2);		frm.add(btn3);
		// ������ ��ư���� ������(frm)�� �ø�

		frm.setVisible(true);
		// �������� ���̰� ��
	}
}
