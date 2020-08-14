import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MouseEventHandler implements MouseListener {
	public void mouseClicked(MouseEvent e) {
	// ���콺 ��ư Ŭ���� ȣ��Ǵ� �޼ҵ�
		JButton button = (JButton)e.getComponent();
		button.setText("Clicked");
		System.out.println("Clicked Button" + e.getButton());
		System.out.println("���콺 ��ư ���ȴ� Ǯ��");
	}
	public void mouseEntered(MouseEvent e) {
	// ���콺 Ŀ���� ������ ������Ʈ ���� ������ ��� ȣ��Ǵ� �޼ҵ�
		System.out.println("Ŀ�� ��ư �� ����");
	}
	public void mouseExited(MouseEvent e) {
	// ���콺 Ŀ���� ������ ������Ʈ ������ ��� ��� ȣ��Ǵ� �޼ҵ�
		System.out.println("Ŀ�� ��ư �� Ż��");
	}
	public void mousePressed(MouseEvent e) {
	// ���콺 ��ư�� ���� ��� ȣ��Ǵ� �޼ҵ�
		System.out.println("���콺 ��ư ����");
	}
	public void mouseReleased(MouseEvent e) {
	// ���콺 ��ư�� �����ٰ� �� ��� ȣ��Ǵ� �޼ҵ�
		System.out.println("���콺 ��ư Ǯ��");
	}
}

class MouseEventEx {
	public static void main(String[] args) {
		JFrame frm = new JFrame("Mouse Event");
		frm.setBounds(120, 120, 400, 100);
		frm.setLayout(new FlowLayout());

		MouseListener listener = new MouseEventHandler();
		// MouseListener �� �������̽� �̹Ƿ� MouseListener �� ������ Ŭ������ 
		// MouseEventHandler �� �̿��Ͽ� �ν��Ͻ��� ����
		// ��, �ν��Ͻ��� MouseListener �� ����Ǿ��� ������ �ν��Ͻ��� MouseListener ������
		// ����� �� ����
		JButton btn1 = new JButton("1st Button");
		btn1.addMouseListener(listener);
		// btn1�� listener�� �޾Ƽ� ���콺 ���� �̺�Ʈ�� �����ϰ� ��

		JButton btn2 = new JButton("2nd Button");
		btn2.addMouseListener(listener);

		JButton btn3 = new JButton("3rd Button");
		btn3.addMouseListener(listener);

		frm.add(btn1);	frm.add(btn2);	frm.add(btn3);
		// ������ ��ư���� ������ ���� ��ġ

		frm.setVisible(true);
		// �������� ������
	}
}
