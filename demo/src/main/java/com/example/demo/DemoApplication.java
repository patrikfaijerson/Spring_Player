package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	

	@Autowired
	private PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int selectedChoice = 0;
		while(selectedChoice != 100){
			System.out.println();
			System.out.println("*** MENU ***");
			System.out.println("1: Add New Player");
			System.out.println("2: Update Player");
			System.out.println("3: List players");
			System.out.println("4: Delete player");
			System.out.println("100: Exit");
			System.out.print("Enter menu choice: ");
			selectedChoice = Integer.parseInt(System.console().readLine());

			switch(selectedChoice){
				case 1 : addNewPlayer();
					break;
				case 2 : updatePlayer();
					break;	
				case 3 : listPLayers();
					break;
				case 4 : deletePlayer();
					break;	
				default: 
				System.out.println("Invalid menu choice");	

			}

		}
		
	}

	
	private void listPLayers() {
		System.out.println("*** List players ***");
		
		Iterable<Player> players = playerRepository.findAll();
		players.forEach(p-> {
			System.out.println(p);
		});
        
	}

	private void addNewPlayer() {
		System.out.println("*** Add new player ***");
		System.out.print("Name: ");
		String name = System.console().readLine();
		System.out.print("JerseyNumber: ");
		String jerseyNumber = System.console().readLine();
		System.out.print("Age: ");
		int age = Integer.parseInt(System.console().readLine());

		Player player = new Player(name, jerseyNumber, age);
		playerRepository.save(player);
		System.out.println("Player added");
	}

	private void updatePlayer() {
		System.out.println("*** Update Player ***");
		System.out.print("Select id of player to update: ");
		int selectedId = Integer.parseInt(System.console().readLine());
		if(playerRepository.existsById(selectedId)){
			System.out.print("Name: ");
			String name = System.console().readLine();
			System.out.print("JerseyNumber: ");
			String jerseyNumber = System.console().readLine();
			System.out.print("Age: ");
			int age = Integer.parseInt(System.console().readLine());
			Player player = new Player(name, jerseyNumber, age);
			player.setId(selectedId);
			playerRepository.save(player);
		}
		else{
			System.out.print("No player with id: " + selectedId + " exists!");
			System.out.println();
		}
		
	
	
	}
	private void deletePlayer(){
		System.out.println("*** Delete Player ***");
		System.out.print("Select id of player to update: ");
		int selectedId = Integer.parseInt(System.console().readLine());
		if(playerRepository.existsById(selectedId)){
			playerRepository.deleteById(selectedId);
		}
		else{
			System.out.print("No player with id: " + selectedId + " exists!");
			System.out.println();
		}
	
	}




}
