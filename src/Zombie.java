public class Zombie {

    private int health;
    private int damage;
    private int exp;
    private int zombieFlesh;

    public Zombie() {
        health = 50;
        damage = 5;
        zombieFlesh = (int) (Math.random() * 11) + 5;
        exp = (int) (Math.random() * 50);
    }

    public void level3Zombie() {
        health = 100;
        damage = 20;
        zombieFlesh = (int) (Math.random() * 16) + 20;
    }

    public void level5Zombie() {
        health = 300;
        damage = 50;
        zombieFlesh = (int) (Math.random() * 16) + 30;
    }

    public void level7Zombie() {
        health = 500;
        damage = 100;
        zombieFlesh = (int) (Math.random() * 16) + 40;
    }

    public void takeDamage(int dmg) {
        if (!isDead()) {
            health -= dmg;
            if (isDead()) {
                System.out.println("Zombie killed! +" + exp + " exp");
            }
        }
    }

    public int zombieFleshDrop() {
        return zombieFlesh;
    }

    public int attack() {
        return damage;
    }

    public int expDrop() {
        return exp;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
