import java.awt.*;
import javax.swing.*;
import java.applet.*;
public class Exercise extends JFrame{
	private ImageIcon image1;
	private JLabel label1;
	
	//create a constructor to get the image
	Exercise(){
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource("nah.jpeg"));
		
		label1 = new JLabel(image1);
		add(label1);
	}
	public static void main(String[] args){
		Exercise gui = new Exercise();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setTitle("Daily Exercise Recommendation");
	}
}
