package com.anjoyo.meituan.app;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.anjoyo.meituan.Parser.AssetsParser;
import com.anjoyo.meituan.domain.AllCategories;
import com.anjoyo.meituan.domain.City;
import com.anjoyo.meituan.domain.Good;
import com.anjoyo.meituan.domain.Seller;
import com.anjoyo.meituan.domain.SpecificCategories;
import com.anjoyo.meituan.domain.User;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;

public class AppContext extends Application {
	private List<City> cities;
	private List<Good> goods;
	private List<Seller> seller;
	private List<SpecificCategories>  specificCategories;
	private List<AllCategories>  allCategories;
	private String city;
	private SharedPreferences preferences;
	private User user;
	private int screenWidth;
	private int screenHeight;

	public List<SpecificCategories> getSpecificCategories() {
		return specificCategories;
	}

	public void setSpecificCategories(List<SpecificCategories> specificCategories) {
		this.specificCategories = specificCategories;
	}

	public List<AllCategories> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(List<AllCategories> allCategories) {
		this.allCategories = allCategories;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<City> getCities() {
		return cities;
	}
	

	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}
	public List<Seller> getSeller() {
		return seller;
	}

	public void setSeller(List<Seller> seller) {
		this.seller = seller;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		String as;
		try {
			as = getA();
			AssetsParser parser = new AssetsParser();
			List<City> cities = parser.getCities(as);
			setCities(cities);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getA() throws IOException {
		AssetManager assetManager = this.getAssets();
		InputStream is = assetManager.open("city_coordinate.txt");
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = is.read(buffer)) != -1) {
			stream.write(buffer, 0, length);
		}
		return stream.toString();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public SharedPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(SharedPreferences preferences) {
		this.preferences = preferences;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		Editor editor = preferences.edit();
		editor.putString("username", user.getUsername());
		editor.putString("password", user.getPassword());
		editor.commit();

	}

}
