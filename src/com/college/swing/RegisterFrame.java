package com.college.swing;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.college.javaProject.DB;
import com.college.javaProject.User;

public class RegisterFrame extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JLabel lblUserRegisteredSuccessfully;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(38, 107, 114, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 107, 124, 21);
		contentPane.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 87, 83, 17);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(163, 87, 60, 17);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 107, 114, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(300, 87, 60, 17);
		contentPane.add(lblEmail);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(156, 168, 105, 27);
		btnRegister.addMouseListener(this);
		contentPane.add(btnRegister);
		
		lblUserRegisteredSuccessfully = new JLabel("User registered successfully");
		lblUserRegisteredSuccessfully.setBounds(135, 12, 183, 17);
		lblUserRegisteredSuccessfully.setVisible(false);
		contentPane.add(lblUserRegisteredSuccessfully);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String username = textField.getText();
		String password = passwordField.getText();
		String email = textField_1.getText();
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);
		u.setPasswordChanged((long) 0);
		DB db = new DB();
		User u1 = db.add(u);
		System.out.println(u1);
		if(u1!=null) {
			textField.setText("");
			textField_1.setText("");
			passwordField.setText("");
			lblUserRegisteredSuccessfully.setVisible(true);
			this.dispose();
			Main o = new Main();
			o.setVisible(true);
		}else {
			lblUserRegisteredSuccessfully.setText("User registration failed!");
			textField.setText("");
			textField_1.setText("");
			passwordField.setText("");
			lblUserRegisteredSuccessfully.setVisible(true);
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
