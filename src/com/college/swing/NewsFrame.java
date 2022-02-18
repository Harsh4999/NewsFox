package com.college.swing;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.college.javaProject.News;

public class NewsFrame extends JInternalFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	private String news;
	private JScrollPane scrollPane;
	private JButton btnAll,btnSports;
	private JMenuBar menuBar;
	private JButton btnWorld;
	private JButton button;
	private JButton btnBusiness;
	private JButton btnNational;
	private JButton btnScience;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextPane textPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsFrame frame = new NewsFrame();
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
	public NewsFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		textPane = new JTextPane();
		textPane.setBounds(22,26,398,217);
		textPane.setContentType("text/html");
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(30, 30,1300,650);
	

		
		getContentPane().add(scrollPane);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(28, 5, 830, 23);
		getContentPane().add(menuBar);
		
		btnAll = new JButton("All");
		btnAll.addMouseListener(this);
		 menuBar.add(btnAll); 
		
		btnSports = new JButton("Sports");
		btnSports.addMouseListener(this);
		 menuBar.add(btnSports);
		 
		 btnWorld = new JButton("World");
		 btnWorld.addMouseListener(this);
		 menuBar.add(btnWorld);
		 
		 button = new JButton("Automobile");
		 button.addMouseListener(this);
		 menuBar.add(button);
		 
		 btnBusiness = new JButton("Business");
		 btnBusiness.addMouseListener(this);
		 menuBar.add(btnBusiness);
		 
		 btnNational = new JButton("National");
		 btnNational.addMouseListener(this);
		 menuBar.add(btnNational);
		 
		 btnScience = new JButton("Science");
		 btnScience.addMouseListener(this);
		 menuBar.add(btnScience);
		 
		 btnNewButton = new JButton("Startup");
		 btnNewButton.addMouseListener(this);
		 menuBar.add(btnNewButton);
		 
		 btnNewButton_1 = new JButton("Politics");
		 btnNewButton_1.addMouseListener(this);
		 menuBar.add(btnNewButton_1);
		 
		 btnNewButton_2 = new JButton("Entertainment");
		 btnNewButton_2.addMouseListener(this);
		 menuBar.add(btnNewButton_2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		News o = new News();
		Component c = e.getComponent();
		try {
			if(c.equals(btnAll)) {
				news=o.getNews("all");
			}else if(c.equals(btnSports)) {
				news=o.getNews("sports");
			}else if(c.equals(btnWorld)) {
				news=o.getNews("world");
			}else if(c.equals(button)) {
				news=o.getNews("automobile");
			}else if(c.equals(btnBusiness)) {
				news=o.getNews("business");
			}else if(c.equals(btnNational)) {
				news=o.getNews("national");
			}else if(c.equals(btnScience)) {
				news=o.getNews("science");
			}else if(c.equals(btnNewButton)) {
				news=o.getNews("startup");
			}else if(c.equals(btnNewButton_1)) {
				news=o.getNews("politics");
			}else if(c.equals(btnNewButton_2)) {
				news=o.getNews("entertainment");
			}else {
				news="Error Occured";
			}
			textPane.setText(news);
			textPane.setEditable(false);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
