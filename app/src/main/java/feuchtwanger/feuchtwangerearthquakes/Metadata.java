package feuchtwanger.feuchtwangerearthquakes;

import java.net.URL;

/**
 * Created by student1 on 12/3/2015.
 */
public class Metadata {
    private double generated;
    private URL url;
    private String title;
    private int status;
    private String api;
    private int count;

    public String getTitle(){
        return title;
    }

    public int getCount(){
        return count;
    }
}
