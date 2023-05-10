import java.util.HashSet;
import java.util.Set;

public class InOut {
    /**printing the menu
     *
     * @return
     * @throws InterruptedException
     */
    public int printMenu() throws InterruptedException {

        System.out.println("#####################################");
        System.out.println("#    Welcome to lottery Game!!      #");
        System.out.println("#####################################");
        char c;
        Thread.sleep(1500);
        do {
            System.out.println("(The cost of each draw is $2)");
            System.out.print("Ready to try your luck??(Y/N): ");
            c = Genio.getCharacter();
            if(c == 'Y' || c == 'y'){
                break;
            } else if( c == 'N' || c =='n') {
                System.out.println("The Game is exiting!!!");
                System.exit(0);
            }
        } while(true);
        System.out.println("Thank you for choosing to play");
        Thread.sleep(1500);
        return getMaxNum();
    }

    /**getting the range of lottery from the user
     *
     * @return
     */
    public int getMaxNum(){
        System.out.println("#####################################");
        System.out.println("#      Choose the size of Lottery   #");
        System.out.println("#####################################");
        System.out.println("[1] Small Lottery (1-21)");
        System.out.println("[2] Medium Lottery (1-50)");
        System.out.println("[3] Big Lottery (1-99)");
        int num;
        do {
        System.out.print("Enter The Lottery Type(1-3): ");
         num = Genio.getInteger();
        } while (num < 1 || num > 3);
        if(num == 1){
            return 20;
        } else if(num == 2){
            return 49;
        } else {
            return 99;
        }
    }

    /**getting number of weeks from user
     *
     * @return
     */
    public int getWeeks(){
        System.out.println("#####################################");
        int weeks;
        System.out.println("Note: Your guesses won't be changed");
        System.out.println("Note: You pay $2 for each draw");
        do {
            System.out.print("Enter the number of weeks you want to play: ");
            weeks = Genio.getInteger();
        } while(weeks<=0);
        return weeks;
    }

    /**getting number of players from the user
     *
     * @return
     */
    public int getPlayersNum(){
        System.out.println("#####################################");
        int num;
        do {
            System.out.print("Enter the number of Players: ");
            num = Genio.getInteger();
        } while(num <= 0);
        return num;
    }

    /**getting the name of player
     *
     * @return
     */
    public String inputName(){
        System.out.print("Enter Your Name: ");
        String name = Genio.getString();
        return name;
    }

    /**inputting the unique guess numbers from the user
     *
     * @param maxLim
     * @return
     */
    public Set inputNumbers(int maxLim){
        Set<Integer> guesses = new HashSet<>();
        int number;
        for(int i = 0; i < 6; i++) {
            do {
                System.out.print("Enter Your Number " + (i + 1)+": ");
                number = Genio.getInteger();
                if(guesses.contains(number)){
                    System.out.println("You Can't Enter Duplicate Numbers");
                }
                if(number > maxLim){
                    System.out.println("You can't enter values greater than " + maxLim);
                }

            } while (number < 1 || guesses.contains(number) || number > maxLim);
            guesses.add(number);
        }
        return guesses;
    }

    /**printing the result
     *
     * @param player
     * @param drawnNums
     * @param matchedNums
     */
    public void printResult(Player player, Set drawnNums, Set matchedNums){
        System.out.println("Player: " + player.getName());
        System.out.println("Your Numbers: " + player.getGuessNums());
        System.out.println("Drawn Numbers: " + drawnNums);
        if(matchedNums.isEmpty()){
            System.out.println("Matched Numbers: No Numbers matched");
        }else {
            System.out.println("Matched Numbers: " + matchedNums);
        }
        System.out.println("Total Winnings: $" + player.getWinnings());
        System.out.println("Total Cost: $" + player.getCost());
    }
}
