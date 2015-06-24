package com.anjoyo.meituan.ui;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.app.AppContext;
import com.anjoyo.meituan.common.NetRequestConstant;
import com.anjoyo.meituan.common.NetUrlConstant;
import com.anjoyo.meituan.domain.User;
import com.anjoyo.meituan.interfaces.Netcallback;
import com.anjoyo.meituan.ui.BaseActivity.HttpRequestType;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AmedPasswordActivity extends BaseActivity implements
		OnClickListener {
	private ImageView imageview_back;
	private TextView textview_back;
	private EditText et_oldpassword, et_newpassword, et_newpassword2;
	private Button confirm;
	private String username;
	private User user;
	private AppContext appContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	void init() {
		setContentView(R.layout.amedpassword_activity);
		imageview_back = (ImageView) findViewById(R.id.imageview_aboutmeituanback);
		textview_back = (TextView) findViewById(R.id.textview_meituan);
		et_oldpassword = (EditText) findViewById(R.id.oldpassword);
		et_newpassword = (EditText) findViewById(R.id.newpassword);
		et_newpassword2 = (EditText) findViewById(R.id.newpassword2);
		confirm = (Button) findViewById(R.id.button_confirm);
		
		confirm.setOnClickListener(this);
		imageview_back.setOnClickListener(this);
		textview_back.setOnClickListener(this);

		appContext = (AppContext) getApplicationContext();
		user = appContext.getUser();
		username = user.getUsername();

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageview_aboutmeituanback:
		case R.id.textview_meituan:
			finish();
			break;
		case R.id.button_confirm:

			String oldpassword = et_oldpassword.getText().toString();
			String newpassword = et_newpassword.getText().toString();
			String newpassword2 = et_newpassword2.getText().toString();
			if (newpassword.equals(newpassword2)) {

				NetRequestConstant nrc = new NetRequestConstant();
				// post请求
				nrc.setType(HttpRequestType.POST);

				NetRequestConstant.requestUrl = NetUrlConstant.CHANGEPASSWORDURL;
				NetRequestConstant.context = this;
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("username", username);
				map.put("oldpassword", oldpassword);
				map.put("newpassword", newpassword);
				NetRequestConstant.map = map;

				getServer(new Netcallback() {

					public void preccess(Object res, boolean flag) {
						if (res != null) {
							try {
								JSONObject object = new JSONObject((String) res);
								String success = object.optString("success");
								if (success.equals("1")) {
									Toast.makeText(AmedPasswordActivity.this,
											"修改成功", Toast.LENGTH_SHORT).show();
									finish();
								} else {
									Toast.makeText(AmedPasswordActivity.this,
											"修改失败，请核对你的当前密码",
											Toast.LENGTH_SHORT).show();

								}

							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}, nrc);

			} else {
				Toast.makeText(this, "两次输入密码不正确，请重新输入", Toast.LENGTH_SHORT)
						.show();
				et_newpassword.setText("");
				et_newpassword2.setText("");

			}

			break;
		default:
			break;
		}

	}

}
