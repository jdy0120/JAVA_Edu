import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LoginHandler implements ActionListener {
	JTextField id;	// �� ���� ���ڿ��� �Է¹޴� ������Ʈ
	JPasswordField pw;	// JTextField�� ����Ŭ������ ��ȣ�� �Է¹ޱ� ���� ������Ʈ
	public LoginHandler(JTextField id, JPasswordField pw) {
		this.id = id;
		this.pw = pw;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("ID : " + id.getText());
		// id���ο� �Էµ� ���ڿ��� �����ͼ� ���
		System.out.println("Password : " + new String(pw.getPassword()));
		// getPassword() : PasswordField�� �����͸� char�� �迭�� ����
		// char�� �迭�� �ٷ� ����ϱ� ���� String�ν��Ͻ��� ����
		id.setText("");		pw.setText("");
		// id�� pw�� ���� ����
	}
}

class JLabelJTextField {
	public static void main(String[] args) {
		JFrame frm = new JFrame("JLabel & JTextField");
		frm.setBounds(120, 120, 180, 80);
		frm.setLayout(new GridLayout(2, 2));

		JLabel lblId = new JLabel("ID ", SwingConstants.RIGHT);
		// "ID "��� ���ڿ��� ������ ���Ľ�Ŵ
		JTextField txtId = new JTextField(10);
		// 10�ڰ� ���������� ũ�⸦ ���� �ؽ�Ʈ�ʵ� txtId����

		JLabel lblPw = new JLabel("Password ", SwingConstants.RIGHT);
		JPasswordField txtPw = new JPasswordField(10);
		// 10�ڰ� ���������� ũ�⸦ ���� JPasswordField txtPw����
		txtPw.setEchoChar('*');
		// �Էµ� ���� ��� ������ ���� ����

		txtPw.addActionListener(new LoginHandler(txtId, txtPw));
		// txtPw�� action listener ����

		frm.add(lblId);		frm.add(txtId);
		frm.add(lblPw);		frm.add(txtPw);

		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
