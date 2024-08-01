import java.util.HashMap;
import java.util.Map;

public class MonoAlphaSubstitution extends Substitution {

    /**
     * @param mapping is used to store each char mapping for enc and dec...
     */
    public final Map<Character, Character> mapping;

    /**
     * This is the default requested constructor(the one with no arguments) which is used to create identity mapping by
     * mapping each character to itself, this constructor is used in the process of initializing MonoAlphaSubstitution objects
     */
    public MonoAlphaSubstitution() {
        this.mapping = generateIdentityMapping();
    }

    /**
     *
     *The required constructor which takes a string as an arguments,
     * The purpose of this constructor is to generate an identity mapping if the given string is an empty one or
     * to generate a custom mapping using the given string
     */
    public MonoAlphaSubstitution(String mappingString) {
        if (mappingString.isEmpty()) {
            this.mapping = generateIdentityMapping();
        } else {
            this.mapping = generateMapping(mappingString);
        }
    }

    /**
     *
     * @return identity mapping that was generated for each char using a for from a to z
     * method is placing every single char one by one, so they can be identified
     * then we are placing each char, for Upper chars
     */
    private Map<Character, Character> generateIdentityMapping() {
        Map<Character, Character> identityMapping = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            identityMapping.put(c, c);
            identityMapping.put(Character.toUpperCase(c), Character.toUpperCase(c));
        }
        return identityMapping;
    }


    /**
     *
     * @param mappingString argument used for mapping a pair of chars, mapping them one to another
     *  The mapping is randomly generated given by the mapping string
     * @return the new custom map created
     */
    public Map<Character, Character> generateMapping(String mappingString) {
Ege Isik 4 months ago *

In the generateMapping method, you’re creating a mapping from each character in the mappingString to the next character. However, if the mappingString is not a perfect mapping (i.e., it doesn’t contain a unique mapping for each character), this leads to incorrect results.

Click to start a new thread…
        Map<Character, Character> customMapping = new HashMap<>();
        for (int i = 0; i < mappingString.length(); i += 2) {
            char current = mappingString.charAt(i);
            char next;
            if (i + 1 < mappingString.length()) {
                next = mappingString.charAt(i + 1);
            } else {
                next = current;
            }
            customMapping.put(current, next);
            customMapping.put(Character.toUpperCase(current), Character.toUpperCase(next));
        }
        return customMapping;
    }

    /**
     *
     * @param c arguments of our function
     * @return encrypted char
     * this method simply encrypts a char by finding its correspondence in mapping
     */
    public char encrypt(char c) {

        return mapping.getOrDefault(c, c);
    }

    /**
     *
     * @param c current char that we want to decrypt
     * @return decrypted character was decrypted  by using each char key
     * The purpose of the function is to decrypt a character by finding the correspondence to the original char in mapping, if we manage to find it, we simply
     * return the original char otherwise we return the char unchanged.
     *
     */
    public char decrypt(char c) {
Ege Isik 4 months ago

Your decrypt is unable to

Click to start a new thread…

        for (Map.Entry<Character, Character> entry : mapping.entrySet()) {
            if (entry.getValue().equals(c)) {
                return entry.getKey();
            }
        }
        return c;
    }


    /**
     *
     * @param args user's command line input
     *  Main use to encrypt / decrypt user's input using methods coded above
     *  In main we also verify that user's input are using the program as they should
     *  Errors handling for each wrong input/usage  scenario
     */
    // Checking if the user is inputting the proper number of inputs
    public static void main(String[] args) {
        if (args.length != 3) {
            if (args.length < 3) {
                System.out.println("Too few parameters!");
            } else {
                System.out.println("Too many parameters!");
            }
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        }

        //Using some variables to make the main easier to understand
        String mode = args[0];
        String key = args[1];
        String text = args[2];

        MonoAlphaSubstitution cipher = new MonoAlphaSubstitution(key);

        if (mode.equals("encrypt")) {
            System.out.println(cipher.encrypt(text));
        } else if (mode.equals("decrypt")) {
            System.out.println(cipher.decrypt(text));
        } else {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
    }
}
