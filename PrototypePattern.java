interface CharacterPrototype {
    CharacterPrototype getClone();
}

class GameCharacter implements CharacterPrototype {
    private String type;
    private int health;
    private String weapon;
    private String ability;

    public GameCharacter(String type, int health, String weapon, String ability) {
        this.type = type;
        this.health = health;
        this.weapon = weapon;
        this.ability = ability;
    }

    public void showCharacter() {
        System.out.println("Type: " + type + ", Health: " + health + ", Weapon: " + weapon + ", Ability: " + ability);
    }

    @Override
    public GameCharacter getClone() {
        return new GameCharacter(type, health, weapon, ability);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
   //ma ndirouch set Type pcq les instances li ghadi ncreeihm a partir d'une instance ykounou de meme type
}

public class PrototypePattern {
    public static void main(String[] args) {

        GameCharacter warrior = new GameCharacter("Warrior", 100, "Sword", "Shield Block");

        GameCharacter archer = warrior.getClone();
        archer.setWeapon("Bow");
        archer.setAbility("Eagle Eye");

        GameCharacter thor = warrior.getClone();
        thor.setWeapon("Hammer");
        thor.setAbility("Thunder");

        System.out.println("Original Warrior:");
        warrior.showCharacter();

        System.out.println("\nArcher (Cloned from Warrior):");
        archer.showCharacter();

        System.out.println("\nThor (Cloned from Warrior):");
        thor.showCharacter();
    }
}
