package logic;

import java.util.ArrayList;

public class UnitDeck{
	
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		this.cardsInDeck = new ArrayList<CardCounter>();
		setDeckName(deckName);
	}
	
	public void setDeckName(String deckName) {
		if(deckName.isBlank()) {
			this.deckName = "Untitled Deck";
		} else {
			this.deckName = deckName;
		}
	}
	
	public void addCard(UnitCard newCard, int count) {
		if (count<1) {
			return;
		}
		for(int i = 0;i < cardsInDeck.size();i++) {
			if(newCard.equals((cardsInDeck.get(i)).getCard())) {
				(cardsInDeck.get(i)).setCount((cardsInDeck.get(i)).getCount() + count);
				return;
			}
		}
		cardsInDeck.add(new CardCounter(newCard,count));
	}
	
	public void removeCard(UnitCard toRemove, int count) {
		if (count<0) {
			return;
		}
		for(int i = 0;i < cardsInDeck.size();i++) {
			if(toRemove.equals((cardsInDeck.get(i)).getCard())) {
				(cardsInDeck.get(i)).setCount((cardsInDeck.get(i)).getCount() - count);
				if((cardsInDeck.get(i)).getCount() == 0) {
					cardsInDeck.remove(i);
				}
			}
		}
	}
	
	public int cardCount() {
		int ccount = 0;
		for(int i = 0; i<cardsInDeck.size(); i++) {
			ccount += (cardsInDeck.get(i)).getCount();
		}
		return ccount;
	}
	
	public boolean existsInDeck(UnitCard card) {
		for(int i = 0;i < cardsInDeck.size(); i++) {
			if(card.equals((cardsInDeck.get(i)).getCard())) {
				return true;
			} 
		}
		return false;
	}
	
	
	public String getDeckName() {
		return this.deckName;
	}
	
	public boolean equals(UnitDeck other) {
		if(this.deckName == other.getDeckName()) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }
	
}
