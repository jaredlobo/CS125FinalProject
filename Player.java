package jaredjl2.illinois.edu.cardgames;

import java.util.ArrayList;

public class Player {
    private String name;
    private int points;
    private ArrayList<Card> hand;
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int number) {
        points += number;
    }
    public boolean addPoints(String input) {
        for (int i = 0; i < hand.size(); i++) {
            if (input.equalsIgnoreCase(hand.get(i).getValue())) {
                hand.remove(i);
                setPoints(1);
                return true;
            }
        }
        return false;

        //return points;

    }
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(Deck deck) {
        //deck.createDeck();
        for (int i = 0; i < 7; i++) {
            hand.add(deck.draw());
        }
    }
    public void checkHand() {
        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getValue().equals(hand.get(j).getSuit())) {
                    setPoints(1);
                    hand.remove(i);
                    hand.remove(j);
                    i--;
                    break;
                }
            }
        }
    }
}


class Card {
    private String suit;
    private String value;
    private String url;
    public Card(String suit, String value, String url) {
        this.suit = suit;
        this.value = value;
        this.url = url;
    }
    public String getSuit() {
        return suit;
    }
    public String getValue() {
        return value;
    }
    public String getUrl() {
        return url;
    }

}


class Deck {
    private ArrayList<Card> deck;
    public Deck () {

    }
    public void createDeck() {
        for (int i = 2; i < 11; i++) {
            deck.add(new Card ("HEARTS", i + "", "https://deckofcardsapi.com/static/img/" + i + "H.png"));
        }
        deck.add(new Card ("HEARTS", "JACK", "https://deckofcardsapi.com/static/img/JH.png"));
        deck.add(new Card ("HEARTS", "QUEEN", "https://deckofcardsapi.com/static/img/QH.png"));
        deck.add(new Card ("HEARTS", "KING", "https://deckofcardsapi.com/static/img/KH.png"));
        deck.add(new Card ("HEARTS", "ACE",  "https://deckofcardsapi.com/static/img/AH.png"));
        for (int i = 2; i < 11; i++) {
            deck.add(new Card ("DIAMONDS", i + "", "https://deckofcardsapi.com/static/img/" + i + "D.png"));
        }
        deck.add(new Card ("DIAMONDS", "JACK","https://deckofcardsapi.com/static/img/JD.png" ));
        deck.add(new Card ("DIAMONDS", "QUEEN","https://deckofcardsapi.com/static/img/QD.png"));
        deck.add(new Card ("DIAMONDS", "KING" , "https://deckofcardsapi.com/static/img/KD.png"));
        deck.add(new Card ("DIAMONDS", "ACE" , "https://deckofcardsapi.com/static/img/AD.png"));
        for (int i = 2; i < 11; i++) {
            deck.add(new Card ("CLUBS", i + "", "https://deckofcardsapi.com/static/img/" + i + "C.png"));
        }
        deck.add(new Card ("CLUBS", "JACK","https://deckofcardsapi.com/static/img/JC.png"));
        deck.add(new Card ("CLUBS", "QUEEN", "https://deckofcardsapi.com/static/img/QC.png"));
        deck.add(new Card ("CLUBS", "KING", "https://deckofcardsapi.com/static/img/KC.png"));
        deck.add(new Card ("CLUBS", "ACE", "https://deckofcardsapi.com/static/img/AC.png"));
        for (int i = 2; i < 11; i++) {
            deck.add(new Card ("SPADES", i + "", "https://deckofcardsapi.com/static/img/" + i + "S.png"));
        }
        deck.add(new Card ("SPADES", "JACK", "https://deckofcardsapi.com/static/img/JS.png"));
        deck.add(new Card ("SPADES", "QUEEN", "https://deckofcardsapi.com/static/img/QS.png"));
        deck.add(new Card ("SPADES", "KING", "https://deckofcardsapi.com/static/img/KS.png"));
        deck.add(new Card ("SPADES", "ACE", "https://deckofcardsapi.com/static/img/AS.png"));

    }
    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card draw() {
        int ran = (int) (Math.random() * 52);
        return deck.get(ran);
    }
}


class Game {

    public Player getWinner(Deck deck, ArrayList<Player> roster) {
        if (deck.getDeck().size() != 0) {
            return null;

        } else {
            int max = roster.get(0).getPoints()
                    ; //figure out getWinner  write up psudo for game
            Player winner = roster.get(0);
            for (int i = 1; i < roster.size(); i++) {
                if (roster.get(i).getPoints() > max) {
                    winner = roster.get(i);
                    max = roster.get(i).getPoints();
                } else if (roster.get(i).getPoints() == max) {
                    winner = null;
                }
            }
            if (winner == null) {
                return null;
            } else {
                return winner;
            }

        }

    }
}
