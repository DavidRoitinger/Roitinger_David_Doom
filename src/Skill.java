public class Skill {
    private int tear;
    private String name;
    private int damage;
    private int damageSpread;
    private int critChance;
    private int useCostHP;
    private int useCostMP;

    private Skill(int tear, String name, int damage, int damageSpread, int critChance, int useCostHP, int useCostMP) {
        this.tear = tear;
        this.name = name;
        this.damage = damage;
        this.damageSpread = damageSpread;
        this.critChance = critChance;
        this.useCostHP = useCostHP;
        this.useCostMP = useCostMP;
    }
    public static Skill deserialize(String line){
        String[] split = line.split(";");

        return new Skill(Integer.parseInt(split[0]), split[1],
                Integer.parseInt(split[2]),
                Integer.parseInt(split[3]),
                Integer.parseInt(split[4]),
                Integer.parseInt(split[5]),
                Integer.parseInt(split[6]));
    }

    public int getTear() {
        return tear;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getDamageSpread() {
        return damageSpread;
    }
    public int getCritChance() {
        return critChance;
    }
    public int getUseCostHP() {
        return useCostHP;
    }
    public int getUseCostMP() {
        return useCostMP;
    }

    @Override
    public String toString() {
        return name+": Dmg.: "+damage+";   Spread: "+damageSpread+";   Crit.: "+critChance+";    Cost: HP: "+useCostHP+" MP: "+useCostMP;
    }
}
