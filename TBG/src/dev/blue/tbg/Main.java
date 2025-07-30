package dev.blue.tbg;

import java.util.Scanner;

public class Main {
	public static Scanner scanner;
	private static int wdelay = 120;
	private static int cdelay = 400;
	private static int sdelay = 750;
	private static int ldelay = 1000;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		sayfast("-------------------------TBG-------------------------\n\n\n");
		engageMainMenu();
		pause(1200);
		engageCharacterCreation();
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
