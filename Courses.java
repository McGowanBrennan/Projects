
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//I am extending JPanel instead of JFrame because I'm only using 1 panel
public class Courses extends JPanel {
	private static final long serialVersionUID = 1L;
	JButton b1, b2, b3, b4, b5, b6, b7, b8; //Creating buttons before use
	ArrayList<JTextField> listOfFields = new ArrayList<JTextField>(); //Keeps track of JTextField input
	ArrayList<JButton> listOfButtons = new ArrayList<JButton>(); //Keeps track of new
	DefaultListModel<String> listOfCourses = new DefaultListModel<>();
	JTextField tf1, tf2;
	
	JLabel label1, label2, label3;
	int x = 3; //Used for gridbag coordinates
	int y = 1; // ^^
	int indexer = 0; //Keeps track of dynamically created text fields
	int buttonIndexer = 0; //^^
	double gpa = 0.0; //GPA for output
	double credit = 0.0;
	private JList<String> courseList; //A JList of newCourses
	ArrayList<JTextField> newCourses = new ArrayList<JTextField>(); //List of JTextFields composed of the "courses" field
	ArrayList<String> listOfGrades = new ArrayList<String>(); //^^ but for grade field
	ArrayList<String> listOfHours = new ArrayList<String>(); //^^ for hours field
	ArrayList<Double> listOfParsedGrades = new ArrayList<Double>(); //Holds a list of the listOfGrades values turned into cooresponding GPA
	
   
	
	public Courses(){
		//Using gridbag for layout, Source: https://docs.oracle.com/javase/7/docs/api/java/awt/GridBagLayout.html
		GridBagConstraints c = new GridBagConstraints();

		setLayout(new GridBagLayout());
		
		label1 = new JLabel("Course Options");
		c.gridx = 0;
		c.gridy = 0;
		add(label1,c);
		
		b1 = new JButton("Add 1 Course"); //Button to add a new JTextField with Course Name, Grade, and Credit Hours
		c.gridx = 0;
		c.gridy = 1;
		add(b1, c);
		b1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
							x = 3;
							c.gridx = x;
							c.gridy = y;
							listOfFields.add(new JTextField("Course")); //Dynamically creates a new JTextField
							add(listOfFields.get(indexer), c); //I add the field from listOfFields because it
							indexer++;						   //needs to be added to the list to keep track of newly created fields
							x++;
							
		
							c.gridx = x;
							c.gridy = y;
							listOfFields.add(new JTextField("Grade")); //^^
							add(listOfFields.get(indexer), c);
							indexer++;
							x++;
							
						
							c.gridx = x;
							c.gridy = y;
							listOfFields.add(new JTextField("Hours")); //^^
							add(listOfFields.get(indexer), c);
							x++;
							indexer++;
							
							updateUI();
							x = 2;
							y++;
						
					
			  } 
			} );
		
		b4 = new JButton("Delete a Course"); //Button to remove a set of TextFields
		c.gridx = 0;
		c.gridy = 3;
		add(b4, c);
		b4.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  deleteButtonPressed();
				  updateUI();
			  } 
		} );
		
		b2 = new JButton("Add 15 Credits");
		c.gridx = 0;
		c.gridy = 2;
		add(b2, c);
		b2.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  x = 3;
				
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Course"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Grade"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Hours"));
					add(listOfFields.get(indexer), c);
					indexer++;
					y++;
					x=3;
					
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Course"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Grade"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
					
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Hours"));
					add(listOfFields.get(indexer), c);
					indexer++;
					
	
					x=3;
					y++;
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Course"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;

					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Grade"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
				
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Hours"));
					add(listOfFields.get(indexer), c);
					indexer++;
					
					
					x=3;
					y++;
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Course"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
					
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Grade"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
					
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Hours"));
					add(listOfFields.get(indexer), c);
					indexer++;
					
			
					y++;
					x=3;
					
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Course"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
				
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Grade"));
					add(listOfFields.get(indexer), c);
					indexer++;
					x++;
				
					c.gridx = x;
					c.gridy = y;
					listOfFields.add(new JTextField("Hours"));
					add(listOfFields.get(indexer), c);
					indexer++;
					
					y++;
					x=3;
					updateUI();
			  } 
			} );
		
		 courseList = new JList<>(listOfCourses);
		 c.gridx=6;
		 c.gridy = 10;
		 //c.weightx = 0;
		 //c.weighty = -1;
		 courseList.setFixedCellWidth(60);
	     courseList.setFixedCellHeight(10);
		 add(add(new JScrollPane(courseList)), c);
		 
		 JLabel GPA = new JLabel("Your GPA is: " + gpa);
			c.gridx = 8;
			c.gridy = 4;
			add(GPA, c);
			
		label3 = new JLabel(" ");
		c.gridx = 12; //coordinates for the new JLabel calculateGPA() creates
		  c.gridy = 5;
		  add(label3, c);
		
		b3 = new JButton("Calculate GPA");
		c.gridx = 0;
		c.gridy = 5;
		add(b3, c);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GPA.setText(" ");
				gpa = 0.0;
				int hoursTotal = 0;
				for (String grade : listOfGrades){
					if (grade.equals("A+")){ //does the same thing as getGPA() but I added that method later
						listOfParsedGrades.add(4.0);
					}
					if (grade.equals("A")){
						listOfParsedGrades.add(4.0);
					}
					if (grade.equals("A-")){
						listOfParsedGrades.add(3.7);
					}
					if (grade.equals("B+")){
						listOfParsedGrades.add(3.3);	
					}
					if (grade.equals("B")){
						listOfParsedGrades.add(3.0);	
					}
					if (grade.equals("B-")){
						listOfParsedGrades.add(2.7);	
					}
					if (grade.equals("C+")){
						listOfParsedGrades.add(2.3);	
					}
					if (grade.equals("C")){
						listOfParsedGrades.add(2.0);	
					}
					if (grade.equals("C-")){
						listOfParsedGrades.add(1.7);	
					}
					if (grade.equals("D+")){
						listOfParsedGrades.add(1.3);	
					}
					if (grade.equals("D")){
						listOfParsedGrades.add(1.0);	
					}
					if (grade.equals("F")){
						listOfParsedGrades.add(0.0);	
					}
				}
				
				for (Double realGrade : listOfParsedGrades){
					for (String hour : listOfHours){
						int newHour = Integer.parseInt(hour);
						hoursTotal = hoursTotal + newHour;
						credit = newHour * realGrade;
						gpa = gpa + credit;
					}
				}
				gpa = gpa / hoursTotal;
			
				GPA.setText("Your GPA is: " + gpa);
				updateUI();
				gpa = 0.0;
				credit = 0;
			}
		} );
		
		
		b5 = new JButton("Add courses to course history");
		c.gridx = 0;
		c.gridy = 4;
		add(b5, c);
		b5.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  addToList();
				  deleteAll();
				  updateUI();
			  } 
		} );
		
		b6 = new JButton("Delete a course from course list");
		c.gridx = 0;
		c.gridy = 10;
		//c.weighty = 5;
		add(b6, c);
		b6.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  removeFromList();
				  updateUI();
			  } 
		} );
		
		b7 = new JButton("Delete all courses in course list");
		c.gridx=0;
		c.gridy = 12;
		add(b7, c);
		b7.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  removeAllFromList();
				  updateUI();
			  } 
		} );
		
		label2 = new JLabel("Enter your target GPA:");
		c.gridx = 12;
		c.gridy = 0;
		add(label2, c);
		
		b8 = new JButton("Find required GPA");
		c.gridx = 12;
		c.gridy = 3;
		add(b8, c);
		b8.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  calculateGPA();
				  
				  updateUI();
			  } 
		} );
		
		tf1 = new JTextField("Enter GPA");
		c.gridx = 12;
		c.gridy = 1;
		add(tf1, c);
		
		tf2 = new JTextField("How many credits are you taking");
		c.gridx = 12;
		c.gridy = 2;
		add(tf2, c);
		
		
		
		
	}
	
	public void deleteAll(){
		ArrayList<JTextField> fieldsToRemove = new ArrayList<JTextField>(); 
		for (JTextField field2 : listOfFields){
			remove(field2);
			fieldsToRemove.add(field2); //adds the text fields to another ArrayList to avoiding deleting things from the AL I am looping through
			indexer--;
		}
		
		for (JTextField removeThis : fieldsToRemove){
			listOfFields.remove(removeThis);
		}
		x = 3;
		y = 1;
	}
	
	public int getHours(){
		int hoursTotal = 0; 
		for (String hour : listOfHours){//iterate through and returns the total hours added in the course list
			int newHour = Integer.parseInt(hour);
			hoursTotal = hoursTotal + newHour;
			
	}
		return hoursTotal;}
	
	public double getGPA(){
		double gpa = 0;
		int hoursTotal = 0; 
		for (String grade : listOfGrades){
			if (grade.equals("A+")){
				listOfParsedGrades.add(4.0); //loops through and converts all String values to doubles
			}
			if (grade.equals("A")){
				listOfParsedGrades.add(4.0);
			}
			if (grade.equals("A-")){
				listOfParsedGrades.add(3.7);
			}
			if (grade.equals("B+")){
				listOfParsedGrades.add(3.3);	
			}
			if (grade.equals("B")){
				listOfParsedGrades.add(3.0);	
			}
			if (grade.equals("B-")){
				listOfParsedGrades.add(2.7);	
			}
			if (grade.equals("C+")){
				listOfParsedGrades.add(2.3);	
			}
			if (grade.equals("C")){
				listOfParsedGrades.add(2.0);	
			}
			if (grade.equals("C-")){
				listOfParsedGrades.add(1.7);	
			}
			if (grade.equals("D+")){
				listOfParsedGrades.add(1.3);	
			}
			if (grade.equals("D")){
				listOfParsedGrades.add(1.0);	
			}
			if (grade.equals("F")){
				listOfParsedGrades.add(0.0);	
			}
		}
		
		for (Double realGrade : listOfParsedGrades){ //after parsing, gpa is calculated by iterating through the field loops
			for (String hour : listOfHours){
				int newHour = Integer.parseInt(hour);
				hoursTotal = hoursTotal + newHour;
				double credit = newHour * realGrade;
				gpa = gpa + credit;  //credit is the GPA of each grade/hour field which is added into the overall gpa
			}
		}
		gpa = gpa / hoursTotal;
		return gpa;
		
	}
	
	public void addToList(){
		
		for (int i = 0; i < listOfFields.size(); i = i + 3){
				
			 	String fieldText = listOfFields.get(i).getText(); //Gets text from JTextField
		        listOfCourses.addElement(fieldText); //adds text to list of courses
		}   
		 
		for (int i = 1; i <listOfFields.size(); i = i+3){  //^^ but for grades
			String gradeText = listOfFields.get(i).getText();
			listOfGrades.add(gradeText);
		}
		
		for (int i = 2; i <listOfFields.size(); i = i+3){ //^^ but for hours
			String hoursText = listOfFields.get(i).getText();
			listOfHours.add(hoursText);
		}
		x = 3;
		y = 1;
		
		       	}
	
	
	public void newCourseButtonPressed(){
		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		int x = 2; //coordinates for GridBagLayout
		int y = 0; 
		int counter = 0; //used to iterate 3 times
		for (JTextField field : newCourses){
			if (counter == 0){
				c.gridx = x;
				c.gridy = y;
				listOfFields.add(new JTextField("Course"));
				add(listOfFields.get(indexer), c); //adds the text field to an ArrayListt
				x++; //increases the x coordinate so the next text field is moved over
				counter++;
				indexer++;
			}
			if (counter == 1){
				c.gridx = x;
				c.gridy = y;
				listOfFields.add(new JTextField("Grade"));
				add(listOfFields.get(indexer), c);
				x++;
				counter++; 
				indexer++;
			}
			if (counter == 2){
				c.gridx = x;
				c.gridy = y;
				listOfFields.add(new JTextField("Hours"));
				add(listOfFields.get(indexer), c);
				x++;
				counter++;
			}
			if (counter == 3){
				counter = 0;
				indexer++;
				break;
			}
		}
		y++;
	}
	
	
	public void deleteButtonPressed(){
		for(int i = 0; i < 3;i++){
			remove(listOfFields.get(listOfFields.size()-1)); //removes the last course from GUI
			listOfFields.remove(listOfFields.size()-1); //removes last course from ArrayList
			indexer--; 
		}
		updateUI();
		
	}
	
	public void removeFromList(){
		
		listOfCourses.remove(listOfCourses.size()-1); //always removes the last added course
		courseList.setModel(listOfCourses); //updates course li;st
		updateUI();
	 
	for (int i = listOfGrades.size()-1; i <listOfGrades.size(); i++){
		//String gradeText = listOfFields.get(i).getText();
		listOfGrades.remove(i);
		listOfParsedGrades.remove(i);
	}
	
	for (int i = listOfHours.size()-1; i <listOfHours.size(); i++){
		//String hoursText = listOfFields.get(i).getText();
		listOfHours.remove(i);
	}
	
	gpa = 0.0;
	credit = 0.0;
		
	}
	
	public void removeAllFromList(){
		listOfCourses.clear();
		listOfGrades.clear(); //Clears the course list 
		listOfHours.clear();
		listOfParsedGrades.clear();
		courseList.setModel(listOfCourses); //updates the course list
		gpa = 0.0; //resets the GPA because only current courses should impact GPA
		credit = 0.0;
	}
	
	public void calculateGPA(){
		
		String parseThisGPA = tf1.getText();
		double parsedGPA = Double.parseDouble(parseThisGPA);
		String parseTheseHours = tf2.getText();
		int parsedRequiredHours = Integer.parseInt(parseTheseHours);
		int totalCredits = getHours() + parsedRequiredHours;
		double requiredGPA = ((parsedGPA * totalCredits) - (getGPA() * getHours()))/parsedRequiredHours;
		
		if (requiredGPA <= 4.0 && requiredGPA >= 2.0){
		label3.setText("You need a GPA of " + requiredGPA + " over "  + parsedRequiredHours + " credit hours");
		}
		
		if (requiredGPA > 4.0){
			label3.setText("You need a GPA of " + requiredGPA + " , try adding more credit hours");
		}
		
		if (requiredGPA <2.0){
			label3.setText("You need a GPA of " +requiredGPA + " , you can take less credit hours");
		}
		
		
		
	}
	public static void main(String[] args){
		JFrame frame = new JFrame();
       Courses coursePanel = new Courses();
		
        frame.add(coursePanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(); //Used code from Lab 7
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		frame.setSize(width, height);
        //frame.setSize(1000, 1000);
        //frame.pack();
        frame.setVisible(true);
            
       
    }
	}
		

