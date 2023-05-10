import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class Tester {
    private Set<Integer> drawnNumbers;
    //setting up the drawnNumbers set
    @Before
    public void setUp() {
        drawnNumbers = new HashSet();
        drawnNumbers.add(1);
        drawnNumbers.add(23);
        drawnNumbers.add(32);
        drawnNumbers.add(14);
        drawnNumbers.add(7);
        drawnNumbers.add(27);
    }
    @Test
    public void testIntersection(){
        Lottery lottery = new Lottery();
        lottery.setDrawnNums(drawnNumbers);
        Player player = new Player();
        Set<Integer> playerInputs = new HashSet<>();
        playerInputs.add(7);
        playerInputs.add(32);
        playerInputs.add(14);
        playerInputs.add(23);
        playerInputs.add(4);
        playerInputs.add(5);

        player.setGuessNums(playerInputs);
        lottery.checkWinnings(drawnNumbers,player);
        assertTrue(lottery.matchedNums.size() == 4); //checking the intersection numbers
        assertTrue(player.getGuessNums().equals(playerInputs)); //checking if the previous sets remained same after intersection
        assertTrue(lottery.getDrawnNums().equals(drawnNumbers));
        playerInputs.clear();

        playerInputs.add(7);
        playerInputs.add(32);
        playerInputs.add(8);
        playerInputs.add(2);
        playerInputs.add(4);
        playerInputs.add(5);
        player.setGuessNums(playerInputs);
        lottery.checkWinnings(drawnNumbers,player);
        assertTrue(lottery.matchedNums.size() == 2);//checking the intersection numbers
        assertTrue(player.getGuessNums().equals(playerInputs));//checking if the previous sets remained same after intersection
        assertTrue(lottery.getDrawnNums().equals(drawnNumbers));

    }
    @Test
    public void checkWinnings(){
        Lottery lottery = new Lottery();
        lottery.setDrawnNums(drawnNumbers);
        Player player = new Player();
        Set<Integer> playerInputs = new HashSet<>();
        playerInputs.add(7);
        playerInputs.add(32);
        playerInputs.add(14);
        playerInputs.add(23);
        playerInputs.add(4);
        playerInputs.add(5);

        player.setGuessNums(playerInputs);
        lottery.checkWinnings(drawnNumbers,player);
        assertTrue(player.getWinnings() == 100); //checking the winning amount of player
        //clearing the guessedNums and setting winning to 0
        playerInputs.clear();
        player.setWinnings(0);

        playerInputs.add(7);
        playerInputs.add(32);
        playerInputs.add(1);
        playerInputs.add(2);
        playerInputs.add(4);
        playerInputs.add(5);
        player.setGuessNums(playerInputs);
        lottery.checkWinnings(drawnNumbers,player);
        assertTrue(player.getWinnings() == 25);//checking the winning amount of player
//clearing the guessedNums and setting winning to 0
        playerInputs.clear();
        player.setWinnings(0);

        playerInputs.add(7);
        playerInputs.add(32);
        playerInputs.add(1);
        playerInputs.add(14);
        playerInputs.add(4);
        playerInputs.add(23);
        player.setGuessNums(playerInputs);
        lottery.checkWinnings(drawnNumbers,player);
        assertTrue(player.getWinnings() == 1000);//checking the winning amount of player

        playerInputs.clear(); //clearing the guessedNums and setting winning to 0
        player.setWinnings(0);

        playerInputs.add(7);
        playerInputs.add(32);
        playerInputs.add(27);
        playerInputs.add(14);
        playerInputs.add(23);
        playerInputs.add(1);
        player.setGuessNums(playerInputs);
        lottery.checkWinnings(drawnNumbers,player);
        assertTrue(player.getWinnings() == 1000000);//checking the winning amount of player
    }
}
