public class NumberCard extends Card {
    public NumberCard(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }
    @Override
    public String toString() {
        return "" + value + " of " + suit;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NumberCard){
            NumberCard otherCard = (NumberCard) obj;
            if(this.value == otherCard.value) return true;
        }
        return false;
    }
}
