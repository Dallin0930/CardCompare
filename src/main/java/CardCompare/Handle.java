package CardCompare;

import java.util.List;

public class Handle{
    public String compare(Player player1, Player player2) {
        List<String> str1 = player1.getCards();
        List<String> str2 = player2.getCards();

        if(str1.get(0).charAt(0)>str2.get(0).charAt(0)){
            return player1.getPlayName();
        }else{
            return player2.getPlayName();
        }
    }
}
