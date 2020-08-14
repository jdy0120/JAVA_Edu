import java.awt.*;
import javax.swing.*;

class BorderLayoutManager {
	public static void main(String[] args) {
		JFrame frm = new JFrame("FlowLayout Test");
		frm.setBounds(120, 120, 300, 200);
		frm.setLayout(new BorderLayout());

		frm.add(new JButton("EAST"), BorderLayout.EAST);
		frm.add(new JButton("WEST"), BorderLayout.WEST);
		frm.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		frm.add(new JButton("NORTH"), BorderLayout.NORTH);
		frm.add(new JButton("CENTER"), BorderLayout.CENTER);

		// center�� �����ϰ� �ٸ� ������ ä���� ������ �ֺ��� �ٸ� �������� �� �ڸ��� ä����
		// ��, center�� ä������ ����

		frm.setVisible(true);
	}
}
