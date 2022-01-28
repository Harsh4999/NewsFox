package com.college.swing;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.college.javaProject.harsh.DB;
import javax.swing.JPasswordField;

public class Entry extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entry frame = new Entry();
					frame.setBounds(100, 100, 450, 300);
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
	public Entry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(this);
		btnLogin.setBounds(186, 123, 105, 27);
		contentPane.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(100, 90, 114, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(100, 74, 89, 17);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(275, 74, 60, 17);
		contentPane.add(lblPassword);
		
		label = new JLabel("");
		label.setBounds(88, 0, 271, 17);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(275, 90, 122, 21);
		contentPane.add(passwordField);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
				DB obj = new DB();
				String username = textField.getText();
				String password = passwordField.getText();
				if(obj.validate(username, password)) {
					System.out.println("Success");
					this.dispose();
					final Main o = new Main();
					o.setVisible(true);
				}else {
					label.setText("Wrong password try again!");
					textField.setText("");
					passwordField.setText("");
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
