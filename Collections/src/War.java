import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class War {
    private LinkedList<Card> deck;
    Player player1;
    Player player2;
    Scanner scan = new Scanner(System.in);
    ArrayList<Card> warCards = new ArrayList<>();
    Card warCard1 = null;
    Card warCard2 = null;
    protected class Player{
        LinkedList<Card> hand;
        ArrayList<Card> graveYard;
        String name;

        Player(String name, LinkedList<Card> hand){
            this.name = name;
            this.hand = hand;
            graveYard = new ArrayList<>();
        }
    }



    War(LinkedList<Card> deck){
        this.deck = deck;
        try {
            start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void start() throws InterruptedException {
        LinkedList<Card> hand1 = new LinkedList<>();
        LinkedList<Card> hand2 = new LinkedList<>();

        Collections.shuffle(deck);
        for(int i = 0; i< 26 ;i ++){
            hand1.add(deck.pollFirst());
            hand2.add(deck.pollFirst());
        }
        System.out.println("Input Players 1 Name");
        String player = scan.nextLine();
        player1 = new Player(player, hand1);
        System.out.println("Input Players 2 Name");
        player = scan.nextLine();
        player2 = new Player(player, hand2);

        while(true){
            Thread.sleep(500);
            Card p1 = player1.hand.pollFirst();
            Card p2 = player2.hand.pollFirst();
            System.out.println("Player 1 " + p1);
            System.out.println("Player 2 " + p2);

            outcome(p1, p2);
            if(player1.hand.size() == 0){
                player1.hand.addAll(player1.graveYard);
                player1.graveYard.clear();
            }
            if(player2.hand.size() == 0){
                player2.hand.addAll(player2.graveYard);
                player2.graveYard.clear();
            }
            if((player1.hand.size() == 0 && player1.graveYard.size() == 0 )|| (player2.hand.size()==0 && player2.graveYard.size() == 0)){
                break;
            }
        }
        if(player1.hand.size() == 0 ){
            System.out.println("Player 2 Wins!");
        }
        else
            System.out.println(("Player 1 Wins!"));

    }
    private void outcome(Card p1, Card p2){
        if(p1.equals(p2)){
            System.out.println("WARRRR!!!!");
            war(player1.hand.size(), player2.hand.size());
            outcome(warCard1, warCard2);
        }
        else if(p1.getValue() < p2.getValue()){
            System.out.println("Player 1 Wins! " + (warCards.size()+2) + " added to graveyard ");
            player1.graveYard.addAll(warCards);
            player1.graveYard.add(p1);
            player1.graveYard.add(p2);
            warCards.clear();
        }
        else{
            System.out.println("Player 2 Wins! " + (warCards.size()+2) + " added to graveyard ");
            player2.graveYard.addAll(warCards);
            player2.graveYard.add(p1);
            player2.graveYard.add(p2);
            warCards.clear();
        }
    }
    private void war(int size1, int size2){
        if(size1>=3) {
            if (size2 >= 3) {
                normalWar();
            }
        }
        else
            abnormalWar(player1.hand.size(), player2.hand.size());
    }
    private void normalWar(){
        player1.graveYard.add(player1.hand.pollFirst());
        player1.graveYard.add(player1.hand.pollFirst());
        player2.graveYard.add(player2.hand.pollFirst());
        player2.graveYard.add(player2.hand.pollFirst());
        warCard1 = player1.hand.pollFirst();
        warCard2 = player2.hand.pollFirst();
        player1.graveYard.add(warCard1);
        player2.graveYard.add(warCard2);
        System.out.println("Player 1 " + warCard1 + " vs " + "Player 2 " + warCard2);
        outcome(warCard1,warCard2);
    }
    private void abnormalWar(int s1, int s2){
        if(s1 >3) s1 =3;
        if(s2 > 3) s2 = 3;
        for(int i = 0; i < s1;i++){
            if(i == s1-1){
                warCard1 = player1.hand.pollFirst();
                break;
            }
            player1.graveYard.add(player1.hand.pollFirst());
        }
        for(int i = 0; i < s2;i++){
            if(i == s2-1){
                warCard2 = player2.hand.pollFirst();
                break;
            }
            player2.graveYard.add(player2.hand.pollFirst());
        }
        outcome(warCard1, warCard2);
    }
}
