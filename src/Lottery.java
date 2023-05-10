import LinkedList.LinkedList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lottery extends InOut {
    protected Set<Integer> drawnNums;
    protected Set<Integer> matchedNums;
    public static LinkedList<Player> playerList = new LinkedList<Player>();
    private static int maxNum;

    /**generates random unique numbers
     *
     * @return
     */
    public Set generateNumbers(){
        drawnNums = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 6; i ++){
            while(true){
                int uniqueNumber = random.nextInt(maxNum) + 1;
                if(!drawnNums.contains(uniqueNumber)){ //validating if number is already generated
                    drawnNums.add(uniqueNumber);
                    break;
                }
            }
        }
        return drawnNums;
    }

    /**this method is responsible for running this class
     *
     * @throws InterruptedException
     */
    public void launch() throws InterruptedException {
        maxNum = printMenu(); //printing menu and setting the value of maxNum to the value returned bu the method
        int weeks = getWeeks(); // getting the number of weeks
        populatePlayers(); //populating the linked list with players
        Player player;
        for(int i = 0; i < weeks; i++) { //Draws lottery for weeks amount of time
            generateNumbers(); //generating differet random numbers for each week
            System.out.println("******************************************************");
            System.out.println("*                     WEEK "+ (i+1)+"                        *");
            System.out.println("******************************************************");
            for(int j = 0; j < playerList.size(); j++) { //drawing results for each player in playerList
                player = playerList.get(j).value; // getting the player object from the linkedlist
                player.setCost(player.getCost() + 2); //adding the cost of each lottery draw to the player
                checkWinnings(drawnNums, player); //checking winnings
                System.out.println("Drawing Results...");
                Thread.sleep(2500); //delaying printing
                printResult(player,drawnNums,matchedNums); //printing the results
                System.out.println("******************************************************");
            }
        }

    }

    /**This method is responsible for populating the playerList with players
     *
     * @throws InterruptedException
     */
    public void populatePlayers() throws InterruptedException {
        int num = getPlayersNum(); // getting number of players from the player
        Player player;
        for(int i = 0; i<num; i++){
            Thread.sleep(1000); //delaying printing
            System.out.println("#####################################");
            System.out.println("Player " + (i+1));
            player = new Player(inputName()); //asking player to enter their name
            player.setGuessNums(inputNumbers(maxNum)); //taking guess numbers from the player
            playerList.addLast(player); //adding the player to linkedList
        }
    }

    /**This method is responsible for checking if the player won any amount or not
     *
     * @param drawnNums
     * @param player
     */
    public void checkWinnings(Set drawnNums, Player player){
        matchedNums = new HashSet<>(player.getGuessNums()); //setting the matchedNums to the copy of set of playersNumbers
        matchedNums.retainAll(drawnNums); //finding the intersection of drawnNums and playerNums and storing it to matchedNums
        int matches = matchedNums.size(); //calculating how many matches the player got
        switch (matches){
            case 3: player.setWinnings(player.getWinnings() + 25); //if match is 3 adding 25 dollars to winnings
                    break;
            case 4: player.setWinnings(player.getWinnings() + 100); //if match is 4 adding 100 dollars to winnings
                    break;
            case 5: player.setWinnings(player.getWinnings() + 1000); //if match is 5 adding 1000 dollars to winnings
                    break;
            case 6: player.setWinnings(player.getWinnings() + 1000000); //if match is 6 adding 1000000 dollars to winnings
                    break;
        }
    }

    /**accessor
     *
     * @return
     */
    public Set<Integer> getDrawnNums() {
        return drawnNums;
    }

    /**mutator
     *
     * @param drawnNums
     */
    public void setDrawnNums(Set<Integer> drawnNums) {
        this.drawnNums = drawnNums;
    }
}
