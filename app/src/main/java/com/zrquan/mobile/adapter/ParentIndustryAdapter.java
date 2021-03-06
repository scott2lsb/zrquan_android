package com.zrquan.mobile.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zrquan.mobile.R;
import com.zrquan.mobile.model.Industry;

import java.util.List;

public class ParentIndustryAdapter extends BaseAdapter{
    private Context context;
    private List<Industry> list;
    private int mCurrentPosition;

    public int getCurrentPosition() {
        return mCurrentPosition;
    }

    public void setCurrentPosition(int mCurrentPosition) {
        this.mCurrentPosition = mCurrentPosition;
    }

    public ParentIndustryAdapter(Context context, List<Industry> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (this.list != null)
            return this.list.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (position < this.list.size())
            return this.list.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0L;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder tvHolder;
        if(convertView == null) {
            // http://stackoverflow.com/questions/9439401/set-listview-item-height
            // set attachToRoot to false to avoid java.lang.UnsupportedOperationException:
            // addView(View, LayoutParams) is not supported in AdapterView
            convertView =  LayoutInflater.from(context).inflate(R.layout.list_picker_item, parent, false);
            tvHolder = new ViewHolder();
            tvHolder.textView = (TextView)convertView.findViewById(R.id.list_picker_item_content);
            convertView.setTag(tvHolder);
        }else {
            // 使用缓存的view http://blog.csdn.net/li_wen_qi_/article/details/8539521
            tvHolder = (ViewHolder) convertView.getTag();
        }

        if(position == mCurrentPosition) {
            tvHolder.textView.setBackgroundColor(Color.WHITE);
        } else {
            tvHolder.textView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_cascade_picker_level1));
        }

        Industry industry = this.list.get(position);
        tvHolder.textView.setText(industry.getName());

        return convertView;
    }

    private class ViewHolder {
        TextView textView;
    }
}
