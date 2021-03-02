package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class NewsWithHeaderListAdapter extends BaseAdapter {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private int category;
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Post> items;
    private DisplayImageOptions options;
    private int resource;

    private class ViewHolder {
        /* access modifiers changed from: private */
        public ImageView commentIcon;
        /* access modifiers changed from: private */
        public TextView comments;
        /* access modifiers changed from: private */
        public ImageView image;
        /* access modifiers changed from: private */
        public ImageView msgReadImage;
        /* access modifiers changed from: private */
        public TextView tvNewsContent;
        /* access modifiers changed from: private */
        public TextView tvTime;
        /* access modifiers changed from: private */
        public TextView tvTitle;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(NewsWithHeaderListAdapter newsWithHeaderListAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    public NewsWithHeaderListAdapter(Context ctx, int resourceId, ArrayList<Post> objects, DisplayImageOptions options2, int category2) {
        this.resource = resourceId;
        this.inflater = (LayoutInflater) ctx.getSystemService("layout_inflater");
        this.context = ctx;
        this.items = objects;
        this.options = options2;
    }

    public int getItemViewType(int position) {
        return position > 0 ? 1 : 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View view = convertView;
        int type = getItemViewType(position);
        if (convertView == null) {
            TextView tvNewsContent = null;
            ImageView image = null;
            ImageView msgReadImage = null;
            if (type == 0) {
                view = (LinearLayout) this.inflater.inflate(C0089R.layout.news_header_list_item, (ViewGroup) null);
                tvNewsContent = (TextView) view.findViewById(C0089R.C0090id.HomeNewsListItem_tvNewsContent);
            } else {
                view = (RelativeLayout) this.inflater.inflate(this.resource, (ViewGroup) null);
                image = (ImageView) view.findViewById(C0089R.C0090id.HomeNewsListItem_image);
                msgReadImage = (ImageView) view.findViewById(C0089R.C0090id.HomeNewsListItem_msgReadImage);
            }
            holder = new ViewHolder(this, (ViewHolder) null);
            holder.tvTitle = (TextView) view.findViewById(C0089R.C0090id.HomeNewsListItem_title);
            holder.tvTime = (TextView) view.findViewById(C0089R.C0090id.HomeNewsListItem_time);
            holder.image = image;
            holder.comments = (TextView) view.findViewById(C0089R.C0090id.HomeNewsListItem_comments);
            holder.msgReadImage = msgReadImage;
            holder.commentIcon = (ImageView) view.findViewById(C0089R.C0090id.HomeNewsListItem_commentIcon);
            holder.tvNewsContent = tvNewsContent;
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        fillCommonFields(position, holder);
        if (position > 0) {
            if (holder.image != null) {
                Picasso.with(this.context).load(this.items.get(position).getThumbnail()).placeholder((int) C0089R.drawable.fotocarga).resize(view.getContext().getResources().getInteger(C0089R.integer.news_thumb_width), view.getContext().getResources().getInteger(C0089R.integer.news_thumb_height)).into(holder.image);
            }
            checkArticle(this.items.get(position).getId(), holder);
        } else {
            holder.tvNewsContent.setText(this.items.get(position).getFormattedContent());
        }
        return view;
    }

    private void fillCommonFields(int position, ViewHolder holder) {
        holder.tvTitle.setText(this.items.get(position).getTitle());
        String date = this.items.get(position).getDate();
        holder.tvTime.setText(date.substring(0, date.length() - 3));
        if (this.items.get(position).getComments() == null || this.items.get(position).getComments().isEmpty()) {
            holder.commentIcon.setVisibility(8);
            holder.comments.setVisibility(8);
            return;
        }
        holder.comments.setText(Utils.insertZeroIfLessThanTen(this.items.get(position).getComments().size()));
        holder.commentIcon.setVisibility(0);
        holder.comments.setVisibility(0);
    }

    public ArrayList<Post> getItems() {
        return this.items;
    }

    public int getCount() {
        return this.items.size();
    }

    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList());

        private AnimateFirstDisplayListener() {
        }

        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                Bitmap bitmap = GuiUtil.cropBitmap(view.getContext(), loadedImage, view.getContext().getResources().getInteger(C0089R.integer.news_thumb_width), view.getContext().getResources().getInteger(C0089R.integer.news_thumb_height));
                ImageView imageView = (ImageView) view;
                imageView.setDrawingCacheQuality(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                imageView.setImageBitmap(bitmap);
                displayedImages.add(imageUri);
            }
        }
    }

    private void checkArticle(int id, ViewHolder holder) {
        if (isReadArticle(id)) {
            holder.commentIcon.setImageResource(C0089R.drawable.disabled_comment);
            holder.msgReadImage.setVisibility(0);
            holder.tvTitle.setTextColor(this.context.getResources().getColor(C0089R.color.disabled_title));
            holder.tvTime.setTextColor(this.context.getResources().getColor(C0089R.color.disabled_orange_time_label));
            holder.comments.setTextColor(this.context.getResources().getColor(C0089R.color.disabled_orange_time_label));
            if (Build.VERSION.SDK_INT < 11) {
                holder.image.setAlpha(127);
            } else {
                holder.image.setAlpha(0.5f);
            }
        } else {
            holder.commentIcon.setImageResource(C0089R.drawable.comentario);
            holder.msgReadImage.setVisibility(8);
            holder.tvTitle.setTextColor(this.context.getResources().getColor(17170444));
            holder.tvTime.setTextColor(this.context.getResources().getColor(C0089R.color.orange_time_label));
            holder.comments.setTextColor(this.context.getResources().getColor(C0089R.color.orange_time_label));
            if (Build.VERSION.SDK_INT < 11) {
                holder.image.setAlpha(MotionEventCompat.ACTION_MASK);
            } else {
                holder.image.setAlpha(1.0f);
            }
        }
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

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category2) {
        this.category = category2;
    }

    public Object getItem(int pos) {
        return this.items.get(pos);
    }

    public long getItemId(int pos) {
        return (long) pos;
    }

    public void setItems(ArrayList<Post> postsList) {
        this.items = postsList;
    }
}
