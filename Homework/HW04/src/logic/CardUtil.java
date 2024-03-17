package logic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		//TODO: Fill Code
		for (UnitCard tmpCard : list) if (tmpCard.equals(card)) return true;
		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		
		//TODO: Fill Code
		for (UnitDeck tmpDeck : list) if (tmpDeck.equals(deck)) return true;
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		
		//TODO: Fill Code
		for (UnitDeck tmpDeck : deckList) if (tmpDeck.existsInDeck(cardToTest)) return true;
		return false;
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<UnitCard> getCardsFromFile(String filename) {
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		//TODO: Fill Code
		Scanner reader = null;
		try {
			reader = new Scanner(fileToRead);
			while (reader.hasNextLine()) {
				try {
					String[] tmpString = reader.nextLine().split(",");
					cardsFromFile.add(new UnitCard(tmpString[0],Integer.parseInt(tmpString[1]),
							Integer.parseInt(tmpString[2]),Integer.parseInt(tmpString[3]),tmpString[4]));
				} catch (Exception e) {
					System.out.println("Flie contains string with incorrect format!");
					return null;
				}
			}
			reader.close();
			return cardsFromFile;
		} catch (FileNotFoundException e) {
			System.out.println("Can not find file!");
			return null;
		}
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
