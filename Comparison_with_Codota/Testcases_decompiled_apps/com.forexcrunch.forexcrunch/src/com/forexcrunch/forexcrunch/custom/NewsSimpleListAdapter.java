package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.p000v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.model.Post;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NewsSimpleListAdapter extends ArrayAdapter<Post> {
    private int category;
    private Context context;
    private LayoutInflater inflater;
    private boolean isSavedArticles;
    private ArrayList<Post> items;
    private DisplayImageOptions options;
    private int resource;

    private class ViewHolder {
        public ImageView commentIcon;
        public TextView comments;
        public ImageView image;
        public ImageView msgReadImage;
        public TextView time;
        public TextView title;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(NewsSimpleListAdapter newsSimpleListAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    public NewsSimpleListAdapter(Context ctx, int resourceId, ArrayList<Post> objects, DisplayImageOptions options2, int category2) {
        super(ctx, resourceId, objects);
        this.resource = resourceId;
        this.inflater = LayoutInflater.from(ctx);
        this.context = ctx;
        this.items = objects;
        this.options = options2;
        this.isSavedArticles = false;
    }

    public NewsSimpleListAdapter(Context ctx, int resourceId, ArrayList<Post> objects, DisplayImageOptions options2, int category2, boolean isSavedArticles2) {
        super(ctx, resourceId, objects);
        this.resource = resourceId;
        this.inflater = LayoutInflater.from(ctx);
        this.context = ctx;
        this.items = objects;
        this.options = options2;
        this.isSavedArticles = isSavedArticles2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View view = convertView;
        if (convertView == null) {
            view = (RelativeLayout) this.inflater.inflate(this.resource, (ViewGroup) null);
            holder = new ViewHolder(this, (ViewHolder) null);
            holder.title = (TextView) view.findViewById(C0089R.C0090id.HomeNewsListItem_title);
            holder.time = (TextView) view.findViewById(C0089R.C0090id.HomeNewsListItem_time);
            holder.image = (ImageView) view.findViewById(C0089R.C0090id.HomeNewsListItem_image);
            holder.comments = (TextView) view.findViewById(C0089R.C0090id.HomeNewsListItem_comments);
            holder.msgReadImage = (ImageView) view.findViewById(C0089R.C0090id.HomeNewsListItem_msgReadImage);
            holder.commentIcon = (ImageView) view.findViewById(C0089R.C0090id.HomeNewsListItem_commentIcon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (this.items.get(position).getComments() == null || this.items.get(position).getComments().isEmpty()) {
            holder.comments.setVisibility(8);
            holder.commentIcon.setVisibility(8);
        } else {
            holder.comments.setText(Utils.insertZeroIfLessThanTen(this.items.get(position).getComments().size()));
            holder.comments.setVisibility(0);
            holder.commentIcon.setVisibility(0);
        }
        fillTitleInfo(position, holder);
        fillTimeInfo(position, holder);
        setImage(position, holder);
        if (!this.isSavedArticles) {
            checkArticle(this.items.get(position).getId(), holder);
        }
        return view;
    }

    private void checkArticle(int id, ViewHolder holder) {
        if (isReadArticle(id)) {
            holder.commentIcon.setImageResource(C0089R.drawable.disabled_comment);
            holder.msgReadImage.setVisibility(0);
            if (Build.VERSION.SDK_INT < 11) {
                holder.image.setAlpha(127);
            } else {
                holder.image.setAlpha(0.5f);
            }
            holder.title.setTextColor(this.context.getResources().getColor(C0089R.color.disabled_title));
            holder.time.setTextColor(this.context.getResources().getColor(C0089R.color.disabled_orange_time_label));
            holder.comments.setTextColor(this.context.getResources().getColor(C0089R.color.disabled_orange_time_label));
            return;
        }
        holder.commentIcon.setImageResource(C0089R.drawable.comentario);
        holder.msgReadImage.setVisibility(8);
        if (Build.VERSION.SDK_INT < 11) {
            holder.image.setAlpha(MotionEventCompat.ACTION_MASK);
        } else {
            holder.image.setAlpha(1.0f);
        }
        holder.title.setTextColor(this.context.getResources().getColor(17170444));
        holder.time.setTextColor(this.context.getResources().getColor(C0089R.color.orange_time_label));
        holder.comments.setTextColor(this.context.getResources().getColor(C0089R.color.orange_time_label));
    }

    private void setImage(int position, ViewHolder holder) {
        if (this.items.get(position).getThumbnail() == null || this.items.get(position).getThumbnail().equals("null")) {
            holder.image.setImageResource(C0089R.drawable.fotocarga);
        } else {
            Picasso.with(this.context).load(this.items.get(position).getThumbnail()).placeholder((int) C0089R.drawable.fotocarga).resize(getContext().getResources().getInteger(C0089R.integer.news_thumb_width), getContext().getResources().getInteger(C0089R.integer.news_thumb_height)).into(holder.image);
        }
    }

    private void fillTimeInfo(int position, ViewHolder holder) {
        String date = this.items.get(position).getDate();
        holder.time.setText(date.substring(0, date.length() - 3));
    }

    private void fillTitleInfo(int position, ViewHolder holder) {
        holder.title.setText(this.items.get(position).getTitle());
    }

    private boolean isReadArticle(int id) {
        String readMsgs = PreferenceManager.getDefaultSharedPreferences(this.context.getApplicationContext()).getString(new StringBuilder().append(this.category).toString(), "");
        if (!readMsgs.equals("")) {
            String[] ids = readMsgs.split(",");
            for (String valueOf : ids) {
                if (Integer.valueOf(valueOf).intValue() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Post> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Post> items2) {
        this.items = items2;
    }

    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList());

        private AnimateFirstDisplayListener() {
        }

        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                ((ImageView) view).setImageBitmap(GuiUtil.cropBitmap(view.getContext(), loadedImage, view.getContext().getResources().getInteger(C0089R.integer.news_thumb_width), view.getContext().getResources().getInteger(C0089R.integer.news_thumb_height)));
                displayedImages.add(imageUri);
            }
        }
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category2) {
        this.category = category2;
    }

    public int getCount() {
        return this.items.size();
    }
}
