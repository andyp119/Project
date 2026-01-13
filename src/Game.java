import java.util.Scanner;

public class Game {

    private Scanner scan;
    private Player p1;
    private Player p2;

    public Game() {
        scan = new Scanner(System.in);
        p1 = null;
        p2 = null;
    }

    public void play() {
        System.out.println("Enter player's 1 name: ");
        String p1Name = scan.nextLine();
        System.out.println("Enter player's 2 name: ");
        String p2Name = scan.nextLine();
        p1 = new Player(p1Name);
        p2 = new Player(p2Name);
        while (p1.getLevels() != 10 || p2.getLevels() != 10) {
            
        }
    }
}
