package be.vdab;

import be.vdab.taken.domain.Woord;

import java.util.Scanner;

public class MainWoord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Geef een woord
        System.out.println("Geef een woord");
        var woord = scanner.next();
        System.out.println(woord);

        System.out.println("is het een palindroom: " + new Woord(woord).isPalindroom());
    }
}
