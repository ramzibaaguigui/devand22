package com.devfest.location;

import static android.content.Context.LOCATION_SERVICE;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;

import com.devfest.api.model.Location;


public class LocationUtils {
    private static Location _getLocation(Context context) {
        // Get the location manager
        LocationManager locationManager = (LocationManager)
                context.getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }
        android.location.Location location = locationManager.getLastKnownLocation(bestProvider);

        Location loc = new Location();
        loc.setX((float) location.getLongitude());
        loc.setY((float) location.getLatitude());
        return loc;
    }

}
