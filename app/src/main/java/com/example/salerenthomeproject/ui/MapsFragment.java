package com.example.salerenthomeproject.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.util.map.DrawDistance;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {
    private MapsFragmentArgs args;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
    private DrawDistance drawMap = new DrawDistance();
    public  Location mLocation;
    Button pathBtn;


        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng start= new LatLng(36.891326579165394, 30.712792656541104);
            LatLng end = new LatLng(36.911549694652564, 30.58754031563194);
            googleMap.addMarker(new MarkerOptions().position(start).title("Marker in Antalya").snippet("Antalya is city of Turkey"));
            googleMap.addMarker(new MarkerOptions().position(end).title("Marker").draggable(true).snippet("end"));
            CameraPosition a = new CameraPosition.Builder().target(start).tilt(12).zoom(11f).bearing(10f).build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(a));
            googleMap.getUiSettings().isZoomControlsEnabled();
            googleMap.getUiSettings().isCompassEnabled();
            googleMap.setOnMyLocationClickListener(new GoogleMap.OnMyLocationClickListener() {
                @Override
                public void onMyLocationClick(@NonNull Location location) {
                    mLocation = location;

                }
            });
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            drawMap.addPolyLine(googleMap,start,end);
            googleMap.isMyLocationEnabled();
            showMap();


        }
    };

    public  void displayMyLocation(Location mLocation,GoogleMap googleMap) {
        CameraPosition cameraPosition = new CameraPosition.Builder().
                target(new LatLng(mLocation.getLatitude(), mLocation.getLongitude())).
                zoom(2).
                bearing(0).
                build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
    public void showMap(){
        if(args != null){
            Toast.makeText(requireContext(),"This Empty",Toast.LENGTH_SHORT).show();
        }
        else{
            args=MapsFragmentArgs.fromBundle(getArguments());

        }

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_maps, container, false);




        return view;
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