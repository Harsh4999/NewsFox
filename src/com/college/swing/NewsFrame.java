package com.college.swing;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import com.college.javaProject.harsh.News;

public class NewsFrame extends JInternalFrame implements MouseListener{

	/**
	 * Launch the application.
	 */
	private JLabel lblFetching;
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
		
		JButton btnAll = new JButton("All");
		btnAll.addMouseListener(this);
		btnAll.setBounds(184, 0, 105, 27);
		getContentPane().add(btnAll);
		
		lblFetching = new JLabel("Fetching...");
		lblFetching.setBounds(198, 110, 60, 17);
		lblFetching.setVisible(false);
		getContentPane().add(lblFetching);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		News o = new News();
		try {
			lblFetching.setVisible(true);
			o.getNews("all");
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
