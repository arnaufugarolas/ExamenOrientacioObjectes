import java.util.ArrayList;

public class Main {
    static final Functions f = new Functions();
    static final Main m = new Main();
    static final ArrayList<Character> characters = new ArrayList<Character>();

    public static void main(String[] args) {
        m.principal();
    }

    public void principal() {
        boolean stop = false;
        while (!stop) {
            int option = f.nextInt("""
                    1. Exit
                    2. Insert data
                    3. Show data in console
                    4. Fight between factions
                    """, "Choose an option: ", 1, 4);
            switch (option) {
                case 1 -> stop = true;
                case 2 -> insertData();
                case 3 -> showData();
                case 4 -> fight();
            }
        }
    }

    public void fight() {
        int alliancePower = 0;
        int hordePower = 0;
        for (Character character : characters) {
            if (character.getFaction().equals("Alliance")) {
                alliancePower += character.getAverageDamage();
            } else {
                hordePower += character.getAverageDamage();
            }
        }
        if (alliancePower > hordePower) {
            System.out.println("Alliance win!");
        } else if (alliancePower < hordePower) {
            System.out.println("Horde win!");
        } else {
            System.out.println("Draw!");
        }
    }

    public void showData() {
        for (Character character : characters) {
            System.out.println("\nCharacter " + (characters.indexOf(character) + 1)  + ":");
            character.printInfo();
            System.out.println();
        }
    }

    public void insertData() {
        int intelligence = 0;
        int toughness = 0;
        double magic = 0;

        int race = f.nextInt("Choose race (1-Human 2-Orc 3-Elf)", "Race: ", 1, 3);
        int faction = f.nextInt("Choose faction (1-Alliance 2-Horde)", "Faction: ", 1, 2);
        String name = f.nextString("Name: ");

        switch (race) {
            case 1 -> {intelligence = f.nextInt("Intelligence (0-1)", "Intelligence:", 0, 1);}
            case 2 -> {toughness = f.nextInt("Toughness (1-3)", "Toughness: ", 1, 3);}
            case 3 -> {magic = f.nextDouble("Magic (0-0.99)", "Magic: ", 0, 0.99);}
        }

        int attackPower = f.nextInt("Attack power", "Power: ",0, Integer.MAX_VALUE);
        int numberWeapons = f.nextInt("How many weapons (1-10)", "Number of weapons: ", 1, 10);
        Weapon[] weapons = new Weapon[numberWeapons];
        for (int i = 0; i < numberWeapons; i++) {
            String weaponName = f.nextString("Weapon " + (i + 1) + " Name: ");
            int weaponAttackPower = f.nextInt("Weapon " + (i + 1) + " Attack Power: ", 0, Integer.MAX_VALUE);
            weapons[i] = new Weapon(weaponName, weaponAttackPower);
        }

        switch (race) {
            case 1 -> {characters.add(new Human(faction, name, attackPower, weapons, intelligence));}
            case 2 -> {characters.add(new Orc(faction, name, attackPower, weapons, toughness));}
            case 3 -> {characters.add(new Elf(faction, name, attackPower, weapons, magic));}
        }
    }

}