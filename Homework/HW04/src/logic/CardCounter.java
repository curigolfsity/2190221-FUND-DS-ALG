package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	
	public CardCounter(UnitCard card, int count) {
		this.setCard(card);
		this.setCount(count);
	}
	
	public int getCount() {
		return count;
	}
	
	public UnitCard getCard() {
		return card;
	}
	
	public void setCount(int count) {
		this.count = (count < 0) ? 0 : count;
	}
	
	public void setCard(UnitCard card) {
		this.card = card;
	}
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}

}
