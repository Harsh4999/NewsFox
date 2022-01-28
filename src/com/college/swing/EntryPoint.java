package com.college.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class EntryPoint extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryPoint frame = new EntryPoint();
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
	public EntryPoint() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	
		JLabel lblNewLabel = new JLabel("Username");
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("Login");
		contentPane.add(btnLogin);
	}

}
