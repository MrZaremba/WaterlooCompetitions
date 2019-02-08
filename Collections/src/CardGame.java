import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGame {
    public static LinkedList<Card> deck = new LinkedList<>();
    public static ArrayList<Card> hand = new ArrayList<>();
    private static void buildDeck(){
        for(int i = 2 ; i< 11;i++){
            deck.add(new NumberCard(i, Card.Suit.HEARTS));
            deck.add(new NumberCard(i, Card.Suit.CLUBS));
            deck.add(new NumberCard(i, Card.Suit.SPADES));
            deck.add(new NumberCard(i, Card.Suit.DIAMONDS));
        }
        deck.add(new FaceCard(FaceCard.Face.ACE, Card.Suit.HEARTS));
        deck.add(new FaceCard(FaceCard.Face.KING, Card.Suit.HEARTS));
        deck.add(new FaceCard(FaceCard.Face.QUEEN, Card.Suit.HEARTS));
        deck.add(new FaceCard(FaceCard.Face.JACK, Card.Suit.HEARTS));
        deck.add(new FaceCard(FaceCard.Face.ACE, Card.Suit.SPADES));
        deck.add(new FaceCard(FaceCard.Face.KING, Card.Suit.SPADES));
        deck.add(new FaceCard(FaceCard.Face.QUEEN, Card.Suit.SPADES));
        deck.add(new FaceCard(FaceCard.Face.JACK, Card.Suit.SPADES));
        deck.add(new FaceCard(FaceCard.Face.ACE, Card.Suit.CLUBS));
        deck.add(new FaceCard(FaceCard.Face.KING, Card.Suit.CLUBS));
        deck.add(new FaceCard(FaceCard.Face.QUEEN, Card.Suit.CLUBS));
        deck.add(new FaceCard(FaceCard.Face.JACK, Card.Suit.CLUBS));
        deck.add(new FaceCard(FaceCard.Face.ACE, Card.Suit.DIAMONDS));
        deck.add(new FaceCard(FaceCard.Face.KING, Card.Suit.DIAMONDS));
        deck.add(new FaceCard(FaceCard.Face.QUEEN, Card.Suit.DIAMONDS));
        deck.add(new FaceCard(FaceCard.Face.JACK, Card.Suit.DIAMONDS));
    }
    public static void createHand(int size){
        for(int i = 0; i < size;i++){
            hand.add(deck.pollFirst());
        }
    }
    public static void main(String[] args) {
        buildDeck();
        War game = new War(deck);

    }
}
