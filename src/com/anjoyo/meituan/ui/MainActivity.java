package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.app.AppContext;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends TabActivity implements OnClickListener {

	private TabHost host;
	private final static String GROUPBUY_STRING = "GROUPBUY_STRING";//团购
	private final static String MERCHANT_STRING = "MERCHANT_STRING";//商家
	private final static String MYSELF_STRING = "MYSELF_STRING";//我的
	private final static String MORE_STRING = "MORE_STRING";//更多
	private ImageView img_groupbuy;
	private ImageView img_merchant;
	private ImageView img_mine;
	private ImageView img_more;
	private TextView  text_groupbuy;
	private TextView  text_merchant;
	private TextView  text_mine;
	private TextView  text_more;
	private LinearLayout linearlayout_groupbuy;
	private LinearLayout linearlayout_merchant;
	private LinearLayout linearlayout_mine;
	private LinearLayout linearlayout_more;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.getScreenDisplay();
		
		this.initView();
		host = getTabHost();
		host.setup();
		setGroupBuyTab();
		setMerchantTab();
		setMyselfTab();
		setMoreTab();
		host.setCurrentTabByTag(GROUPBUY_STRING);//默认团购页面

	}

	public void initView(){
		img_groupbuy=(ImageView) findViewById(R.id.img_groupbuy);
		img_merchant=(ImageView) findViewById(R.id.img_merchant);
		img_mine=(ImageView) findViewById(R.id.img_mine);
		img_more=(ImageView) findViewById(R.id.img_more);
		img_groupbuy.setOnClickListener(this);
		img_merchant.setOnClickListener(this);
		img_mine.setOnClickListener(this);
		img_more.setOnClickListener(this);
		
		text_groupbuy=(TextView) findViewById(R.id.text_groupbuy);
		text_merchant=(TextView) findViewById(R.id.text_merchant);
		text_mine=(TextView) findViewById(R.id.text_mine);
		text_more=(TextView) findViewById(R.id.text_more);
		
		linearlayout_groupbuy=(LinearLayout) findViewById(R.id.linearlayout_groupbuy);
		linearlayout_merchant=(LinearLayout) findViewById(R.id.linearlayout_merchant);
		linearlayout_mine=(LinearLayout) findViewById(R.id.linearlayout_mine);
		linearlayout_more=(LinearLayout) findViewById(R.id.linearlayout_more);
		
		linearlayout_groupbuy.setOnClickListener(this);
		linearlayout_merchant.setOnClickListener(this);
		linearlayout_mine.setOnClickListener(this);
		linearlayout_more.setOnClickListener(this);
	}
	
	private void setGroupBuyTab() {
		TabSpec tabSpec = host.newTabSpec(GROUPBUY_STRING);
		tabSpec.setIndicator(GROUPBUY_STRING);
		Intent intent = new Intent(MainActivity.this, GroupBuyActivity.class);
		tabSpec.setContent(intent);
		host.addTab(tabSpec);
	}

	private void setMerchantTab() {
		TabSpec tabSpec = host.newTabSpec(MERCHANT_STRING);
		tabSpec.setIndicator(MERCHANT_STRING);
		Intent intent = new Intent(MainActivity.this, MerchantActivity.class);
		tabSpec.setContent(intent);
		host.addTab(tabSpec);
	}

	private void setMyselfTab() {
		TabSpec tabSpec = host.newTabSpec(MYSELF_STRING);
		tabSpec.setIndicator(MYSELF_STRING);
		Intent intent = new Intent(MainActivity.this, MineActivity.class);
		tabSpec.setContent(intent);
		host.addTab(tabSpec);
	}

	private void setMoreTab() {
		TabSpec tabSpec = host.newTabSpec(MORE_STRING);
		tabSpec.setIndicator(MORE_STRING);
		Intent intent = new Intent(MainActivity.this, MoreActivity.class);
		tabSpec.setContent(intent);
		host.addTab(tabSpec);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.linearlayout_groupbuy:
		case R.id.img_groupbuy:
			host.setCurrentTabByTag(GROUPBUY_STRING);
			img_groupbuy.setBackgroundResource(R.drawable.ic_menu_deal_on);
			text_groupbuy.setTextColor(getResources().getColor(R.color.green));
			img_merchant.setBackgroundResource(R.drawable.ic_menu_poi_off);
			text_merchant.setTextColor(getResources().getColor(R.color.textgray));
			img_mine.setBackgroundResource(R.drawable.ic_menu_user_off);
			text_mine.setTextColor(getResources().getColor(R.color.textgray));
			img_more.setBackgroundResource(R.drawable.ic_menu_more_off);
			text_more.setTextColor(getResources().getColor(R.color.textgray));
			
			break;

		case R.id.linearlayout_merchant:
		case R.id.img_merchant:	
			host.setCurrentTabByTag(MERCHANT_STRING);
			img_groupbuy.setBackgroundResource(R.drawable.ic_menu_deal_off);
			text_groupbuy.setTextColor(getResources().getColor(R.color.textgray));
			img_merchant.setBackgroundResource(R.drawable.ic_menu_poi_on);
			text_merchant.setTextColor(getResources().getColor(R.color.green));
			img_mine.setBackgroundResource(R.drawable.ic_menu_user_off);
			text_mine.setTextColor(getResources().getColor(R.color.textgray));
			img_more.setBackgroundResource(R.drawable.ic_menu_more_off);
			text_more.setTextColor(getResources().getColor(R.color.textgray));
			break;

		case R.id.linearlayout_mine:
		case R.id.img_mine:
			host.setCurrentTabByTag(MYSELF_STRING);
			img_groupbuy.setBackgroundResource(R.drawable.ic_menu_deal_off);
			text_groupbuy.setTextColor(getResources().getColor(R.color.textgray));
			img_merchant.setBackgroundResource(R.drawable.ic_menu_poi_off);
			text_merchant.setTextColor(getResources().getColor(R.color.textgray));
			img_mine.setBackgroundResource(R.drawable.ic_menu_user_on);
			text_mine.setTextColor(getResources().getColor(R.color.green));
			img_more.setBackgroundResource(R.drawable.ic_menu_more_off);
			text_more.setTextColor(getResources().getColor(R.color.textgray));
			break;

		case R.id.linearlayout_more:
		case R.id.img_more:
			host.setCurrentTabByTag(MORE_STRING);
			img_groupbuy.setBackgroundResource(R.drawable.ic_menu_deal_off);
			text_groupbuy.setTextColor(getResources().getColor(R.color.textgray));
			img_merchant.setBackgroundResource(R.drawable.ic_menu_poi_off);
			text_merchant.setTextColor(getResources().getColor(R.color.textgray));
			img_mine.setBackgroundResource(R.drawable.ic_menu_user_off);
			text_mine.setTextColor(getResources().getColor(R.color.textgray));
			img_more.setBackgroundResource(R.drawable.ic_menu_more_on);
			text_more.setTextColor(getResources().getColor(R.color.green));
			break;

		default:
			break;
		}
	}
	
	private void getScreenDisplay(){
		 Display display=this.getWindowManager().getDefaultDisplay();
	     int screenWidth = display.getWidth();
	     int screenHeight=display.getHeight();
	     
	     AppContext appContext=(AppContext) getApplicationContext();
	     appContext.setScreenWidth(screenWidth);
	     appContext.setScreenHeight(screenHeight);
	}
}
