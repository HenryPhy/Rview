package com.example.rview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TwoFragment extends Fragment {

    private TextView tv;

    public TwoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_two, container, false);
        // Inflate the layout for this fragment
        tv = (TextView) view.findViewById(R.id.tv2);
        getLocation();
        return view;
    }
    private void getLocation() {
        LocationManager locationManager;
        String service = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) getActivity().getSystemService(service);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.ACCURACY_LOW);

        String provider = locationManager.getBestProvider(criteria, true);
        @SuppressLint("MissingPermission") Location lastKnownLocation = locationManager.getLastKnownLocation(provider);

        updateToNewLocation(lastKnownLocation);
//        locationManager.requestLocationUpdates(provider, 100 * 1000, 500,
//                locationListener);

    }

    private void updateToNewLocation(Location lastKnownLocation) {
        if (lastKnownLocation!=null){
            double latitude = lastKnownLocation.getLatitude();
            double longitude = lastKnownLocation.getLongitude();
            tv.setText("纬度："+latitude + "\n经度:"+longitude);
        }else {
            tv.setText("无法获取地理位置");
        }

    }
}
