package CardCompare;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class Handle{
    public String compare(Player player1, Player player2) {
        List<String> str1 = player1.getCards();
        List<String> str2 = player2.getCards();

        List<Integer> newStr1=CharTranNum(str1);      //處理後的fiveNumber集合   :數字
        List<Integer> newStr2=CharTranNum(str2);

        Collections.sort(newStr1);
        Collections.sort(newStr2);

        HashSet<Integer> singleStr1 = new HashSet<>(newStr1);    //得到去重後的Set集合
        HashSet<Integer> singleStr2 = new HashSet<>(newStr2);

        Collection singleChar1 = CollectionUtils.disjunction(newStr1,singleStr1);    //獲取重複元素
        Collection singleChar2 = CollectionUtils.disjunction(newStr2,singleStr2);
        List<Integer> singleNum1 = new ArrayList<>(singleChar1);
        List<Integer> singleNum2 = new ArrayList<>(singleChar2);


        if(singleChar1.size()!=0 && singleChar2.size()!=0){
            if(singleStr1.size()<singleStr2.size()){
                return player1.getPlayName();
            }else if(singleStr1.size()>singleStr2.size()){
                return player2.getPlayName();
            }else{
                if(singleNum1.get(0)<singleNum2.get(0)){
                    return player2.getPlayName();
                }else if(singleNum1.get(0)>singleNum2.get(0)){
                    return player1.getPlayName();
                }
            }
        }
        for(int i= 0;i<= newStr1.size()-1;i++){
            if(newStr1.get(i)>newStr2.get(i)){
                return player1.getPlayName();
            }
            if(newStr1.get(i)>newStr2.get(i)){
                return player2.getPlayName();
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





