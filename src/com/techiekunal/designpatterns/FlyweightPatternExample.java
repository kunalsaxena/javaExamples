package com.techiekunal.designpatterns;

import java.util.*;

/**
 * We need four things for flyweight pattern implementation <br/>
 * 1st: someone to manage all objects(pooling or caching) : <b> FlyweightFactory
 * Class </b> <br/>
 * 2nd: Flyweight object blueprint : <b> An Flyweight Interface </b> <br/>
 * 3rd: Concrete Implementation : <b> Flyweight Object that will have extrinsic
 * properties </b> <br/>
 * <br/>
 * 4th: Client Object : <b> Flyweight Object that will have intrinsic
 * properties</b> <br/>
 * <br/>
 * 
 * In this example we will implement flyweight design pattern for program like
 * MSWord, each char will be flyweight object. we will call this object "letter"
 * 
 * @author kunalsaxena
 *
 */

class LetterFactory {

	// Associative array(map) to store FWChar objects which will be reused
	private static Map<String, ConcreteLetter> objectPool = new HashMap<>();

	/*
	 * Factory method to return instance :: return existing object if present
	 * otherwise create new and return
	 */
	public static Letter getFWChar(String key) {
		ConcreteLetter cLetter = objectPool.get(key);
		if (cLetter == null) {
			cLetter = new ConcreteLetter();
			cLetter.setExterinsicProperties(key, 10);
			objectPool.put(key, cLetter);
		}
		return cLetter;

	}
}

/**
 * interface for setting up extrinsic properties
 * 
 * @author kunalsaxena
 *
 */
interface Letter {
	void setExterinsicProperties(String fontName, int fontSize);
}

/**
 * Concrete Implementation of flyweight object
 * 
 * @author kunalsaxena
 *
 */
class ConcreteLetter implements Letter {

	// Extrinsic property
	private String fontName;

	// Extrinsic property
	private int fontSize = 10; // default size

	@Override
	public void setExterinsicProperties(String fontName, int fontSize) {
		this.fontName = fontName;
		this.fontSize = fontSize;
	}

	// equality will be based on font name
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Letter))
			return false;
		ConcreteLetter cfwchar = (ConcreteLetter) obj;
		return cfwchar.fontName.equals(this.fontName);
	}

	@Override
	public int hashCode() {
		return this.fontName.hashCode();
	}

}

/**
 * Client object. will have intrinsic properties.
 * 
 * @author kunalsaxena
 *
 */
class LetterClient {

	final Letter letterStyle;

	// intrinsic property
	int charLocation;

	// intrinsic property
	char letter;

	public LetterClient(String fontName, char letter, int location) {
		letterStyle = LetterFactory.getFWChar(fontName);
		this.letter = letter;
		this.charLocation = location;
	}

	@Override
	public String toString() {
		return letterStyle.hashCode() + "";
	}

}

public class FlyweightPatternExample {

	public static void main(String[] args) {

		// say we have written "Hello World" :: char count 6
		
		// hello is with font "Helvetica"
		LetterClient c1 = new LetterClient("Helvetica", 'h', 1);
		LetterClient c2 = new LetterClient("Helvetica", 'e', 2);
		LetterClient c3 = new LetterClient("Helvetica", 'l', 3);
		LetterClient c4 = new LetterClient("Helvetica", 'l', 4);
		LetterClient c5 = new LetterClient("Helvetica", 'o', 5);

		// one location consumed by space char
		LetterClient c6 = new LetterClient("Calibri", ' ', 6);

		// world is with font "Calibri"
		LetterClient c7 = new LetterClient("Calibri", 'w', 7);
		LetterClient c8 = new LetterClient("Calibri", 'o', 8);
		LetterClient c9 = new LetterClient("Calibri", 'r', 9);
		LetterClient c10 = new LetterClient("Calibri", 'l', 10);
		LetterClient c11 = new LetterClient("Calibri", 'd', 11);

		// now FWChar object for c3 and c4 should be equal :: same font properties
		if (c3.letterStyle.equals(c4.letterStyle))
			System.out.println("c3 " + c3 + " and c4 " + c4 + " are equal");
		else
			System.out.println("c3 " + c3 + " and c4 " + c4 + " are not equal");

		// now FWChar object for c5 and c8 should not be equal :: different font
		// properties
		if (c5.letterStyle.equals(c8.letterStyle))
			System.out.println("c5 " + c5 + " and c8 " + c8 + " are equal");
		else
			System.out.println("c5 " + c5 + " and c8 " + c8 + " are not equal");
	}

}
