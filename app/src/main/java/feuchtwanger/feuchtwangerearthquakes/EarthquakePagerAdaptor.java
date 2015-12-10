package feuchtwanger.feuchtwangerearthquakes;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ariella on 12/7/2015.
 */
public class EarthquakePagerAdaptor extends PagerAdapter {
    private EarthquakeEvent[] earthquakes;

    public EarthquakePagerAdaptor(EarthquakeEvent[] earthquakes) {
        this.earthquakes = earthquakes;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.earthquake_pager_item, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView place = (TextView) view.findViewById(R.id.place);
        TextView magnitude = (TextView) view.findViewById(R.id.magnitude);
        WebView website = (WebView) view.findViewById(R.id.website);

        title.setText(earthquakes[position].getTitle());
        place.setText("Location: " + earthquakes[position].getPlace());
        magnitude.setText("Magnitude: " + (int) earthquakes[position].getMag() + " - " + earthquakes[position].getMagType());
        website.loadUrl(earthquakes[position].getURL().toString());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return earthquakes.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
}
