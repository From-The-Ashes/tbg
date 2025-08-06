package dev.blue.tbg;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dev.blue.nml.NMLParser;
import dev.blue.nml.Node;

public class Main {
	public static Scanner scanner;
	private static int wdelay = 120;
	private static int cdelay = 400;
	private static int sdelay = 750;
	private static int ldelay = 1000;
	private static Engine engine;
	private static File save;
	private static NMLParser nml;
	private static Node root;
	public static String saveName;

	public static void main(String[] args) {
		nml = new NMLParser();
		save = new File("Plantation.nml");
		saveName = "TestSaveName";
		root = new Node("ROOT", null);
		try {
			if(save.createNewFile()) {
				System.out.println("No save file found, creating new game.");
				createDefaultSave();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			root = nml.readFromFile(save.getPath());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		//scanner = new Scanner(System.in);
		//sayfast("-------------------------TBG-------------------------\n\n\n");
		//engageMainMenu();
		//pause(1200);
		//engageCharacterCreation();
		engine = new Engine(root);
		engine.start();
	}
	
	private static void createDefaultSave() {
		Node save = root.addChild("SaveName", saveName);
		save.addChild("Time", 0);
		save.addChild("TPS", 60);
		save.addChild("Assets");
		saveGame();
	}
	
	public static Node getSave() {
		return root;
	}
	
	public static void saveGame() {
		try {
			nml.writeToFile(root, save.getPath());
		} catch (IOException e) {
			System.out.println("ERROR: Could not save game!");
			e.printStackTrace();
		}
	}
	
	public static void exitGame() {
		saveGame();
		System.exit(0);
	}
	
	private static void engageMainMenu() {}
	
	private static void engageCharacterCreation() {
		say(line(70)+"Before we begin, let's set up your character. What is their name?");
		String name = scanner.nextLine();
		say("Hello, "+name+". Tell me about yourself. Are you: \n"+
		"|| [S]edentary || [T]ypical || [A]thletic ||");
		String weight = scanner.nextLine();
		say("Hmm, ok. Well, how tall are you?\n"+
		"|| [T]all || [M]edium || [S]hort ||");
		String height = scanner.nextLine();
		say("Ok, not what I was expecting tbh. That's fine.\n"
		+"You might think looks don't really matter here, but they really do. You'll see. \nLast, is your skin: \n"
		+"|| [L]ight || [T]anned || [B]rown || [D]ark ||");
		String shade = scanner.nextLine();
		say(line(70));
	}
	
	private static String line(int length) {
		String line = "";
		for(int i = 0; i < length; i++) {
			line += "_";
		}
		line += "\n";
		return line;
	}
	
	public static void say(String message) {
		String[] words = message.split(" "); // Split the message into words by spaces
		int delay;

		for (String word : words) {
			delay = wdelay;
			System.out.print(word + " ");
			System.out.flush();
			word = word.trim();
			if(word.endsWith(".")||word.endsWith("!")||word.endsWith("?")) {
				delay = sdelay;
			}
			if(word.endsWith(",")||word.endsWith(";")) {
				delay = cdelay;
			}
			if(word.endsWith(":")) {
				delay = ldelay;
			}
			pause(delay);
		}
		System.out.println();
	}
	
	public static void sayfast(String message) {
		System.out.println(message);
	}
	
	private static void pause(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("Thread interrupted during sleep: " + e.getMessage());
		}
	}
}
