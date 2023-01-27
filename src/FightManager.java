import java.util.Random;
import java.util.Scanner;

public class FightManager {
    private Enemy enemy;
    public boolean startFight(){
        //Sound.changeMusicBattle();
        enemy = Enemy.instanceEnemy();

        PrintManager.printFightingStart(enemy);
        boolean result = fight();
        //Sound.changeMusicMap();
        return result;
    }


    private boolean fight(){
        Scanner s = new Scanner(System.in);
        s.nextLine();
        while (Data.playerHealth >0 && enemy.getEnemyHealth()>0){
            PrintManager.printFighting();
            String line = s.nextLine();
            if(isNumber(line)&&Integer.parseInt(line)<=Data.learnedSkills.size()&&Integer.parseInt(line)>0){
                useSkill(Data.learnedSkills.get(Integer.parseInt(line)-1));
                s.nextLine();
                enemyAttac();
                s.nextLine();
                PrintManager.printFightingInfo(enemy);
                s.nextLine();
            }
        }

        return Data.playerHealth>0;
    }
    private boolean enemyAttac(){
        System.out.println("Enemy:");
        boolean crit = false;
        Random rand = new Random();
        int damage = enemy.getEnemyDamage();
        if(rand.nextInt(99)+1<=5){
            damage= damage*3;
            crit = true;
            System.out.println("""
                    CRITICAL!!!
                    >w<
                    """);
        }
        Data.playerHealth -= damage;
        System.out.println(damage+" Damage!");
        return crit;
    }

    private boolean useSkill(Skill skill){
        Data.playerHealth -= skill.getUseCostHP();
        Data.playerMana -= skill.getUseCostMP();
        boolean crit = false;
        Random rand = new Random();
        int damage = skill.getDamage();
        damage += rand.nextInt(skill.getDamageSpread() + 1 - skill.getDamageSpread() *-1) + skill.getDamageSpread() *-1;
        if(rand.nextInt(99)+1<=skill.getCritChance()){
            damage= damage*3;
            crit = true;
            System.out.println("CRITICAL!!!");
        }
        enemy.setEnemyHealth(enemy.getEnemyHealth()-damage);
        System.out.println(damage+" Damage!");
        return crit;
    }

    private boolean isNumber(String line) {
        Scanner sc = new Scanner(line.trim());
        if (!sc.hasNextInt(10)) return false;
        sc.nextInt(10);
        return !sc.hasNext();
    }

}
