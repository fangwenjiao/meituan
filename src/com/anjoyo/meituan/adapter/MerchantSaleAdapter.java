package com.anjoyo.meituan.adapter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import com.anjoyo.meituan.R;
import com.anjoyo.meituan.domain.Seller;
import com.anjoyo.meituan.ui.MerchantDetailActivity;
import com.anjoyo.meituan.utils.Logger;
import com.anjoyo.meituan.utils.SplitNetImagePath;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MerchantSaleAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Seller> saleList;
	private Intent intent;
	Bitmap pngBM;// 网络图片
	Bitmap[] bitmaps;

	public MerchantSaleAdapter(Context context, ArrayList<Seller> saleList) {
		this.context = context;
		this.saleList = saleList;
		Logger.i("---------SaleList.size():"+this.saleList.size());
		intent = new Intent(context, MerchantDetailActivity.class);
		bitmaps = new Bitmap[this.saleList.size()];
		ImageCache1 imageCache = new ImageCache1();
		imageCache.start();
	}

	public int getCount() {
		// TODO Auto-generated method stub
	
		return saleList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return saleList.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		HolderView holderView = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.merchant_listitem, null);
			holderView = new HolderView();
			holderView.address_merchant = (TextView) convertView
					.findViewById(R.id.address_merchant);
			holderView.name_merchant = (TextView) convertView
					.findViewById(R.id.name_merchant);
			holderView.distance_merchant = (TextView) convertView
					.findViewById(R.id.distance_merchant);
			holderView.image_merchant = (ImageView) convertView
					.findViewById(R.id.image_merchant);
			holderView.image_group = (ImageView) convertView
					.findViewById(R.id.image_group);
			holderView.ratingBar = (RatingBar) convertView
					.findViewById(R.id.ratingBar1);

			convertView.setTag(holderView);
		} else {
			holderView = (HolderView) convertView.getTag();

		}

		holderView.address_merchant.setText(saleList.get(position)
				.getSeller_address());
		// holderView.distance_merchant.setText(saleList.get(position).getSeller_distance());
		holderView.name_merchant.setText(saleList.get(position)
				.getSeller_name());
		holderView.relativeLayout = (RelativeLayout) convertView
				.findViewById(R.id.rl_merchant_item);
		if (saleList.get(position).getSeller_isSale() == 0) {
			holderView.image_group.setImageResource(R.color.white);
		} else if (saleList.get(position).getSeller_isSale() == 1) {
			holderView.image_group.setImageResource(R.drawable.ic_group);
		}

		final int getPosition = position;
		holderView.relativeLayout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intent.setAction("MerchantSale");
				intent.putExtra("salePosition", getPosition);
				context.startActivity(intent);
			}
		});

		holderView.image_merchant.setImageResource(R.drawable.test);
		holderView.ratingBar.setRating((float) 4.3);
		
		holderView.image_merchant.setImageBitmap(bitmaps[position]);
		return convertView;
	}

	class HolderView {

		private ImageView image_merchant, image_group;
		private TextView name_merchant, address_merchant, distance_merchant;
		private RatingBar ratingBar;
		private RelativeLayout relativeLayout;
	}

	class ImageCache1 extends Thread {

		public void run() {
			for (int i = 0; i < saleList.size(); i++) {
				String netPictruePath = saleList.get(i).getSeller_picture();
				String[] strings = SplitNetImagePath
						.splitNetImagePath(netPictruePath);
				// 显示第一张图片，为默认图片
				String pictruePath = strings[0];
				// 把网络地址转换为BitMap
				URL picUrl;
				try {
					picUrl = new URL(pictruePath);
					pngBM = BitmapFactory.decodeStream(picUrl.openStream());
					bitmaps[i] = pngBM;
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
