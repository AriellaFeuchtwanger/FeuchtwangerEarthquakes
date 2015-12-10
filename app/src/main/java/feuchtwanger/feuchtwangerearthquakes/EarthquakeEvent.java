package feuchtwanger.feuchtwangerearthquakes;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by Ariella on 12/9/2015.
 */
public class EarthquakeEvent implements Serializable {
    private String title;
    private EarthquakeProperties properties;
    private Geometry geometry;
    private String id;

    public String getTitle() {
        return properties.getTitle();
    }

    public String getPlace() {
        return properties.getPlace();
    }

    public double getMag() {
        return properties.getMag();
    }

    public String getMagType() {
        return properties.getMagType();
    }

    public URL getURL() {
        return properties.getUrl();
    }
}
