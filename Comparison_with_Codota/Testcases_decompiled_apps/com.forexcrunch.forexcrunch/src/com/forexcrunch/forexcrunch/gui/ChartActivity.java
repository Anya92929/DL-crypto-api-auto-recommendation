package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.HistTableModel;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class ChartActivity extends Activity {
    public static final String TYPE = "type";
    private ArrayList<HistTableModel> items;
    private GraphicalView mChartView;
    private XYMultipleSeriesDataset mDataset;
    private XYMultipleSeriesRenderer mRenderer;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.chart_activity);
        this.items = NewsController.getInstance(this).getHistTableItems();
        if (this.items == null) {
            Toast.makeText(this, C0089R.string.noitemstoplot, 1).show();
            finish();
            return;
        }
        this.mDataset = getDataset(this.items);
        this.mRenderer = getRenderer();
        setRendererStyling(this.mRenderer, this.items);
        if (this.mChartView == null) {
            this.mChartView = ChartFactory.getLineChartView(this, this.mDataset, this.mRenderer);
            this.mRenderer.setSelectableBuffer(this.items.size() + 10);
            ((LinearLayout) findViewById(C0089R.C0090id.chart)).addView(this.mChartView);
            return;
        }
        this.mChartView.repaint();
    }

    private void setRendererStyling(XYMultipleSeriesRenderer mRenderer2, ArrayList<HistTableModel> items2) {
        mRenderer2.setApplyBackgroundColor(true);
        mRenderer2.setAxisTitleTextSize(16.0f);
        mRenderer2.setChartTitleTextSize(20.0f);
        mRenderer2.setLabelsTextSize((float) getResources().getInteger(C0089R.integer.chart_label_text_size));
        mRenderer2.setLegendTextSize(15.0f);
        mRenderer2.setMargins(new int[]{getResources().getInteger(C0089R.integer.chart_margin_top), getResources().getInteger(C0089R.integer.chart_margin_left), getResources().getInteger(C0089R.integer.chart_margin_botton), getResources().getInteger(C0089R.integer.chart_margin_right)});
        mRenderer2.setZoomButtonsVisible(true);
        mRenderer2.setPointSize(20.0f);
        mRenderer2.setAxesColor(DefaultRenderer.TEXT_COLOR);
        mRenderer2.setBackgroundColor(-1);
        mRenderer2.setMarginsColor(-1);
        mRenderer2.setXLabels(0);
        mRenderer2.setXLabelsColor(DefaultRenderer.BACKGROUND_COLOR);
        mRenderer2.setYLabelsColor(0, DefaultRenderer.BACKGROUND_COLOR);
        mRenderer2.setYLabelsAlign(Paint.Align.RIGHT);
        int j = items2.get(items2.size() - 1).getDateTime().getYear() - 1;
        int count = 0;
        boolean first = true;
        for (int i = items2.size() - 1; i >= 0; i--) {
            count++;
            if (j < items2.get(i).getDateTime().getYear()) {
                if (count > 4) {
                    mRenderer2.addXTextLabel((double) ((items2.size() - i) - 1), new StringBuilder(String.valueOf(items2.get(i).getDateTime().getYear())).toString());
                    j = items2.get(i).getDateTime().getYear();
                    count = 0;
                }
                if (first) {
                    mRenderer2.addXTextLabel((double) ((items2.size() - i) - 1), new StringBuilder(String.valueOf(items2.get(i).getDateTime().getYear())).toString());
                    j = items2.get(i).getDateTime().getYear();
                    count = 0;
                    first = false;
                }
            }
        }
        formatYLabelAxis(mRenderer2);
    }

    private void formatYLabelAxis(XYMultipleSeriesRenderer mRenderer2) {
        float max = BitmapDescriptorFactory.HUE_RED;
        float min = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getActual() < min) {
                min = this.items.get(i).getActual();
            }
            if (this.items.get(i).getActual() > max) {
                max = this.items.get(i).getActual();
            }
        }
        if (((double) max) > 10000.0d || ((double) min) < -10000.0d) {
            mRenderer2.setYLabels(0);
            long distancemM = (long) Math.abs(max - min);
            int group = 4;
            long sep = distancemM / 10;
            if (((double) distancemM) > 4.0E12d) {
                group = 0;
                if (((double) sep) < 1.0E12d) {
                    sep = 1000000000000L;
                }
            } else if (((double) distancemM) > 4.0E9d) {
                group = 1;
                if (((double) sep) < 1.0E9d) {
                    sep = 1000000000;
                }
            } else if (((double) distancemM) > 4000000.0d) {
                group = 2;
                if (((double) sep) < 1000000.0d) {
                    sep = 1000000;
                }
            } else if (((double) distancemM) > 40000.0d) {
                group = 3;
                if (((double) sep) < 10000.0d) {
                    sep = 10000;
                }
            }
            for (long i2 = 0; ((float) i2) < ((float) (distancemM / 2)) + max; i2 += sep) {
                mRenderer2.addYTextLabel((double) i2, formatFloat((float) i2, group));
            }
            for (long i3 = 0; ((float) i3) > min - ((float) (distancemM / 2)); i3 -= sep) {
                mRenderer2.addYTextLabel((double) i3, formatFloat((float) i3, group));
            }
        }
    }

    private String formatFloat(float actual, int group) {
        String res = new StringBuilder(String.valueOf(actual)).toString();
        if (group == 0) {
            return String.valueOf((long) (((double) actual) / 1.0E12d)) + "T";
        }
        if (group == 1) {
            return String.valueOf((long) (((double) actual) / 1.0E9d)) + "B";
        }
        if (group == 2) {
            return String.valueOf((long) (((double) actual) / 1000000.0d)) + "M";
        }
        if (group == 3) {
            return String.valueOf((long) (actual / 1000.0f)) + "K";
        }
        return res;
    }

    private XYMultipleSeriesDataset getDataset(ArrayList<HistTableModel> items2) {
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        XYSeries firstSeries = new XYSeries("");
        for (int i = items2.size() - 1; i >= 0; i--) {
            firstSeries.add((double) ((items2.size() - i) - 1), (double) items2.get(i).getActual());
        }
        dataset.addSeries(firstSeries);
        return dataset;
    }

    private XYMultipleSeriesRenderer getRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer r = new XYSeriesRenderer();
        r.setColor(-16776961);
        r.setLineWidth((float) getResources().getInteger(C0089R.integer.chart_line_width));
        r.setPointStyle(PointStyle.POINT);
        r.setFillPoints(true);
        renderer.addSeriesRenderer(r);
        return renderer;
    }

    public void onBackPressed() {
        finish();
    }
}
