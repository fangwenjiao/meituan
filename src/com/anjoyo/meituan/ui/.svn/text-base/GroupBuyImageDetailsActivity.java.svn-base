package com.anjoyo.meituan.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.adapter.GroupBuyDetailsViewPAgerAdapter;

public class GroupBuyImageDetailsActivity extends Activity implements OnPageChangeListener{

    private ViewPager viewPager;
    String[] strings=null;
	private String goods_name;
	private String goods_saleInfo;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_buy_image_details);
        
        Intent intent=getIntent();
        strings=intent.getStringArrayExtra("netPathStrings");
        goods_name = intent.getStringExtra("goods_name");
        goods_saleInfo = intent.getStringExtra("goods_saleInfo");
        this.initView();
    }
    
    public void initView(){
    	viewPager = (ViewPager) findViewById(R.id.viewPager_image_details);
    	viewPager.setOnPageChangeListener(this);
    	
    	GroupBuyDetailsViewPAgerAdapter adapter=new GroupBuyDetailsViewPAgerAdapter(this, strings,goods_name,goods_saleInfo);
    	viewPager.setAdapter(adapter);
    	viewPager.setCurrentItem(0);
    }

	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
	}

	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}
  
}
