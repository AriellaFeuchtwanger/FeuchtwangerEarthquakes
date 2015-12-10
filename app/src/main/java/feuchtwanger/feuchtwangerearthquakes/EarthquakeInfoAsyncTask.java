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

public class EarthquakeInfoAsyncTask extends AsyncTask<String, String, String> {
    private Earthquake earthquakes;
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        EarthquakeAdaptor adaptor = new EarthquakeAdaptor(earthquakes.getFeatures());
    }

    @Override
    protected String doInBackground(String... params) {
        URL url = null;

        try {
            url = new URL(params[0]);
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
        Gson gson = new Gson();
        earthquakes = gson.fromJson(new InputStreamReader(in), Earthquake.class);

        return null;
    }
}
