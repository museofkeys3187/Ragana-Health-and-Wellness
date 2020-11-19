
import java.awt.*;  
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class CalendarSystem extends JPanel{
	SimpleDateFormat month = new SimpleDateFormat("MMMM");
	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	SimpleDateFormat day = new SimpleDateFormat("d");
	Date currentDate = new Date();
	
	public void dateSet(Date currentDate){
		this.currentDate = currentDate;
	}
	public void Coloration(Graphics g){
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawString(month.format(currentDate), 34, 36);
		g.setColor(Color.pink);
		g.drawString(year.format(currentDate), 235, 36);
		
		Calendar date = Calendar.getInstance();
		date.setTime(currentDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -calendar.get(Calendar.DAY_OF_WEEK) + 1);
		
		for(int week = 0; week < 6; week++){
			for(int days = 0; days < 7; days++){
				Color txt = Color.pink;
				g.drawString(day.format(calendar.getTime()), days * 30 + 46 + 4, week * 29 + 81 + 20);
				calendar.add(Calendar.DATE, + 1);
			}
		}
	}
	public void main(String[] args){
		JFrame calFrame = new JFrame();
		calFrame.setPreferredSize(new Dimension(600, 560));
		
		CalendarSystem cs = new CalendarSystem();
		cs.dateSet(new Date());
		calFrame.getContentPane().add(cs);
		calFrame.setUndecorated(false);
		//testButton = new Button("Testing");
		//this.add(testButton);
		
		calFrame.pack();
		calFrame.setVisible(true);
		Exercise.main(null);
		
	
}
	}

