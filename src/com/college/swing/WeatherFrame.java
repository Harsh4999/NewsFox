package com.college.swing;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.college.javaProject.WeatherInfo;

import javax.swing.JMenuBar;
import javax.swing.JButton;

public class WeatherFrame extends JInternalFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JButton btnAll;
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
		textPane = new JTextPane();
		textPane.setBounds(22,26,398,217);
		textPane.setContentType("text/html");
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(30, 30,1300,650);
		getContentPane().add(scrollPane);
		
		
		menuBar = new JMenuBar();
		menuBar.setBounds(28, 5, 830, 23);
		getContentPane().add(menuBar);
		
		btnAll = new JButton("Get Weather");
		btnAll.addMouseListener(this);
		 menuBar.add(btnAll); 

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		WeatherInfo w = new WeatherInfo();
		try {
			w.getCurrentWeather("in","gj","rajkot");
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
