import java.util.HashSet;
import java.util.Set;

public class InOut {
    public void printMenu(){ //printing menu

        System.out.println("#####################################");
        System.out.println("#    Welcome to lottery Game!!      #");
        System.out.println("#####################################");
        char c;
        do {
            System.out.print("Ready to try your luck??(Y/N): ");
            c = Genio.getCharacter();
            if(c == 'Y' || c == 'y'){
                getPlayers();
                break;
            } else if( c == 'N' || c =='n') {
                System.out.println("The Game is exiting!!!");
                System.exit(0);
            }
        } while(true);


    }
    public void getPlayers(){
        System.out.println("#####################################");
        System.out.print("Enter number of Players: ");
        int num = Genio.getInteger();

    }
    public int getWeeks(){
        System.out.println("#####################################");
        int weeks;
        System.out.println("Note: Your guesses won't be changed");
        do {
            System.out.print("Enter the number of weeks you want to play: ");
            weeks = Genio.getInteger();
        } while(weeks<=0);
        return weeks;
    }
    public int getPlayersNum(){
        System.out.println("#####################################");
        int num;
        do {
            System.out.print("Enter the number of Players: ");
            num = Genio.getInteger();
        } while(num <= 0);
        return num;
    }
    public String inputName(){
        System.out.print("Enter Your Name: ");
        String name = Genio.getString();
        return name;
    }
    public Set getNumbers(){
        Set<Integer> guesses = new HashSet<>();
        int number;
        for(int i = 0; i < 6; i++) {
            do {
                System.out.print("Enter Your Guess " + (i + 1)+": ");
                number = Genio.getInteger();
                if(guesses.contains(number)){
                    System.out.println("You Can't Enter Duplicate Numbers");
                }

            } while (number < 1 || guesses.contains(number));
            guesses.add(number);
        }
        return guesses;
    }
}
