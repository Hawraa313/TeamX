/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cs;
import java.util.Scanner;

/**
 *
 * @author HP
 */

public class affineCipher {
    public static int gcd(int x, int y) {
        int z = x % y;
        if (z == 0)
            return y;
        else
            return gcd(y, z);
    }

    public static String encrypt(String plainText, int a, int b) {
        int length = plainText.length();
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < length; i++) {

            if (plainText.charAt(i) == ' ') {
                cipherText.append(' ');
                continue;
            }

            int letter = (a * (plainText.charAt(i) - 'A') + b) % 26;
            char encryptedLetter = (char) (letter + 'A');
            cipherText.append(encryptedLetter);
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int a, int b) {
        int length = cipherText.length();
        StringBuilder plainText = new StringBuilder();
        int m=26;
        
        int aInver = 0;
    for (int i = 0; i < m; i++) {
        if ((a * i) % m == 1) {
            aInver = i;
            break;
        }
    }

        for (int i = 0; i < length; i++) {

            if (cipherText.charAt(i) == ' ') {
                plainText.append(' ');
                continue;
            }

            int letter = (aInver * (cipherText.charAt(i) - 'A' - b + m)) % m;
            if (letter < 0)
                letter += m;
            char decryptedLetter = (char) (letter + 'A');
            plainText.append(decryptedLetter);
        }

        return plainText.toString();
    }

    public static void main(String[] args) {
        Affine affine = new Affine();
        affine.setVisible(true);
        affine.setDefaultCloseOperation(0);
        affine.pack();
      
    }
}
