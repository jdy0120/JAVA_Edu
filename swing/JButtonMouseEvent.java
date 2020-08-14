/*
�� ���� ��ư�� FlowLayout���� ��ġ�ϰ� �� �� ù��° ��ư�� �̺�Ʈ �����ʸ� ����
ù��° ��ư�� Ŭ���ϸ� �ܼ�â�� '��ư�� Ŭ���Ǿ����ϴ�.'��� ��µǰ� �۾�
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MouseEventHandler implements MouseListener {
	public void mouseClicked(MouseEvent e) {
		System.out.println("��ư�� Ŭ���Ǿ����ϴ�.");
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	// MouseListener�� �������̽��̹Ƿ� MouseListener���� ��� �޼ҵ���� �����ؾ� ��
	// �޼ҵ峻���� �� �۾��� ������ �� �߰�ȣ�� �Է��Ͽ� �����ؾ� ��
}

class JButtonMouseEvent {
	public static void main(String[] args) {
		JFrame frm = new JFrame("JButton Test");
		frm.setBounds(120, 120, 250, 150);
		frm.setLayout(new FlowLayout());

		MouseListener listener = new MouseEventHandler();

		JButton btn1 = new JButton("1st button");
		btn1.addMouseListener(listener);

		JButton btn2 = new JButton("2nd button");
		btn2.setEnabled(false);

		frm.add(btn1);		frm.add(btn2);

		frm.setVisible(true);
	}
}
