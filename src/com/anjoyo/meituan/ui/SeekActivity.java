package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class SeekActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seek_activity);

		this.initView();
	}

	public void initView() {
		//返回
		RelativeLayout relativeLayout_title = (RelativeLayout) findViewById(R.id.relativeLayout_title);
		relativeLayout_title.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.relativeLayout_title:
			finish();
			break;

		default:
			break;
		}
	}
}
