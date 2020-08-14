import java.awt.*;
import javax.swing.*;

class MultiLayoutManager {
	public static void main(String[] args) {
		JFrame frm = new JFrame("Multi Layout Manager");
		frm.setBounds(120, 120, 250, 150);
		frm.setLayout(new BorderLayout());
		// �����ӿ��� BorderLayout�� ���

		JButton btn0 = new JButton("B0");	JButton btn1 = new JButton("B1");
		JButton btn2 = new JButton("B2");	JButton btn3 = new JButton("B3");
		JButton btn4 = new JButton("B4");	JButton btn5 = new JButton("B5");
		JButton btn6 = new JButton("B6");	JButton btn7 = new JButton("B7");
		JButton btn8 = new JButton("B8");	JButton btn9 = new JButton("B9");

		JPanel pan1 = new JPanel();
		// �����Ӱ� ������ ���̾ƿ��� ������ �� �ִ� ���
		pan1.setLayout(new FlowLayout());
		// pan1�̶�� JPanel�� ���̾ƿ��� FlowLayout���� ����
		pan1.add(btn0);		pan1.add(btn1);
		pan1.add(btn2);		pan1.add(btn3);

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(2, 3, 2, 2));
		// pan2��� JPanel�� ���̾ƿ��� GridLayout���� ����
		// 2�� 3���� ���̾ƿ��� ������Ʈ�� ���� ������ �����¿� 2�� ����
		pan2.add(btn4);		pan2.add(btn5);		pan2.add(btn6);
		pan2.add(btn7);		pan2.add(btn8);		pan2.add(btn9);

		frm.add(pan1, BorderLayout.NORTH);
		frm.add(pan2, BorderLayout.CENTER);
		// ������Ʈ���� ��ġ�� JPanel�� �����ӿ� ��ġ

		frm.setVisible(true);
	}
}
