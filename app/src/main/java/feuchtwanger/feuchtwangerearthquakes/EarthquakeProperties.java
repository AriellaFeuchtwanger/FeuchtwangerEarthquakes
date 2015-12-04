package feuchtwanger.feuchtwangerearthquakes;

import java.net.URL;

/**
 * Created by student1 on 12/3/2015.
 */
public class EarthquakeProperties {
    private double mag;
    private String place;
    private int time;
    private int updated;
    private int tz;
    private URL url;
    private URL detail;
    private Integer felt;
    private Integer cdi;
    private Integer mmi;
    private Integer alert;
    private String status;
    private int tsunami;
    private int sig;
    private String het;
    private String code;
    private String ids;
    private String sources;
    private String types;
    private int nst;
    private double dmin;
    private double rms;
    private int gap;
    private String magType;
    private String type;
    private String title;

    public double getMag(){
        return mag;
    }

    public String getPlace(){
        return place;
    }

    public String getTitle(){
        return title;
    }
}
