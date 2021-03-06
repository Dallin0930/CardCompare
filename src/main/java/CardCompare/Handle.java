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

        HashSet<Integer> singleStr1 = new HashSet<>(newStr1);     //得到去重後的Set集合
        HashSet<Integer> singleStr2 = new HashSet<>(newStr2);
        List<Integer> noMultiList1 = new ArrayList<>(singleStr1);         //Int型非重複元素集合
        List<Integer> noMultiList2 = new ArrayList<>(singleStr2);


        Collection singleChar1 = CollectionUtils.disjunction(newStr1,singleStr1);    //獲取重複元素
        Collection singleChar2 = CollectionUtils.disjunction(newStr2,singleStr2);
        List<Integer> singleNum1 = new ArrayList<>(singleChar1);          //Int型重複元素集合
        List<Integer> singleNum2 = new ArrayList<>(singleChar2);

        boolean resultTag=false;
        if(noMultiList2.size()==5&&noMultiList1.size()<5){
            for(int i=0,j=i+1;i<noMultiList2.size()-1;i++){
                boolean tag= noMultiList2.get(i) + 1 == noMultiList2.get(j);
                resultTag = tag;
                if(!resultTag){
                    return player2.getPlayName();
                }
            }
            if(resultTag){
                return player1.getPlayName();
            }
        }

        if(singleChar1.size()!=0 && singleChar2.size()!=0){
            if(singleStr1.size()<singleStr2.size()){
                return player1.getPlayName();
            }else if(singleStr1.size()>singleStr2.size()){
                return player2.getPlayName();
            }else{             //求和方式判斷
                int sum1 = 0;
                int sum2 = 0;
                for(int i=0;i<singleChar1.size();i++){
                    sum1+=singleNum1.get(i);
                }
                for(int i=0;i<singleChar2.size();i++){
                    sum2+=singleNum2.get(i);
                }
                if(sum1>sum2){
                    return player1.getPlayName();
                }else if(sum1<sum2){
                    return player2.getPlayName();
                }else{
                    return "peace";
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





