package CardCompare;

import java.util.ArrayList;
import java.util.List;

public class Handle{
    public String compare(Player player1, Player player2) {
        List<String> str1 = player1.getCards();
        List<String> str2 = player2.getCards();

        List<String> newStr1=CharTranNum(str1);
        List<String> newStr2=CharTranNum(str2);

        if(str1.get(0).charAt(0)>str2.get(0).charAt(0)){
            return player1.getPlayName();
        }else{
            return player2.getPlayName();
        }
    }

    private List<String> CharTranNum(List<String> str) {
        List<String> newCards = new ArrayList<>();
        for(int i=0;i<str.size();i++){
            String singleStr = str.get(i);
            switch(singleStr.charAt(0)){
                case 'T':
                    singleStr = "10";
                    break;
                case 'J':
                    singleStr = "11";
                    break;
                case 'Q':
                    singleStr = "12";
                    break;
                case 'K':
                    singleStr = "13";
                    break;
                case 'A':
                    singleStr = "14";
                    break;
            }
            String TwoChar = singleStr + singleStr.charAt(1);
            newCards.add(TwoChar);
        }
        return newCards;
    }

}





