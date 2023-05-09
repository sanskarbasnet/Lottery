import LinkedList.LinkedList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lottery extends InOut {
    private Set<Integer> drawnNums;
    public static LinkedList<Player> playerList = new LinkedList<Player>();
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
    public void launch() throws InterruptedException {
        int weeks = getWeeks();
        System.out.println(generateNumbers());
        populatePlayers();
        Player player;
        for(int i = 0; i < weeks; i++) {
            System.out.println("******************************************************");
            System.out.println("*                     week "+ (i+1)+"                        *");
            System.out.println("******************************************************");
            for(int j = 0; j < playerList.size(); j++) {
                player = playerList.get(j).value;
                player.setCost(player.getCost() + 2);
                checkWinnings(player.getGuessNums(), drawnNums, player);
                player.printDetails();
                System.out.println("******************************************************");
            }
        }

    }
    public void populatePlayers() throws InterruptedException {
        int num = getPlayersNum();
        Player player;
        for(int i = 0; i<num; i++){
            Thread.sleep(1000);
            System.out.println("#####################################");
            System.out.println("Player " + (i+1));
            player = new Player(inputName());
            player.setGuessNums(getNumbers());
            playerList.addLast(player);
        }
    }
    public void checkWinnings(Set guesses, Set drawnNums, Player player){
        Set intersection = guesses;
        intersection.retainAll(drawnNums);
        int matches = intersection.size();
        switch (matches){
            case 3: player.setWinnings(player.getWinnings() + 25);

                    break;
            case 4: player.setWinnings(player.getWinnings() + 100);

                    break;
            case 5: player.setWinnings(player.getWinnings() + 1000);

                    break;
            case 6: player.setWinnings(player.getWinnings() + 1000000);

                    break;
        }
    }
}
