package com.example.miniproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Establishment> est;
    private LayoutInflater layoutInflater;
    private Context context;
    public CustomListAdapter(Context aContext, List<Establishment> est){
        this.context = aContext;
        this.est = est;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return est.size();
    }

    @Override
    public Object getItem(int i) {
        return est.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_item, null);
            holder = new ViewHolder();
            holder.estImage = (ImageView) convertView.findViewById(R.id.showImage);
            holder.estNAME = (TextView) convertView.findViewById(R.id.est_name);
            holder.estDes = (TextView) convertView.findViewById(R.id.est_description);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Establishment est = this.est.get(position);
        holder.estNAME.setText(est.getEstName());
        holder.estDes.setText( "Type: " + est.getEstType() +"\n" +"Food: " + est.getFoodType() + "\n" +"Location: "+ est.getLocation());

        int imageId = this.getMipmapResIdByName(est.getImageURL());

        holder.estImage.setImageResource(imageId);

        return convertView;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        return resID;
    }
    static class ViewHolder {
        ImageView estImage;
        TextView estNAME;
        TextView estDes;
    }
}
