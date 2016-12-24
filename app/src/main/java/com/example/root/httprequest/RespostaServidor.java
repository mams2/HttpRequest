package com.example.root.httprequest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by root on 24/12/16.
 */

public class RespostaServidor {
    @SerializedName("list")
    public ArrayList<CityInformation> cities;

}