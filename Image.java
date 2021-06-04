import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
public class Image extends JFrame{
	private final JTextField text;
	private JLabel label;
	Random random = new Random();
	int[] right = new int[3];
	public Image()
	{
		super("Testing Image");
		setLayout(new FlowLayout());
		right[0] = random.nextInt(10);
		while(true) {
			right[1] = random.nextInt(10);  // ���� �ڸ�
			if (right[0] != right[1]) {
				break;
			}
		}
		while(true) {
			right[2] = random.nextInt(10);  // ���� �ڸ�
			if (right[0] != right[2] && right[1] != right[2]) {
				break;
			}
		}
		System.out.printf("%d %d %d",right[0],right[1],right[2]);
		text = new JTextField("Enter number");
		add(text);
		TextFieldHandler handler = new TextFieldHandler();
	    text.addActionListener( handler );
	}
	private class TextFieldHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			int out = 0;
			int ball = 0;
			int strike = 0;
			Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
			Icon o = new ImageIcon(getClass().getResource("3out.png"));
			String string = "";
			String num = event.getActionCommand();
			int to = Integer.parseInt(num);
			int[] user = new int[3]; // ����ڰ� �Է��� ���� ����
			user[2] = to % 10;
			to /= 10;
			user[1] = to % 10;
			user[0] = to / 10;
			for (int i = 0; i < user.length; i++) {
				for (int j = 0; j < right.length; j++) {
					if (user[i] == right[j]) {  // ����ڰ� �Է��� ���̶� ���� ���� ������ 
						if (i == j) {  // �ڸ� ���� ������ ��Ʈ����ũ
							strike++;
						}
						else {  // �ٸ��� ��
							ball++;
						}
						break;
					}
					else {
						out++;
					}
				}
			}
			//event.getActionCommand�� string ���� int ��ȯ
			if(ball == 1 && strike == 0)
			{
				string = String.format("1Ball!!���ݸ� �� �����غ�����!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(ball == 2 && strike == 0)
			{
				string = String.format("2Ball!!���ݸ� �� �����غ�����!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(ball == 3)
			{
				string = String.format("3Ball!!���� ���߾����ϴ�!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 1 && ball == 0)
			{
				string = String.format("1Strike!!���ݸ� �� �����غ�����!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 2 && ball == 0)
			{
				string = String.format("2Strike!!���ݸ� �� �����غ�����!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 1 && ball == 1)
			{
				string = String.format("1Strike 1Ball!!���ݸ� �� �����غ�����!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 1 && ball == 2)
			{
				string = String.format("1Strike 2Ball!!���ݸ� �� �����غ�����!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 2 && ball == 1)
			{
				string = String.format("2Strike 1Ball!!���ݸ� �� �����غ�����!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 3)
			{
				string = String.format("3Strike!!������ ���߼̽��ϴ�!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else
			{
				string = String.format("Out!!� ���ڵ� ��ġ���� �ʽ��ϴ�!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,o);
			}
			//null,string,����,������,���� �ٲٴ� ������
		}
	}
}
