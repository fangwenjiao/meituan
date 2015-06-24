package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class VoucherActivity extends BaseActivity implements OnClickListener {

	private Button button_vouchar;// 代金劵帮助
	private ImageView imageview_back, imageview_back2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voucher_activity);
		this.initView();
	}

	public void initView() {
		button_vouchar = (Button) findViewById(R.id.button_voucherHelp);
		imageview_back = (ImageView) findViewById(R.id.imageview_back);
		imageview_back2 = (ImageView) findViewById(R.id.imageview_back2);

		button_vouchar.setOnClickListener(this);
		imageview_back.setOnClickListener(this);
		imageview_back2.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_voucherHelp:
			startActivity(new Intent(this, VoucherHelpActivity.class));
			break;
		case R.id.imageview_back:
		case R.id.imageview_back2:
			finish();
			break;
		default:
			break;
		}
	}

	@Override
	void init() {
		// TODO Auto-generated method stub

	}

}
