public class Zombie {

    private int health;
    private int damage;
    private int exp;

    public Zombie() {
        health = 50;
        damage = 5;
        exp = (int) (Math.random() * 50);
    }

    public void getHurt(int dmg) {
        if (isDead()) {
            System.out.println("Zombie is already dead");
        } else {
            health -= dmg;
            if (isDead()) {
                System.out.println("Zombie killed. +" + exp +  " exp");
            }
        }
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
