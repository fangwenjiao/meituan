package com.anjoyo.meituan.ui;

import com.anjoyo.meituan.R;
import com.anjoyo.meituan.adapter.MoreClassifyAdapter;
import com.anjoyo.meituan.myview.MyGridView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MoreClassifyActivity extends Activity {
	private ImageView back;
	private MyGridView myGridView_food, myGridView_wineshop,
			myGridView_entertainment, myGridView_lifeservice,
			myGridView_beautifulwomen, myGridView_travel, myGridView_shop,
			myGridView_draw;
	private String[] strs_food = new String[] { "全部", "火锅", "自助餐", "西餐",
			"日韩料理", "蛋糕甜点", "烧烤烤鱼", "川湘菜", "江浙菜", "粤菜", "西北/东北菜", "京菜/鲁菜",
			"云贵菜", "素食", "清真菜", "东南亚菜", "台湾菜", "海鲜", "小吃快餐", "特色菜", "汤/粥/炖菜",
			"咖啡酒吧", "蒙餐", "新疆菜", "其他美食" };
	private String[] strs_wineshop = new String[] { "全部", "经济酒店", "豪华酒店" };
	private String[] strs_entertainment = new String[] { "全部", "电影", "KTV",
			"温泉", "洗浴/汗蒸", "足疗按摩", "运动健身", "滑雪", "桌游/电玩", "密室逃脱", "咖啡酒吧",
			"演出赛事", "DIY手工", "真人CS", "4D/5D电影", "其他娱乐" };
	private String[] strs_lifeservice = new String[] { "母婴亲子", "摄影写真", "体检保健",
			"汽车服务", "照片冲印", "培训课程", "鲜花婚庆", "服饰服务", "配镜", "商场购物卡", "其他生活" };
	private String[] strs_beautifulwomen = new String[] { "美发", "美甲", "美容SPA",
			"瑜伽/舞蹈" };
	private String[] strs_travel = new String[] { "全部", "本地/周边游", "景点门票",
			"国内/境外游" };
	private String[] strs_shop = new String[] { "全部", "服装鞋帽", "家居日用", "食品饮料",
			"箱包", "母婴用品", "个护化妆", "数码家电", "钟表首饰", "户外用品", "图书音像", "本地购物",
			"其他购物" };
	private String[] strs_draw = new String[] { "全部", "美梦成真", "霸王餐" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moreclassify_activity);
		init();

	}

	private void init() {
		myGridView_food = (MyGridView) findViewById(R.id.mygridview_food);
		myGridView_wineshop = (MyGridView) findViewById(R.id.mygridview_wineshop);
		myGridView_entertainment = (MyGridView) findViewById(R.id.mygridview_entertainment);
		myGridView_lifeservice = (MyGridView) findViewById(R.id.mygridview_lifeservice);
		myGridView_beautifulwomen = (MyGridView) findViewById(R.id.mygridview_beautifulwomen);
		myGridView_travel = (MyGridView) findViewById(R.id.mygridview_travel);
		myGridView_shop = (MyGridView) findViewById(R.id.mygridview_shop);
		myGridView_draw = (MyGridView) findViewById(R.id.mygridview_draw);
		back = (ImageView) findViewById(R.id.imageview_moreclassifyback);

		myGridView_food.setAdapter(new MoreClassifyAdapter(this, strs_food));
		myGridView_wineshop.setAdapter(new MoreClassifyAdapter(this,
				strs_wineshop));

		myGridView_entertainment.setAdapter(new MoreClassifyAdapter(this,
				strs_entertainment));
		myGridView_lifeservice.setAdapter(new MoreClassifyAdapter(this,
				strs_lifeservice));
		myGridView_beautifulwomen.setAdapter(new MoreClassifyAdapter(this,
				strs_beautifulwomen));
		myGridView_travel
				.setAdapter(new MoreClassifyAdapter(this, strs_travel));
		myGridView_shop.setAdapter(new MoreClassifyAdapter(this, strs_shop));
		myGridView_draw.setAdapter(new MoreClassifyAdapter(this, strs_draw));

		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				finish();
			}
		});

	}

}
