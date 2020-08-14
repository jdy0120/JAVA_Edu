import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CheckBoxHandler implements ItemListener {
	JRadioButton rdo1, rdo2, rdo3;
	public CheckBoxHandler(JRadioButton rdo1, JRadioButton rdo2, 
		JRadioButton rdo3) {
		this.rdo1 = rdo1;	this.rdo2 = rdo2;	this.rdo3 = rdo3;
	}
	public void itemStateChanged(ItemEvent e) {
	// ���� ���°� ���� �� ȣ��Ǵ� �޼ҵ�
		if (e.getStateChange() == ItemEvent.SELECTED) {
		// �̺�Ʈ�� ����Ų e�� ��ȭ�� ���°� '����'�Ǿ� �ִ� �����̸�
			rdo1.setEnabled(true);
			rdo2.setEnabled(true);
			rdo3.setEnabled(true);
			// ���� ��ư��(rdo1, rdo2, rdo3)�� Ȱ��ȭ ��Ŵ
		} else {	// ItemEvent.DESELECTED
		// �̺�Ʈ�� ����Ų e�� ��ȭ�� ���°� '����'�Ǿ� �ִ� �����̸�
			rdo1.setEnabled(false);
			rdo2.setEnabled(false);
			rdo3.setEnabled(false);
			// ���� ��ư��(rdo1, rdo2, rdo3)�� ��Ȱ��ȭ ��Ŵ
		}
	}
}

class JCheckBoxJRadioButton {
	public static void main(String[] args) {
		JFrame frm = new JFrame("Choice Component");
		frm.setBounds(120, 120, 200, 200);
		frm.setLayout(new GridLayout(0, 1));
		// GridLayout(0, 1) : 0�� ������� �Է��ص� �ȴٴ� �ǹ�

		JCheckBox chk = new JCheckBox("Are you a programmer");

		JRadioButton rdo1 = new JRadioButton("I like C");
		JRadioButton rdo2 = new JRadioButton("I like C++");
		JRadioButton rdo3 = new JRadioButton("I like Java", true);
		// JRadioButton������ true�� ������ �̸� ���õǾ� �ִ� ���·� ����
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdo1);	bg.add(rdo2);	bg.add(rdo3);
		// �� ���� ������ư �� �ϳ��� ���õǰ� ��

		chk.addItemListener(new CheckBoxHandler(rdo1, rdo2, rdo3));
		frm.add(chk);	frm.add(rdo1);	frm.add(rdo2);	frm.add(rdo3);
		rdo1.setEnabled(false);
		rdo2.setEnabled(false);
		rdo3.setEnabled(false);

		// innerŬ������ �̺�Ʈ �����ʸ� ����
		rdo1.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
				// �̺�Ʈ�� �Ͼ ������Ʈ�� ���°� '����'�Ǿ� �ִ� �����̸�
					System.out.println("I like C too");
			}
		} );

		rdo2.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					System.out.println("I like C++ too");
			}
		} );

		rdo3.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					System.out.println("I like Java too");
			}
		} );

		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
