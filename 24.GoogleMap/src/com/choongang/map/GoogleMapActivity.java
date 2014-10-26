package com.choongang.map;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;
public class GoogleMapActivity extends MapActivity {
	/** Called when the activity is first created. */
	MapView mapView;
	MapController mapController;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mapView=(MapView)findViewById(R.id.mapView);
		mapController=mapView.getController();
		/*
			위도(latitude) :37.4956783
			경도(longitude):127.0292015
		 */
		GeoPoint gp=new GeoPoint((int)(37.4956783*1E6), (int)(127.0292015*1E6));

		mapController.setCenter(gp);
		
		setIcon(gp);
		mapController.setZoom(16);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(true);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_SEARCH){
			mapView.setSatellite(!mapView.isSatellite());
		}
		if(keyCode==KeyEvent.KEYCODE_MENU){
			//역삼역:[37.500542,127.036436]
			GeoPoint gp=new GeoPoint((int)(37.500542*1E6), (int)(127.036436*1E6));
			//mapController.setCenter(gp);
			mapController.animateTo(gp);
			setIcon(gp);
		}

		return super.onKeyDown(keyCode, event);
	}
	public void setIcon(GeoPoint gp){
		
		
		MapView.LayoutParams mapParams=
			new MapView.LayoutParams(
					LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT,
					gp,MapView.LayoutParams.CENTER);
		
		
		ImageView iv=new
		ImageView(getApplicationContext());
		iv.setImageResource(R.drawable.koreanfood);
		
		mapView.removeAllViews();
		
		mapView.addView(iv,mapParams);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}