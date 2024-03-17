package logic;

import java.util.ArrayList;

public class UnitDeck{
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		cardsInDeck = new ArrayList<CardCounter>();
		this.setDeckName(deckName);
	}
	
	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck=cardsInDeck;
	}
	
	public ArrayList<CardCounter> getCardsInDeck(){
		return this.cardsInDeck;
	}
	
	public void setDeckName(String deckName) {
		if (deckName.isBlank()) this.deckName="Untitled Deck";
		else this.deckName=deckName;
	}
	
	public String getDeckName() {
		return this.deckName;
	}
	
	public void addCard(UnitCard newCard, int count) {
		if (count<=0) return;
		if (this.existsInDeck(newCard)) {
			for (CardCounter tmpCard: this.cardsInDeck) {
				if (tmpCard.getCard().equals(newCard)) {
					tmpCard.setCount(tmpCard.getCount()+count);
					return;
				}
			}
		}else {
			cardsInDeck.add(new CardCounter(newCard,count));
		}
	}
	
	public void removeCard(UnitCard toRemove, int count) {
		if (count<=0 || !this.existsInDeck(toRemove)) return;
		if (this.existsInDeck(toRemove)) {
			for (CardCounter tmpCard: this.cardsInDeck) {
				if (tmpCard.getCard().equals(toRemove)) {
					tmpCard.setCount(tmpCard.getCount()-count);
					if (tmpCard.getCount()==0) cardsInDeck.remove(tmpCard);
					return;
				}
			}
		}
	}
	
	public int cardCount() {
		int countSum=0;
		for (CardCounter tmpCard: cardsInDeck) {
			countSum+=tmpCard.getCount();
		}
		return countSum;
	}
	
	public boolean existsInDeck(UnitCard card) {
		for (CardCounter tmpCard: cardsInDeck) {
			if (tmpCard.getCard().equals(card) && tmpCard.getCount() >=1) return true;
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		return this.deckName.equals(other.getDeckName());
	}
}