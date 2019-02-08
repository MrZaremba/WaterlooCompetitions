public abstract class Card {
    protected enum Suit{
        SPADES, CLUBS, HEARTS, DIAMONDS;
    }
    protected Suit suit;
    protected int value;
    public abstract int getValue();
    public abstract Suit getSuit();

}
