import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherFetcher {
    private static String fetch(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream responseStream = con.getInputStream();
            ByteArrayOutputStream responseString = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int length;
            while ((length = responseStream.read(buffer)) != -1) {
                responseString.write(buffer, 0, length);
            }
            return responseString.toString();

        } catch (Exception er) {
            er.printStackTrace();
            return "{}";
        }
    }

    public static String fetchWeather(String cityName, String countryCode) {
        return fetch("http://api.openweathermap.org/data/2.5/weather?q="+cityName+","+countryCode+"&APPID=41e331119c476ed17cf52fda4eb427df");
    }
}
