public class Human extends Character {
    private boolean intelligence;

    public Human(int faction, String name, int attackPower, Weapon[] weapons, int intelligence) {
        super(faction, name, attackPower, weapons);
        this.intelligence = intelligence == 1;
        calculateAverageDamage();
    }

    public boolean isIntelligence() {
        return intelligence;
    }

    public void setIntelligence(boolean intelligence) {
        this.intelligence = intelligence;
    }

    public void printInfo() {
        System.out.println(this.getName() + " is a Human in " + this.getFaction() + " faction");
        if (this.isIntelligence()) System.out.println("Intelligence: Yes");
        else System.out.println("Intelligence: No");
        super.printInfo();
    }

    public void calculateAverageDamage() {
        super.calculateAverageDamage();
        double mAttack;
        double weaponsDamage = 0;
        if (this.isIntelligence()) mAttack = ( this.getAverageDamage() * 1.33);
        else mAttack = this.getAverageDamage();

        for (Weapon weapon : this.getWeapons()) weaponsDamage += weapon.getDamage();
        this.setAverageDamage(mAttack + weaponsDamage / this.getWeapons().length);
    }
    }
