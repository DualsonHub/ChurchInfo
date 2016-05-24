package com.livingfaith.lfc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_OfflineStore_Grid extends ArrayAdapter<GridViewItem_2> {
    Context mContext;
    int resourceId;

    ArrayList<GridViewItem_2> data = new ArrayList<GridViewItem_2>();

    public Adapter_OfflineStore_Grid(Context context, int layoutResourceId, ArrayList<GridViewItem_2> data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.resourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder = null;

        if (itemView == null) {
            final LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(resourceId, parent, false);

            holder = new ViewHolder();
            holder.imgItem = (ImageView) itemView.findViewById(R.id.store_logo);
            holder.txtItem = (TextView) itemView.findViewById(R.id.store_name);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        GridViewItem_2 item = getItem(position);
        holder.imgItem.setImageDrawable(item.getImage());
        holder.txtItem.setText(item.getTitle());


        return itemView;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView txtItem;
    }

}