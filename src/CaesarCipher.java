/**
 * @class: CaesarCipher
 * @author: Jan Kaltenegger
 * @version: 1.0
 * Course: ITEC 2140 - 04
 * Written: April 25, 2023
 *
 * Description: This class contains an instance variable, which is initialized by the constructor and given a value by the main class.
 * This instance variable is then used in the two following methods in order to dictate the amount the characters need to be transformed.
 * These methods will then save and return the new encrypted or decrypted String.
 */

public class CaesarCipher {

    public int shift;

    //Constructor initializes instance variable.
    public CaesarCipher(int encryptionKey) {
        this.shift = encryptionKey;
    }

    //Encrypts the message
    public String encrypt(String message) {
        //Converts the String to a char array
        char[] charMessage = message.toCharArray();
        // Iterates through the length of the string and depending on the character will execute the upper or lowercase part of the code. Will then shift characters x spots to the left.
        for(int i = 0; i < message.length(); i++) {
            if (Character.isLetter(charMessage[i]) && Character.isLowerCase(charMessage[i])) {
                charMessage[i] += shift;
                if (charMessage[i] > 122) {
                    charMessage[i] = (char) (96 + Math.abs(122 - charMessage[i]));
                } else if (charMessage[i] < 96) {
                    charMessage[i] = (char) (122 - Math.abs(96 - charMessage[i]));
                }
            } else if (Character.isLetter(charMessage[i]) && Character.isUpperCase(charMessage[i])) {
                charMessage[i] += shift;
                if (charMessage[i] > 90) {
                    charMessage[i] = (char) (64 + Math.abs(90 - charMessage[i]));
                } else if (charMessage[i] < 64) {
                    charMessage[i] = (char) (90 - Math.abs(64 - charMessage[i]));
                }
            }
        }
        //Array is then returned as a new String object.
        return new String(charMessage);
    }

    //Decrypts the message
    public String decrypt(String message) {
        //Converts the String to a char array
        char[] charMessage = message.toCharArray();
        // Iterates through the length of the string and depending on the character will execute the upper or lowercase part of the code. Will then shift characters x spots to the right.
        for(int i = 0; i < message.length(); i++) {
            if (Character.isLetter(charMessage[i]) && Character.isLowerCase(charMessage[i])) {
                charMessage[i] -= shift;
                if (charMessage[i] <= 96) {
                    charMessage[i] = (char) (122 - Math.abs(96 - charMessage[i]));
                }
            } else if (Character.isLetter(charMessage[i]) && Character.isUpperCase(charMessage[i])) {
                charMessage[i] -= shift;
                if (charMessage[i] < 65) {
                    charMessage[i] = (char) (90 - Math.abs(64 - charMessage[i]));
                }
            }
        }
        //Array is then returned as a new String object.
        return new String(charMessage);
    }
}
