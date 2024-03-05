package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		//TODO: Fill Code
		for(int i = 0;i < list.size(); i++) {
			if(card.equals((list.get(i)))) {
				return true;
			} 
		}
		return false;
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		
		//TODO: Fill Code
		for(int i = 0;i < list.size(); i++) {
			if(deck.equals(list.get(i))) {
				return true;
			} 
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		
		//TODO: Fill Code
		for(int i = 0;i < deckList.size(); i++) {
			if((deckList.get(i)).existsInDeck(cardToTest)) {
				return true;
			} 
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		//TODO: Fill Code
		try {
			Scanner read = new Scanner(fileToRead);
			while(read.hasNext()) {
				String line = read.nextLine();
				String[] elements = line.split(",");
				try {
					
					if (elements.length != 5) {
						throw new NumberFormatException();
		            }
				
				UnitCard card = new UnitCard(elements[0],Integer.parseInt(elements[1]),Integer.parseInt(elements[2]),Integer.parseInt(elements[3]),elements[4]);
				cardsFromFile.add(card);
			} catch (NumberFormatException e) {
				System.out.println("File contains string with incorrect format!");
				read.close();
                return null;
			}
		}
		read.close();
		} catch (FileNotFoundException e){
			System.out.println("Cannot find file!");
			return null;
		}
		return cardsFromFile;
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
