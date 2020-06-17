package encryptdecrypt;

import javax.management.loading.MLet;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String encrypt(String input, int key) {
        String alphabet = " " +"!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String shifted = alphabet.substring(key) + alphabet.substring(0, key);
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++) {
            char current = encrypted.charAt(i);
            int idx = alphabet.indexOf(current);
            if (idx != -1) {
                char newChar = shifted.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String input, int key) {
        String alphabet = "  !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String shifted = alphabet.substring(key) + alphabet.substring(0,key);
        StringBuilder decrypted = new StringBuilder(input);
        for (int i = 0; i < decrypted.length(); i++) {

            char current = decrypted.charAt(i);
            int idx = shifted.indexOf(current);
            if (idx != -1) {
                char newChar = alphabet.charAt(idx);
                decrypted.setCharAt(i, newChar);
            }
        }
        return decrypted.toString();
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        String input = scanner.nextLine();
        int key = scanner.nextInt();

        if (operation.equals("enc")) {
          System.out.print(encrypt(input, key));
       }else if (operation.equals("dec")){
            System.out.println(decrypt(input,key));
        }

    }
}

























