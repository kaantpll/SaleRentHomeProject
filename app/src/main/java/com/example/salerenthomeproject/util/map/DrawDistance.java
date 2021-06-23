package com.example.salerenthomeproject.util.map;

import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.regex.Pattern;

public class DrawDistance {

    public DrawDistance(){}

    public void addPolyLine(GoogleMap map){

        Polygon polygon = map.addPolygon(new PolygonOptions()
        .add(new LatLng(36.840315861655974, 30.59576396751613))
                .add(new LatLng(36.93389376514316, 30.745735926028004))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE)

        );
        polygon.setStrokeJointType(JointType.ROUND);

    }



}
