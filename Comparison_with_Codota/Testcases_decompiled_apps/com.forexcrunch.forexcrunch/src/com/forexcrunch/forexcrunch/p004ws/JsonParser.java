package com.forexcrunch.forexcrunch.p004ws;

import android.content.Context;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.model.CalendarItem;
import com.forexcrunch.forexcrunch.model.Category;
import com.forexcrunch.forexcrunch.model.Comment;
import com.forexcrunch.forexcrunch.model.DateTime;
import com.forexcrunch.forexcrunch.model.HistTableModel;
import com.forexcrunch.forexcrunch.model.MarketImpactCalDetails;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.NewsCalDetails;
import com.forexcrunch.forexcrunch.model.NewsCalendarContent;
import com.forexcrunch.forexcrunch.model.Post;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.forexcrunch.forexcrunch.ws.JsonParser */
public class JsonParser {
    private static ArrayList<Post> getPostsFromJson(JSONArray jsonArray, Gson gson) throws JSONException {
        ArrayList<Post> postsList = null;
        if (!(jsonArray == null || jsonArray.length() == 0)) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Post post = (Post) gson.fromJson(jsonObject.toString(), Post.class);
                post.setTitle(GuiUtil.formatStringFromHtml(post.getTitle()));
                if (jsonObject.has("categories")) {
                    ArrayList<Category> categories = new ArrayList<>();
                    JSONArray categoriesJSONArray = jsonObject.getJSONArray("categories");
                    for (int j = 0; j < categoriesJSONArray.length(); j++) {
                        categories.add((Category) gson.fromJson(categoriesJSONArray.get(j).toString(), Category.class));
                    }
                    post.setCategories(categories);
                }
                if (postsList == null) {
                    postsList = new ArrayList<>();
                }
                postsList.add(post);
            }
        }
        return postsList;
    }

    public static Post getPostFromJson(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        Gson gson = new Gson();
        if (jsonObject.has("post")) {
            return (Post) gson.fromJson(jsonObject.getJSONObject("post").toString(), Post.class);
        }
        return null;
    }

    public static News getNewsListFromJson(String response, Context context) throws JSONException {
        return createNewsFromJson(new JSONObject(response), context, false);
    }

    private static News createNewsFromJson(JSONObject jsonObject, Context context, boolean isDetails) throws JsonSyntaxException, JSONException {
        Gson gson = new Gson();
        Category category = null;
        ArrayList<Post> posts = null;
        if (jsonObject.has("category")) {
            category = (Category) gson.fromJson(jsonObject.get("category").toString(), Category.class);
        }
        if (jsonObject.has("posts")) {
            posts = getPostsFromJson(jsonObject.getJSONArray("posts"), gson);
        }
        if (jsonObject.has("comments")) {
            ArrayList<Comment> comments = getCommentsFromJson(jsonObject.getJSONArray("comments"), gson);
        }
        News news = new News("", 0, 0, category, posts);
        setCommentReplies(news);
        return news;
    }

    private static void setCommentReplies(News news) {
        Iterator<Post> it = news.getPostsList().iterator();
        while (it.hasNext()) {
            Post currentPost = it.next();
            if (currentPost.getComments() != null && !currentPost.getComments().isEmpty()) {
                Iterator<Comment> it2 = currentPost.getComments().iterator();
                while (it2.hasNext()) {
                    Comment commentParent = it2.next();
                    Iterator<Comment> it3 = currentPost.getComments().iterator();
                    while (it3.hasNext()) {
                        Comment commentChild = it3.next();
                        if (!commentChild.equals(commentParent) && commentChild.getParent() == commentParent.getId()) {
                            commentParent.getReplies().add(commentChild);
                            Iterator<Comment> it4 = currentPost.getComments().iterator();
                            while (it4.hasNext()) {
                                Comment commentGrandChild = it4.next();
                                if (!commentGrandChild.equals(commentParent) && !commentGrandChild.equals(commentChild) && commentGrandChild.getParent() == commentChild.getId()) {
                                    commentParent.getReplies().add(commentGrandChild);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static ArrayList<Comment> getCommentsFromJson(JSONArray jsonArray, Gson gson) throws JSONException {
        ArrayList<Comment> commentList = null;
        if (!(jsonArray == null || jsonArray.length() == 0)) {
            for (int i = 0; i < jsonArray.length(); i++) {
                Comment comment = (Comment) gson.fromJson(jsonArray.getJSONObject(i).toString(), Comment.class);
                if (commentList == null) {
                    commentList = new ArrayList<>();
                }
                commentList.add(comment);
            }
        }
        return commentList;
    }

    public static ArrayList<CalendarItem> getCalendarFromJson(String response, Context context) throws JSONException {
        JSONArray jsonCalendarArray = new JSONArray(response);
        Gson gson = new Gson();
        ArrayList<CalendarItem> calendarList = new ArrayList<>();
        if (!(jsonCalendarArray == null || jsonCalendarArray.length() == 0)) {
            for (int i = 0; i < jsonCalendarArray.length(); i++) {
                CalendarItem item = (CalendarItem) gson.fromJson(jsonCalendarArray.get(i).toString(), CalendarItem.class);
                if (jsonCalendarArray.getJSONObject(i).has("DateTime")) {
                    item.setDateTime((DateTime) gson.fromJson(jsonCalendarArray.getJSONObject(i).getJSONObject("DateTime").toString(), DateTime.class));
                }
                calendarList.add(item);
            }
        }
        return calendarList;
    }

    public static ArrayList<NewsCalDetails> getNewsCalDetailsFromJson(String response, Context context) throws JSONException {
        JSONArray jsonNewsCalDetailsArray = new JSONArray(response);
        Gson gson = new Gson();
        ArrayList<NewsCalDetails> newsCalDetailsList = new ArrayList<>();
        for (int i = 0; i < jsonNewsCalDetailsArray.length(); i++) {
            NewsCalDetails newsCalDetails = (NewsCalDetails) gson.fromJson(jsonNewsCalDetailsArray.get(i).toString(), NewsCalDetails.class);
            if (jsonNewsCalDetailsArray.getJSONObject(i).has("DateTime")) {
                newsCalDetails.setDateTime((DateTime) gson.fromJson(jsonNewsCalDetailsArray.getJSONObject(i).get("DateTime").toString(), DateTime.class));
                newsCalDetailsList.add(newsCalDetails);
            }
        }
        return newsCalDetailsList;
    }

    public static ArrayList<HistTableModel> getHistoryCalDetailsFromJson(String response, Context context) throws JSONException {
        JSONArray jsonHistoryCalDetailsArray = new JSONArray(response);
        Gson gson = new Gson();
        ArrayList<HistTableModel> historyCalDetailsList = new ArrayList<>();
        for (int i = 0; i < jsonHistoryCalDetailsArray.length(); i++) {
            HistTableModel historyCalDetails = (HistTableModel) gson.fromJson(jsonHistoryCalDetailsArray.get(i).toString(), HistTableModel.class);
            if (jsonHistoryCalDetailsArray.getJSONObject(i).has("DateTime")) {
                historyCalDetails.setDateTime((DateTime) gson.fromJson(jsonHistoryCalDetailsArray.getJSONObject(i).get("DateTime").toString(), DateTime.class));
                historyCalDetailsList.add(historyCalDetails);
            }
        }
        return historyCalDetailsList;
    }

    public static MarketImpactCalDetails getMarketImpactsCalDetailsFromJson(String response, Context context) throws JSONException {
        JSONObject jsonMarketImpacts = new JSONObject(response);
        Gson gson = new Gson();
        MarketImpactCalDetails marketDetails = (MarketImpactCalDetails) gson.fromJson(jsonMarketImpacts.toString(), MarketImpactCalDetails.class);
        if (jsonMarketImpacts.has("DateTime")) {
            marketDetails.setDateTime((DateTime) gson.fromJson(jsonMarketImpacts.get("DateTime").toString(), DateTime.class));
        }
        return marketDetails;
    }

    public static NewsCalendarContent getNewsCalendarContentFromJSON(String response) throws JSONException {
        return (NewsCalendarContent) new Gson().fromJson(new JSONObject(response).toString(), NewsCalendarContent.class);
    }
}
