public class FaceCard extends Card {
    protected enum Face{
        JACK, QUEEN, KING, ACE;

        int value;

        protected int getValue() {
            return value;
        }

        protected void setValue(int value) {
            this.value = value;
        }
    }

    Face face;


    public FaceCard(Face face, Suit suit){
        this.face = face;
        face.setValue(10);
        value = 10;
        this.suit = suit;
    }

    public void setFaceValue(int value){
        face.setValue(value);
        super.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + face + " of " + suit;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof FaceCard){
            FaceCard faceCard = (FaceCard)obj;
            if(this.face == faceCard.face)
                return true;
        }
        return false;
    }
}
