package com.anjoyo.meituan.Parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.anjoyo.meituan.domain.City;

public class AssetsParser {
	
	
	public List<City> getCities(String res){
		List<City> cities = new ArrayList<City>();
		try {
			JSONArray array = new JSONArray(res);
			for(int i = 0;i<array.length();i++){
				JSONObject object = array.getJSONObject(i);
				String cityname = object.optString("cityname");
				City city = new City();
				city.setName(cityname);
				cities.add(city);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cities;
	}

}
