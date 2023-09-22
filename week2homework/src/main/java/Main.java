import com.sun.source.tree.SwitchTree;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String hungarian = "hun";
        final String english = "eng";
        final String hawaiian = "haw";
        String name = args[0];
        if (args.length != 2) {
            System.out.println("Szia, " + name + "!");
            return;
        }
        String lang = args[1];
        switch (lang) {
            case english -> System.out.println("Hello, " + name + "!");
            case hawaiian -> System.out.println("Aloha, " + name + "!");
            case hungarian -> System.out.println("Szia, " + name + "!");
            default -> {
                System.out.println("Unknown language error.");
            }
        }
    }
}
