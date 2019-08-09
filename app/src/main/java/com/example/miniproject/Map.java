package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.GeoApiContext;

import java.util.concurrent.TimeUnit;

public class Map extends AppCompatActivity implements OnMapReadyCallback {
    public static final String ESTNAME = "estname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Bundle extras = getIntent().getExtras();
        String estName = extras.getString(ESTNAME);
        switch (estName){
            case "The Coffee House":
                LatLng coffeeHouse = new LatLng(10.839029, 106.671399);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(coffeeHouse)
                        .snippet("Nguyen Van Luong")
                        .title("The coffee house"))
                        .showInfoWindow();
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(coffeeHouse));
                break;
            case "Trung Nguyen":
                LatLng trungNguyen = new LatLng(10.773803, 106.697271);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(trungNguyen)
                        .title("Trung Nguyen Coffee")
                        .snippet("Hang Xanh"))
                        .showInfoWindow();
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(trungNguyen));
                break;
            case "Coffee Story":
                LatLng coffeeStory = new LatLng(10.877853, 106.801652);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(coffeeStory)
                        .title("Coffee Story ")
                        .snippet("International University"))
                        .showInfoWindow();
                googleMap.setMinZoomPreference(15);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(coffeeStory));
                break;
            case "Sky":
                LatLng Sky = new LatLng(10.774811, 106.700629);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(Sky)
                        .title("Sky Bar ")
                        .snippet("Ben Nghe, Quan 1"))
                        .showInfoWindow();
                googleMap.setMinZoomPreference(15);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(Sky));
                break;
            case "LandMark81":
                LatLng LandMark81 = new LatLng(10.795369, 106.721894);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(LandMark81)
                        .title("Landmark 81 ")
                        .snippet("Nguyen Huu Canh   "))
                        .showInfoWindow();
                googleMap.setMinZoomPreference(15);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(LandMark81));
                break;
            case "NewTomorrow":
                Toast.makeText(this, "No result found", Toast.LENGTH_LONG).show();
                break;
            case "Ran Bien":
                LatLng ranBien = new LatLng(10.786907, 106.686642);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(ranBien)
                        .title("Ran Bien Restaurant ")
                        .snippet("Nam Ki Khoi Nghia"))
                        .showInfoWindow();
                googleMap.setMinZoomPreference(15);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(ranBien));
                break;
            case "Huong Sen":
                LatLng HuongSen = new LatLng(10.237189, 105.983864);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(HuongSen)
                        .title("Huong Sen Restaurant ")
                        .snippet("Vinh Long"))
                        .showInfoWindow();
                googleMap.setMinZoomPreference(15);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(HuongSen));
                break;
            case "Hanuri":
                LatLng Hanuri = new LatLng(10.793928, 106.708738);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(Hanuri)
                        .title("Hanuri ")
                        .snippet("Xo Viet Nghe Tinh"))
                        .showInfoWindow();
                googleMap.setMinZoomPreference(15);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(Hanuri));
                break;
            case "caztus":
                LatLng caztus = new LatLng(10.791726, 106.695529);
                googleMap.setMinZoomPreference(15);
                googleMap.addMarker(new MarkerOptions().position(caztus)
                        .title("Caztus ")
                        .snippet("Vo Thi Sau"))
                        .showInfoWindow();
                googleMap.setMinZoomPreference(15);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(caztus));
                break;
        }

    }


}
