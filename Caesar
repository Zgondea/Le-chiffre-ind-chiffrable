public class Caesar extends MonoAlphaSubstitution {

    /**
     * @param shift requested field (UML diagram)
     */
    private final int shift;

    /**
     * Default constructor as requested, so we can make both methods to works as identify functions
     * This constructor is meant to create a new instance of Caesar cipher with a sift of 0 because this will consider
     * the encrypted text the same as the plain text
     *
     *super is used to the call the constructor of the parents class, passing all results of generateMappingString
     *This.shift = 0 is used to set the shift value for caesar cipher to 0 this will ensure that no shifting is going to happen in the encrypt/decrypt methods
     */
    public Caesar() {
        super(generateMappingString(0));
        this.shift = 0;
    }

    /**
     *
     * @param shift is determinated according ot all en/decrypt methods (as requested)
    *
     */

    public Caesar(int shift) {
        super(generateMappingString((shift + 12224) % 26));
        this.shift = (shift + 12224) % 26;
    }

    /**
     *
     * @param shift used to generate the mapping string
     *  Basically this method wil generate a string mapping for  chars substitution
     *  based on a specific shift,for both lower and Upper cases
     *  The result will be a pairing of the original char and the encrypted chars by mapping them.
     * @return generated mapping string
     */
    private static String generateMappingString(int shift) {
        StringBuilder mappingString = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            char encryptedChar = (char) (((c - 'a' + shift + 26) % 26) + 'a');
            mappingString.append(c).append(encryptedChar);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            char encryptedChar = (char) (((c - 'A' + shift + 26) % 26) + 'A');
            mappingString.append(c).append(encryptedChar);
        }
        return mappingString.toString();
    }

    /**
     *
     * @param args user's command line input
     *  Main use to encrypt / decrypt user's input using methods coded above
     *  In main we also verify that user's input are using the program as they should
     *  Errors handling for each wrong input/usage  scenario
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            if (args.length < 3) {
                System.out.println("Too few parameters!");
            } else {
                System.out.println("Too many parameters!");
            }
            System.out.println("Usage: java Caesar encrypt/decrypt n \"text\"");
            return;
        }

        String mode = args[0];
        int shift;
        try {
            shift = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid integer for the shift.");
            System.out.println("Usage: java Caesar encrypt/decrypt n \"text\"");
            return;
        }
        String text = args[2];

        Caesar cipher = new Caesar(shift);


        if ("encrypt".equals(mode)) {
            System.out.println(cipher.encrypt(text));
        } else if ("decrypt".equals(mode)) {
            System.out.println(cipher.decrypt(text));
        } else {
            System.out.println("Usage: java Caesar encrypt|decrypt n \"text\"");
        }
    }
}
