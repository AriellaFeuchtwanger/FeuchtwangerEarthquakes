package feuchtwanger.feuchtwangerearthquakes;

import java.io.Serializable;
import java.net.URL;

public class Earthquake implements Serializable{
    private String type;
    private Metadata metadata;
    private EarthquakeEvent[] features;
    private double[] bbox;

    public EarthquakeEvent[] getFeatures(){
        return features;
    }
}
