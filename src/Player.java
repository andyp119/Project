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
        zombie = new Zombie();
    }

    public int attack(Zombie zombie) {
        zombie.getHurt(damage);
        return damage;
    }

    public void expGain (int exp) {
        this.exp += exp;
    }

    public void takeDamage(int dmg) {
        if (getHealth() <= 0) {
            System.out.println("You died");
        } else {
            health -= dmg;
            if (getHealth() <= 0) {
                System.out.println("You died");
            }
        }
    }

    public void levelChange() {
        if (exp >= 1000) {
            levels = 10;
            damage = 300;
        } else if (exp >= 900) {
            levels = 9;
            damage = 200;
        } else if (exp >= 800) {
            levels = 8;
            damage = 150;
        } else if (exp >= 700) {
            levels = 7;
            damage = 125;
        } else if (exp >= 600) {
            levels = 6;
            damage = 100;
        } else if (exp >= 500) {
            levels = 5;
            damage = 75;
        } else if (exp >= 400) {
            levels = 4;
            damage = 50;
        } else if (exp >= 250) {
            levels = 3;
            damage = 40;
        } else if (exp >= 150) {
            levels = 2;
            damage = 25;
        } else if (exp >= 60) {
            levels = 1;
            damage = 15;
        } else if (exp >= 0) {
            levels = 0;
        }
    }

    public void increaseHealth () {
        health += 50;
    }

    public boolean isDead() {
        return health <= 0;
    }


    public int getLevels() {
        return levels;
    }

    public int getExp() {
        return exp;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
