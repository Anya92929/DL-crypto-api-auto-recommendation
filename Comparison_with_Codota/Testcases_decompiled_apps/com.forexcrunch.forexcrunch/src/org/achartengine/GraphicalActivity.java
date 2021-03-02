package org.achartengine;

import android.app.Activity;
import android.os.Bundle;
import org.achartengine.chart.AbstractChart;

public class GraphicalActivity extends Activity {
    private AbstractChart mChart;
    private GraphicalView mView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        this.mChart = (AbstractChart) extras.getSerializable(ChartFactory.CHART);
        this.mView = new GraphicalView(this, this.mChart);
        String title = extras.getString("title");
        if (title == null) {
            requestWindowFeature(1);
        } else if (title.length() > 0) {
            setTitle(title);
        }
        setContentView(this.mView);
    }
}
