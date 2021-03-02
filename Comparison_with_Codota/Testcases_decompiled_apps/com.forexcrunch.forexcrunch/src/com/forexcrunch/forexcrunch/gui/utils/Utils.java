package com.forexcrunch.forexcrunch.gui.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.model.CountryItem;
import com.forexcrunch.forexcrunch.model.FilterModel;
import com.forexcrunch.forexcrunch.model.MarketImpactCalDetails;
import com.forexcrunch.forexcrunch.model.Post;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;

public class Utils {
    public static int getVolatilityResourceId(int volatility) {
        switch (volatility) {
            case 0:
                return C0089R.drawable.volu0;
            case 1:
                return C0089R.drawable.volu1;
            case 2:
                return C0089R.drawable.volu2;
            case 3:
                return C0089R.drawable.volu3;
            default:
                return 0;
        }
    }

    public static String getFormattedTime(int hours, int minutes) {
        String h;
        String m;
        if (hours < 9) {
            h = "0" + hours;
        } else {
            h = new StringBuilder().append(hours).toString();
        }
        if (minutes < 9) {
            m = "0" + minutes;
        } else {
            m = new StringBuilder().append(minutes).toString();
        }
        return String.valueOf(h) + ":" + m;
    }

    public static int getFlagImageId(String countryName, Context ctx) {
        if (countryName == null || countryName.equals("") || countryName.equals("null")) {
            return C0089R.drawable.nocountry;
        }
        return ctx.getResources().getIdentifier("drawable/" + countryName.trim(), (String) null, ctx.getPackageName());
    }

    public static String getDefaultCountryCodes() {
        return "DE,IT,NZ,ES,CH,UK,AU,CA,CN,EMU,FR,GR,JP,PT,US";
    }

    public static int getCountryRoundedFlagByCountryCode(Context ctx, String countryCode, boolean stateChecked) {
        String state;
        if (countryCode == null || countryCode.equals("") || countryCode.equals("null")) {
            return 0;
        }
        String resourceName = countryCode.toLowerCase().trim();
        if (stateChecked) {
            state = "on";
        } else {
            state = "off";
        }
        return ctx.getResources().getIdentifier("drawable/s" + resourceName + state, (String) null, ctx.getPackageName());
    }

    public static ArrayList<CountryItem> createCountriesList(Context ctx) {
        ArrayList<CountryItem> list = new ArrayList<>();
        try {
            Scanner input = new Scanner(ctx.getAssets().open("countries.txt"));
            while (input.hasNext()) {
                String countryCode = input.next();
                String next = input.next();
                if (next.equals("") && input.hasNext()) {
                    next = input.next();
                }
                list.add(new CountryItem(getCountryRoundedFlagByCountryCode(ctx, countryCode, false), getCountryRoundedFlagByCountryCode(ctx, countryCode, true), next.replace("_", " "), countryCode, isSelectedForDefault(countryCode)));
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static boolean isSelectedForDefault(String code) {
        return getDefaultCountryCodes().contains(code);
    }

    public static String getformattedString(Calendar calendar) {
        String monthString;
        String dayString;
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        if (month <= 9) {
            monthString = "0" + month;
        } else {
            monthString = new StringBuilder().append(month).toString();
        }
        if (day <= 9) {
            dayString = "0" + day;
        } else {
            dayString = new StringBuilder().append(day).toString();
        }
        return String.valueOf(monthString) + "-" + dayString + "-" + calendar.get(1);
    }

    public static String getFormattedMonthAndDay(int month, int day) {
        String d;
        String ms = "";
        if (month == 1) {
            ms = "JAN";
        } else if (month == 2) {
            ms = "FEB";
        } else if (month == 3) {
            ms = "MAR";
        } else if (month == 4) {
            ms = "APR";
        } else if (month == 5) {
            ms = "MAY";
        } else if (month == 6) {
            ms = "JUN";
        } else if (month == 7) {
            ms = "JUL";
        } else if (month == 8) {
            ms = "AUG";
        } else if (month == 9) {
            ms = "SEP";
        } else if (month == 10) {
            ms = "OCT";
        } else if (month == 11) {
            ms = "NOV";
        } else if (month == 12) {
            ms = "DEC";
        }
        if (day <= 9) {
            d = "0" + day;
        } else {
            d = new StringBuilder().append(day).toString();
        }
        return String.valueOf(ms) + " " + d;
    }

    public static ArrayList<Integer> createIdsList(Context ctx, int category) {
        ArrayList<Integer> list = new ArrayList<>();
        String ids = PreferenceManager.getDefaultSharedPreferences(ctx.getApplicationContext()).getString(new StringBuilder().append(category).toString(), "");
        if (!ids.equals("")) {
            String[] idList = ids.split(",");
            for (String valueOf : idList) {
                list.add(Integer.valueOf(valueOf));
            }
        }
        return list;
    }

    public static void idListToPreferences(Context ctx, ArrayList<Integer> idList, int category) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx.getApplicationContext());
        String ids = "";
        Iterator<Integer> it = idList.iterator();
        while (it.hasNext()) {
            Integer current = it.next();
            if (ids.equals("")) {
                ids = new StringBuilder().append(current).toString();
            } else {
                ids = String.valueOf(ids) + "," + current;
            }
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(new StringBuilder().append(category).toString(), ids);
        editor.commit();
    }

    public static String getInstrumentByCaption(String caption) {
        if (caption.equals(MarketImpactCalDetails.USD_CAPTION)) {
            return MarketImpactCalDetails.USD_INSTRUMENT;
        }
        if (caption.equals(MarketImpactCalDetails.EUR_CAPTION)) {
            return MarketImpactCalDetails.EUR_INSTRUMENT;
        }
        if (caption.equals(MarketImpactCalDetails.GBP_CAPTION)) {
            return MarketImpactCalDetails.GBP_INSTRUMENT;
        }
        if (caption.equals(MarketImpactCalDetails.CHF_CAPTION)) {
            return MarketImpactCalDetails.CHF_INSTRUMENT;
        }
        if (caption.equals(MarketImpactCalDetails.JPY_CAPTION)) {
            return MarketImpactCalDetails.JPY_INSTRUMENT;
        }
        if (caption.equals(MarketImpactCalDetails.AUD_CAPTION)) {
            return MarketImpactCalDetails.AUD_INSTRUMENT;
        }
        if (caption.equals(MarketImpactCalDetails.CAD_CAPTION)) {
            return MarketImpactCalDetails.CAD_INSTRUMENT;
        }
        if (caption.equals(MarketImpactCalDetails.NZD_CAPTION)) {
            return MarketImpactCalDetails.NZD_INSTRUMENT;
        }
        return "";
    }

    public static boolean isValidEmail(String email) {
        String email2 = email.trim();
        if (email2.equalsIgnoreCase("") || !Character.isLetter(email2.charAt(0))) {
            return false;
        }
        boolean matchFound1 = Pattern.compile("^\\.|^\\@ |^_").matcher(email2.toString()).matches();
        boolean matchFound = Pattern.compile("^[a-zA-z0-9._-]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z]{2,4}$").matcher(email2.toString()).matches();
        StringTokenizer st = new StringTokenizer(email2, ".");
        String lastToken = null;
        while (st.hasMoreTokens()) {
            lastToken = st.nextToken();
        }
        if (!matchFound || lastToken.length() < 2 || email2.length() - 1 == lastToken.length() || matchFound1) {
            return false;
        }
        return true;
    }

    public static String insertZeroIfLessThanTen(int count) {
        if (count < 9) {
            return "0" + count;
        }
        return new StringBuilder().append(count).toString();
    }

    public static ArrayList<Post> getSavedArticlesFromPreferences(Context context) {
        Gson gson = new Gson();
        String myBooks = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getString(context.getString(C0089R.string.saved_articles_preferences), "");
        ArrayList<Post> savedArticles = null;
        if (myBooks.equals("")) {
            return null;
        }
        try {
            ArrayList<Post> savedArticles2 = new ArrayList<>();
            try {
                JSONArray myBooksArray = new JSONArray(myBooks);
                for (int i = 0; i < myBooksArray.length(); i++) {
                    savedArticles2.add((Post) gson.fromJson(myBooksArray.getString(i), Post.class));
                }
                return savedArticles2;
            } catch (JSONException e) {
                e = e;
                savedArticles = savedArticles2;
                e.printStackTrace();
                return savedArticles;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            return savedArticles;
        }
    }

    public static FilterModel getFilterModelFromPrefs(Context ctx) {
        String model = PreferenceManager.getDefaultSharedPreferences(ctx.getApplicationContext()).getString("filterModel", "");
        if (!model.equals("")) {
            return (FilterModel) new Gson().fromJson(model, FilterModel.class);
        }
        return null;
    }
}
