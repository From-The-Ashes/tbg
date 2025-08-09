package dev.blue.tbg;

import java.io.File;
import java.io.IOException;

import dev.blue.nml.NMLParser;
import dev.blue.nml.Node;

public class Main {
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
		engine = new Engine(root);
		engine.start();
	}
	
	private static void createDefaultSave() {//d_m_y_h_m_s
		Node save = root.addChild("SaveName", saveName);
		save.addChild("DateTime", "14_3_1800_0_0_0");
		save.addChild("TPS", 60);
		save.addChild("SecondsPerDay", 30);
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
}
