public class Orc extends Character{
    private int toughness;

    public Orc(int faction, String name, int attackPower, Weapon[] weapons, int toughness) {
        super(faction, name, attackPower, weapons);
        this.toughness = toughness;
        calculateAverageDamage();
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public void printInfo() {
        System.out.println(this.getName() + " is a Orc in " + this.getFaction() + " faction");
        System.out.println("Toughness: " + this.getToughness());
        super.printInfo();
    }

    public void calculateAverageDamage() {
        super.calculateAverageDamage();
        double mAttack = this.getAverageDamage();
        double weaponsDamage = 0;
        for (Weapon weapon : this.getWeapons()) weaponsDamage += weapon.getDamage();
        this.setAverageDamage(mAttack + (((weaponsDamage / this.getWeapons().length) * this.getToughness()) / 2));
    }

}
