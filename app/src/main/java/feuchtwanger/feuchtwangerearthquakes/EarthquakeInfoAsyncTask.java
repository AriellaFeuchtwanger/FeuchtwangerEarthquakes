package feuchtwanger.feuchtwangerearthquakes;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class EarthquakeInfoAsyncTask extends AsyncTask<Long, String, String> {
    private Earthquake[] earthquakes;
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }

    @Override
    protected String doInBackground(Long... params) {
        //Uses the builder design pattern
        Gson gson = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        URL url = null;

        try {
            url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpsURLConnection connection = null;

        try {
            connection = (HttpsURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream in = null;
        try {
            in = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.earthquakes = gson.fromJson(new InputStreamReader(in), Earthquake[].class);
        Gson gson = new Gson();
        earthquakes = gson.fromJson(new InputStreamReader(in), Earthquake[].class);

        EarthquakeAdaptor adaptor = new EarthquakeAdaptor(earthquakes);

        return null;
    }
}
