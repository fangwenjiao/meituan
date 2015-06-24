package com.anjoyo.meituan.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.Parser.AddressParser;
import com.anjoyo.meituan.adapter.AddressAdapter;
import com.anjoyo.meituan.app.AppContext;
import com.anjoyo.meituan.common.NetRequestConstant;
import com.anjoyo.meituan.common.NetUrlConstant;
import com.anjoyo.meituan.domain.Address;
import com.anjoyo.meituan.domain.User;
import com.anjoyo.meituan.interfaces.Netcallback;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AddressManageActivity extends BaseActivity implements
		OnClickListener, OnItemLongClickListener {
	private ImageView back, meituan;
	private ListView listview;
	private TextView nodata;
	private Button button_new;
	private List<Address> addresses = new ArrayList<Address>();
	private AddressAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.addressmanage_activity);
		super.onCreate(savedInstanceState);
	}

	@Override
	void init() {
		back = (ImageView) findViewById(R.id.imageview_back);
		meituan = (ImageView) findViewById(R.id.imageview_meituan);
		listview = (ListView) findViewById(R.id.listview_data);
		nodata = (TextView) findViewById(R.id.textview_nodata);
		button_new = (Button) findViewById(R.id.button_new);

		back.setOnClickListener(this);
		meituan.setOnClickListener(this);
		button_new.setOnClickListener(this);
		
		AppContext appContext = (AppContext) getApplicationContext();
		User user = appContext.getUser();
		String username = user.getUsername();
		
		listview.setOnItemLongClickListener(this);
		
		NetRequestConstant nrc = new NetRequestConstant();
		nrc.setType(HttpRequestType.POST);

		NetRequestConstant.requestUrl = NetUrlConstant.ADDRESSURL;
		NetRequestConstant.context = this;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		NetRequestConstant.map = map;
		getServer(new Netcallback() {
			
			@Override
			public void preccess(Object res, boolean flag) {
				if(res!=null){
					AddressParser parser = new AddressParser();
					addresses = parser.getAddress((String)res);
					if(addresses.size()>0){
						adapter = new AddressAdapter(AddressManageActivity.this, addresses);
						listview.setAdapter(adapter);
						nodata.setVisibility(View.GONE);
						listview.setVisibility(View.VISIBLE);
					}
				}
			}
		}, nrc);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.imageview_back:
		case R.id.imageview_meituan:
			finish();
			break;
		case R.id.button_new:
			startActivityForResult(new Intent(this, NewAddressActivity.class),
					40);
			break;
		default:
			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null) {
			if(adapter==null){
				adapter = new AddressAdapter(this, addresses);
			}
			Bundle bundle = data.getExtras();
			Address address = bundle.getParcelable("address");
			addresses.add(address);
			adapter.setData(addresses);
		}

	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int arg2,
			long arg3) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("确定删除吗");
		builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				addresses.remove(arg2);
				adapter.setData(addresses);
			}
		} );
		
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		builder.create();
		builder.show();
		return false;
	}
}
