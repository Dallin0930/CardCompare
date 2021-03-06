package CardTest;

import CardCompare.Handle;

import java.util.Arrays;
import java.util.List;

import CardCompare.Player;
import org.junit.Assert;
import org.junit.Test;

public class CardCompareTest {

  @Test
  public void should_return_player2_when_input_4D_6H(){

         List<String> cards1 = Arrays.asList("4D");
         List<String> cards2 = Arrays.asList("6H");
         Handle handle = new Handle();
         Player player1 = new Player("player1",cards1);
         Player player2 = new Player("player2",cards2);
         String result = handle.compare(player1,player2);
         Assert.assertEquals("player2",result);
    }

    @Test
    public void should_return_player2_when_input_4D_TH(){
        List<String> cards1 = Arrays.asList("4D");
        List<String> cards2 = Arrays.asList("TH");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player2",result);
    }
    @Test
    public void should_return_player2_when_input_3C4D6H8S9D_3C4D6H7S8D(){
        List<String> cards1 = Arrays.asList("3C","4D","6H","8S","9D");
        List<String> cards2 = Arrays.asList("3C","4D","6H","7S","8D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player1",result);
    }
    @Test
    public void should_return_peace_when_input_3C4D6H8S9D_3C4D6H8S8D(){
        List<String> cards1 = Arrays.asList("3C","4D","6H","8S","9D");
        List<String> cards2 = Arrays.asList("3C","4D","6H","8S","9D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("peace",result);
    }
    @Test
    public void should_return_player1_when_input_3H3D5S7C8D_2H3D5S7C9D(){
        List<String> cards1 = Arrays.asList("3H","3D","5S","7C","8D");
        List<String> cards2 = Arrays.asList("2H","3D","5S","7C","9D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player1",result);
    }
    @Test
    public void should_return_player2_when_input_3H3D5S7C9D_4H4D5S7C8D(){
        List<String> cards1 = Arrays.asList("3H","3D","5S","7C","9D");
        List<String> cards2 = Arrays.asList("4H","4D","5S","7C","8D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player2",result);
    }
    @Test
    public void should_return_player1_when_input_3H3D5S5C8D_6H6D5S7C9D(){
        List<String> cards1 = Arrays.asList("3H","3D","5S","5C","8D");
        List<String> cards2 = Arrays.asList("6H","6D","5S","7C","9D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player1",result);
    }
    @Test
    public void should_return_player2_when_input_3H3D5S5C9D_6H6D4S4C8D(){
        List<String> cards1 = Arrays.asList("3H","3D","5S","5C","9D");
        List<String> cards2 = Arrays.asList("6H","6D","4S","4C","8D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player2",result);
    }
    @Test
    public void should_return_peace_when_input_2H2D5S5C8D_3H3D4S4C9D(){
        List<String> cards1 = Arrays.asList("2H","2D","5S","5C","8D");
        List<String> cards2 = Arrays.asList("3H","3D","4S","4C","9D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("peace",result);
    }
    @Test
    public void should_return_player1_when_input_3D3H3D5S8C_3D3H4D5S9C(){
        List<String> cards1 = Arrays.asList("3D","3H","3D","5S","8C");
        List<String> cards2 = Arrays.asList("3D","3H","4D","5S","9C");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player1",result);
    }
    @Test
    public void should_return_peace_when_input_3D3H3D5S9C_3D3H4D5S9C(){
        List<String> cards1 = Arrays.asList("3D","3H","3D","5S","9C");
        List<String> cards2 = Arrays.asList("4D","4H","4D","5S","8C");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player2",result);
    }
    @Test
    public void should_return_player2_when_input_3D3H3D5S7C_3H4D5S6C9D(){
        List<String> cards1 = Arrays.asList("3D","3H","3D","5S","7C");
        List<String> cards2 = Arrays.asList("5H","6D","7S","8C","9D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player2",result);
    }
    @Test
    public void should_return_player2_when_input_3H4D5S6C7D_5H6D7S8C9D(){
        List<String> cards1 = Arrays.asList("3H","4D","5S","6C","7D");
        List<String> cards2 = Arrays.asList("5H","6D","7S","8C","9D");
        Handle handle = new Handle();
        Player player1 = new Player("player1",cards1);
        Player  player2 = new Player("player2",cards2);
        String result = handle.compare(player1,player2);
        Assert.assertEquals("player2",result);
    }
}
