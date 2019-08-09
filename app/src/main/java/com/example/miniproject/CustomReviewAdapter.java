package com.example.miniproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomReviewAdapter extends BaseAdapter {
    private List<Review> review;
    private LayoutInflater layoutInflater;
    private Context context;
    public CustomReviewAdapter(Context aContext, List<Review> review){
        this.context = aContext;
        this.review = review;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return review.size();
    }

    @Override
    public Object getItem(int i) {
        return review.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.custom_review, null);
            holder = new ViewHolder();
            holder.reviewIMG = (ImageView) view.findViewById(R.id.showImage);
            holder.overallRating = (TextView) view.findViewById(R.id.overallRating);
            holder.reviewDes = (TextView) view.findViewById(R.id.review_description);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Review item = this.review.get(i);
        if(item.getOverallRating() > 3.0){
            String overallrating = String.valueOf(item.getOverallRating());
            holder.overallRating.setText("Overall Rating: "+overallrating);
            holder.reviewDes.setText( "Review Date: " +item.getDate()+"\n"+"\n" + "Comment: " + item.getComment());

            int imageId = this.getMipmapResIdByName("positive");

            holder.reviewIMG.setImageResource(imageId);


        }
        if(item.getOverallRating() == 3.0){
            String overallrating = String.valueOf(item.getOverallRating());
            holder.overallRating.setText("Overall Rating: "+overallrating);
            holder.reviewDes.setText( "Review Date: " +item.getDate()+"\n"+"\n" + "Comment: " + item.getComment());

            int imageId = this.getMipmapResIdByName("neutral");

            holder.reviewIMG.setImageResource(imageId);
        }
        if(item.getOverallRating() < 3.0){

            String overallrating = String.valueOf(item.getOverallRating());
            holder.overallRating.setText("Overall Rating: "+overallrating);
            holder.reviewDes.setText( "Review Date: " +item.getDate()+"\n"+"\n" + "Comment: " + item.getComment());

            int imageId = this.getMipmapResIdByName("negative");

            holder.reviewIMG.setImageResource(imageId);
        }
        return view;
    }

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        return resID;
    }
    static class ViewHolder {
        ImageView reviewIMG;
        TextView overallRating;
        TextView reviewDes;
    }


}
