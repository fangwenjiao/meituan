package com.anjoyo.meituan.adapter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import com.anjoyo.meituan.R;
import com.anjoyo.meituan.domain.Seller;
import com.anjoyo.meituan.ui.MerchantDetailActivity;
import com.anjoyo.meituan.utils.SplitNetImagePath;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MerchantAllAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Seller> allList;
	private Intent intent;
	Bitmap pngBM;// 网络图片
	Bitmap[] bitmaps;

	public MerchantAllAdapter(Context context, ArrayList<Seller> allList) {
		this.context = context;
		this.allList = allList;
		System.out.println("allList.size()" + allList.size());

		intent = new Intent(context, MerchantDetailActivity.class);

		bitmaps = new Bitmap[allList.size()];
		ImageCache1 imageCache = new ImageCache1();
		imageCache.start();
		try {
			imageCache.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return allList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
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
			holderView.relativeLayout = (RelativeLayout) convertView
					.findViewById(R.id.rl_merchant_item);

			convertView.setTag(holderView);
		} else {
			holderView = (HolderView) convertView.getTag();
		}

		holderView.address_merchant.setText(allList.get(position)
				.getSeller_address());
		holderView.name_merchant
				.setText(allList.get(position).getSeller_name());
		if (allList.get(position).getSeller_isSale() == 0) {
			holderView.image_group.setImageResource(R.color.white);
		} else if (allList.get(position).getSeller_isSale() == 1) {
			holderView.image_group.setImageResource(R.drawable.ic_group);
		}

		holderView.image_merchant.setImageResource(R.drawable.test);
		holderView.ratingBar.setRating((float) 4.3);

		holderView.image_merchant.setImageBitmap(bitmaps[position]);

		final int getPosition = position;
		holderView.relativeLayout.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				intent.setAction("MerchantAll");
				intent.putExtra("allPosition", getPosition);
				context.startActivity(intent);
			}
		});
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
			for (int i = 0; i < allList.size(); i++) {
				String netPictruePath = allList.get(i).getSeller_picture();
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
