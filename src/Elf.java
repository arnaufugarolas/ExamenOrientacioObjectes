public class Elf extends Character{
    private double magic;

    public Elf(int faction, String name, int attackPower, Weapon[] weapons, double magic) {
        super(faction, name, attackPower, weapons);
        this.magic = magic;
        calculateAverageDamage();
    }

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }

    public void printInfo() {
        System.out.println(this.getName() + " is a Elf in " + this.getFaction() + " faction");
        System.out.println("Magic: " + this.getMagic());
        super.printInfo();
    }

    public void calculateAverageDamage() {
        super.calculateAverageDamage();
        double mAttack = this.getAverageDamage();
        double weaponsDamage = 0;

        for (Weapon weapon : this.getWeapons()) weaponsDamage += (weapon.getDamage() * (1 + this.getMagic()));
        this.setAverageDamage(mAttack + weaponsDamage / this.getWeapons().length);
    }

}
