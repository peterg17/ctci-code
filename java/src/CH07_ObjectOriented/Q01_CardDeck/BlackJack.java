package CH07_ObjectOriented.Q01_CardDeck;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BlackJack {
    /*
    Problem: Design the data structures for a generic deck of cards
    Explain how you would subclass the data structures to implement blackjack
    Blackjack is when you deal cards to people when they ask for another card
    Up to 21, tie goes to the dealer

    Each blackjack class would have a card deck that is made of card objects
    The card deck is just a list of cards that are shuffled in some order
    Or we could just get a random index each time...
     */
    public CardDeck deck;
    public List<List<Card>> hands;
    public int turn;
    public int dealtIdx;
    public int nPlayers;

    public BlackJack(int numPlayers) {
        nPlayers = numPlayers;
        dealtIdx = 0;
        deck = new CardDeck();
        hands = new ArrayList<>();
        for (int i=0; i < numPlayers; i++) {
            hands.add(new ArrayList<Card>());
        }
        turn = (int) Math.floor(Math.random() * (numPlayers-1));
        assert(turn >= 0 && turn < numPlayers);
        System.out.println("before shuffle cards are: " + deck.cards);
        // shuffle cards
        Collections.shuffle(deck.cards);
        System.out.println("shuffled cards are: " + deck.cards);
    }

    public enum Suit {
        HEART,
        SPADE,
        DIAMOND,
        CLUB
    }

    public static class Card {
        public Suit suit;
        public int rank;
        public boolean isDealt;
        public Card(Suit s, int r) {
            suit = s;
            rank = r;
        }

        @Override
        public String toString() {
            return "{suit: " + suit + " , rank: " + rank + "}";
        }
    }

    public static class CardDeck {
        public List<Card> cards;

        public CardDeck() {
            // initialize all of the cards
            // represent rank as 1 - 13 (1=1, ace=13)
            cards = new ArrayList<>();
            for (int i=0; i < 13; i++) {
                Card heart = new Card(Suit.HEART, i+1);
                Card diamond = new Card(Suit.DIAMOND, i+1);
                Card spade = new Card(Suit.SPADE, i+1);
                Card club = new Card(Suit.CLUB, i+1);
                cards.add(heart);
                cards.add(diamond);
                cards.add(spade);
                cards.add(club);
            }
            System.out.println("card deck length: " + cards.size());
        }
    }


    public void dealHand() {
        // deal cards
        Card newCard = deck.cards.get(dealtIdx);
        newCard.isDealt = true;
        hands.get(turn).add(newCard);

        // check if game is over!
        
        for (int i=0; i < nPlayers; i++) {
            List<Card> playerHand = hands.get(i);
            System.out.println("player " + i  + " hand is: " + playerHand);
        }

        // set the new turn
        turn = (turn+1) % (nPlayers);
        dealtIdx++;
    }




    public static void main(String[] args) {
        System.out.println("Testing CardDeck class implementation....");
        System.out.println("Playing blackjack: " );
        BlackJack game = new BlackJack(2);
        game.dealHand();
        game.dealHand();
    }
}