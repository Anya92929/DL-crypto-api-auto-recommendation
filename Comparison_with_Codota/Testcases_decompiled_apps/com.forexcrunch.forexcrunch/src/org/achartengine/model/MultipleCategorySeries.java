package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultipleCategorySeries implements Serializable {
    private List<String> mCategories = new ArrayList();
    private String mTitle;
    private List<String[]> mTitles = new ArrayList();
    private List<double[]> mValues = new ArrayList();

    public MultipleCategorySeries(String title) {
        this.mTitle = title;
    }

    public void add(String[] titles, double[] values) {
        add(this.mCategories.size() + "", titles, values);
    }

    public void add(String category, String[] titles, double[] values) {
        this.mCategories.add(category);
        this.mTitles.add(titles);
        this.mValues.add(values);
    }

    public void remove(int index) {
        this.mCategories.remove(index);
        this.mTitles.remove(index);
        this.mValues.remove(index);
    }

    public void clear() {
        this.mCategories.clear();
        this.mTitles.clear();
        this.mValues.clear();
    }

    public double[] getValues(int index) {
        return this.mValues.get(index);
    }

    public String getCategory(int index) {
        return this.mCategories.get(index);
    }

    public int getCategoriesCount() {
        return this.mCategories.size();
    }

    public int getItemCount(int index) {
        return this.mValues.get(index).length;
    }

    public String[] getTitles(int index) {
        return this.mTitles.get(index);
    }

    public XYSeries toXYSeries() {
        return new XYSeries(this.mTitle);
    }
}
