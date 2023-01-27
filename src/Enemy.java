import java.util.Arrays;
import java.util.Random;

public class Enemy {
    private int enemyMaxHealth;
    private int enemyHealth;
    private int enemyDamage;
    private String enemyName;

    private Enemy(String enemyName, int enemyMaxHealth, int enemyDamage) {
        this.enemyName = enemyName;
        this.enemyMaxHealth = enemyMaxHealth;
        this.enemyHealth = enemyMaxHealth;
        this.enemyDamage = enemyDamage;
    }
    public static Enemy instanceEnemy() {
        Random rand = new Random();
        int enemyStrength = 10 *(1+Data.level/5);

        int enemyMaxHealth = rand.nextInt(enemyStrength)+1;
        int enemyDamage = enemyStrength+1 - enemyMaxHealth;

        return new Enemy(Data.enemyNames.get(rand.nextInt(Data.enemyNames.size())), enemyMaxHealth,enemyDamage);
    }
    public static Enemy[] instanceEnemyGroup(int count) {
        Random rand = new Random();
        Enemy[] enemies = new Enemy[10];

        for (int i = 0; i < count; i++) {
            int enemyStrength = (10*(1+Data.level/5))/(count/2);

            int enemyMaxHealth = rand.nextInt(enemyStrength)+1;
            int enemyDamage = enemyStrength+1 - enemyMaxHealth;

            enemies[i]= new Enemy(Data.enemyNames.get(rand.nextInt(Data.enemyNames.size())), enemyMaxHealth,enemyDamage);
        }

        return enemies;
    }

    public int getEnemyMaxHealth() {
        return enemyMaxHealth;
    }

    public void setEnemyMaxHealth(int enemyMaxHealth) {
        this.enemyMaxHealth = enemyMaxHealth;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
}
