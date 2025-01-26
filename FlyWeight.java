import java.util.HashMap;
import java.util.Map;

class Character {
    private final char name;
    private final String font;
    private final int size;

    public Character(char name, String font, int size) {
        this.name = name;
        this.font = font;
        this.size = size;
    }

    public char getname() {
        return name;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public void display(int row, int column) {
        System.out.println("Character: " + name + " Font: " + font + " Size: " + size + 
                           " Position: (" + row + ", " + column + ")");
    }
}

class Charc{
    private final int row;
    private final int column;
    private Character charact;

    public Charc(int row, int column, Character charact){
        this.row = row;
        this.column = column;
        this.charact = charact;
    } 

    public void display() {
        System.out.println("Character: " + charact.getname() + " Font: " + charact.getFont() + " Size: " + charact.getSize() + 
                           " Position: (" + row + ", " + column + ")");
    }
}

class CharacterFactory {
    private static Map<String, Character> characterMap = new HashMap<>();

    public static Character getCharacter(char name, String font, int size) {
        String key = name + font + size;
        Character character = characterMap.get(key);

        if (character == null) {
            character = new Character(name, font, size);
            characterMap.put(key, character);
            System.out.println("Creating new character: " + name);
        }
        
        return character;
    }
}

public class FlyWeight {
    public static void main(String[] args) {
        
        Character charType1 = CharacterFactory.getCharacter('a', "Arial", 12);
        Charc char1 = new Charc(12, 6, charType1);
        char1.display();

        Character charType2 = CharacterFactory.getCharacter('a', "Arial", 12);
        Charc char2 = new Charc(3, 4, charType2);
        char2.display();
        
        Character charType3 = CharacterFactory.getCharacter('b', "Arial", 12);
        Charc char3 = new Charc(1, 0, charType3);
        char3.display();

    }
}
