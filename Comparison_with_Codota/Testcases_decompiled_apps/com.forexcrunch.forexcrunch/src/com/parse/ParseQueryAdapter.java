package com.parse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class ParseQueryAdapter<T extends ParseObject> extends BaseAdapter {
    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_NEXT_PAGE = 1;
    private boolean autoload;
    private Context context;
    /* access modifiers changed from: private */
    public int currentPage;
    private WeakHashMap<DataSetObserver, Void> dataSetObservers;
    /* access modifiers changed from: private */
    public boolean hasNextPage;
    private String imageKey;
    private WeakHashMap<ParseImageView, Void> imageViewSet;
    /* access modifiers changed from: private */
    public List<T> objects;
    /* access modifiers changed from: private */
    public int objectsPerPage;
    private List<OnQueryLoadListener<T>> onQueryLoadListeners;
    /* access modifiers changed from: private */
    public boolean paginationEnabled;
    private Drawable placeholder;
    private QueryFactory<T> queryFactory;
    private String textKey;

    public interface OnQueryLoadListener<T extends ParseObject> {
        void onLoaded(List<T> list, Exception exc);

        void onLoading();
    }

    public interface QueryFactory<T extends ParseObject> {
        ParseQuery<T> create();
    }

    public ParseQueryAdapter(Context context2, Class<? extends ParseObject> clazz) {
        this(context2, ParseObject.getClassName(clazz));
    }

    public ParseQueryAdapter(Context context2, final String className) {
        this(context2, new QueryFactory<T>() {
            public ParseQuery<T> create() {
                ParseQuery<T> query = ParseQuery.getQuery(className);
                query.orderByDescending("createdAt");
                return query;
            }
        });
        if (className == null) {
            throw new RuntimeException("You need to specify a className for the ParseQueryAdapter");
        }
    }

    public ParseQueryAdapter(Context context2, QueryFactory<T> queryFactory2) {
        this.objectsPerPage = 25;
        this.paginationEnabled = true;
        this.imageViewSet = new WeakHashMap<>();
        this.dataSetObservers = new WeakHashMap<>();
        this.autoload = true;
        this.objects = new ArrayList();
        this.currentPage = 0;
        this.hasNextPage = true;
        this.onQueryLoadListeners = new ArrayList();
        this.context = context2;
        this.queryFactory = queryFactory2;
    }

    public Context getContext() {
        return this.context;
    }

    public T getItem(int index) {
        if (index == getPaginationCellRow()) {
            return null;
        }
        return (ParseObject) this.objects.get(index);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getItemViewType(int position) {
        if (position == getPaginationCellRow()) {
            return 1;
        }
        return 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
        this.dataSetObservers.put(observer, (Object) null);
        if (this.autoload) {
            loadObjects();
        }
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
        this.dataSetObservers.remove(observer);
    }

    public void clear() {
        this.objects.clear();
        notifyDataSetChanged();
        this.currentPage = 0;
    }

    public void loadObjects() {
        loadObjects(0, true);
    }

    private void loadObjects(final int page, final boolean shouldClear) {
        final ParseQuery<T> query = this.queryFactory.create();
        if (this.objectsPerPage > 0 && this.paginationEnabled) {
            setPageOnQuery(page, query);
        }
        notifyOnLoadingListeners();
        query.findInBackground(new FindCallback<T>() {
            @SuppressLint({"ShowToast"})
            public void done(List<T> foundObjects, ParseException e) {
                boolean z = true;
                if (query.getCachePolicy() != ParseQuery.CachePolicy.CACHE_ONLY || e == null || e.getCode() != 120) {
                    if (e != null && (e.getCode() == 100 || e.getCode() != 120)) {
                        ParseQueryAdapter.this.hasNextPage = true;
                    } else if (foundObjects != null) {
                        ParseQueryAdapter.this.currentPage = page;
                        ParseQueryAdapter parseQueryAdapter = ParseQueryAdapter.this;
                        if (foundObjects.size() <= ParseQueryAdapter.this.objectsPerPage) {
                            z = false;
                        }
                        parseQueryAdapter.hasNextPage = z;
                        if (ParseQueryAdapter.this.paginationEnabled && foundObjects.size() > ParseQueryAdapter.this.objectsPerPage) {
                            foundObjects.remove(ParseQueryAdapter.this.objectsPerPage);
                        }
                        if (shouldClear) {
                            ParseQueryAdapter.this.objects.clear();
                        }
                        ParseQueryAdapter.this.objects.addAll(foundObjects);
                        ParseQueryAdapter.this.notifyDataSetChanged();
                    }
                    ParseQueryAdapter.this.notifyOnLoadedListeners(foundObjects, e);
                }
            }
        });
    }

    public void loadNextPage() {
        loadObjects(this.currentPage + 1, false);
    }

    public int getCount() {
        int count = this.objects.size();
        if (shouldShowPaginationCell()) {
            return count + 1;
        }
        return count;
    }

    public View getItemView(T object, View v, ViewGroup parent) {
        if (v == null) {
            v = getDefaultView(this.context);
        }
        try {
            TextView textView = (TextView) v.findViewById(16908308);
            if (textView != null) {
                if (this.textKey == null) {
                    textView.setText(object.getObjectId());
                } else if (object.get(this.textKey) != null) {
                    textView.setText(object.get(this.textKey).toString());
                } else {
                    textView.setText((CharSequence) null);
                }
            }
            if (this.imageKey != null) {
                try {
                    ParseImageView imageView = (ParseImageView) v.findViewById(16908294);
                    if (imageView == null) {
                        throw new IllegalStateException("Your object views must have a ParseImageView whose id attribute is 'android.R.id.icon' if an imageKey is specified");
                    }
                    if (!this.imageViewSet.containsKey(imageView)) {
                        this.imageViewSet.put(imageView, (Object) null);
                    }
                    imageView.setPlaceholder(this.placeholder);
                    imageView.setParseFile((ParseFile) object.get(this.imageKey));
                    imageView.loadInBackground();
                } catch (ClassCastException ex) {
                    throw new IllegalStateException("Your object views must have a ParseImageView whose id attribute is 'android.R.id.icon'", ex);
                }
            }
            return v;
        } catch (ClassCastException ex2) {
            throw new IllegalStateException("Your object views must have a TextView whose id attribute is 'android.R.id.text1'", ex2);
        }
    }

    public View getNextPageView(View v, ViewGroup parent) {
        if (v == null) {
            v = getDefaultView(this.context);
        }
        ((TextView) v.findViewById(16908308)).setText("Load more...");
        return v;
    }

    public final View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) != 1) {
            return getItemView(getItem(position), convertView, parent);
        }
        View nextPageView = getNextPageView(convertView, parent);
        nextPageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ParseQueryAdapter.this.loadNextPage();
            }
        });
        return nextPageView;
    }

    /* access modifiers changed from: protected */
    public void setPageOnQuery(int page, ParseQuery<T> query) {
        query.setLimit(this.objectsPerPage + 1);
        query.setSkip(this.objectsPerPage * page);
    }

    public void setTextKey(String textKey2) {
        this.textKey = textKey2;
    }

    public void setImageKey(String imageKey2) {
        this.imageKey = imageKey2;
    }

    public void setObjectsPerPage(int objectsPerPage2) {
        this.objectsPerPage = objectsPerPage2;
    }

    public int getObjectsPerPage() {
        return this.objectsPerPage;
    }

    public void setPaginationEnabled(boolean paginationEnabled2) {
        this.paginationEnabled = paginationEnabled2;
    }

    public void setPlaceholder(Drawable placeholder2) {
        if (this.placeholder != placeholder2) {
            this.placeholder = placeholder2;
            for (ParseImageView imageView : this.imageViewSet.keySet()) {
                if (imageView != null) {
                    imageView.setPlaceholder(this.placeholder);
                }
            }
        }
    }

    public void setAutoload(boolean autoload2) {
        if (this.autoload != autoload2) {
            this.autoload = autoload2;
            if (this.autoload && !this.dataSetObservers.isEmpty() && this.objects.isEmpty()) {
                loadObjects();
            }
        }
    }

    public void addOnQueryLoadListener(OnQueryLoadListener<T> listener) {
        this.onQueryLoadListeners.add(listener);
    }

    public void removeOnQueryLoadListener(OnQueryLoadListener<T> listener) {
        this.onQueryLoadListeners.remove(listener);
    }

    private View getDefaultView(Context context2) {
        LinearLayout view = new LinearLayout(context2);
        view.setPadding(8, 4, 8, 4);
        ParseImageView imageView = new ParseImageView(context2);
        imageView.setId(16908294);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
        view.addView(imageView);
        TextView textView = new TextView(context2);
        textView.setId(16908308);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setPadding(8, 0, 0, 0);
        view.addView(textView);
        return view;
    }

    private int getPaginationCellRow() {
        return this.objects.size();
    }

    private boolean shouldShowPaginationCell() {
        return this.paginationEnabled && this.objects.size() > 0 && this.hasNextPage;
    }

    private void notifyOnLoadingListeners() {
        for (OnQueryLoadListener<T> listener : this.onQueryLoadListeners) {
            listener.onLoading();
        }
    }

    /* access modifiers changed from: private */
    public void notifyOnLoadedListeners(List<T> objects2, Exception e) {
        for (OnQueryLoadListener<T> listener : this.onQueryLoadListeners) {
            listener.onLoaded(objects2, e);
        }
    }
}
