package feuchtwanger.feuchtwangerearthquakes;

import java.io.Serializable;

/**
 * Created by student1 on 12/3/2015.
 */
public class Feature implements Serializable{
    private String title;
    private EarthquakeProperties properties;
    private Geometry geometry;
    private String id;
}
