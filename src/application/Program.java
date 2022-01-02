package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.logEntry;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Set<logEntry> set = new HashSet<>();
			
			String line = br.readLine();
			while (line != null) {
				
				String [] fields = line.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new logEntry(userName, moment));
				
				line = br.readLine();
			}
			System.err.println("Total users: " +set.size());
		}
		catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		sc.close();

	}

}
