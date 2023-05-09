import java.util.Set;

public class Player {
    private String name;
    private Set<Integer> guessNums;
    private int cost;
    private int winnings;

    public Player() {
        cost = 0;
        winnings = 0;
    }

    public Player(String name) {
        this.name = name;
        cost = 0;
        winnings = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getGuessNums() {
        return guessNums;
    }

    public void setGuessNums(Set guessNums) {
        this.guessNums = guessNums;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }
    public void printDetails(){
        System.out.println("########################");
        System.out.println(name + ":");
        System.out.println("Winnings: $" + winnings);
        System.out.println("Cost: $" + cost);
        System.out.println("#######################");
    }
}
