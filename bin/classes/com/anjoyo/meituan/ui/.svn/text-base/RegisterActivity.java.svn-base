package com.anjoyo.meituan.ui;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.common.NetRequestConstant;
import com.anjoyo.meituan.common.NetUrlConstant;
import com.anjoyo.meituan.interfaces.Netcallback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends BaseActivity implements OnClickListener {
	private EditText edittext_username, edittext_password;
	private Button button_confirm;
	private ImageView imageview_back;
	private TextView textview_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	void init() {
		setContentView(R.layout.register_activity);
		edittext_username = (EditText) findViewById(R.id.edittext_username);
		edittext_password = (EditText) findViewById(R.id.edittext_password);
		button_confirm = (Button) findViewById(R.id.button_confirm);
		imageview_back = (ImageView) findViewById(R.id.imageview_back);
		textview_back = (TextView) findViewById(R.id.textview_meituan);

		button_confirm.setOnClickListener(this);
		imageview_back.setOnClickListener(this);
		textview_back.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageview_back:
		case R.id.textview_meituan:
			finish();
			break;
		case R.id.button_confirm:// 确认注册
			final String username = edittext_username.getText().toString();
			final String password = edittext_password.getText().toString();

			if (!username.equals("") && !password.equals("")) {

				NetRequestConstant nrc = new NetRequestConstant();
				// post请求
				nrc.setType(HttpRequestType.POST);
				NetRequestConstant.requestUrl = NetUrlConstant.REGISTERURL;
				NetRequestConstant.context = this;
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("user_Name", username);
				map.put("user_Password", password);
				NetRequestConstant.map = map;

				getServer(new Netcallback() {

					public void preccess(Object res, boolean flag) {
						if (res != null) {
							try {
								JSONObject object = new JSONObject((String) res);
								String success = object.optString("success");
								if (success.equals("1")) {
									Intent data = new Intent();
									data.putExtra("username", username);
									data.putExtra("password", password);
									setResult(RESULT_OK, data);
									Toast.makeText(RegisterActivity.this,
											"注册成功", Toast.LENGTH_LONG)
											.show();
									finish();
								} else {
									Toast.makeText(RegisterActivity.this,
											"该账号已被注册", Toast.LENGTH_LONG)
											.show();
								}

							} catch (JSONException e) {
								e.printStackTrace();
							}

						}

					}
				}, nrc);

			}

			break;
		default:
			break;
		}

	}

}
