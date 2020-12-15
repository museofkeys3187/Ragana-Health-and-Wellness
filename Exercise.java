import java.awt.*;
import java.util.Random;
import javax.swing.*;
//have class Exercise extend JFrame to create the frame
public class Exercise extends JFrame{
	//add the image icon and label for the frame
	private ImageIcon exerciseRecommendationImage;
	private JLabel exerciseLabel;
	
	//create a constructor to get the image from a random set of exercise images
	Exercise(){
		setLayout(new FlowLayout());
		//list of exercise images, will streamline later
		String exercises[] = {"BridgePose.JPG", "PlankLegSwings.JPG", "RunnersLunge.JPG", 
				"CrestenLunge.JPG", "SideLegLifts.JPG", "CrunchKicks.JPG","SitUps.JPG", 
				"ForwardBend.JPG", "TrianglePose.JPG","LegExtensions.JPG", "LegRaises.JPG",
				"PlankBackKicks.JPG"};
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
