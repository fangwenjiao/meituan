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

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements OnClickListener {

	private TextView textview_register;
	private ImageView imageview_back, imageview_meituan;
	private EditText edittext_username, edittext_password;
	private Button login;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	void init() {
		setContentView(R.layout.login_user);
		textview_register = (TextView) findViewById(R.id.textView_register);
		imageview_back = (ImageView) findViewById(R.id.imageview_back);
		imageview_meituan = (ImageView) findViewById(R.id.imageview_meituan);
		login = (Button) findViewById(R.id.button_login);
		edittext_username = (EditText) findViewById(R.id.login_userName);
		edittext_password = (EditText) findViewById(R.id.login_userPassword);

		textview_register.setOnClickListener(this);
		imageview_back.setOnClickListener(this);
		imageview_meituan.setOnClickListener(this);
		login.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.textView_register:
			startActivityForResult(new Intent(this, RegisterActivity.class), 9);
			break;
		case R.id.imageview_back:
		case R.id.imageview_meituan:
			finish();
			break;
		case R.id.button_login:
			NetRequestConstant nrc = new NetRequestConstant();
			// post请求
			nrc.setType(HttpRequestType.POST);
			final String username = edittext_username.getText().toString();
			final String password = edittext_password.getText().toString();
			NetRequestConstant.requestUrl = NetUrlConstant.LOGINURL;
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
								AppContext appContext = (AppContext) getApplicationContext();
								User user = new User();
								user.setUsername(username);
								user.setPassword(password);
								appContext.setUser(user);
								Toast.makeText(LoginActivity.this, "登陆成功！",
										Toast.LENGTH_LONG).show();
								setResult(12, data);
								finish();
							} else {
								Toast.makeText(LoginActivity.this, "账号或密码不正确",
										Toast.LENGTH_LONG).show();
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}, nrc);

			break;
		default:
			break;
		}

	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                    	  if(data!=null){
                    		  String username = data.getStringExtra("username");
                        	  String password = data.getStringExtra("password");
                        	  edittext_username.setText(username);
                        	  edittext_password.setText(password);
                    	 
                      }
	}
}
