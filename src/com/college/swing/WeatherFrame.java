package com.college.swing;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import org.json.simple.JSONObject;

import com.college.javaProject.WeatherInfo;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WeatherFrame extends JInternalFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JFrame searchPlace;
	public static String country,state,city;
	private static  JButton btnFetch ;
	private JInternalFrame search;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherFrame frame = new WeatherFrame();
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
	public WeatherFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		search = new SearchPlace();
		search.setBounds(20,26,480,600);
		search.setVisible(true);
		getContentPane().add(search);
		textPane = new JTextPane();
		textPane.setBounds(500,26,750,600);
		textPane.setContentType("text/html");
		getContentPane().add(textPane);
//		scrollPane = new JScrollPane(textPane);
//		scrollPane.setBounds(30, 30,1300,650);
//		getContentPane().add(scrollPane);
		
		
		menuBar = new JMenuBar();
		menuBar.setBounds(28, 5, 830, 23);
		getContentPane().add(menuBar);
		
		  btnFetch = new JButton("Fetch");
		  btnFetch.addMouseListener(this);
		  btnFetch.setVisible(false);
		 menuBar.add(btnFetch);
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent().equals(btnFetch)) {
			WeatherInfo w = new WeatherInfo();
			JSONObject city2 = w.getCity(country, state, city);
			if(city2!=null) {
				System.out.println(city2);
				String lat = (String) city2.get("latitude");
				String lon = (String) city2.get("longitude");
				try {
					String html=w.getCurrentWeather(lat, lon);
					textPane.setEditable(false);
					textPane.setContentType("text/html");
					textPane.setText(html);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
	public static void makeVisible() {
		if(state!=null && country!=null && city!=null) {
			btnFetch.setVisible(true);
		}
	}
}
