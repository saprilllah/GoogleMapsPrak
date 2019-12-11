package com.example.mapslab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latitude  = -7.747034
        val longitude = 110.355398
        val latRumah = -7.7509806
        val longRumah = 110.3770734
        val latBoshe = -7.7532626
        val longBoshe = 110.362358
        val zoomlevel =15f
        val overlaySize =110f

        val uty = LatLng(latitude,longitude )
        mMap.addMarker(MarkerOptions()
            .position(uty).title("Universitas Teknologi Yogyakarta").snippet("-7.747034,110.355398").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,zoomlevel))

        val kos = LatLng(latRumah,longRumah)
        mMap.addMarker(MarkerOptions().position(kos).title("Rumah").snippet("-7.7509806/110.3770734").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val boshevip = LatLng(latBoshe,longBoshe)
        mMap.addMarker(MarkerOptions().position(boshevip).title("Boshe").snippet("-7.7532626/110.362358").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))

        val googleOverlay= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.utylogo1)).position(uty,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay2= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.rumah)).position(kos,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)

        val googleOverlay3= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.boshe1)).position(boshevip,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)


    }

}
