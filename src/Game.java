import java.util.Scanner;

public class Game {

    private Scanner scan;
    private Player p1;
    private int zombieKilled;

    public Game() {
        scan = new Scanner(System.in);
        p1 = null;
        zombieKilled = 0;
    }

    public void play() {
        System.out.print("Enter your name: ");
        String p1Name = scan.nextLine();
        p1 = new Player(p1Name);
        while (!isGameOver()) {
            Zombie zombie = new Zombie();
            if (p1.getLevels() >= 5) {
                System.out.println("ZOMBIE UPGRADED");
                zombie.setHealth(250);
                zombie.setDamage(100);
                System.out.println("ZOMBIE HEALTH " + zombie.getHealth());
                System.out.println("ZOMBIE DAMAGE " + zombie.getDamage());
            } else if (p1.getLevels() >= 3) {
                System.out.println("ZOMBIE UPGRADED");
                zombie.setHealth(100);
                zombie.setDamage(50);
                System.out.println("ZOMBIE HEALTH " + zombie.getHealth());
                System.out.println("ZOMBIE DAMAGE " + zombie.getDamage());
            }
            System.out.println("Kill the zombie");
            while (!zombie.isDead()) {
                System.out.println("1. Attack \n2. Check your level and exp");
                String input = scan.nextLine();
                if (input.equals("1")) {
                    System.out.println("You attacked for " + p1.getDamage() + " damage");
                    p1.attack(zombie);
                    System.out.println("The zombie has " + zombie.getHealth() + " hp");
                    System.out.println("-------------------------");
                    p1.takeDamage(zombie.attack());
                    System.out.println("The zombie attacked you for " + zombie.getDamage() + " damage.");
                    System.out.println("You have " + p1.getHealth() + " hp");
                    System.out.println("ARE YOU DEAD: " + p1.isDead());

                }
                if (input.equals("2")) {
                    System.out.println("You are level " + p1.getLevels() + " and you have " + p1.getExp() + " exp");
                }
            }
            zombieKilled++;
            p1.expGain(zombie.expDrop());
            p1.levelChange();
            p1.increaseHealth();
            System.out.println("You have " + p1.getExp() + " exp and you are level " + p1.getLevels());
        }
        endGameStats();
    }

    public boolean isGameOver() {
        return (p1.isDead() || p1.getLevels() >= 10);
    }

    public void endGameStats() {
        System.out.println("Level: " + p1.getLevels());
        System.out.println("EXP: " + p1.getExp());
        System.out.println("Zombie killed: " + zombieKilled);
    }
}
