import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pogoda {

    public static void main(String[] args) {


        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=41e331119c476ed17cf52fda4eb427df");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream responseStream = con.getInputStream();
            ByteArrayOutputStream responseString = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int length;
            while ((length = responseStream.read(buffer)) != -1) {
                responseString.write(buffer, 0, length);
            }
            String res = responseString.toString();
            System.out.println(res);

        } catch (Exception er) {
            er.printStackTrace();
        }
    }
}
