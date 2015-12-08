package feuchtwanger.feuchtwangerearthquakes;

import java.io.Serializable;

public class Earthquake implements Serializable{
    private String type;
    private Metadata metadata;
    private Feature[] features;
    private double[] bbox;

    public String getTitle(){
        return features[0].getTitle();
    }

    public String getPlace(){
        return features[0].getPlace();
    }

    public double getMag(){
        return features[0].getMag();
    }
}
