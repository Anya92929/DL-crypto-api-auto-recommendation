package com.forexcrunch.forexcrunch.p004ws;

import android.content.Context;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.http.RequestMethod;
import com.forexcrunch.forexcrunch.http.RestClient;
import com.forexcrunch.forexcrunch.model.CalendarItem;
import com.forexcrunch.forexcrunch.model.FilterModel;
import com.forexcrunch.forexcrunch.model.HistTableModel;
import com.forexcrunch.forexcrunch.model.MarketImpactCalDetails;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.NewsCalDetails;
import com.forexcrunch.forexcrunch.model.NewsCalendarContent;
import com.forexcrunch.forexcrunch.model.Post;
import com.google.ads.AdActivity;
import com.google.analytics.tracking.android.ModelFields;
import com.parse.ParseFacebookUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.joda.time.LocalDate;

/* renamed from: com.forexcrunch.forexcrunch.ws.WSController */
public class WSController {
    private static final String FORMAT = "json";
    private static final String FXCALENDAR_URL = "http://calendar.fxstreet.com/eventdate/";
    private static final String HISTORY_CALENDAR_DETAILS = "http://calendar.fxstreet.com/eventdate/*/history/";
    private static final String LATEST_NEWS_URL = "http://www.forexcrunch.com/api/get_recent_posts/";
    private static final String LISTNAME_PARAM = "forexcrunch";
    private static final String MARKET_IMPACT_CALENDAR_DETAILS = "http://calendar.fxstreet.com/eventdate/*/olsen/";
    private static final String NEWS_CALENDAR_DETAILS = "http://calendar.fxstreet.com/eventdate/*/news/";
    private static final String NEWS_CALENDAR_DETAILS_WITH_TEXT = "http://calendar.fxstreet.com/news/*/";
    private static final String NEWS_URL = "http://www.forexcrunch.com/api/get_category_posts/";
    private static final String PRIVATE_KEY = "676DDF2C29824CAF87B8B90FB9F93E";
    private static final String PUBLIC_KEY = "43326FB571BC4B9EAC6A";
    private static final String SEARCH_URL = "http://www.forexcrunch.com/api/get_search_results/";
    private static final String SUBSCRIBE_URL = "http://www.aweber.com/scripts/addlead.pl";
    private static final String TIMEZONE = "Central+Europe+Standard+Time";

    public static ArrayList<CalendarItem> getCalendarFromJson(Context context, String view) throws Exception {
        return requestCalendar(context, view);
    }

    public static News getNewsFromJson(Context context, int id) throws Exception {
        return requestNews(context, id);
    }

    public static News requestSearch(Context context, String searchFor) throws Exception {
        return requestNewsSearch(context, searchFor);
    }

    public static News getNewsFromJson(Context context, int id, int count) throws Exception {
        return requestNews(context, id, count);
    }

    public static News getMoreNewsFromJson(Context context, int id, int page) throws Exception {
        return requestMoreNews(context, id, page);
    }

    public static News getLatestNewsFromJson(Context context) throws Exception {
        return requestLatestNews(context);
    }

    public static ArrayList<NewsCalDetails> getNewsCalendarDetails(Context context, String id) throws Exception {
        return requestNewsCalendarDetails(context, id);
    }

    public static ArrayList<HistTableModel> getHistoryCalendarDetails(Context context, String id) throws Exception {
        return requestHistoryCalendarDetails(context, id);
    }

    public static MarketImpactCalDetails getMarketImpactCalendarDetails(Context context, String id) throws Exception {
        return requestMarketImpactCalendarDetails(context, id);
    }

    public static boolean requestSubscription(Context context, String email) throws Exception {
        return performSubscription(context, email);
    }

    private static ArrayList<CalendarItem> requestCalendar(Context context, String view) throws Exception {
        RestClient restClient = new RestClient(FXCALENDAR_URL);
        setDefaultParameters(restClient);
        FilterModel filterModel = Utils.getFilterModelFromPrefs(context);
        if (filterModel != null) {
            applyFilters(filterModel, restClient);
        } else {
            restClient.addParam("countrycode", Utils.getDefaultCountryCodes());
        }
        if (view.equals(CalendarItem.TOMORROW)) {
            setTomorrowViewAndDateParameters(restClient);
        } else if (view.equals(CalendarItem.NEXT_WEEK)) {
            setNextWeekViewAndDateParam(restClient);
        } else if (view.equals(CalendarItem.CUSTOM)) {
            setCustomViewAndDateParam(filterModel, restClient);
        } else {
            restClient.addParam("view", view);
        }
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        return JsonParser.getCalendarFromJson(restClient.getResponse(), context);
    }

    private static void setDefaultParameters(RestClient restClient) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String time = GuiUtil.getDateTime();
        String hashedKey = GuiUtil.sha1Hash(PRIVATE_KEY + time);
        restClient.addParam("timezone", TIMEZONE);
        restClient.addParam(AdActivity.INTENT_FLAGS_PARAM, FORMAT);
        restClient.addParam("k", PUBLIC_KEY);
        restClient.addParam("s", hashedKey);
        restClient.addParam("t", time);
    }

    private static void setCustomViewAndDateParam(FilterModel filterModel, RestClient restClient) {
        if (filterModel.getStartDate().equals("")) {
            restClient.addParam("view", CalendarItem.CURRENT);
            return;
        }
        restClient.addParam("view", CalendarItem.CUSTOM);
        restClient.addParam("start", filterModel.getStartDate());
        restClient.addParam("end", filterModel.getEndDate());
    }

    private static void setNextWeekViewAndDateParam(RestClient restClient) {
        LocalDate now = new LocalDate();
        String start = now.plusWeeks(1).withDayOfWeek(1).toString().replace("-", "");
        String end = now.plusWeeks(1).withDayOfWeek(7).toString().replace("-", "");
        restClient.addParam("view", CalendarItem.CUSTOM);
        restClient.addParam("start", start);
        restClient.addParam("end", end);
    }

    private static void setTomorrowViewAndDateParameters(RestClient restClient) {
        LocalDate now = new LocalDate();
        String start = now.plusDays(1).toString().replace("-", "");
        String end = now.plusDays(1).toString().replace("-", "");
        restClient.addParam("view", CalendarItem.CUSTOM);
        restClient.addParam("start", start);
        restClient.addParam("end", end);
    }

    private static void applyFilters(FilterModel filterModel, RestClient restClient) {
        restClient.addParam("volatility", new StringBuilder().append(filterModel.getVolatility()).toString());
        if (!filterModel.getCategories().equals("")) {
            restClient.addParam("categories", filterModel.getCategories());
        }
        if (filterModel.getCountries().equals("")) {
            restClient.addParam("countrycode", Utils.getDefaultCountryCodes());
        } else {
            restClient.addParam("countrycode", filterModel.getCountries());
        }
    }

    private static News requestNews(Context context, int id) throws Exception {
        RestClient restClient = new RestClient(NEWS_URL);
        restClient.addParam("id", Integer.toString(id));
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        News news = JsonParser.getNewsListFromJson(restClient.getResponse(), context);
        formatNewsContent(news);
        return news;
    }

    private static News requestNewsSearch(Context context, String searchFor) throws Exception {
        RestClient restClient = new RestClient(SEARCH_URL);
        restClient.addParam("search", searchFor);
        restClient.addParam("count", "30");
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        News news = JsonParser.getNewsListFromJson(restClient.getResponse(), context);
        formatNewsContent(news);
        return news;
    }

    private static News requestNews(Context context, int id, int count) throws Exception {
        RestClient restClient = new RestClient(NEWS_URL);
        restClient.addParam("id", Integer.toString(id));
        restClient.addParam("count", Integer.toString(count));
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        News news = JsonParser.getNewsListFromJson(restClient.getResponse(), context);
        formatNewsContent(news);
        return news;
    }

    private static News requestMoreNews(Context context, int id, int page) throws Exception {
        RestClient restClient = new RestClient(NEWS_URL);
        restClient.addParam("id", Integer.toString(id));
        restClient.addParam(ModelFields.PAGE, Integer.toString(page));
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        News news = JsonParser.getNewsListFromJson(restClient.getResponse(), context);
        formatNewsContent(news);
        return news;
    }

    private static News requestLatestNews(Context context) throws Exception {
        RestClient restClient = new RestClient(LATEST_NEWS_URL);
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        return JsonParser.getNewsListFromJson(restClient.getResponse(), context);
    }

    private static void checkResponseCode(RestClient restClient) throws IOException {
        int responseCode = restClient.getResponseCode();
        if (responseCode != 500 && responseCode != 503 && responseCode != 404 && responseCode != 200) {
            throw new IOException();
        }
    }

    private static MarketImpactCalDetails requestMarketImpactCalendarDetails(Context context, String id) throws Exception {
        RestClient restClient = new RestClient(MARKET_IMPACT_CALENDAR_DETAILS.replace("*", id));
        setDefaultParameters(restClient);
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        return JsonParser.getMarketImpactsCalDetailsFromJson(restClient.getResponse(), context);
    }

    private static ArrayList<HistTableModel> requestHistoryCalendarDetails(Context context, String id) throws Exception {
        RestClient restClient = new RestClient(HISTORY_CALENDAR_DETAILS.replace("*", id));
        setDefaultParameters(restClient);
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        return JsonParser.getHistoryCalDetailsFromJson(restClient.getResponse(), context);
    }

    private static ArrayList<NewsCalDetails> requestNewsCalendarDetails(Context context, String id) throws Exception {
        RestClient restClient = new RestClient(NEWS_CALENDAR_DETAILS.replace("*", id));
        setDefaultParameters(restClient);
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        return JsonParser.getNewsCalDetailsFromJson(restClient.getResponse(), context);
    }

    public static NewsCalendarContent requestNewsCalendarDetailsText(Context context, String id) throws Exception {
        RestClient restClient = new RestClient(NEWS_CALENDAR_DETAILS_WITH_TEXT.replace("*", id));
        setDefaultParameters(restClient);
        restClient.execute(RequestMethod.GET);
        checkResponseCode(restClient);
        return JsonParser.getNewsCalendarContentFromJSON(restClient.getResponse());
    }

    private static void formatNewsContent(News news) throws Exception {
        Iterator<Post> it = news.getPostsList().iterator();
        while (it.hasNext()) {
            Post current = it.next();
            current.setFormattedContent(GuiUtil.formatStringFromHtml(current.getExcerpt()));
        }
    }

    private static boolean performSubscription(Context context, String email) throws Exception {
        RestClient restClient = new RestClient(SUBSCRIBE_URL);
        restClient.addParam(ParseFacebookUtils.Permissions.User.EMAIL, email);
        restClient.addParam("listname", "forexcrunch");
        restClient.execute(RequestMethod.POST);
        checkResponseCode(restClient);
        String response = restClient.getResponse();
        return false;
    }

    public static Post getPost(String url) throws Exception {
        RestClient restClient = new RestClient(url);
        restClient.execute(RequestMethod.GET);
        return JsonParser.getPostFromJson(restClient.getResponse());
    }
}
