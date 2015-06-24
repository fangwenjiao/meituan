package com.anjoyo.meituan.adapter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.ui.GroupBuyDetailsActivity;

public class GroupBuyDetailsViewPAgerAdapter extends PagerAdapter {
	private String[] strings ;
	private Context context;
	private String goods_name;
	private String goods_saleInfo;
	Bitmap[] bitmaps ;
	
	public GroupBuyDetailsViewPAgerAdapter(Context context,String[] strings,String goods_name,String goods_saleInfo) {
		this.context = context;
		this.strings = strings;
		this.goods_name=goods_name;
		this.goods_saleInfo=goods_saleInfo;
		
		bitmaps=new Bitmap[strings.length];
		NetPathToBitmap run=new NetPathToBitmap();
		run.start();
		//阻塞主线程，使NetPathToBitmap线程先执行完
		try {
			run.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getCount() {
		return strings.length;
	}
	
	/**
	 * arg0 当前显示的View 
	 * arg1 将要加载的View
	 * 
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	/**
	 *  销毁拖过去的view
	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	/**
	 * 初始化将要加载的View
	 */
	public Object instantiateItem(ViewGroup container, int position) {
		
		View view = LayoutInflater.from(context).inflate(R.layout.groupbuy_image_details_item, null);
		TextView textView_groupbuy_name=(TextView) view.findViewById(R.id.textView_groupbuy_name);
		textView_groupbuy_name.setText(goods_name);
		TextView textView_groupbuy_content=(TextView) view.findViewById(R.id.textView_groupbuy_content);
		textView_groupbuy_content.setText(goods_saleInfo);
		ImageView imageView =(ImageView) view.findViewById(R.id.imageView_groupbuy_image_details);
		imageView.setImageBitmap(bitmaps[position]);
		imageView.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				Intent intent=new Intent(context,GroupBuyDetailsActivity.class);
				intent.setAction("GroupBuyDetailsViewPAger");
				intent.putExtra("netImagePath", strings[0]);
				context.startActivity(intent);
			}
		});
		container.addView(view);
		
		return view;
	}
	
	class NetPathToBitmap extends Thread{
		
		public void run() {
			for(int i=0;i<strings.length;i++){
				String netImagePath=strings[i];
				URL picUrl;
				try {
					picUrl = new URL(netImagePath);
					Bitmap pngBM = BitmapFactory.decodeStream(picUrl.openStream());
					bitmaps[i]=pngBM;
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
