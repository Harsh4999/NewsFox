package com.college.javaProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
abstract class shapes{
	abstract void display();
}
class sphere extends shapes{
	public long r=5;
	
	public long getR() {
		return r;
	}

	public void setR(long r) {
		this.r = r;
	}

	public void display() {
		System.out.println("hello from sphere");
	}
}
class triangle extends shapes{
	public long t;
	public void display() {
		System.out.println("hello from triangle");
	}
}
public class Test {
	public static void main(String[] args) throws IOException {
		//weather
/* 
1. All UML diagrams as stated in the lab ( Class, Activity, Use case , Sequence )
2. Code developed till date
3. Database design ( Data tables and E-R diagram)
4. DFD ( Context flow and level - 0 diagram)
//*/	//	WeatherInfo w = new WeatherInfo();
//		w.getCountries();
//		Scanner sc = new Scanner(System.in);
//		Scanner sc1 = new Scanner(System.in);
//		DB obj = new DB();
//		int choice,choice1,choice2;
//		System.out.println("Enter a choice: ");
//		System.out.println("1)Login ");
//		System.out.println("2)Register ");
//		choice = sc1.nextInt();
//		switch(choice) {
//			case 1:{
//	
//				System.out.println("Enter username: ");
//				String username = sc.nextLine();
//				System.out.println("Enter password: ");
//				String password = sc.nextLine();
//				if(obj.validate(username, password)) {
//					System.out.println("Welcome");
//					System.out.println("Enter a choice: ");
//					System.out.println("1)See Weather!");
//					System.out.println("2)See News!");
//					choice1 = sc.nextInt();
//					switch(choice1) {
//						case 1: {
//							WeatherInfo w = new WeatherInfo();
//							w.getCurrentWeather("In", "Gj", "Rajkot");
//							break;
//						}
//						case 2:{
//							System.out.println("Chose category of news");
//							System.out.println("1)All");
//							System.out.println("2)Sports");
//							System.out.println("3)Automobile");
//							System.out.println("4)Business");
//							System.out.println("5)Entertainment");
//							System.out.println("6)National");
//							System.out.println("7)Science");
//							System.out.println("8)Startup");
//							System.out.println("9)Technology");
//							System.out.println("10)World");
//							System.out.println("11)Politics");
//							choice2 = sc.nextInt();
//							News n = new News();
//							String[] category = {"all","sports","automobile","business","entertainment","national",
//									"science","startup","technology","world","politics"};
//							n.getNews(category[choice2-1]);
//							break;
//						}
//					}
//				}else {
//					System.out.println("Wrong pass");
//				}
//				break;
//			}
//			case 2:{
//				System.out.println("Enter your username: ");
//				String username = sc.nextLine();
//				System.out.println("Enter password: ");
//				String password = sc.nextLine();
//				System.out.println("Enter email: ");
//				String email = sc.nextLine();
//				User u = new User();
//				u.setUsername(username);
//				u.setPassword(password);
//				u.setEmail(email);
//				if(obj.checkUsername(username)) {
//					obj.add(u);
//				}else {
//					System.out.println("Username already taken!");
//				}
//				break;
//			}
//		}
//		sc1.close();
//		sc.close();
		
		
		shapes a [] = new shapes[5];
		a[0]= new sphere();
		sphere s = (sphere) a[0];
		System.out.println(s.getR());
		a[1] = new triangle();
		a[1].display();
	}
}
