import java.awt.*;
import javax.swing.*;

class FlowLayoutManager {
	public static void main(String[] args) {
		JFrame frm = new JFrame("FlowLayout Test");
		frm.setBounds(120, 120, 400, 200);
		frm.setLayout(new FlowLayout());
		// �⺻������ �������� �߾ӿ� ������Ʈ���� ��ġ�ϸ�, �������� ���� ���� ��� 
		// ������Ʈ���� �Ʒ��� ������

		frm.add(new JButton("Hi!"));
		frm.add(new JButton("Swing"));
		frm.add(new JButton("Button"));

		frm.add(new JButton("Hi2!"));
		frm.add(new JButton("Swing2"));
		frm.add(new JButton("Button2"));

		frm.setVisible(true);
	}
}
