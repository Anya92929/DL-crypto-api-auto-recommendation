package org.achartengine.chart;

import org.achartengine.chart.BarChart;

public class RangeStackedBarChart extends RangeBarChart {
    public static final String TYPE = "RangeStackedBar";

    RangeStackedBarChart() {
        super(BarChart.Type.STACKED);
    }

    public String getChartType() {
        return TYPE;
    }
}
