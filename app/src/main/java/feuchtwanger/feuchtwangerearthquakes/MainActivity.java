package feuchtwanger.feuchtwangerearthquakes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public Earthquake[] earthquakes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String url = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";

        new EarthquakeInfoAsyncTask().execute(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class EarthquakeInfoAsyncTask extends AsyncTask<String, String, String> {
        private Earthquake earthquakes;
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            EarthquakeEvent[] features = earthquakes.getFeatures();

            EarthquakeAdaptor adaptor = new EarthquakeAdaptor(features);
            recyclerView.setAdapter(adaptor);
        }

        @Override
        protected String doInBackground(String... params) {
            URL url = null;

            try {
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            URLConnection connection = null;

            try {
                connection = url.openConnection();
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

}
