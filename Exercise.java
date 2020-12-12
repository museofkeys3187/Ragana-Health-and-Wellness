import java.awt.*;
import java.util.Random;
import javax.swing.*;
//import java.applet.*;
public class Exercise extends JFrame{
	private ImageIcon exerciseRecommendationImage;
	private JLabel exerciseLabel;
	
	//create a constructor to get the image
	Exercise(){
		setLayout(new FlowLayout());
		String exercises[] = {"clyde.jpeg", "testImage.JPG", "merv.JPG", "corpse.JPG", "stonestatue.JPG"};
		Random ex = new Random();
		String randExercise = exercises[ex.nextInt(exercises.length)];
		exerciseRecommendationImage = new ImageIcon(getClass().getResource(randExercise));
		
		exerciseLabel = new JLabel(exerciseRecommendationImage);
		add(exerciseLabel);
	}
	public static void main(String[] args){
		Exercise exerciseFrame = new Exercise();
		exerciseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exerciseFrame.setVisible(true);
		exerciseFrame.pack();
		exerciseFrame.setTitle("Daily Exercise Recommendation");
	}
}
