import java.util.Set;

public class Player extends Lottery {
    private String name;
    private Set<Integer> guessNums;
    private int cost;
    private int winnings;

    public Player() {
        cost = 0;
        winnings = 0;
    }

    /**player constructor with name parameter
     *
     * @param name
     */
    public Player(String name) {
        this.name = name;
        cost = 0; // setting cost and winning to 0 at start
        winnings = 0;
    }

    /**accessor
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**mutator
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**accessor
     *
     * @return
     */
    public Set getGuessNums() {
        return guessNums;
    }

    /**mutator
     *
     * @param guessNums
     */
    public void setGuessNums(Set guessNums) {
        this.guessNums = guessNums;
    }

    /**accessor
     *
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**mutator
     *
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**accessor
     *
     * @return
     */
    public int getWinnings() {
        return winnings;
    }

    /**mutator
     *
     * @param winnings
     */
    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }
}
