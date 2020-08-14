import java.awt.*;

class FirstAWT {
	public static void main(String[] args) {
		Frame frm = new Frame("First AWT");
		frm.setBounds(120, 120, 400, 100);
		frm.setLayout(new FlowLayout());

		Button btn1 = new Button("1st Button");
		Button btn2 = new Button("2nd Button");
		Button btn3 = new Button("3rd Button");

		frm.add(btn1);		frm.add(btn2);		frm.add(btn3);

		frm.setVisible(true);
	}
}
