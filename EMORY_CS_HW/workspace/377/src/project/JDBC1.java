

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.swing.*;

public class JDBC {

	static Connection conn = null;
	static Statement stmt = null;
	static int[] length = new int[100]; 
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;

	static public JTextArea inputArea = new JTextArea();      // Text area for input
	static public JTextArea outputArea = new JTextArea();      // Text area for output
	static private JLabel Database;      
	static private JButton Select;     
	static private JButton Execute;      
	static private JTextField DB; 
	static private JLabel space; 
	static private JLabel space1; 
	static private JLabel space2; 
	static private JLabel space3; 
	static private JLabel space4; 

	static private JLabel Column; 
	static private JTextField t1;
	static private JTextField t2 = new JTextField();     
	static private JButton Minimum;      
	static private JTextField t3; 
	static private JButton Maximum;      
	static private JTextField t4; 
	static private JButton Average;      
	static private JTextField t5; 
	static private JButton Median; 


	public static void main(String[] args)
	{
		JFrame f = new JFrame("JDBC");
		JPanel InputPanel = new JPanel();
		JScrollPane input = new JScrollPane(inputArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JPanel InputEast = new JPanel();
		Font F1;
		F1 = new Font("SansSarif", Font.BOLD,18);

		inputArea.setEditable(true);
		inputArea.setFont( F1 );



		Database = new JLabel("Database:       ");
		Database.setFont( F1 );
		Select = new JButton("Select");
		Select.setFont( F1 );
		Execute = new JButton("Execute");
		Execute.setFont( F1 );
		DB = new JTextField();
		DB.setEditable(true);
		DB.setFont( F1 );
		space = new JLabel("\n\n\n\n\n\n\n");
		space1 = new JLabel("\n\n\n");
		space2 = new JLabel("\n\n\n");
		space3 = new JLabel("\n\n\n");
		space4 = new JLabel("\n\n\n");
		JLabel space5= new JLabel("\n\n\n");
		JLabel space6= new JLabel("\n\n\n");
		JLabel space7= new JLabel("\n\n\n");
		JLabel space8= new JLabel("\n\n\n");
		JLabel space9= new JLabel("\n\n\n");
		JLabel space10= new JLabel("\n\n\n");
		JLabel space11= new JLabel("\n\n\n");
		JLabel space12= new JLabel("\n\n\n");
		JLabel space13= new JLabel("\n\n\n");
		JLabel space14= new JLabel("\n\n\n");
		JLabel space15= new JLabel("\n\n\n");
		JLabel space16= new JLabel("\n\n\n");




		space.setFont( F1 );

		DB.setMaximumSize(new Dimension(300, 50));
		Select.setMaximumSize(new Dimension(200, 50));
		Execute.setMaximumSize(new Dimension(200, 50));

		InputEast.setLayout(new BoxLayout(InputEast,1));
		InputEast.add(Database);
		InputEast.add(DB);
		InputEast.add(space3);
		InputEast.add(space4);
		InputEast.add(space6);
		InputEast.add(Select);
		InputEast.add(space7);
		InputEast.add(space8);
		InputEast.add(space9);
		InputEast.add(space10);
		InputEast.add(space11);


		InputEast.add(Execute);
		InputEast.add(space5);
		InputEast.add(space);


		InputPanel.setLayout(new BorderLayout());

		InputPanel.add(input,"Center");
		InputPanel.add(InputEast,"East");


		JPanel OutputPanel = new JPanel();
		JScrollPane output = new JScrollPane(outputArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JPanel outputEast = new JPanel();
		JPanel outputEast1 = new JPanel();
		JPanel outputEast2 = new JPanel();
		JPanel outputEast3 = new JPanel();
		JPanel outputEast4 = new JPanel();
		JPanel outputEast5 = new JPanel();
		JPanel outputEast6 = new JPanel();
		JPanel outputEast7 = new JPanel();
		JPanel outputEast8 = new JPanel();
		JPanel outputEast9 = new JPanel();
		Font F2;
		F2 = new Font("Monospaced", Font.BOLD,18);

		outputArea.setEditable(false);
		outputArea.setFont( F2 );



		Column = new JLabel("Column:");
		t1 = new JTextField();





		outputEast1.setLayout(new GridLayout(1,2));
		outputEast1.add(Column);
		outputEast1.add(t1);
		t1.setFont( F1 );
		t1.setEditable(true);

		outputEast2.setLayout(new GridLayout(1,1));
		outputEast4.setLayout(new GridLayout(1,1));
		outputEast6.setLayout(new GridLayout(1,1));
		outputEast8.setLayout(new GridLayout(1,1));


		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();

		t2.setFont( F1 );
		t3.setFont( F1 );
		t4.setFont( F1 );
		t5.setFont( F1 );

		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);

		t2.setMaximumSize(new Dimension(300, 50));
		t3.setMaximumSize(new Dimension(300, 50));
		t4.setMaximumSize(new Dimension(300, 50));
		t5.setMaximumSize(new Dimension(300, 50));


		Minimum = new JButton("Minimum");
		Maximum = new JButton("Maximum");
		Average = new JButton("Average");
		Median = new JButton("Median");

		Minimum.setFont( F1 );
		Maximum.setFont( F1 );
		Average.setFont( F1 );
		Median.setFont( F1 );

		Minimum.setMaximumSize(new Dimension(200, 50));
		Maximum.setMaximumSize(new Dimension(200, 50));
		Average.setMaximumSize(new Dimension(200, 50));
		Median.setMaximumSize(new Dimension(200, 50));


		outputEast2.add(t2);
		outputEast3.add(Minimum);
		outputEast4.add(t3);
		outputEast5.add(Maximum);
		outputEast6.add(t4);
		outputEast7.add(Average);
		outputEast8.add(t5);
		outputEast9.add(Median);




		outputEast.setLayout(new BoxLayout(outputEast,1));
		outputEast.add(outputEast1);
		outputEast.add(space12);
		outputEast.add(space13);
		outputEast.add(outputEast2);
		outputEast.add(outputEast3);
		outputEast.add(space14);
		outputEast.add(outputEast4);
		outputEast.add(outputEast5);
		outputEast.add(space15);
		outputEast.add(outputEast6);
		outputEast.add(outputEast7);
		outputEast.add(space16);
		outputEast.add(outputEast8);
		outputEast.add(outputEast9);
		outputEast.add(space1);
		outputEast.add(space2);




		OutputPanel.setLayout(new BorderLayout());

		OutputPanel.add(output,"Center");
		OutputPanel.add(outputEast,"East");


		f.setLayout(new GridBagLayout());
		GridBagConstraints c0 = new GridBagConstraints();
		GridBagConstraints c1 = new GridBagConstraints();
		c0.fill = GridBagConstraints.BOTH;
		c0.weightx = 0.1;
		c0.weighty = 0.1;
		c0.gridx = 0;
		c0.gridy = 0;
		c1.fill = GridBagConstraints.BOTH;
		c1.weightx = 0.1;
		c1.weighty = 0.1;
		c1.gridx = 0;
		c1.gridy = 1;

		f.getContentPane().add(InputPanel,c0);
		f.getContentPane().add(OutputPanel,c1);

		Select.addActionListener(new SelectListener()); 
		Execute.addActionListener(new ExecuteListener()); 
		Minimum.addActionListener(new MinimumListener()); 
Maximum.addActionListener(new MaximumListener()); 
Average.addActionListener(new AverageListener()); 
Median.addActionListener(new medianListener());

		f.setSize(800,800);
		f.setVisible(true);





	}


	static private class SelectListener implements ActionListener
	{  
		public void actionPerformed(ActionEvent event)
		{  outputArea.setText(null);
		String databasetext;


		// get user input from text area
		databasetext = DB.getText();


		String url = "jdbc:mysql://holland.mathcs.emory.edu:3306/";
		String dbName = databasetext;
		String userName = "cs377";
		String password = "abc123";

		/****************************************************************/
		try 
		{
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			outputArea.append("Failed to load JDBC driver.");
			return;
		}

		// Connect to the database
		try 
		{
			conn = DriverManager.getConnection(url+dbName,userName,password);
			stmt = conn.createStatement ();
			outputArea.append("Connected to DB.");
		} 
		catch (Exception e) 
		{
			outputArea.append("problems connecting to " + url+dbName);
		}

		Boolean done = false;

		}
	}


	static private class ExecuteListener implements ActionListener
	{  
		public void actionPerformed(ActionEvent event)
		{  outputArea.setText(null);
		String inputtext;
        
		// get user input from text area
		inputtext = inputArea.getText();

		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       // Exec query

			ResultSetMetaData meta = rset.getMetaData(); // Get meta data

			int NCols = meta.getColumnCount();

			/* ===================================================
			 **** Print the column names before any data ****
          =================================================== */
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;
				

				name = meta.getColumnLabel(i);
				outputArea.append( name );  // Print field name

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 0;
				// Set the length of the field to print
				// It's 2 more than the name and display size

				/* ----------------------------------------------
             Pad the attr name to length[k]
             ---------------------------------------------- */
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			        outputArea.append("\n");

			/* ===========================================
          Fetch and print one row at a time....
          =========================================== */
			while ( rset.next () ) // Advance to next row
			{ String type;
				/* ===========================================
             Fetch the columns (attributes) from a row
             =========================================== */
				for(int i = 1; i <= NCols; i++)
				{   type = meta.getColumnTypeName(i);
					String nextItem;

					nextItem = rset.getString(i);
					if(type== "DECIMAL"){

						if(nextItem != null){
							for (int j = nextItem.length(); j < length[i]; j++)
								outputArea.append(" ");}
						else {for (int j = 4; j < length[i]; j++)
							outputArea.append(" ");
						}
						if(nextItem == null)
							outputArea.append("NULL");


						outputArea.append(nextItem);
						
						
					}
					else{

					if(nextItem == null)
						outputArea.append("NULL");


					outputArea.append(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
					}
				outputArea.append("\n");

			}

			rset.close();           // De-allocate result set resources
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); // Print the error message
		}




		}

	}
	
	
	
	
	static private class MinimumListener implements ActionListener
	{  
		public void actionPerformed(ActionEvent event)
		{  outputArea.setText(null);
		String inputtext;
		String sqltext;
		String columntext;
		int column;
		String cname = null;

		// get user input from text area
		inputtext = inputArea.getText();
		columntext = t1.getText();
		column = Integer.parseInt(columntext);

		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       

			ResultSetMetaData meta = rset.getMetaData();


			cname = meta.getColumnLabel(column);
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage());
		}
		
		String newinput=inputtext.substring(inputtext.toLowerCase().indexOf("from"));
		newinput="select min("+cname+") \n"+newinput; 
		
		
		try 
		{
			ResultSet rset = stmt.executeQuery( newinput );       

			ResultSetMetaData meta = rset.getMetaData(); 

			int NCols = meta.getColumnCount();

			
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			
			while ( rset.next () ) 
			{
			
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");


					t2.setText(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); 
		}
   outputArea.setText(null);
		
		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       // Exec query

			ResultSetMetaData meta = rset.getMetaData(); // Get meta data

			int NCols = meta.getColumnCount();

			/* ===================================================
			 **** Print the column names before any data ****
          =================================================== */
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  // Print field name

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				// Set the length of the field to print
				// It's 2 more than the name and display size

				/* ----------------------------------------------
             Pad the attr name to length[k]
             ---------------------------------------------- */
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			/* ===========================================
          Fetch and print one row at a time....
          =========================================== */
			while ( rset.next () ) // Advance to next row
			{
				/* ===========================================
             Fetch the columns (attributes) from a row
             =========================================== */
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");


					outputArea.append(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           // De-allocate result set resources
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); // Print the error message
		}
	
		}
	}
	
	static private class MaximumListener implements ActionListener
	{  
		public void actionPerformed(ActionEvent event)
		{  outputArea.setText(null);
		String inputtext;
		String sqltext;
		String columntext;
		int column;
		String cname = null;

		// get user input from text area
		inputtext = inputArea.getText();
		columntext = t1.getText();
		column = Integer.parseInt(columntext);

		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       

			ResultSetMetaData meta = rset.getMetaData();


			cname = meta.getColumnLabel(column);
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage());
		}
		
		String newinput=inputtext.substring(inputtext.toLowerCase().indexOf("from"));
		newinput="select max("+cname+") \n"+newinput; 
		
		
		try 
		{
			ResultSet rset = stmt.executeQuery( newinput );       

			ResultSetMetaData meta = rset.getMetaData(); 

			int NCols = meta.getColumnCount();

			
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			
			while ( rset.next () ) 
			{
			
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");


					t3.setText(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); 
		}
   outputArea.setText(null);
		
		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       // Exec query

			ResultSetMetaData meta = rset.getMetaData(); // Get meta data

			int NCols = meta.getColumnCount();

			/* ===================================================
			 **** Print the column names before any data ****
          =================================================== */
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  // Print field name

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				// Set the length of the field to print
				// It's 2 more than the name and display size

				/* ----------------------------------------------
             Pad the attr name to length[k]
             ---------------------------------------------- */
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			/* ===========================================
          Fetch and print one row at a time....
          =========================================== */
			while ( rset.next () ) // Advance to next row
			{
				/* ===========================================
             Fetch the columns (attributes) from a row
             =========================================== */
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");


					outputArea.append(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           // De-allocate result set resources
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); // Print the error message
		}
	
		}
	}
	
	static private class AverageListener implements ActionListener
	{  
		public void actionPerformed(ActionEvent event)
		{  outputArea.setText(null);
		String inputtext;
		String sqltext;
		String columntext;
		int column;
		String cname = null;

		// get user input from text area
		inputtext = inputArea.getText();
		columntext = t1.getText();
		column = Integer.parseInt(columntext);

		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       

			ResultSetMetaData meta = rset.getMetaData();


			cname = meta.getColumnLabel(column);
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage());
		}
		
		String newinput=inputtext.substring(inputtext.toLowerCase().indexOf("from"));
		newinput="select avg("+cname+") \n"+newinput; 
		
		
		try 
		{
			ResultSet rset = stmt.executeQuery( newinput );       

			ResultSetMetaData meta = rset.getMetaData(); 

			int NCols = meta.getColumnCount();

			
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			
			while ( rset.next () ) 
			{
			
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");


					t4.setText(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); 
		}
   outputArea.setText(null);
		
		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       // Exec query

			ResultSetMetaData meta = rset.getMetaData(); // Get meta data

			int NCols = meta.getColumnCount();

			/* ===================================================
			 **** Print the column names before any data ****
          =================================================== */
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  // Print field name

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				// Set the length of the field to print
				// It's 2 more than the name and display size

				/* ----------------------------------------------
             Pad the attr name to length[k]
             ---------------------------------------------- */
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			/* ===========================================
          Fetch and print one row at a time....
          =========================================== */
			while ( rset.next () ) // Advance to next row
			{
				/* ===========================================
             Fetch the columns (attributes) from a row
             =========================================== */
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");


					outputArea.append(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           // De-allocate result set resources
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); // Print the error message
		}
	
		}
	}
	
	static private class medianListener implements ActionListener
	{  
		public void actionPerformed(ActionEvent event)
		{  outputArea.setText(null);
		String inputtext;
		String sqltext;
		String columntext;
		int column;
String copy = null;
		int num = 0;
                int count= 0;
int row = 0;
		String cname = null;

		// get user input from text area
		inputtext = inputArea.getText();
		columntext = t1.getText();
		column = Integer.parseInt(columntext);

		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       

			ResultSetMetaData meta = rset.getMetaData();


			cname = meta.getColumnLabel(column);
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage());
		}
		
		String newinput=inputtext.substring(inputtext.toLowerCase().indexOf("from"));
		newinput="select  "+cname+"\n"+newinput+"\n"+"order by "+cname;
		
		
		try 
		{
			ResultSet rset = stmt.executeQuery( newinput );       

			ResultSetMetaData meta = rset.getMetaData(); 

			int NCols = meta.getColumnCount();
                        

			
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			
			while ( rset.next () ) 
			{
			   row++;
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null){
						outputArea.append("NULL");
                                                count ++;}


					outputArea.append(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); 
		}
		
		
		try 
		{
			ResultSet rset = stmt.executeQuery( newinput );       

			ResultSetMetaData meta = rset.getMetaData(); 

			int NCols = meta.getColumnCount();
                        

			
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");
			

			
			while ( rset.next () ) 
			{
			   num ++;
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;
                                        

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");
                                                  outputArea.append(nextItem);


                            if((row-count)%2==1) {           
                       if(num == count+count + (row-count)/2+1)                         
               t5.setText(copy);}
else{if(num == count+count + (row-count)/2+1) 
t5.setText(Double.toString((Double.parseDouble(nextItem)+Double.parseDouble(copy))/2));
}



                       
                         copy = nextItem;


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
			   
				outputArea.append("\n");

			}

			rset.close();           
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); 
		}

 outputArea.setText(null);
		
		try 
		{
			ResultSet rset = stmt.executeQuery( inputtext );       // Exec query

			ResultSetMetaData meta = rset.getMetaData(); // Get meta data

			int NCols = meta.getColumnCount();

			/* ===================================================
			 **** Print the column names before any data ****
          =================================================== */
			for ( int i = 1; i <= NCols; i++ )
			{
				String name;

				name = meta.getColumnLabel(i);
				outputArea.append( name );  // Print field name

				length[i] = Math.max( name.length(),
						meta.getColumnDisplaySize(i) )
						+ 2;
				// Set the length of the field to print
				// It's 2 more than the name and display size

				/* ----------------------------------------------
             Pad the attr name to length[k]
             ---------------------------------------------- */
				for (int j = name.length(); j < length[i]; j++)
					outputArea.append(" ");
			}
			outputArea.append("\n");

			for ( int i = 1; i <= NCols; i++ )
				for ( int j = 0; j < length[i]; j++)
					outputArea.append("=");
			outputArea.append("\n");

			/* ===========================================
          Fetch and print one row at a time....
          =========================================== */
			while ( rset.next () ) // Advance to next row
			{
				/* ===========================================
             Fetch the columns (attributes) from a row
             =========================================== */
				for(int i = 1; i <= NCols; i++)
				{
					String nextItem;

					nextItem = rset.getString(i);
					if(nextItem == null)
						outputArea.append("NULL");


					outputArea.append(nextItem);


					if(nextItem != null){
						for (int j = nextItem.length(); j < length[i]; j++)
							outputArea.append(" ");}
					else {for (int j = 4; j < length[i]; j++)
						outputArea.append(" ");
					}
				}
				outputArea.append("\n");

			}

			rset.close();           // De-allocate result set resources
		}
		catch (Exception e) 
		{
			outputArea.append(e.getMessage()); // Print the error message
		}
		
		
		
		
		
   
	
		}
	}
	
	
	

}