package com.example.root.httprequest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by root on 24/12/16.
 */
public class CityInformation {
    public String name;
    public ArrayList<Weather> weather;
    @SerializedName("main")
    public TemperatureInformation temperature;

}
