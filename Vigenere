import java.util.Arrays;

public class Vigenere extends Substitution {
    /**
     * cipherkey is String which represents the key that the user will use for encryption
     * contor is used to track the actual/current position in the cipherKey during the encryption or the decryption process
     * ciphers is an array of String used to represent the Caesar shift for each letter
     */
    private String cipherKey;
    private int myContor = 0;
    String[] ciphers;

    /**
     * This method basically generate a string with all alphabet letters and returns it
     *
     */
    private static String alphabetString(){
        StringBuilder alphabetString = new StringBuilder();
        for(char currentLowerLetter = 'a'; currentLowerLetter <= 'z'; currentLowerLetter++){
            alphabetString.append(currentLowerLetter);
        }

        for(char currentUpperLetter = 'A'; currentUpperLetter <= 'Z'; currentUpperLetter++){
            alphabetString.append(currentUpperLetter);
        }
        return alphabetString.toString();
    }

    /**
     * This is our default constructor which will initialize the cipher with an empty key and will pre-generate
     * all shit for each letter (Caesar shifts)
     */
    public Vigenere() {
        this.cipherKey = "";

        this.ciphers = new String[26];
        for (int i = 0; i < 26; i++) {
            char currentChar = (char) ('A' + i);
            ciphers[i] = Character.toString(currentChar);
            currentChar = (char) ('a' + i);
            ciphers[i] += currentChar;
        }
    }

    /**
     * This is the second constructor as requested which takes a String key as an argument
     * this constructor will ensure that the cipher will pe initialized with the provided key
     * and will generate shifts based on the alphabet
     *
     */
    public Vigenere(String key) {
        this.cipherKey = key.toUpperCase();
        this.ciphers = caesarShifts();
    }


    /**
     * This method will generate an array of string, each one of them will represent the alphabet shifted
     * by 0 to 25 positions
     *
     */
    public String[] caesarShifts() {
        int i, j;
        String alphabet = alphabetString(); 
        String[] caesarShifts = new String[26];

        for (i = 0; i < caesarShifts.length; i++) {
            caesarShifts[i] = "";
        }

        for (i = 0; i < 26; i++) {
            for (j = 0; j < alphabet.length(); j++) { 
                char currentChar = alphabet.charAt(j);
                if (Character.isUpperCase(currentChar)) {
                    caesarShifts[i] = caesarShifts[i] + (char) ((currentChar - 'A' + i) % 26 + 'A');
                } else if (Character.isLowerCase(currentChar)) {
                    caesarShifts[i] = caesarShifts[i] + (char) ((currentChar - 'a' + i) % 26 + 'a');
                }
            }
        }
        return caesarShifts;
    }


    /**
     *
     * @param c char that we want to encrypt
     *  This method is basically used to encrypt one Character using Vigenere alg
     * @return the encrypted char
     * if it is not a letter it will return the char as it is
     */
    @Override
    public char encrypt(char c){
        char myChar = ' ';
        int actualShift = cipherKey.charAt(myContor) - 'A';

        if(cipherKey.equals(" ")){
            return c;
        }


        if(Character.isAlphabetic(c)){
            if(Character.isLowerCase(c)){
               char shifted = (char)((c - 'a' + actualShift) % 26 + 'a');
                myContor = (myContor + 1) % cipherKey.length();

                return shifted;
            }else{
                char shifted = (char)((c - 'A' + actualShift) % 26 + 'A');
                myContor = (myContor + 1) % cipherKey.length();

                return shifted;
            }
        }else{
            myContor = (myContor + 1) % cipherKey.length();
            return c;
        }
    }



    /**
     *
     * @param c char that we want to decrypt
     *  This method is basically used to decrypt one Character using Vigenere alg
     * @return the decrypt char
     * if it is not a letter it will return the char as it is
     */
    @Override
    public char decrypt(char c) {
        char myChar = ' ';
        int actualShift = cipherKey.charAt(myContor) - 'A';

        if (cipherKey.equals(" ")) {
            return c;
        }

        if (Character.isAlphabetic(c)) {
            if (Character.isLowerCase(c)) {
                char shifted = (char) ((c - 'a' - actualShift + 26) % 26 + 'a');
                myContor = (myContor + 1) % cipherKey.length();
                return shifted;
            } else {
                char shifted = (char) ((c - 'A' - actualShift + 26) % 26 + 'A');
                myContor = (myContor + 1) % cipherKey.length();
                return shifted;
            }
        } else {
            myContor = (myContor + 1) % cipherKey.length();
            return c;
        }
    }


    /**
     *
     * @param args user's command line input
     *  Main use to encrypt / decrypt user's input using methods coded above
     *  In main we also verify that user's input are using the program as they should
     *  Errors handling for each wrong input/usage  scenario
     */
    public static void main(String[] args) {

        if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;

        } else if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;
        }

        if (!(args[0].equals("encrypt") || args[0].equals("decrypt"))){
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");

            return;
        }

        String selectedOption = args[0];
        Vigenere keyword = new Vigenere(args[1]);
        String text = args[2];
        if (selectedOption.equals("encrypt")) {
            System.out.println(keyword.encrypt(text));


        } else if (args[0].equals("decrypt")) {
            System.out.println(keyword.decrypt(text));
        }


    }
}
