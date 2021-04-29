import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pogoda {

    public static void main(String[] args) {

        System.out.println(WeatherFetcher.fetchWeather("Torun", "pl"));
        System.out.println(WeatherFetcher.fetchWeather("London", "uk"));

    }
}
