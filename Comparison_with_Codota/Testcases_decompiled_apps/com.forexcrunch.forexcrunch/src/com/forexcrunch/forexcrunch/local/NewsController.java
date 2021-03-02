package com.forexcrunch.forexcrunch.local;

import android.content.Context;
import com.forexcrunch.forexcrunch.model.CalendarItem;
import com.forexcrunch.forexcrunch.model.FilterModel;
import com.forexcrunch.forexcrunch.model.HistTableModel;
import com.forexcrunch.forexcrunch.model.MarketImpactCalDetails;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.NewsCalDetails;
import com.forexcrunch.forexcrunch.model.Post;
import java.util.ArrayList;

public class NewsController {
    private static NewsController instance;
    private News audNews;
    private News basicNews;
    private News bitsNews;
    private News cadNews;
    private FilterModel calendarFilters;
    private News chfNews;
    private Context ctx;
    private News eurNews;
    private News eurusdNews;
    private News firstEURUSD;
    private News forecastNews;
    private News gbpNews;
    private ArrayList<HistTableModel> histTableItems;
    private News industryNews;
    private News jpyNews;
    private News latestNews;
    private News majorsNews;
    private MarketImpactCalDetails marketCalDetails;
    private News minorsNews;
    private ArrayList<NewsCalDetails> newsCalDetailsList;
    private News newsNews;
    private News nzdNews;
    private News opinionsNews;
    private int pagerHeight;
    private int pagerWidth;
    private News searchResults;
    private CalendarItem selectedCalendarItem;
    private Post selectedPost;

    public NewsController(Context context) {
        this.ctx = context;
    }

    public static NewsController getInstance(Context ctx2) {
        if (instance == null) {
            instance = new NewsController(ctx2.getApplicationContext());
        }
        return instance;
    }

    public News getNewsNews() {
        return this.newsNews;
    }

    public ArrayList<HistTableModel> getHistTableItems() {
        return this.histTableItems;
    }

    public void setHistTableItems(ArrayList<HistTableModel> histTableItems2) {
        this.histTableItems = histTableItems2;
    }

    public void setNewsNews(News newsNews2) {
        this.newsNews = newsNews2;
    }

    public News getOpinionsNews() {
        return this.opinionsNews;
    }

    public void setOpinionsNews(News opinionsNews2) {
        this.opinionsNews = opinionsNews2;
    }

    public News getLatestNews() {
        return this.latestNews;
    }

    public void setLatestNews(News latestNews2) {
        this.latestNews = latestNews2;
    }

    public News getMajorsNews() {
        return this.majorsNews;
    }

    public void setMajorsNews(News majorsNews2) {
        this.majorsNews = majorsNews2;
    }

    public News getMinorsNews() {
        return this.minorsNews;
    }

    public void setMinorsNews(News minorsNews2) {
        this.minorsNews = minorsNews2;
    }

    public News getBasicNews() {
        return this.basicNews;
    }

    public void setBasicNews(News basicNews2) {
        this.basicNews = basicNews2;
    }

    public News getEurNews() {
        return this.eurNews;
    }

    public void setEurNews(News eurNews2) {
        this.eurNews = eurNews2;
    }

    public News getForecastNews() {
        return this.forecastNews;
    }

    public void setForecastNews(News forecastNews2) {
        this.forecastNews = forecastNews2;
    }

    public News getBitsNews() {
        return this.bitsNews;
    }

    public void setBitsNews(News bitsNews2) {
        this.bitsNews = bitsNews2;
    }

    public News getIndustryNews() {
        return this.industryNews;
    }

    public void setIndustryNews(News industryNews2) {
        this.industryNews = industryNews2;
    }

    public int getPagerWidth() {
        return this.pagerWidth;
    }

    public void setPagerWidth(int pagerWidth2) {
        this.pagerWidth = pagerWidth2;
    }

    public int getPagerHeight() {
        return this.pagerHeight;
    }

    public void setPagerHeight(int pagerHeight2) {
        this.pagerHeight = pagerHeight2;
    }

    public News getGbpNews() {
        return this.gbpNews;
    }

    public void setGbpNews(News gbpNews2) {
        this.gbpNews = gbpNews2;
    }

    public News getCadNews() {
        return this.cadNews;
    }

    public void setCadNews(News cadNews2) {
        this.cadNews = cadNews2;
    }

    public News getChfNews() {
        return this.chfNews;
    }

    public void setChfNews(News chfNews2) {
        this.chfNews = chfNews2;
    }

    public News getFirstEURUSD() {
        return this.firstEURUSD;
    }

    public void setFirstEURUSD(News firstEURUSD2) {
        this.firstEURUSD = firstEURUSD2;
    }

    public News getNzdNews() {
        return this.nzdNews;
    }

    public void setNzdNews(News nzdNews2) {
        this.nzdNews = nzdNews2;
    }

    public News getJpyNews() {
        return this.jpyNews;
    }

    public void setJpyNews(News jpyNews2) {
        this.jpyNews = jpyNews2;
    }

    public News getAudNews() {
        return this.audNews;
    }

    public void setAudNews(News audNews2) {
        this.audNews = audNews2;
    }

    public News getEurusdNews() {
        return this.eurusdNews;
    }

    public void setEurusdNews(News eurusdNews2) {
        this.eurusdNews = eurusdNews2;
    }

    public Post getSelectedPost() {
        return this.selectedPost;
    }

    public void setSelectedPost(Post selectedPost2) {
        this.selectedPost = selectedPost2;
    }

    public FilterModel getCalendarFilters() {
        return this.calendarFilters;
    }

    public void setCalendarFilters(FilterModel calendarFilters2) {
        this.calendarFilters = calendarFilters2;
    }

    public CalendarItem getSelectedCalendarItem() {
        return this.selectedCalendarItem;
    }

    public void setSelectedCalendarItem(CalendarItem selectedCalendarItem2) {
        this.selectedCalendarItem = selectedCalendarItem2;
    }

    public News getSearchResults() {
        return this.searchResults;
    }

    public void setSearchResults(News searchResults2) {
        this.searchResults = searchResults2;
    }

    public ArrayList<NewsCalDetails> getNewsCalDetailsList() {
        return this.newsCalDetailsList;
    }

    public void setNewsCalDetailsList(ArrayList<NewsCalDetails> newsCalDetailsList2) {
        this.newsCalDetailsList = newsCalDetailsList2;
    }

    public MarketImpactCalDetails getMarketCalDetails() {
        return this.marketCalDetails;
    }

    public void setMarketCalDetails(MarketImpactCalDetails marketCalDetails2) {
        this.marketCalDetails = marketCalDetails2;
    }

    public void clearCalendarDetails() {
        this.marketCalDetails = null;
        this.newsCalDetailsList = null;
        this.selectedCalendarItem = null;
        this.histTableItems = null;
        System.gc();
    }
}
