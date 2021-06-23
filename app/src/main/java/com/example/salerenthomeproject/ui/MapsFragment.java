package com.example.salerenthomeproject.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.util.map.DrawDistance;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
    private DrawDistance drawMap = new DrawDistance();
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng start= new LatLng(36.891326579165394, 30.712792656541104);

            googleMap.addMarker(new MarkerOptions().position(start).title("Marker in Antalya").snippet("Antalya is city of Turkey"));
            CameraPosition a = new CameraPosition.Builder().target(start).tilt(17).zoom(10f).bearing(30f).build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(a));
            googleMap.getUiSettings().isZoomControlsEnabled();
            googleMap.getUiSettings().isCompassEnabled();
            googleMap.getUiSettings().isMapToolbarEnabled();
            googleMap.getUiSettings().isZoomGesturesEnabled();
            googleMap.getUiSettings().isScrollGesturesEnabledDuringRotateOrZoom();
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            drawMap.addPolyLine(googleMap);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}