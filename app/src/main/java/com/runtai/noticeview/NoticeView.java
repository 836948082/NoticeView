package com.runtai.noticeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class NoticeView extends LinearLayout {

	private static final String TAG = "PUBLICNOTICEVIEW";
	private Context mContext;
	private ViewFlipper mViewFlipper;
	private View mScrollTitleView;

	public NoticeView(Context context) {
		super(context);
		mContext = context;
		init();
	}

	public NoticeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}

	private void init() {
		bindLinearLayout();
		bindNotices();
	}

	/**
	 * 初始化自定义的布局
	 */
	private void bindLinearLayout() {
		mScrollTitleView = LayoutInflater.from(mContext).inflate(R.layout.scrollnoticebar, null);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		addView(mScrollTitleView, params);
		mViewFlipper = (ViewFlipper) mScrollTitleView.findViewById(R.id.id_scrollNoticeTitle);
		mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_bottom));
		mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_top));
		mViewFlipper.startFlipping();
	}

	List<String> list;

	/**
	 * 网络请求内容后进行适配
	 */
	protected void bindNotices() {
		mViewFlipper.removeAllViews();

		list = new ArrayList<>();
		list.add("公告:恭喜您中了100W,赶紧去领取吧!");
		list.add("公告:恭喜您中了200W,赶紧去领取吧!");
		list.add("公告:恭喜您中了300W,赶紧去领取吧!");
		list.add("公告:恭喜您中了400W,赶紧去领取吧!");
		list.add("公告:恭喜您中了500W,赶紧去领取吧!");

		for (int i = 0; i < list.size(); i++) {
			final TextView textView = new TextView(mContext);
			textView.setText(list.get(i).toString());
			textView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(mContext, textView.getText().toString(), Toast.LENGTH_SHORT).show();
				}
			});
			LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			mViewFlipper.addView(textView, layoutParams);
		}
	}
}
