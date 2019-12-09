package viewers;

import java.util.Scanner;

public class Input {

    public static String stringDegerIste(String girilecekDeger, Scanner scanner){
        System.out.println(girilecekDeger);
        return scanner.nextLine();
    }

    public static int sayiDegeriIste(String girilecekSayi, Scanner scanner){
        System.out.println(girilecekSayi);
        return scanner.nextInt();
    }
}
