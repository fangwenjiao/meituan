package com.anjoyo.meituan.adapter;

import java.util.ArrayList;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MerchantListAdapter extends PagerAdapter {
private ArrayList<View> pagesArrayList;
  public MerchantListAdapter(ArrayList<View> pagesArrayList){
	  this.pagesArrayList=pagesArrayList;
  }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pagesArrayList.size();
	}

	
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView(pagesArrayList.get(position));
	}
	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		
		if(pagesArrayList.get(position).getParent()==null){
			((ViewPager)container).addView(pagesArrayList.get(position),0);
			
		}else{
			((ViewPager)pagesArrayList.get(position).getParent()).removeView(pagesArrayList.get(position));
			((ViewPager)container).addView(pagesArrayList.get(position),0);
		}
		return pagesArrayList.get(position);
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		return arg0==arg1;
	}

}
