import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ActionEventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	// ������Ʈ�� �⺻ ���۽� ȣ��Ǵ� �޼ҵ�(��ư�� Ŭ��)
		System.out.println(e.getActionCommand());
	}
}

class JButtonActionEvent {
	public static void main(String[] args) {
		JFrame frm = new JFrame("Action Event");
		frm.setBounds(120, 120, 250, 150);
		frm.setLayout(new FlowLayout());

		JButton btn1 = new JButton("btnOne");
		JButton btn2 = new JButton("btnTwo");

		ActionListener action = new ActionEventHandler();
		btn1.addActionListener(action);
		btn2.addActionListener(action);
		// ��ư�� ActionListener ����

		frm.add(btn1);	frm.add(btn2);
		btn2.setEnabled(false);
		// btn2�� ��Ȱ��ȭ

		frm.setVisible(true);
	}
}
