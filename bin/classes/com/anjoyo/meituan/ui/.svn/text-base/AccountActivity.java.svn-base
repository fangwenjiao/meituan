package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.app.AppContext;
import com.anjoyo.meituan.domain.User;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AccountActivity extends Activity implements OnClickListener {
	private ImageView imageview_back, imageview_back2;
	private TextView textview_amendusername;
	private LinearLayout linearlayout_amendusername, linearlayout_myreward,
			linearlayout_amedpassword, linearlayout_phonenum,
			linearlayout_address;
    private Button button_exit;
	private AppContext appContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_activity);
		init();
	}

	private void init() {
		appContext = (AppContext) getApplicationContext();
		User user = appContext.getUser();
		linearlayout_amendusername = (LinearLayout) findViewById(R.id.linearlayout_amendusername);
		imageview_back = (ImageView) findViewById(R.id.imageview_back);
		linearlayout_amedpassword = (LinearLayout) findViewById(R.id.linearlayout_amedpassword);
		linearlayout_address = (LinearLayout) findViewById(R.id.linearlayout_address);
		imageview_back2 = (ImageView) findViewById(R.id.imageview_back2);
		textview_amendusername = (TextView) findViewById(R.id.textview_amendusername);
		linearlayout_myreward = (LinearLayout) findViewById(R.id.linearlayout_myreward);
		linearlayout_phonenum = (LinearLayout) findViewById(R.id.linearlayout_phonenum);
		button_exit = (Button) findViewById(R.id.button_exit);

		linearlayout_amendusername.setOnClickListener(this);
		imageview_back.setOnClickListener(this);
		linearlayout_amedpassword.setOnClickListener(this);
		linearlayout_address.setOnClickListener(this);
		imageview_back2.setOnClickListener(this);
		linearlayout_myreward.setOnClickListener(this);
		linearlayout_phonenum.setOnClickListener(this);
		button_exit.setOnClickListener(this);

		if (user != null) {
			textview_amendusername.setText(user.getUsername());
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.linearlayout_amendusername:
			startActivityForResult(new Intent(this, AmedUserNameActivity.class),19);
			break;
		case R.id.imageview_back:
		case R.id.imageview_back2:
			finish();
			break;
		case R.id.linearlayout_amedpassword:
			startActivity(new Intent(this, AmedPasswordActivity.class));
			break;
		case R.id.linearlayout_address:
			startActivity(new Intent(this, AddressManageActivity.class));
			break;
		case R.id.button_exit:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("确定退出吗");
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
				//	appContext.setUser(null);
					Intent data = new Intent();
					setResult(11);
					finish();
				}
			
			});
			
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					
				}
			});
			builder.create();
			builder.show();
			break;
		default:
			break;
		}

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		      if(data!=null){
		    	  String newname = data.getStringExtra("newname");
		    	  textview_amendusername.setText(newname);
		      }
	}
    
}
