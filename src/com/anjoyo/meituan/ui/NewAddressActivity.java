package com.anjoyo.meituan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.app.AppContext;
import com.anjoyo.meituan.domain.Address;
import com.anjoyo.meituan.domain.User;
import com.anjoyo.meituan.ui.BaseActivity;

public class NewAddressActivity extends BaseActivity implements OnClickListener {
	private EditText et_name, et_phone, et_province, et_city, et_area,
			et_postcode, et_address;
	private Button button;
	private User user;

	void init() {
		setContentView(R.layout.newadress_activity);
		et_name = (EditText) findViewById(R.id.et_name);
		et_phone = (EditText) findViewById(R.id.et_phone);
		et_province = (EditText) findViewById(R.id.et_province);
		et_city = (EditText) findViewById(R.id.et_city);
		et_area = (EditText) findViewById(R.id.et_area);
		et_postcode = (EditText) findViewById(R.id.et_postcode);
		et_address = (EditText) findViewById(R.id.et_address);
		button = (Button) findViewById(R.id.button_add);

		button.setOnClickListener(this);

		AppContext appContext = (AppContext) getApplicationContext();
		user = appContext.getUser();

	}

	@Override
	public void onClick(View v) {
		String name = et_name.getText().toString();
		String phone = et_phone.getText().toString();
		String province = et_province.getText().toString();
		String city = et_city.getText().toString();
		String area = et_area.getText().toString();
		String postcode = et_postcode.getText().toString();
		String address = et_address.getText().toString();
		String username = user.getUsername();

		if (name != null && phone != null && province != null && city != null
				&& area != null && postcode != null && address != null) {
			Address address2 = new Address();
			address2.setName(name);
			address2.setPhone(phone);
			address2.setProvince(province);
			address2.setCity(city);
			address2.setArea(area);
			address2.setPostcode(postcode);
			address2.setAddress(address);
			address2.setUsername(username);
			Intent data = new Intent();
			Bundle bundle = new Bundle();
			bundle.putParcelable("address", address2);
			data.putExtras(bundle);
			setResult(40, data);
			finish();
		}else{
			Toast.makeText(this, "亲，数据不能为空", Toast.LENGTH_SHORT).show();
		}

	}

}
