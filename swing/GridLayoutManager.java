import java.awt.*;
import javax.swing.*;

class GridLayoutManager {
	public static void main(String[] args) {
		JFrame frm = new JFrame("FlowLayout Test");
		frm.setBounds(120, 120, 300, 200);
		frm.setLayout(new GridLayout(3, 2, 5, 10));
		// GridLayout(int rows, int cols, int hgap, int vgap)
		// rows : ��� / cols : ���� / hgap : ���򰣰� / vgap : ��������
		// rows�� cols������ �����ϱ⵵ ��
		// GridLayout(3, 2) : 3�� 2���� ǥ������� ���̾ƿ��� �ٹ�
		// Ư�� ĭ�� ������Ʈ�� ���� ������ �� �ڸ��� �����

		frm.add(new JButton("One"));	frm.add(new JButton("Two"));
		frm.add(new JButton("Three"));	frm.add(new JButton("Four"));
		frm.add(new JButton("Five"));	frm.add(new JButton("Six"));

		frm.setVisible(true);
	}
}
