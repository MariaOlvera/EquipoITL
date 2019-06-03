package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment_inicio extends Fragment implements GoogleMap.OnMapLoadedCallback, OnMapReadyCallback {



    View view;
    SupportMapFragment mapFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_inicio, container,false);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if(mapFragment==null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map,mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapLoaded() {

    }

    public void onMapReady(GoogleMap googlemap){
        GoogleMap mMap;
        mMap = googlemap;


        LatLng l1 = new LatLng(21.1229044, -101.6831114);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l1).title("Plaza fundadores").snippet("Esta es la plaza fundadores").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng l2 = new LatLng(21.1203664, -101.6747844);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l2).title("Templo expiatorio").snippet("Este es el Templo Expiatorio Diocesano del Sagrado Corazón de Jesús").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng l3 = new LatLng(21.124633092586265, -101.68183679782673
        );//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l3).title("Museo").snippet("Este es el Museo de Arte Sacro").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng l4 = new LatLng(21.1189206, -101.6720748);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l4).title("Arco de la Calzada").snippet("Este es el Arco Triunfal de la Calzada").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng l5 = new LatLng(21.13052, -101.671 );
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l5).title("Museo de Arte").snippet("Este es el Museo de Arte e Historia").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng l6 = new LatLng(21.123809177663787, -101.68206680918786);
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l6).title("Catedral").snippet("Esta es la Catedral Metropolitana de Nuestra Madre Santísima de la Luz").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng l7 = new LatLng(21.1230546, -101.6791257);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l7).title("Museo de León").snippet("Este es el Museo de la Ciudad de León").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng l8 = new LatLng(21.092614941058713, -101.62738800608241);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(l8).title("Acuario").snippet("Este es el Acuario del Bajio").icon(BitmapDescriptorFactory.fromResource(R.drawable.lugares)));

        LatLng h1 = new LatLng(21.115504993042904, -101.65424565096124);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(h1).title("Real de minas").snippet("Este es el Hotel Real de minas").icon(BitmapDescriptorFactory.fromResource(R.drawable.descarga)));

        LatLng h2 = new LatLng(21.116186268073037, -101.6587161968161);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(h2).title("Hotel stadium").snippet("Este es el Hotel Plaza Stadium").icon(BitmapDescriptorFactory.fromResource(R.drawable.descarga)));

        LatLng h3 = new LatLng(21.113039025128515, -101.6473635280243);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(h3).title("Hotel radisson").snippet("Este es el Hotel Radisson").icon(BitmapDescriptorFactory.fromResource(R.drawable.descarga)));

        LatLng h4 = new LatLng(21.102746906285034, -101.63735841329691);//añade la latitud y la longitud
        //snippet pone una descripcion
        mMap.addMarker(new MarkerOptions().position(h4).title("Fiesta inn").snippet("Este es el Hotel Fiesta Inn - León").icon(BitmapDescriptorFactory.fromResource(R.drawable.descarga)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(l1,14));

    }
}
