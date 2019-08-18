package CardCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Handle{
    public String compare(Player player1, Player player2) {
        List<String> str1 = player1.getCards();
        List<String> str2 = player2.getCards();

        List<Integer> newStr1=CharTranNum(str1);      //處理後的fiveNumber集合
        List<Integer> newStr2=CharTranNum(str2);

        Collections.sort(newStr1);
        Collections.sort(newStr2);

        HashSet<Integer> singleStr1 = new HashSet<>(newStr1);
        HashSet<Integer> singleStr2 = new HashSet<>(newStr2);

        if(singleStr1.size()<singleStr2.size()){
            return player1.getPlayName();
        }
        if(singleStr1.size()== singleStr2.size()){
            for(int i= 0;i<= newStr1.size()-1;i++){
                if(newStr1.get(i)>newStr2.get(i)){
                    return player1.getPlayName();
                }
                if(newStr1.get(i)>newStr2.get(i)){
                    return player2.getPlayName();
                }
            }
        }
        return "peace";
    }


    private List<Integer> CharTranNum(List<String> str) {
        List<String> newCards = new ArrayList<>();
        List<Integer> FiveNumList = new ArrayList<>();

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

        for(int i=0;i<newCards.size();i++){
            char ch = newCards.get(i).charAt(0);
            int number=Integer.parseInt(String.valueOf(ch));
            FiveNumList.add(number);
        }
        return FiveNumList;
    }

}





