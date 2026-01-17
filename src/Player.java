public class Player {

    private int health;
    private int damage;
    private String user;
    private int levels;
    private int exp;
    private Zombie zombie;
    private int zombieFlesh;

    public Player(String user) {
        this.user = user;
        damage = 10;
        health = 150;
        levels = 0;
        exp = 0;
        zombieFlesh = 0;
        zombie = new Zombie();
    }

    public int attack(Zombie zombie) {
        int chance = (int)(Math.random()*10 + 1);
        int dealt = damage;
        if (chance == 10) {
            dealt *= 2; System.out.println("CRITICAL! X2 DAMAGE");
        }
        else if (chance >= 2) {
            System.out.println("You dealt regular damage");
        }
        else {
            dealt = 0;
            System.out.println("Wow. You missed");
        }
        zombie.takeDamage(dealt);
        return dealt;
    }

    public void expGain (int exp) {
        this.exp += exp;
        checkLevel();
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) {
            health = 0;
        }
    }

    public int getLevels() {
        if (exp >= 1000) {
            levels = 10;
            damage = 300;
        } else if (exp >= 1000) {
            levels = 9;
            damage = 200;
        } else if (exp >= 900) {
            levels = 8;
            damage = 150;
        } else if (exp >= 750) {
            levels = 7;
            damage = 125;
        } else if (exp >= 500) {
            levels = 6;
            damage = 100;
        } else if (exp >= 400) {
            levels = 5;
            damage = 75;
        } else if (exp >= 300) {
            levels = 4;
            damage = 50;
        } else if (exp >= 200) {
            levels = 3;
            damage = 40;
        } else if (exp >= 125) {
            levels = 2;
            damage = 25;
        } else if (exp >= 50) {
            levels = 1;
            damage = 15;
        } else if (exp >= 0) {
            levels = 0;
        }
        return levels;
    }

    public void checkLevel() {
        int oldLevel = levels;
        if (levels > oldLevel) {
            health+=50;
            System.out.println("LEVEL UP! You gained 50 hp");
        }
    }

    public void addZombieFlesh(int zf) {
        zombieFlesh += zf;
    }

    public void usePotion(HealthPotion potion) {
        if (zombieFlesh >= potion.getCost()) {
            health += potion.getHeal();
            zombieFlesh -= potion.getCost();
            System.out.println("You used " + potion.getName() + " and healed " + potion.getHeal() + " HP.");
            System.out.println("Current HP: " + health + "\nZombie flesh left: " + zombieFlesh);
        } else {
            System.out.println("Not enough zombie flesh to buy " + potion.getName());
        }
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

    public int getZombieFlesh() {
        return zombieFlesh;
    }
}

    public int getHealth() {
        return health;
    }
}
