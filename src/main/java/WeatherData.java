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
            main = obj.getJSONArray("weather").getJSONObject(0).getString("main");

            JSONObject mainData = obj.getJSONObject("main");
            temp = mainData.getFloat("temp");
            feels_like = mainData.getFloat("feels_like");
            temp_min = mainData.getFloat("temp_min");
            temp_max = mainData.getFloat("temp_max");
        } catch(JSONException e) {
            e.printStackTrace();
        }

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
