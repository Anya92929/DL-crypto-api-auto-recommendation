package org.achartengine;

import android.content.Context;
import android.content.Intent;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.BubbleChart;
import org.achartengine.chart.CombinedXYChart;
import org.achartengine.chart.CubicLineChart;
import org.achartengine.chart.DialChart;
import org.achartengine.chart.DoughnutChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PieChart;
import org.achartengine.chart.RangeBarChart;
import org.achartengine.chart.ScatterChart;
import org.achartengine.chart.TimeChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.MultipleCategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.DialRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class ChartFactory {
    public static final String CHART = "chart";
    public static final String TITLE = "title";

    private ChartFactory() {
    }

    public static final GraphicalView getLineChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new LineChart(dataset, renderer));
    }

    public static final GraphicalView getCubeLineChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, float smoothness) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new CubicLineChart(dataset, renderer, smoothness));
    }

    public static final GraphicalView getScatterChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new ScatterChart(dataset, renderer));
    }

    public static final GraphicalView getBubbleChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new BubbleChart(dataset, renderer));
    }

    public static final GraphicalView getTimeChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String format) {
        checkParameters(dataset, renderer);
        TimeChart chart = new TimeChart(dataset, renderer);
        chart.setDateFormat(format);
        return new GraphicalView(context, chart);
    }

    public static final GraphicalView getBarChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, BarChart.Type type) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new BarChart(dataset, renderer, type));
    }

    public static final GraphicalView getRangeBarChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, BarChart.Type type) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new RangeBarChart(dataset, renderer, type));
    }

    public static final GraphicalView getCombinedXYChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String[] types) {
        if (dataset == null || renderer == null || types == null || dataset.getSeriesCount() != types.length) {
            throw new IllegalArgumentException("Dataset, renderer and types should be not null and the datasets series count should be equal to the types length");
        }
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new CombinedXYChart(dataset, renderer, types));
    }

    public static final GraphicalView getPieChartView(Context context, CategorySeries dataset, DefaultRenderer renderer) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new PieChart(dataset, renderer));
    }

    public static final GraphicalView getDialChartView(Context context, CategorySeries dataset, DialRenderer renderer) {
        checkParameters(dataset, (DefaultRenderer) renderer);
        return new GraphicalView(context, new DialChart(dataset, renderer));
    }

    public static final GraphicalView getDoughnutChartView(Context context, MultipleCategorySeries dataset, DefaultRenderer renderer) {
        checkParameters(dataset, renderer);
        return new GraphicalView(context, new DoughnutChart(dataset, renderer));
    }

    public static final Intent getLineChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        return getLineChartIntent(context, dataset, renderer, "");
    }

    public static final Intent getCubicLineChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, float smoothness) {
        return getCubicLineChartIntent(context, dataset, renderer, smoothness, "");
    }

    public static final Intent getScatterChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        return getScatterChartIntent(context, dataset, renderer, "");
    }

    public static final Intent getBubbleChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        return getBubbleChartIntent(context, dataset, renderer, "");
    }

    public static final Intent getTimeChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String format) {
        return getTimeChartIntent(context, dataset, renderer, format, "");
    }

    public static final Intent getBarChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, BarChart.Type type) {
        return getBarChartIntent(context, dataset, renderer, type, "");
    }

    public static final Intent getLineChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new LineChart(dataset, renderer));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getCubicLineChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, float smoothness, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new CubicLineChart(dataset, renderer, smoothness));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getScatterChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new ScatterChart(dataset, renderer));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getBubbleChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new BubbleChart(dataset, renderer));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getTimeChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String format, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        TimeChart chart = new TimeChart(dataset, renderer);
        chart.setDateFormat(format);
        intent.putExtra(CHART, chart);
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getBarChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, BarChart.Type type, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new BarChart(dataset, renderer, type));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getRangeBarChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, BarChart.Type type, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new RangeBarChart(dataset, renderer, type));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getCombinedXYChartIntent(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String[] types, String activityTitle) {
        if (dataset == null || renderer == null || types == null || dataset.getSeriesCount() != types.length) {
            throw new IllegalArgumentException("Datasets, renderers and types should be not null and the datasets series count should be equal to the types length");
        }
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new CombinedXYChart(dataset, renderer, types));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getPieChartIntent(Context context, CategorySeries dataset, DefaultRenderer renderer, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new PieChart(dataset, renderer));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getDoughnutChartIntent(Context context, MultipleCategorySeries dataset, DefaultRenderer renderer, String activityTitle) {
        checkParameters(dataset, renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new DoughnutChart(dataset, renderer));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    public static final Intent getDialChartIntent(Context context, CategorySeries dataset, DialRenderer renderer, String activityTitle) {
        checkParameters(dataset, (DefaultRenderer) renderer);
        Intent intent = new Intent(context, GraphicalActivity.class);
        intent.putExtra(CHART, new DialChart(dataset, renderer));
        intent.putExtra("title", activityTitle);
        return intent;
    }

    private static void checkParameters(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        if (dataset == null || renderer == null || dataset.getSeriesCount() != renderer.getSeriesRendererCount()) {
            throw new IllegalArgumentException("Dataset and renderer should be not null and should have the same number of series");
        }
    }

    private static void checkParameters(CategorySeries dataset, DefaultRenderer renderer) {
        if (dataset == null || renderer == null || dataset.getItemCount() != renderer.getSeriesRendererCount()) {
            throw new IllegalArgumentException("Dataset and renderer should be not null and the dataset number of items should be equal to the number of series renderers");
        }
    }

    private static void checkParameters(MultipleCategorySeries dataset, DefaultRenderer renderer) {
        if (dataset == null || renderer == null || !checkMultipleSeriesItems(dataset, renderer.getSeriesRendererCount())) {
            throw new IllegalArgumentException("Titles and values should be not null and the dataset number of items should be equal to the number of series renderers");
        }
    }

    private static boolean checkMultipleSeriesItems(MultipleCategorySeries dataset, int value) {
        int count = dataset.getCategoriesCount();
        boolean equal = true;
        for (int k = 0; k < count && equal; k++) {
            equal = dataset.getValues(k).length == dataset.getTitles(k).length;
        }
        return equal;
    }
}
