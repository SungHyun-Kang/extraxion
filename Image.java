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
			right[1] = random.nextInt(10);  // 십의 자리
			if (right[0] != right[1]) {
				break;
			}
		}
		while(true) {
			right[2] = random.nextInt(10);  // 일의 자리
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
			int[] user = new int[3]; // 사옹자가 입력한 숫자 저장
			user[2] = to % 10;
			to /= 10;
			user[1] = to % 10;
			user[0] = to / 10;
			for (int i = 0; i < user.length; i++) {
				for (int j = 0; j < right.length; j++) {
					if (user[i] == right[j]) {  // 사용자가 입력한 값이랑 정답 값이 같을때 
						if (i == j) {  // 자리 수가 같으면 스트라이크
							strike++;
						}
						else {  // 다르면 볼
							ball++;
						}
						break;
					}
					else {
						out++;
					}
				}
			}
			//event.getActionCommand로 string 에서 int 변환
			if(ball == 1 && strike == 0)
			{
				string = String.format("1Ball!!조금만 더 생각해보세요!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(ball == 2 && strike == 0)
			{
				string = String.format("2Ball!!조금만 더 생각해보세요!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(ball == 3)
			{
				string = String.format("3Ball!!거의 맞추었습니다!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 1 && ball == 0)
			{
				string = String.format("1Strike!!조금만 더 생각해보세요!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 2 && ball == 0)
			{
				string = String.format("2Strike!!조금만 더 생각해보세요!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 1 && ball == 1)
			{
				string = String.format("1Strike 1Ball!!조금만 더 생각해보세요!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 1 && ball == 2)
			{
				string = String.format("1Strike 2Ball!!조금만 더 생각해보세요!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 2 && ball == 1)
			{
				string = String.format("2Strike 1Ball!!조금만 더 생각해보세요!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else if(strike == 3)
			{
				string = String.format("3Strike!!정답을 맞추셨습니다!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,bug);
			}
			else
			{
				string = String.format("Out!!어떤 숫자도 일치하지 않습니다!!");
				JOptionPane.showMessageDialog(null, string, "Attemps",JOptionPane.INFORMATION_MESSAGE,o);
			}
			//null,string,제목,아이콘,내가 바꾸는 아이콘
		}
	}
}
