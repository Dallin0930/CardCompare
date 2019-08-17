package CardCompare;

import java.util.List;

public class Player {
     private String playName;
     List<String> cards;

     public Player(String playName, List<String> cards) {
        this.playName = playName;
        this.cards = cards;
    }


    public String getPlayName() {
        return playName;
    }

    public List<String> getCards() {
        return cards;
    }
}

