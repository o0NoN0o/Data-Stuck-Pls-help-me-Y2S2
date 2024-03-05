package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}
	
	public CardCounter(UnitCard card, int count) {
		setCount(count);
		setCard(card);
	}
	
	public void setCount(int count) {
		if(count < 0) {
			this.count = 0;
		} else {
			this.count = count;
		}
	}
	
	public void setCard(UnitCard card) {
		this.card = card;
	}
	
	public int getCount() {
		return this.count;
	}

	public UnitCard getCard() {
		return this.card;
	}
	
}
