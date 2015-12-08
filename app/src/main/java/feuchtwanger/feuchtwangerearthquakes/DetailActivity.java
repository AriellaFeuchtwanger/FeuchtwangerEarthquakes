package feuchtwanger.feuchtwangerearthquakes;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ariella on 12/7/2015.
 */
public class DetailActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        Earthquake[] earthquakes = (Earthquake[]) getIntent().getSerializableExtra("EARTHQUAKES");
        int position = getIntent().getIntExtra("POSITION", 0);
        EarthquakePagerAdaptor adaptor = new EarthquakePagerAdaptor(earthquakes);
        viewPager.setAdapter(adaptor);

        viewPager.setCurrentItem(position);
    }
}
