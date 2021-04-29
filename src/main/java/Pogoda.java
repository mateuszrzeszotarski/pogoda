import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Pogoda {

    public static void main(String[] args) {

        System.out.println("WITAMY W PROGNOZIE POGODY");
        while (true) {
            System.out.println("Wybierz opcję");
            System.out.println(
                    "1: Pokaż pogodę w dowolnym mieście w polsce\n" +
                            "2: Pokaż pogodę w dowolnym mieście na świecie\n" +
                            "3: Wyjdź"
            );

            Scanner sc = new Scanner(System.in);
            System.out.print("wybór: ");
            int n = sc.nextInt();

            switch (n) {

                case 1:
                    try {
                        System.out.print("miasto: ");
                        String city = sc.next();
                        System.out.println(WeatherFetcher.fetchWeather(city, "pl"));
                    } catch (IllegalArgumentException e) {
                        System.out.println("WPROWADZONO NIEPRAWIDŁOWE DANE LOKALIZACJI");
                        System.out.println("~przykład  miasto: torun");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("miasto: ");
                        String city = sc.next();
                        System.out.print("kod państwa: ");
                        String country = sc.next();
                        System.out.println(WeatherFetcher.fetchWeather("torun", "pl"));
                    } catch (IllegalArgumentException e) {
                        System.out.println("WPROWADZONO NIEPRAWIDŁOWE DANE LOKALIZACJI");
                        System.out.println("~przykład  miasto: torun, kod państwa: pl");
                    }
                    break;
                case 3:
                    System.out.println("DO WIDZENIA :)");
                    return;
                default:
                    System.out.println("NIEPRAWIDŁOWY WYBÓR");
            }
        }

    }
}
