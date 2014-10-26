package com.choongang.location;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class LocationActivity extends MapActivity {
	/** Called when the activity is first created. */
	TextView displayTV;
	LocationManager locationManager;
	MyLocationListener locationListener;
	MapView mapview;
	MapController mapController;
	MyPositionOverLay positionOverlay;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		displayTV=(TextView)findViewById(R.id.displayTV);

		mapview=(MapView)findViewById(R.id.mapview);
		mapController = mapview.getController();
		mapController.setZoom(17);
		mapview.setBuiltInZoomControls(true);

		locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		locationListener=new MyLocationListener();
		//String provider=locationManager.getBestProvider(new Criteria(), true);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
		//locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		positionOverlay=new MyPositionOverLay();
		List<Overlay> overlayList=mapview.getOverlays();
		overlayList.add(positionOverlay);
	}



	@Override
	protected void onStop() {
		super.onStop();
		locationManager.removeUpdates(locationListener);
	}

	/*************LocationListener impl*****************/
	class MyLocationListener implements LocationListener{
		public void onLocationChanged(Location location) {

			showLocationName(location);
			GeoPoint gp=new GeoPoint(
					(int)(location.getLatitude()*1E6),
					(int)(location.getLongitude()*1E6)
			);

			mapController.animateTo(gp);
			positionOverlay.setLocation(location);
		}
		public void onProviderDisabled(String provider) {
		}
		public void onProviderEnabled(String provider) {
		}
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	}
	/***************************************************/
	Location preLocation;
	public void showLocationName(Location location) {
		StringBuffer sb=new StringBuffer();

		if(preLocation!=null){
			int distance=(int)preLocation.distanceTo(location);
			int direction =(int)preLocation.bearingTo(location);
			sb.append(direction+ " 으로" +distance+" m 이동\n");

		}
		preLocation=location;

		double latitude=location.getLatitude();
		double longitude=location.getLongitude();
		sb.append("위도:"+latitude+"\n");
		sb.append("경도:"+longitude+"\n");

		Geocoder geocoder = new Geocoder(getApplicationContext(),Locale.KOREA);
		try {
			List<Address> addressList=
				geocoder.getFromLocation(latitude, longitude, 1);
			if((addressList!=null)&&(addressList.size()>0)){
				Address address=addressList.get(0);
				String addressStr = address.getAddressLine(0);
				sb.append("주소:"+addressStr);
			}else{
				sb.append("주소:주소없음..");
			}
		} catch (IOException e) {
			sb.append("주소:IOException");
		}

		displayTV.setText(sb.toString());

	}



	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	/***********Overlay inner class************/
	class MyPositionOverLay extends Overlay{
		Location location;

		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public MyPositionOverLay() {

		}
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			super.draw(canvas, mapView, shadow);
			if(location!=null){
				Paint p=new Paint();
				p.setAntiAlias(true);
				p.setColor(Color.BLUE);

				Projection projection=mapview.getProjection();
				Point out=new Point();
				GeoPoint in=
					new GeoPoint(
							(int)(location.getLatitude()*1E6),
							(int)(location.getLongitude()*1E6)
					);

				projection.toPixels(in, out);
				canvas.drawCircle(out.x, out.y, 5, p);
				if(touchGp!=null){
					Point out2=new Point();
					projection.toPixels(touchGp, out2);
					Paint p1=new Paint();
					p1.setAntiAlias(true);
					p1.setColor(Color.BLACK);
					canvas.drawText(address, out2.x, out2.y,p1);
				}
			}
		}
		GeoPoint touchGp;
		String address="여기";
		@Override
		public boolean onTap(GeoPoint p, MapView mapView) {
			touchGp=p;

			Toast.makeText(getApplicationContext(),
					p.getLatitudeE6()/1E6+","+p.getLongitudeE6()/1E6, 3000).show();

			return super.onTap(p, mapView);
		}
	}



}













