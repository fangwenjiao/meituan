package com.anjoyo.meituan.adapter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.domain.Good;
import com.anjoyo.meituan.http.ThreadPool;
import com.anjoyo.meituan.ui.GroupBuyDetailsActivity;
import com.anjoyo.meituan.utils.Logger;
import com.anjoyo.meituan.utils.SplitNetImagePath;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MerchantGroupAdapter extends BaseAdapter {
 
	private  Context  context;
	private  List<Good>    detail_group;
	//private  String[]   strings;
	private  Bitmap[]   bitmaps;
	private HolderView  holderView=null;
	//private String netImagePath;
	
	public MerchantGroupAdapter(Context context,List<Good>  detail_group){
		this.context=context;
		this.detail_group=detail_group;
		bitmaps=new Bitmap[detail_group.size()];
		Thread  thread=new Thread(runnable);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return detail_group.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return detail_group.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			holderView = new HolderView();
			convertView=LayoutInflater.from(context).inflate(R.layout.merchant__details_group_item,null);
			holderView.ll_detail_group=(LinearLayout) convertView.findViewById(R.id.detail_group);
			holderView.goods_saleInfo=(TextView) convertView.findViewById(R.id.details_group_saleinfo);
			holderView.oldPrice=(TextView) convertView.findViewById(R.id.textview_goodoldprice);
			holderView.price=(TextView) convertView.findViewById(R.id.textview_goodprice);
			holderView.image=(ImageView) convertView.findViewById(R.id.details_group_image);
			
			convertView.setTag(holderView);
		}else{
	        holderView=(HolderView) convertView.getTag();
		}
		final int getPosition=position;
		holderView.ll_detail_group.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(context,GroupBuyDetailsActivity.class);
				intent.setAction("MerchantDetailActivity");
				intent.putExtra("Position",getPosition);
				context.startActivity(intent);
			}
		});
		
		
		holderView.goods_saleInfo.setText(detail_group.get(position).getGoods_saleInfo());
		holderView.price.setText(detail_group.get(position).getGoods_price()+"");
		holderView.oldPrice.setText(detail_group.get(position).getGoods_oldPrice()+"");
		holderView.oldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        //strings=SplitNetImagePath.splitNetImagePath(detail_group.get(position).getGoods_picturePath());
		
		holderView.image.setImageBitmap(bitmaps[position]);
		
		return convertView;
	}
	
	class  HolderView {
		private ImageView   image;
		private TextView    goods_saleInfo,price,oldPrice;
		private LinearLayout    ll_detail_group;
		
	}
	
	Runnable runnable = new Runnable() {
		public void run() {
			for(int i =0;i<detail_group.size();i++){
            String	netPictruePath	=detail_group.get(i).getGoods_picturePath();
            String[] strings=SplitNetImagePath.splitNetImagePath(netPictruePath);
            //显示第一张图片，为默认图片
            String pictruePath=strings[0];
			// 把网络地址转换为BitMap
			URL picUrl; 
			try {
				picUrl = new URL(pictruePath);
				bitmaps[i] = BitmapFactory.decodeStream(picUrl.openStream());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
	};


	
}
