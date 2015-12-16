import java.util.Random;
public class Deck {
	/*This teaches the enum class of java.
	 * enum can have their own attributes
	 * in this case CardType can be as follows:
	 * public enum Suit {
	 * 	CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4)
	 * int value;
	 * private Suit(int v) {value=v;}
	 */
	
	protected enum CardType {
		HEART, SPADE, CLUB, DIAMOND
	}
	
	protected enum CardValue {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}
	
	public class Card {
		CardValue number;
		CardType suite;
		
		public Card(CardValue num, CardType suite){
			this.number = num;
			this.suite = suite;
		}
	}
	
	private Card cards[] = new Card[52];
	
	public Deck() {
		int i=0;
		while(i<52){
			for(CardValue cv: CardValue.values()) {
				for(CardType ct: CardType.values()) {
					cards[i] = new Card(cv, ct);
					i++;
				}
			}
		}
	}
	
	public Card[] getCards() {
		return this.cards;
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		Card[] cards = d.getCards();
	}
	
	public void shuffleCards() {
		Random rnd = new Random();
		for(int i=cards.length-1; i>0; i--){
			int index = rnd.nextInt(i+1);
			Card c = cards[index];
			cards[index] = cards[i];
			cards[i] = c;
		}
	}
}
