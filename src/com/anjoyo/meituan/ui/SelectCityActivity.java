package com.anjoyo.meituan.ui;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.adapter.CityAdapter;
import com.anjoyo.meituan.adapter.CityHeadViewAdapter;
import com.anjoyo.meituan.app.AppContext;
import com.anjoyo.meituan.domain.City;
import com.anjoyo.meituan.myview.MyGridView;
import com.anjoyo.meituan.myview.SideBar;
import com.anjoyo.meituan.utils.PingYinUtil;

public class SelectCityActivity extends BaseActivity implements
		OnItemClickListener, OnScrollListener {

	private WindowManager mWindowManager;
	private SideBar mSideBar;
	private ListView mListView;
	private TextView mDialogText;
	private List<City> cities;
	private SharedPreferences preferences;
	private int isnext;
	private AppContext appContext;
	private boolean mReady;
	private boolean mShowing;
	private char mPrevLetter = Character.MIN_VALUE;
	private RemoveWindow mRemoveWindow = new RemoveWindow();
	Handler mhander = new Handler();
	private MyGridView mGridView;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	}

	@Override
	protected void init() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题栏
		setContentView(R.layout.activity_select_city);
		appContext = (AppContext) getApplicationContext();
		preferences = getPreferences(MODE_PRIVATE);
		appContext.setPreferences(preferences);
		isnext = preferences.getInt("isnext", 7);
		System.out.println("isnext" + isnext);
		if (isnext == 7) {
			show();
			// startActivity(new Intent(this, MainActivity.class));
			// finish();
		} else if (isnext == 3) {
			show();
		} else {
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}
	}

	private void show() {
		mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_APPLICATION,
				WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
						| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT);
		mSideBar = (SideBar) findViewById(R.id.citySideBar);
		mListView = (ListView) findViewById(R.id.lv_city);
		mListView.setOnScrollListener(this);
		mSideBar.setListView(mListView);
		mDialogText = (TextView) LayoutInflater.from(this).inflate(
				R.layout.list_position, null);
		mDialogText.setVisibility(View.INVISIBLE);
		// mWindowManager.addView(mDialogText, lp);
		mSideBar.setTextView(mDialogText);
		mhander.post(new Runnable() {

			@Override
			public void run() {
				mReady = true;
				WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
						LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT,
						WindowManager.LayoutParams.TYPE_APPLICATION,
						WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
								| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
						PixelFormat.TRANSLUCENT);
				mWindowManager.addView(mDialogText, lp);

			}
		});

		cities = ((AppContext) getApplicationContext()).getCities();
		CityAdapter adapter = new CityAdapter(this, cities);
		mListView.addHeaderView(getHeadView());
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(this);
	}

	private View getHeadView() {
		View view = LayoutInflater.from(this).inflate(R.layout.city_headview,
				null);
		mGridView = (MyGridView) view.findViewById(R.id.gv_headview_city);
		mGridView.setAdapter(new CityHeadViewAdapter(this));
		mGridView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (isnext == 7) {
					String city = cities.get(arg2 - 1).getName();
					AppContext appContext = (AppContext) getApplicationContext();
					appContext.setCity(city);
					startActivity(new Intent(SelectCityActivity.this,
							MainActivity.class));
					finish();
				} else {
					String city = cities.get(arg2 - 1).getName();
					Intent intent = new Intent(SelectCityActivity.this,
							MainActivity.class);
					intent.putExtra("city", city);
					setResult(1, intent);
					finish();
				}
			}
		});
		return view;
	}

	@Override
	protected void onDestroy() {
		if (mWindowManager != null)
			mWindowManager.removeView(mDialogText);
		Editor editor = preferences.edit();
		editor.putInt("isnext", 4);
		editor.commit();
		super.onDestroy();
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if (isnext == 7) {
			String city = cities.get(arg2 - 1).getName();
			appContext.setCity(city);
			startActivity(new Intent(SelectCityActivity.this,
					MainActivity.class));
			finish();
		} else {
			String city = cities.get(arg2 - 1).getName();
			Intent intent = new Intent(this, MainActivity.class);
			intent.putExtra("city", city);
			setResult(1, intent);
			finish();
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		int lastItem = firstVisibleItem + visibleItemCount - 1;
		if (mReady) {
			// char firstLetter = mStrings[arg1].charAt(0);

			String name = cities.get(firstVisibleItem).getName();
			String lastCatalogString = PingYinUtil.converterToFirstSpell(name
					.substring(0, 1));

			char firstLetter = lastCatalogString.charAt(0);

			if (!mShowing && firstLetter != mPrevLetter) {
				mShowing = true;
				mDialogText.setVisibility(View.VISIBLE);
			}
			mDialogText.setText(((Character) firstLetter).toString());
			mhander.removeCallbacks(mRemoveWindow);
			mhander.postDelayed(mRemoveWindow, 3000);
			mPrevLetter = firstLetter;
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub

	}

	private void removeWindow() {
		if (mShowing) {
			mShowing = false;
			mDialogText.setVisibility(View.INVISIBLE);
		}
	}

	private final class RemoveWindow implements Runnable {
		public void run() {
			removeWindow();
		}
	}
}