import java.util.Scanner;

public class Game {

    private Scanner scan;
    private Player p1;
    private static int zombieKillCount = 0;

    public Game() {
        scan = new Scanner(System.in);
        p1 = null;
    }

    public void play() {
        System.out.print("Enter your name: ");
        String p1Name = scan.nextLine();
        p1 = new Player(p1Name);
        while (p1.getLevels() != 10) {
            Zombie zombie = zombieSpawner();
            gameRound(zombie);
            if (p1.getHealth() <= 0) {
                loseGame();
                return;
            }
            zombieKillCount++;
            p1.expGain(zombie.expDrop()); // player gets exp from killing the zombie
            System.out.println("EXP: " + p1.getExp() + "\nLEVEL: " + p1.getLevels());
            int zombieFleshAmount  = zombie.zombieFleshDrop(); // amount of zombie flesh
            System.out.println("+ " + zombieFleshAmount + " ZOMBIE FLESH");
            p1.addZombieFlesh(zombieFleshAmount); // player gets zombie flesh from killing zombie
            System.out.println("You have " + p1.getZombieFlesh() + " zombie flesh");
            System.out.println("Would you like to use a healing potion?");
            potions(); // healing potion shop
        }
        System.out.println("ZOMBIE KILLED: " + zombieKillCount);
        System.out.println("Congratulations! You reached level 10!");
    }

    public Zombie zombieSpawner() {
        Zombie zombie = new Zombie();
        if (p1.getLevels() >= 7) {
            System.out.println("---------!!!!!!!WARNING!!!!!!!---------");
            System.out.println("---------!!!!!!!WARNING!!!!!!!---------");
            System.out.println("ZOMBIE HAS MUTATED TO LEVEL 3");
            System.out.println("---------!!!!!!!WARNING!!!!!!!---------");
            System.out.println("---------!!!!!!!WARNING!!!!!!!---------");
            zombie.level7Zombie();
        } else if (p1.getLevels() >= 5) {
            System.out.println("---------WARNING!!!!!!!---------");
            System.out.println("ZOMBIE HAS MUTATED TO LEVEL 2");
            System.out.println("---------WARNING!!!!!!!---------");
            zombie.level5Zombie();
        } else if (p1.getLevels() >= 3) {
            System.out.println("---------WARNING---------");
            System.out.println("ZOMBIE HAD MUTATED TO LEVEL 1");
            System.out.println("---------WARNING---------");
            zombie.level3Zombie();
        }
        return zombie;
    }

    public void gameRound(Zombie zombie) {
        System.out.println("Kill the zombie");
        while (!zombie.isDead()) {
            System.out.println("1. Attack \n2. Check your stats");
            String input = scan.nextLine();
            if (input.equals("1")) {
                int dealt = p1.attack(zombie);
                System.out.println("ATTACKED FOR: " + dealt + " damage");
                System.out.println("ZOMBIE HP: " + zombie.getHealth());
                System.out.println("-------------------------");
                int zombieDealt = zombie.attack(); // zombie attacks player
                p1.takeDamage(zombieDealt);
                System.out.println("ZOMBIE ATTACKS FOR: " + zombieDealt + " damage");
                System.out.println("HP: " + p1.getHealth());
                if (p1.getHealth() <= 0) {
                    return;
                }
            } else if (input.equals("2")) {
                statsChecker();
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void loseGame() {
        System.out.println("You died. Game over.");
        System.out.println("ZOMBIE KILLED: " + zombieKillCount);
        System.out.println("FINAL LEVEL: " + p1.getLevels());
    }

    public void statsChecker() {
        System.out.println("LEVEL: " + p1.getLevels() +
                "\nEXP: " + p1.getExp() +
                "\nHEALTH: " + p1.getHealth() +
                "\nZOMBIE FLESH: " + p1.getZombieFlesh());
    }

    public void potions() {
        // create 5 healing potions where you get more value as price is higher.
        HealthPotion small = new HealthPotion("Small Healing Potion", 30, 10);
        HealthPotion medium = new HealthPotion("Medium Healing Potion", 75, 20);
        HealthPotion large = new HealthPotion("Large Healing Potion", 180, 40);
        HealthPotion huge = new HealthPotion("Huge Healing Potion", 250, 60);
        HealthPotion giant = new HealthPotion("Giant Healing Potion", 500, 90);

        System.out.println("1. " + small.getName() + " (" + small.getHeal() + " HP) - " + small.getCost() + " zombie flesh");
        System.out.println("2. " + medium.getName() + " (" + medium.getHeal() + " HP) - " + medium.getCost() + " zombie flesh");
        System.out.println("3. " + large.getName() + " (" + large.getHeal() + " HP) - " + large.getCost() + " zombie flesh");
        System.out.println("4. " + huge.getName() + " (" + huge.getHeal() + " HP) - " + huge.getCost() + " zombie flesh");
        System.out.println("5. " + giant.getName() + " (" + giant.getHeal() + " HP) - " + giant.getCost() + " zombie flesh");
        System.out.println("6. Skip");
        int choice = scan.nextInt();
        if (choice == 1) {
            p1.usePotion(small);
        } else if (choice == 2) {
            p1.usePotion(medium);
        } else if (choice == 3) {
            p1.usePotion(large);
        } else if (choice == 4) {
            p1.usePotion(huge);
        } else if (choice == 5) {
            p1.usePotion(giant);
        } else if (choice == 6){
            System.out.println("Skipping the purchase of healing potions");
        } else {
            System.out.println("INVALID, SKIPPING HEALING POTIONS");
        }
    }

}
