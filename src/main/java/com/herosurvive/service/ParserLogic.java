package com.herosurvive.service;

import java.util.List;

import com.herosurvice.models.Enemy;
import com.herosurvice.models.ParsedData;

public class ParserLogic {
	private static ParserLogic _parser;

	public ParsedData parsedData;
	String[] keywords;

	private ParserLogic() {
		keywords = getKeywords();
	}

	public static synchronized ParserLogic getInstance() {
		if (_parser == null)
			_parser = new ParserLogic();

		return _parser;
	}

	public void parseWholeFile(List<String> inputData) {
		// some lines are clear, 0 = Resource & 1 = Hero.hp & 2 =
		// Hero.attackpoint & 2-EnemyEndPoint = Enemy declaration &
		// EnemyEndPoint-FileEndPoint = Enemies.forEach(e => return e.position)
		parsedData.resourcePoint = parseSpecificLine(inputData.get(0));
		parsedData.hero.hp = parseSpecificLine(inputData.get(1));
		parsedData.hero.attackPoint = parseSpecificLine(inputData.get(2));
		// now get each enemy of unknown number 
		
		List<Enemy> enemies;
		
		
		// get the known number of enemies position
	}
	
	
	
	public int parseSpecificLine(String resourceLine) { // Example : Resources are 7500
															// meters away
		String[] array = resourceLine.split(" ");
		for (String item : array) {
			if (checkIfNumber(item)) {
				return Integer.parseInt(item);
			}
		}

		return 0; //
	}

	public String[] getKeywords() {
		return "resources*hero*enemy*has*attack*there is a".split("\\*");
	}

	Boolean checkIfNumber(String input) {
		input = input.trim();
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}