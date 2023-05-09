import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lottery extends InOut {
    private Set<Integer> drawnNums;
    private int cost;

    public Set generateNumbers(){ //generating unique numbers
        drawnNums = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 6; i ++){
            while(true){
                int uniqueNumber = random.nextInt(49) + 1;
                if(!drawnNums.contains(uniqueNumber)){ //validating if number is already generated
                    drawnNums.add(uniqueNumber);
                    break;
                }
            }
        }
        return drawnNums;
    }
    public void launch(){
        Player player1 = new Player("Sanskar");
        int weeks = getWeeks();
        for(int i = 0; i < weeks; i++) {
            player1.setCost(player1.getCost() + 2);
            System.out.println(generateNumbers());
            if(i == 0) {
                player1.setGuessNums(getNumbers());
            }
            checkWinnings(player1.getGuessNums(), drawnNums, player1);
        }
        player1.printDetails();
    }
    public void checkWinnings(Set guesses, Set drawnNums, Player player){
        Set intersection = guesses;
        intersection.retainAll(drawnNums);
        int matches = intersection.size();
        System.out.println("#############################################");
        System.out.print("Your Matched Numbers are: ");
        switch (matches){
            case 3: player.setWinnings(player.getWinnings() + 25);
                    System.out.println(intersection);
                    System.out.println("You won $25");
                    break;
            case 4: player.setWinnings(player.getWinnings() + 100);
                    System.out.println(intersection);
                    System.out.println("You won $100");
                    break;
            case 5: player.setWinnings(player.getWinnings() + 1000);
                    System.out.println(intersection);
                    System.out.println("You won $1000");
                    break;
            case 6: player.setWinnings(player.getWinnings() + 1000000);
                    System.out.println(intersection);
                    System.out.println("You Hit a JackPot!!");
                    break;
            default:
                System.out.println("None of your numbers matched");
                System.out.println("You did not win anything");
        }
    }
}
