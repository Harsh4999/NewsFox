package com.college.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.college.javaProject.WeatherInfo;

public class SearchPlace extends JInternalFrame {

	private JPanel contentPane;
	private  JTable table;
	private String countr,state,city;
	private WeatherInfo w;
	private  DefaultTableModel model;
	private List<String> country,states,cities;
	 private TableRowSorter sorter;
	 private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPlace frame = new SearchPlace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchPlace() {
		setTitle("Search Location!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 w = new WeatherInfo();
		 country = w.getCountries();
		String[][] rows=new String[country.size()][];
		for(int i=0;i<country.size();i++) {
			String [] temp= {country.get(i)};
			rows[i]=temp;
		}
		String[] column = {"Country"};
		  model = new DefaultTableModel(rows,column);
		    table = new JTable(model) {
		    	/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean editCellAt(int row, int column, EventObject e) {
		            return false;
		    	}
		    };
		    table.setFocusable(false);
		    sorter = new TableRowSorter<DefaultTableModel>(model);
		    table.setRowSorter(sorter);
		    table.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent e) {
		  	  if (e.getClickCount() == 2) {     // to detect doble click events
	               JTable target = (JTable)e.getSource();
	               int row = target.getSelectedRow(); // select a row
	               int column = target.getSelectedColumn(); // select a column
	               w=new WeatherInfo();
	                 if(model.getRowCount()==country.size()&&state==null) {
	                	  countr=(String) table.getValueAt(row, column);
	                	 model.getDataVector().removeAllElements();
	                	states = w.getStates(countr);
	                	   System.out.println(states);
	                		String[][] rows=new String[states.size()][];
	                		for(int i=0;i<states.size();i++) {
	                			String [] temp= {states.get(i)};
	                			rows[i]=temp;
	                		}
	                		String[] columns = {"States"};
	                		  model = new DefaultTableModel(rows,columns);
	                		  model.fireTableDataChanged();
	                		  table.setModel(model);
	                		 sorter = new TableRowSorter<DefaultTableModel>(model);
	              		    table.setRowSorter(sorter);
	                	 
	                 }else if(model.getRowCount()==states.size()&& city==null) {
	                	 state=(String) table.getValueAt(row, column);
	                	 model.getDataVector().removeAllElements();
	                	 System.out.println(countr+" "+ state);
	                	 cities = w.getCities(countr, state);
	                	   System.out.println(cities);
	                		String[][] rows=new String[cities.size()][];
	                		for(int i=0;i<cities.size();i++) {
	                			String [] temp= {cities.get(i)};
	                			rows[i]=temp;
	                		}
	                		String[] columns = {"Cities"};
	                		  model = new DefaultTableModel(rows,columns);
	                		  model.fireTableDataChanged();
	                		  table.setModel(model);
	                		  sorter = new TableRowSorter<DefaultTableModel>(model);
	              		    table.setRowSorter(sorter);
	                 }else {
	                	 city=(String) table.getValueAt(row, column);
	                	 System.out.println(countr+" "+state+" "+city);
	                	 WeatherFrame.city=city;
	                	 WeatherFrame.state=state;
	                	 WeatherFrame.country=countr;
	                	 WeatherFrame.makeVisible();
	                	 
	                 }
		  	  }
		  	}
		  });
	      table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(0, 28, 440, 558);
	      getContentPane().add(scrollPane);
	      
	      textField = new JTextField();
	      textField.setBounds(89, 0, 155, 21);
	      contentPane.add(textField);
	      textField.setColumns(10);
	      textField.getDocument().addDocumentListener(new DocumentListener() {
	          @Override
	          public void insertUpdate(DocumentEvent e) {
	             search(textField.getText());
	          }
	          @Override
	          public void removeUpdate(DocumentEvent e) {
	             search(textField.getText());
	          }
	          @Override
	          public void changedUpdate(DocumentEvent e) {
	             search(textField.getText());
	          }
	          public void search(String str) {
	             if (str.length() == 0) {
	                sorter.setRowFilter(null);
	             } else {
	                sorter.setRowFilter(RowFilter.regexFilter(str));
	             }
	          }
	       });
	      JLabel lblSearch = new JLabel("Search");
	      lblSearch.setBounds(41, 0, 60, 17);
	      contentPane.add(lblSearch);
	      
	      JButton btnReset = new JButton("Reset");
	      btnReset.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		 w = new WeatherInfo();
	      		 model.getDataVector().removeAllElements();
	    		 country = w.getCountries();
	    		String[][] rows=new String[country.size()][];
	    		for(int i=0;i<country.size();i++) {
	    			String [] temp= {country.get(i)};
	    			rows[i]=temp;
	    		}
	    		String[] column = {"Country"};
	    		 model = new DefaultTableModel(rows,column);
       		  model.fireTableDataChanged();
       		  table.setModel(model);
       		  sorter = new TableRowSorter<DefaultTableModel>(model);
     		    table.setRowSorter(sorter);
     		    countr=null;
     		    state=null;
     		    city=null;
     		    
	      	}
	      });
	      btnReset.setBounds(335, 0, 105, 27);
	      
	      contentPane.add(btnReset);
	}
	public String getCountry() {
		return countr;
	}
	public String getStat() {
		return state;
	}
	public String getCity() {
		return city;
	}
}
