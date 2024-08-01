public abstract class Substitution implements Cipher{

    /**
     *
     * @param c arguments of our function
     * @return
     */


    /**
     *
     * @param c char that we want to encrypt
     *  This method is basically used to encrypt one Character
     *
     */
    public abstract char encrypt(char c);

    /**
     *
     * @param c char that we want to decrypt
     *  This method is basically used to decrypt one Character
     *
     */
    public abstract char decrypt(char c);

    /**
     * @method encrypt get user's text as argument
     * @String encrypted is constructed by appending each char which was encrypted one by one
     * @param plaintext is encrypted using a for each using the encrypting method provided in the Cipher interface
     * @return final encryption of the String
     */
    @Override

    public String encrypt(String plaintext) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            encrypted.append(encrypt(c));
        }
        return encrypted.toString();
    }

    /**
     * @method get user's text as argument
     * decrypted is constructed by appending each encrypted char one by one
     * c is decrypted using a for each using the decrypting method provided in the Cipher interface
     * return the final decryption of the string
     */
    @Override

    public String decrypt(String plaintext) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            decrypted.append(decrypt(c));
        }
        return decrypted.toString();
    }
}
