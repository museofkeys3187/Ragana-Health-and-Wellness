import java.awt.*;
import javax.swing.*;
import java.applet.*;
public class Exercise extends JFrame{
	private ImageIcon exerciseRecommendationImage;
	private JLabel exerciseLabel;
	
	//create a constructor to get the image
	Exercise(){
		setLayout(new FlowLayout());
		
		exerciseRecommendationImage = new ImageIcon(getClass().getResource("nah.jpeg"));
		
		exerciseLabel = new JLabel(exerciseRecommendationImage);
		add(exerciseLabel);
	}
	public static void main(String[] args){
		Exercise gui = new Exercise();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setTitle("Daily Exercise Recommendation");
	}
}
