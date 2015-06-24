package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MoreActivity extends BaseActivity implements OnClickListener {
	private Button button_aboutmeituan,
			button_messageremind, button_shareset;
	private ImageView imageview_picturemode;
	private LinearLayout linearlayout_picturemode,linearlayout_emptybuffer,linearlayout_checkupdate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	void init() {
		setContentView(R.layout.more_activity);
		button_aboutmeituan = (Button) findViewById(R.id.button_meituan);
		linearlayout_picturemode =  (LinearLayout) findViewById(R.id.linearlayout_picturemode);
		imageview_picturemode = (ImageView) findViewById(R.id.imageview_picturemode);
		button_messageremind = (Button) findViewById(R.id.button_messageremind);
		linearlayout_emptybuffer =  (LinearLayout) findViewById(R.id.linearlayout_emptybuffer);
		button_shareset = (Button) findViewById(R.id.button_shareset);
		linearlayout_checkupdate = (LinearLayout) findViewById(R.id.linearlayout_inspectupdate);

		button_aboutmeituan.setOnClickListener(this);
		linearlayout_picturemode.setOnClickListener(this);
		imageview_picturemode.setOnClickListener(this);
		button_messageremind.setOnClickListener(this);
		linearlayout_emptybuffer.setOnClickListener(this);
		button_shareset.setOnClickListener(this);
		linearlayout_checkupdate.setOnClickListener(this);

	}

	int i = 1;

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_meituan:
			startActivity(new Intent(this, AboutMeiTuanActivity.class));
			break;
		case R.id.linearlayout_picturemode:
		case R.id.imageview_picturemode:
			i = -i;
			if (i == 1) {
				imageview_picturemode
						.setBackgroundResource(R.drawable.bg_settings_drag_off);
			} else {
				imageview_picturemode
						.setBackgroundResource(R.drawable.bg_settings_drag_on);
			}
			break;
		case R.id.button_messageremind:
			startActivity(new Intent(this, MessageRemindActivity.class));
			break;
		case R.id.linearlayout_emptybuffer:
			Toast.makeText(this, "缓存已清空", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_shareset:
			startActivity(new Intent(this, ShareSetActivity.class));
			break;
		case R.id.linearlayout_inspectupdate:
			startActivity(new Intent(this, CheckUpdateActivity.class));
			break;
		default:
			break;
		}

	}

}
