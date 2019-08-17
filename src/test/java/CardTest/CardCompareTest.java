package CardTest;

import CardCompare.Handle;

import java.util.Arrays;
import java.util.List;

import CardCompare.Player;
import org.junit.Assert;
import org.junit.Test;

public class CardCompareTest {
    
  @Test
  public void should_return_first_player_when_input_hightCard_type(){


         List<String> cards1 = Arrays.asList("4D");
         List<String> cards2 = Arrays.asList("6H");

         Handle handle = new Handle();

         Player player1 = new Player("player1",cards1);
         Player  player2 = new Player("player2",cards2);

         String result = handle.compare(player1,player2);

         Assert.assertEquals("player2",result);




}
}
