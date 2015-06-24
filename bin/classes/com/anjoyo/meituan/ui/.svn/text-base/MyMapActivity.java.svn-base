package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.common.OverItemT;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.LocationListener;
import com.baidu.mapapi.MKLocationManager;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.MyLocationOverlay;
import com.baidu.mapapi.Overlay;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;

public class MyMapActivity extends MapActivity {

	// private final static String KEY = "OsvOOCUMoAKmBbHq_jMFCtxLD";
	private final static String KEY = "7D3157DA1B76B50A2FA0E9C9AFF13834D72D330B";
	private BMapManager bmanager;
	private MapView mapview;
	private MKLocationManager locationManager;
	private double lat;
	private double lon;
	GeoPoint geoPoint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity);
		this.init();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	private void init() {

		bmanager = new BMapManager(getApplication());
		bmanager.init(KEY, null);
		super.initMapActivity(bmanager);
		mapview = (MapView) findViewById(R.id.mapview);
		mapview.setBuiltInZoomControls(true);
		
		//定位
		locationManager = bmanager.getLocationManager();
		locationManager.enableProvider(MKLocationManager.MK_NETWORK_PROVIDER);
		locationManager.disableProvider(MKLocationManager.MK_GPS_PROVIDER);
		MyLocationOverlay mylocTest = new MyLocationOverlay(this, mapview);
		mylocTest.enableMyLocation();
		mylocTest.enableCompass();
		mapview.getOverlays().add(mylocTest);
		
		// 设置覆盖物
		MapController mMapController = mapview.getController();
		geoPoint=new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));
		mMapController.setCenter(geoPoint);
		mMapController.setZoom(12);
		MyOverlay overlay = new MyOverlay();
		mapview.getOverlays().add(overlay);
		
		//添加覆盖物
		Drawable marker = getResources().getDrawable(R.drawable.ic_pin_shopping); //得到需要标在地图上的资源
		mapview.getOverlays().add(new OverItemT(marker, this,mapview)); //添加ItemizedOverlay实例到mMapView
	}

	@Override
	protected void onDestroy() {
		if (bmanager != null) {
			bmanager.destroy();
		}
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		if (bmanager != null) {
			bmanager.stop();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		if (bmanager != null) {
			bmanager.start();
			locationManager.requestLocationUpdates(new LocationListener() {

				public void onLocationChanged(Location arg0) {
					lat = arg0.getLatitude();
					lon = arg0.getLongitude();
					GeoPoint point = new GeoPoint((int) (lat * 1E6),(int) (lon * 1E6));
					mapview.getController().animateTo(point);

				}
			});
		}
		super.onResume();
	}

	public class MyOverlay extends Overlay {

		//GeoPoint geoPoint = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));
		Paint paint = new Paint();

		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			Point point = mapview.getProjection().toPixels(geoPoint, null);
			canvas.drawText("you are here", point.x, point.y, paint);
		}
	}

}
