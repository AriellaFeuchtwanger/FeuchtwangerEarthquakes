package feuchtwanger.feuchtwangerearthquakes;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ariella on 12/7/2015.
 */
public class EarthquakePagerAdaptor extends PagerAdapter{
    private Earthquake[] earthquakes;

    public EarthquakePagerAdaptor(Earthquake[] earthquakes){
        this.earthquakes = earthquakes;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
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
