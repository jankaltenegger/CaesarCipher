/**
 * @class: Main
 * @author: Jan Kaltenegger
 * @version: 1.0
 * Course: ITEC 2140 - 04
 * Written: April 25, 2023
 *
 * Description: This is the main class for the CaesarCipher program, here the data is asked for, input is recorded and output is shown.
 * Calculations and processing happens in the CaesarCipher class.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a message: ");
        String newMessage = sc.nextLine();

        System.out.println("Enter 'E' to encrypt or 'D' to decrypt: ");
        String encryptionChoice = sc.nextLine();

        System.out.println("Enter the integer key: ");
        int key = sc.nextInt();
        CaesarCipher cc = new CaesarCipher(key);

        if (encryptionChoice.equals("E") || encryptionChoice.equals("e")) {
            System.out.println(cc.encrypt(newMessage));
        } else if (encryptionChoice.equals("D") || encryptionChoice.equals("d")) {
            System.out.println(cc.decrypt(newMessage));
        }

    }
}
