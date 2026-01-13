public class Player {

    private int health;
    private int damage;
    private String user;
    private int levels;
    private int exp;
    private Zombie zombie;

    public Player(String user) {
        this.user = user;
        damage = 10;
        health = 100;
        levels = 0;
        exp = 0;
    }

    public int attack() {
        return damage;
    }

    public void expGain (int exp) {
        this.exp += exp;
    }

    public void levelChecker () {
        if (exp >= 1000) {
            System.out.println("You are level 10");
        } else if (exp >= 900) {
            System.out.println("You are level 9");
        } else if (exp >= 800) {
            System.out.println("You are level 8");
        } else if (exp >= 700) {
            System.out.println("You are level 7");
        } else if (exp >= 600) {
            System.out.println("You are level 6");
        } else if (exp >= 500) {
            System.out.println("You are level 5");
        } else if (exp >= 400) {
            System.out.println("You are level 4");
        } else if (exp >= 300) {
            System.out.println("You are level 3");
        } else if (exp >= 200) {
            System.out.println("You are level 2");
        } else if (exp >= 100) {
            System.out.println("You are level 1");
        } else if (exp >= 0) {
            System.out.println("You are level 0");
        }
    }
}
