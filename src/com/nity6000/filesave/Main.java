package com.nity6000.filesave;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static Integer loadFromFile = 0;
	public static String one = "How old are you?";
	public static String two = "You are: ";
	public static String three = " years old";
	public static Scanner user_input = new Scanner(System.in);
	public static Integer age = 0;

	public static void main(String args[]) {
		File f = new File("data.txt");
		try (FileReader in = new FileReader(f); BufferedReader reader = new BufferedReader(in);) {

			String line = reader.readLine();
			if (line.equals("1")) {
				loadFromFile = 1;}
			else {
				loadFromFile = 0;}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (loadFromFile == 1) {
			File ageFile = new File("age.txt");
			try (FileReader read = new FileReader(ageFile); BufferedReader reader = new BufferedReader(read);) {

				String value = reader.readLine();
					
				age = Integer.parseInt(value);
				System.out.println(two + age + three);
				
				} catch (IOException e) {
					
			}

		} else {
			try {
				System.out.println(one);
				age = user_input.nextInt();
				System.out.println(two + age + three);
			} catch (InputMismatchException e) {
				System.out.println("That is not a valid number");
			}
			try {
				File file = new File("age.txt");
				File file2 = new File("data.txt");
				FileWriter fileWriter = new FileWriter(file);
				FileWriter fileWriter2 = new FileWriter(file2);
				fileWriter.write(age.toString());
				loadFromFile = 1;
				fileWriter2.write(loadFromFile.toString());
				fileWriter.flush();
				fileWriter.close();
				fileWriter2.flush();
				fileWriter2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		user_input.nextLine();

	}
}
