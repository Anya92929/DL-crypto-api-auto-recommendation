package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.model.Comment;
import java.util.ArrayList;

public class CommentsListAdapter extends BaseExpandableListAdapter {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] GROUP_EXPANDED_STATE_SET = {16842920};
    private static final int[][] GROUP_STATE_SETS = {EMPTY_STATE_SET, GROUP_EXPANDED_STATE_SET};
    private Context context;
    private ArrayList<Comment> groups;

    public CommentsListAdapter(Context context2, ArrayList<Comment> groups2) {
        this.context = context2;
        this.groups = groups2;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return this.groups.get(groupPosition).getReplies().get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return (long) childPosition;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        Comment child = (Comment) getChild(groupPosition, childPosition);
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0089R.layout.reply_list_item, (ViewGroup) null);
        }
        fillCommentInfo(child, (TextView) view.findViewById(C0089R.idCommentListItem.title), (TextView) view.findViewById(C0089R.idCommentListItem.time), (TextView) view.findViewById(C0089R.idCommentListItem.content));
        return view;
    }

    public int getChildrenCount(int groupPosition) {
        return this.groups.get(groupPosition).getReplies().size();
    }

    public Object getGroup(int groupPosition) {
        return this.groups.get(groupPosition);
    }

    public int getGroupCount() {
        return this.groups.size();
    }

    public long getGroupId(int groupPosition) {
        return (long) groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent) {
        int stateSetIndex = 0;
        Comment group = (Comment) getGroup(groupPosition);
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0089R.layout.comment_list_item, (ViewGroup) null);
        }
        fillCommentInfo(group, (TextView) view.findViewById(C0089R.idCommentListItem.title), (TextView) view.findViewById(C0089R.idCommentListItem.time), (TextView) view.findViewById(C0089R.idCommentListItem.content));
        View ind = view.findViewById(C0089R.idCommentListItem.explist_indicator);
        if (ind != null) {
            ImageView indicator = (ImageView) ind;
            if (getChildrenCount(groupPosition) == 0) {
                indicator.setVisibility(4);
            } else {
                indicator.setVisibility(0);
                if (isLastChild) {
                    stateSetIndex = 1;
                }
                indicator.getDrawable().setState(GROUP_STATE_SETS[stateSetIndex]);
            }
        }
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }

    private void fillCommentInfo(Comment current, TextView title, TextView time, TextView content) {
        content.setText(GuiUtil.formatStringFromHtml(current.getContent()));
        time.setText(current.getDate());
        title.setText(current.getName());
    }
}
