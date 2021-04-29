import org.json.*;

public class WeatherData {
    private String main = "";
    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;


    public WeatherData(String jsonString) {
        JSONObject obj = new JSONObject(jsonString);

        try {
            main = obj.getJSONArray("weather").getJSONObject(0).getString("description");

            JSONObject mainData = obj.getJSONObject("main");
            temp = mainData.getFloat("temp");
            feels_like = mainData.getFloat("feels_like");
            temp_min = mainData.getFloat("temp_min");
            temp_max = mainData.getFloat("temp_max");
        } catch(JSONException e) {
            e.printStackTrace();
        }

    }

    public void outputWeatherDataToConsole() {
        System.out.println("zachmurzenie: " + main);
        System.out.println("obecna temperatura: " + temp+"°C");
        System.out.println("odczuwalna temperatura: " + feels_like+"°C");
        System.out.println("najwyższa temperatura dzisiaj: " + temp_min+"°C");
        System.out.println("najniższa temperatura dzisiaj: " + temp_max+"°C");
    }

    public String getMain() {
        return main;
    }

    public float getTemp() {
        return temp;
    }

    public float getFeelsLike() {
        return feels_like;
    }

    public float getTempMin() {
        return temp_min;
    }

    public float getTempMax() {
        return temp_max;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "main='" + main + '\'' +
                ", temp='" + temp + '\'' +
                ", feels_like='" + feels_like + '\'' +
                ", temp_min='" + temp_min + '\'' +
                ", temp_max='" + temp_max + '\'' +
                '}';
    }
}
