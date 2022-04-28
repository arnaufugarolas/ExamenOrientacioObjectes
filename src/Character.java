abstract public class Character {
    private String faction;
    private String name;
    private int attackPower;
    private int numberWeapons;
    private final Weapon[] weapons;
    private double averageDamage;

    public Character(int faction, String name, int attackPower, Weapon[] weapons) {
        if (faction == 1) this.faction = "Alliance";
        else if (faction == 2) this.faction = "Horde";
        this.name = name;
        this.attackPower = attackPower;
        this.numberWeapons = weapons.length;
        this.weapons = weapons;
        calculateAverageDamage();
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getNumberWeapons() {
        return numberWeapons;
    }

    public void setNumberWeapons(int numberWeapons) {
        this.numberWeapons = numberWeapons;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public double getAverageDamage() {
        return averageDamage;
    }

    public void setAverageDamage(double averageDamage) {
        this.averageDamage = averageDamage;
    }

    public void calculateAverageDamage() {
        this.averageDamage = this.getAttackPower();
    }

    public void printInfo() {
        System.out.println("Attack Power without weapons: " + this.getAttackPower());
        for (int i = 0; i < this.getWeapons().length; i++) {
            System.out.println("Weapon " + (i + 1) + ": " + this.getWeapons()[i].getName() + " - " + this.getWeapons()[i].getDamage());
        }
        System.out.println("Average Attack Power: " + this.getAverageDamage());
    }

}
