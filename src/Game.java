import java.util.Scanner;

public class Game {

    private Scanner scan;
    private Player p1;

    public Game() {
        scan = new Scanner(System.in);
        p1 = null;;
    }

    public void play() {
        System.out.print("Enter your name: ");
        String p1Name = scan.nextLine();
        p1 = new Player(p1Name);
        while (p1.getLevels() != 10) {
            Zombie zombie = new Zombie();
            System.out.println("Kill the zombie");
            while (!zombie.isDead()) {
                System.out.println("1. Attack \n2. Check your level and exp");
                String input = scan.nextLine();
                if (input.equals("1")) {
                    p1.attack(zombie);
                    System.out.println("You attacked for " + p1.getDamage() + " damage");
                    System.out.println("The zombie has " + zombie.getHealth() + " hp");
                    System.out.println("-------------------------");
                    p1.takeDamage(zombie.attack());
                    System.out.println("The zombie had attacked you for " + zombie.getDamage() + " damage.");
                    System.out.println("You have " + p1.getHealth() + " hp");

                }
                if (input.equals("2")) {
                    System.out.println("You are level: " + p1.getLevels() + " and you have " + p1.getExp() + " exp");
                }
            }
            p1.expGain(zombie.expDrop());
            System.out.println("You have " + p1.getExp() + " exp and you are level " + p1.getLevels());
            if (p1.getLevels() >= 3) {
                zombie.setHealth(100);
                zombie.setDamage(20);
            }
        }
    }
}
