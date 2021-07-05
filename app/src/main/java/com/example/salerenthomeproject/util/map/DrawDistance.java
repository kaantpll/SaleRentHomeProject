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

    public void addPolyLine(GoogleMap map , LatLng startLng,LatLng endLTng){

        Polygon polygon = map.addPolygon(new PolygonOptions()
        .add(startLng)
                .add(endLTng)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE)

        );
        polygon.setStrokeJointType(JointType.ROUND);

    }



}
