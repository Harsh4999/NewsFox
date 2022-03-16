package com.college.swing;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.college.javaProject.DB;

public class Entry extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JPasswordField passwordField;
	private JButton btnRegister;
	private JButton btnLogin;

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
		URL website;
		File temp = new File("data/countries+states+cities.json");
		if(!temp.exists()) {
			System.out.println("Downloading some required files......");
			try {
				website = new URL("https://raw.githubusercontent.com/dr5hn/countries-states-cities-database/master/countries%2Bstates%2Bcities.json");
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				File f = new File("data");
				if(!f.exists()) {
					f.mkdir();
				}
				FileOutputStream fos = new FileOutputStream("data/countries+states+cities.json");
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Welcome!");
		}
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogin = new JButton("Login");
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
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(186, 177, 105, 27);
		btnRegister.addMouseListener(this);
		contentPane.add(btnRegister);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Component c = e.getComponent();
		if(c.equals(btnLogin)) {
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
		}else if(c.equals(btnRegister)) {
			this.dispose();
			final RegisterFrame o = new RegisterFrame();
			o.setVisible(true);
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
