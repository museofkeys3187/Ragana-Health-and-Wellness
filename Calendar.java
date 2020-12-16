import javax.swing.*; 
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarSystem{
	static int currentYear, currentDay, currentMonth;
	static JLabel month;
	static DefaultTableModel tableCalendar;
	public static void main(String[] args) throws IllegalAccessException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(ClassNotFoundException exc) {
			
		} catch (InstantiationException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException exct) {
			// TODO Auto-generated catch block
			exct.printStackTrace();
		}
		
		//create the frame of the calendar
		JFrame calendarFrame = new JFrame();
		calendarFrame.setSize(660, 750);
		Container calendarPane = calendarFrame.getContentPane();
		calendarPane.setLayout(null);
		calendarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create the calendar controls
		month = new JLabel("December");
		JLabel year = new JLabel("Change Calendar Year");
		JComboBox comboYear = new JComboBox();
		JButton previous = new JButton();
		JButton next = new JButton();
		tableCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		JTable newCalendar = new JTable(tableCalendar);
		JScrollPane calendar = new JScrollPane(newCalendar);
		JPanel printCalendar = new JPanel(null);
		
		//set the borders of the calendar
		printCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
		
		//add the controls to the calendar
		calendarPane.add(printCalendar);
		printCalendar.add(month);
		printCalendar.add(year);
		printCalendar.add(previous);
		printCalendar.add(next);
		printCalendar.add(calendar);
		
		//setting the bounds of the calendar
		printCalendar.setBounds(0, 0, 620, 670);
		month.setBounds(320-month.getPreferredSize().width/2, 50, 200, 50);
		year.setBounds(20,610,160,40);previous.setBounds(20, 50, 100, 50);
		calendar.setBounds(20, 100, 600, 500);
		
		//this just makes the frame visible to the user
		calendarFrame.setResizable(false);
		calendarFrame.setVisible(true);
		
		//get the actual month and year from the java Gregorian calendar system
		GregorianCalendar gregCalendar = new GregorianCalendar();
		currentDay  = gregCalendar.get(GregorianCalendar.DAY_OF_MONTH);
		currentMonth = gregCalendar.get(GregorianCalendar.MONTH);
		currentYear = gregCalendar.get(GregorianCalendar.YEAR);
		int calendarMonth = currentMonth;
		int calendarYear = currentYear;
		
		//adding the headers
		String[] headers = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};
		for(int i = 0; i < 7; i++) {
			tableCalendar.addColumn(headers[i]);
		}
		
		newCalendar.getParent().setBackground(newCalendar.getBackground());
		
		//refuse to resize the elements of the calendar table
		newCalendar.getTableHeader().setResizingAllowed(false);
		newCalendar.getTableHeader().setReorderingAllowed(false);
		
		//allow the user to select a single cell from the calendar table at a time
		newCalendar.setColumnSelectionAllowed(true);
		newCalendar.setRowSelectionAllowed(true);
		newCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//setting the column and row dimensions
		newCalendar.setRowHeight(76);
		tableCalendar.setColumnCount(7);
		tableCalendar.setRowCount(6);
		
		//adding the dates into the table
		for(int i = currentYear-100; i<= currentYear+100; i++) {
			comboYear.addItem(String.valueOf(i));
		}
		//allow the calendar to be refreshed
		refreshCalendar(currentMonth, currentYear);
	}
	public static void refreshCalendar(int month, int year) {
		//get the variables for the table
		String[] monthNames = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int numOfDays, startOfMonth;
		
		//getting the contents of the calendar
		GregorianCalendar greg = new GregorianCalendar(year, month, 1);
		numOfDays = greg.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startOfMonth = greg.get(GregorianCalendar.DAY_OF_WEEK);
		
		//actually draw up the calendar
		for(int i = 1; i <= numOfDays; i++){
			@SuppressWarnings("deprecation")
			int row = new Integer((i + startOfMonth-2)/7);
			int column = (i + startOfMonth - 2)%7;
			tableCalendar.setValueAt(i, row, column);
		}
	}

}
