package com.anjoyo.meituan.adapter;

import com.anjoyo.meituan.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class MerchantCommentAdapter extends BaseAdapter {
private Context context;
private String[]  content;

	public MerchantCommentAdapter(Context context,String[] content){
		this.context=context;
		this.content=content;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return content.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return content[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		HolderView  holderView=null;
		if(convertView==null){
			holderView=new HolderView();
			convertView=LayoutInflater.from(context).inflate(R.layout.merchant__details_comment_item,null);
			holderView.comment_content=(TextView) convertView.findViewById(R.id.commemt_content);
			holderView.ratingBar=(RatingBar) convertView.findViewById(R.id.ratingBar1);
			convertView.setTag(holderView);
			
		}else{
			holderView=(HolderView) convertView.getTag();
			
		}
		holderView.comment_content.setText(content[position]);
		holderView.ratingBar.setNumStars(5);
		return convertView;
	}
	
	class  HolderView  {
		private TextView    comment_content;
		private RatingBar   ratingBar;
	}

}
