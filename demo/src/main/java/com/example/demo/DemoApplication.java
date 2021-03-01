package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private ArrayList<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int selectedChoice = 0;
		while(selectedChoice != 100){
			System.out.println("*** MENU ***");
			System.out.println("1: Add New Player");
			System.out.println("3: List players");
			System.out.println("100: Exit");
			System.out.println("Enter menu choice");
			selectedChoice = Integer.parseInt(System.console().readLine());

			switch(selectedChoice){
				case 1 : addNewPlayer();
					break;
				case 3 : listPLayers();
					break;
				default: 
				System.out.println("Invalid menu choice");	

			}
			





		}
		
	}

	private void listPLayers() {
		System.out.println("*** List players ***");
		Iterator<Player> it = players.iterator();
        System.out.println("Players listed: ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
	}

	private void addNewPlayer() {
		System.out.println("*** Add new player ***");
		System.out.println("Name: ");
		String name = System.console().readLine();
		System.out.println("JerseyNumber: ");
		String jerseyNumber = System.console().readLine();
		System.out.println("Age: ");
		int age = Integer.parseInt(System.console().readLine());

		Player player = new Player(name, jerseyNumber, age);
		players.add(player);
	}

}