package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.app.AppContext;
import com.anjoyo.meituan.domain.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MineActivity extends BaseActivity implements OnClickListener {

	private ImageView iv_mine1;// 通知
	private LinearLayout lL_mine, lL_mine2;// //账户
	private RelativeLayout rL_mine;// 我的美团卷
	private RelativeLayout rL_mine1;
	private LinearLayout lL_mine3;// 每日推荐
	private LinearLayout lL_mine4;//待付款
	private LinearLayout lL_mine5;//已付款
	private LinearLayout lL_mine6;// 抽奖单
	private LinearLayout lL_mine7;
	private Button button_register;
	private TextView textview_username;
	private AppContext appContext;
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		appContext = (AppContext) getApplicationContext();
		user = appContext.getUser();
		if (user != null) {
			String username = user.getUsername();
			lL_mine.setVisibility(View.GONE);
			textview_username.setText(username);
			lL_mine2.setVisibility(View.VISIBLE);
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iV_mine1:// 美团通知
			Intent intent = new Intent(MineActivity.this,
					NotificationActivity.class);
			startActivity(intent);

			break;
		case R.id.lL_mine:
		case R.id.button_register:// 登录
			Intent intent1 = new Intent(MineActivity.this, LoginActivity.class);
			startActivityForResult(intent1, 12);

			break;
		case R.id.rL_mine:// 我的美团卷
			if (user != null) {
				Intent intent2 = new Intent(MineActivity.this, TicketActivity.class);
				startActivity(intent2);
			} else {
				Toast.makeText(this, "亲，请先登录", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.rL_mine1:
			if (user != null) {
				Intent intent3 = new Intent(MineActivity.this,
						CollectActivity.class);
				startActivity(intent3);
			} else {
				Toast.makeText(this, "亲，请先登录", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.lL_mine3:// 每日推荐
			Intent intent4 = new Intent(MineActivity.this,
					RecommendedActivity.class);
			startActivity(intent4);
			break;
		case R.id.lL_mine4:
			if (user != null) {
				Intent intent5 = new Intent(MineActivity.this,
						ObligationActivity.class);
				startActivity(intent5);
			} else {
				Toast.makeText(this, "亲，请先登录", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.lL_mine5:
			if (user != null) {
				Intent intent6 = new Intent(MineActivity.this, PaidActivity.class);
				startActivity(intent6);
			} else {
				Toast.makeText(this, "亲，请先登录", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.lL_mine6:// 抽奖单
			if (user != null) {
				Intent intent7 = new Intent(MineActivity.this,
						LotteryActivity.class);
				startActivity(intent7);
			} else {
				Toast.makeText(this, "亲，请先登录", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.lL_mine7:
			Intent intent8 = new Intent(MineActivity.this,
					VoucherActivity.class);
			startActivity(intent8);
			break;
		case R.id.lL_mine2:
			startActivityForResult(new Intent(this, AccountActivity.class), 11);
			break;
		default:
			break;
		}

	}

	@Override
	void init() {
		setContentView(R.layout.mine_activity);
		iv_mine1 = (ImageView) findViewById(R.id.iV_mine1);
		lL_mine = (LinearLayout) findViewById(R.id.lL_mine);
		rL_mine = (RelativeLayout) findViewById(R.id.rL_mine);
		rL_mine1 = (RelativeLayout) findViewById(R.id.rL_mine1);
		lL_mine3 = (LinearLayout) findViewById(R.id.lL_mine3);
		lL_mine4 = (LinearLayout) findViewById(R.id.lL_mine4);
		lL_mine5 = (LinearLayout) findViewById(R.id.lL_mine5);
		lL_mine6 = (LinearLayout) findViewById(R.id.lL_mine6);
		lL_mine7 = (LinearLayout) findViewById(R.id.lL_mine7);
		lL_mine2 = (LinearLayout) findViewById(R.id.lL_mine2);
		button_register = (Button) findViewById(R.id.button_register);
		textview_username = (TextView) findViewById(R.id.textview_username);

		iv_mine1.setOnClickListener(this);
		lL_mine.setOnClickListener(this);
		rL_mine.setOnClickListener(this);
		rL_mine1.setOnClickListener(this);
		lL_mine3.setOnClickListener(this);
		lL_mine4.setOnClickListener(this);
		lL_mine5.setOnClickListener(this);
		lL_mine6.setOnClickListener(this);
		lL_mine7.setOnClickListener(this);
		button_register.setOnClickListener(this);
		lL_mine2.setOnClickListener(this);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 12) {
			if (data != null) {
				String username = data.getStringExtra("username");
				lL_mine.setVisibility(View.GONE);
				textview_username.setText(username);
				lL_mine2.setVisibility(View.VISIBLE);
			} 
		}else if (requestCode == 11) {
			lL_mine2.setVisibility(View.GONE);
			lL_mine.setVisibility(View.VISIBLE);
		}
		user = appContext.getUser();

	}

}
