package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class CombinedXYChart extends XYChart {
    private XYChart[] mCharts;
    private Class<?>[] xyChartTypes = {TimeChart.class, LineChart.class, CubicLineChart.class, BarChart.class, BubbleChart.class, ScatterChart.class, RangeBarChart.class, RangeStackedBarChart.class};

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CombinedXYChart(org.achartengine.model.XYMultipleSeriesDataset r9, org.achartengine.renderer.XYMultipleSeriesRenderer r10, java.lang.String[] r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10)
            r5 = 8
            java.lang.Class[] r5 = new java.lang.Class[r5]
            r6 = 0
            java.lang.Class<org.achartengine.chart.TimeChart> r7 = org.achartengine.chart.TimeChart.class
            r5[r6] = r7
            r6 = 1
            java.lang.Class<org.achartengine.chart.LineChart> r7 = org.achartengine.chart.LineChart.class
            r5[r6] = r7
            r6 = 2
            java.lang.Class<org.achartengine.chart.CubicLineChart> r7 = org.achartengine.chart.CubicLineChart.class
            r5[r6] = r7
            r6 = 3
            java.lang.Class<org.achartengine.chart.BarChart> r7 = org.achartengine.chart.BarChart.class
            r5[r6] = r7
            r6 = 4
            java.lang.Class<org.achartengine.chart.BubbleChart> r7 = org.achartengine.chart.BubbleChart.class
            r5[r6] = r7
            r6 = 5
            java.lang.Class<org.achartengine.chart.ScatterChart> r7 = org.achartengine.chart.ScatterChart.class
            r5[r6] = r7
            r6 = 6
            java.lang.Class<org.achartengine.chart.RangeBarChart> r7 = org.achartengine.chart.RangeBarChart.class
            r5[r6] = r7
            r6 = 7
            java.lang.Class<org.achartengine.chart.RangeStackedBarChart> r7 = org.achartengine.chart.RangeStackedBarChart.class
            r5[r6] = r7
            r8.xyChartTypes = r5
            int r1 = r11.length
            org.achartengine.chart.XYChart[] r5 = new org.achartengine.chart.XYChart[r1]
            r8.mCharts = r5
            r0 = 0
        L_0x0037:
            if (r0 >= r1) goto L_0x00d1
            org.achartengine.chart.XYChart[] r5 = r8.mCharts     // Catch:{ Exception -> 0x00d2 }
            r6 = r11[r0]     // Catch:{ Exception -> 0x00d2 }
            org.achartengine.chart.XYChart r6 = r8.getXYChart(r6)     // Catch:{ Exception -> 0x00d2 }
            r5[r0] = r6     // Catch:{ Exception -> 0x00d2 }
        L_0x0043:
            org.achartengine.chart.XYChart[] r5 = r8.mCharts
            r5 = r5[r0]
            if (r5 != 0) goto L_0x0064
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unknown chart type "
            java.lang.StringBuilder r6 = r6.append(r7)
            r7 = r11[r0]
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x0064:
            org.achartengine.model.XYMultipleSeriesDataset r2 = new org.achartengine.model.XYMultipleSeriesDataset
            r2.<init>()
            org.achartengine.model.XYSeries r5 = r9.getSeriesAt(r0)
            r2.addSeries(r5)
            org.achartengine.renderer.XYMultipleSeriesRenderer r3 = new org.achartengine.renderer.XYMultipleSeriesRenderer
            r3.<init>()
            double r5 = r10.getBarSpacing()
            r3.setBarSpacing(r5)
            float r5 = r10.getPointSize()
            r3.setPointSize(r5)
            org.achartengine.model.XYSeries r5 = r9.getSeriesAt(r0)
            int r4 = r5.getScaleNumber()
            boolean r5 = r10.isMinXSet(r4)
            if (r5 == 0) goto L_0x0098
            double r5 = r10.getXAxisMin(r4)
            r3.setXAxisMin(r5)
        L_0x0098:
            boolean r5 = r10.isMaxXSet(r4)
            if (r5 == 0) goto L_0x00a5
            double r5 = r10.getXAxisMax(r4)
            r3.setXAxisMax(r5)
        L_0x00a5:
            boolean r5 = r10.isMinYSet(r4)
            if (r5 == 0) goto L_0x00b2
            double r5 = r10.getYAxisMin(r4)
            r3.setYAxisMin(r5)
        L_0x00b2:
            boolean r5 = r10.isMaxYSet(r4)
            if (r5 == 0) goto L_0x00bf
            double r5 = r10.getYAxisMax(r4)
            r3.setYAxisMax(r5)
        L_0x00bf:
            org.achartengine.renderer.SimpleSeriesRenderer r5 = r10.getSeriesRendererAt(r0)
            r3.addSeriesRenderer(r5)
            org.achartengine.chart.XYChart[] r5 = r8.mCharts
            r5 = r5[r0]
            r5.setDatasetRenderer(r2, r3)
            int r0 = r0 + 1
            goto L_0x0037
        L_0x00d1:
            return
        L_0x00d2:
            r5 = move-exception
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: org.achartengine.chart.CombinedXYChart.<init>(org.achartengine.model.XYMultipleSeriesDataset, org.achartengine.renderer.XYMultipleSeriesRenderer, java.lang.String[]):void");
    }

    private XYChart getXYChart(String type) throws IllegalAccessException, InstantiationException {
        XYChart chart = null;
        int length = this.xyChartTypes.length;
        for (int i = 0; i < length && chart == null; i++) {
            XYChart newChart = (XYChart) this.xyChartTypes[i].newInstance();
            if (type.equals(newChart.getChartType())) {
                chart = newChart;
            }
        }
        return chart;
    }

    public void drawSeries(Canvas canvas, Paint paint, List<Float> points, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {
        this.mCharts[seriesIndex].setScreenR(getScreenR());
        this.mCharts[seriesIndex].setCalcRange(getCalcRange(this.mDataset.getSeriesAt(seriesIndex).getScaleNumber()), 0);
        this.mCharts[seriesIndex].drawSeries(canvas, paint, points, seriesRenderer, yAxisValue, 0, startIndex);
    }

    /* access modifiers changed from: protected */
    public ClickableArea[] clickableAreasForPoints(List<Float> points, List<Double> values, float yAxisValue, int seriesIndex, int startIndex) {
        return this.mCharts[seriesIndex].clickableAreasForPoints(points, values, yAxisValue, 0, startIndex);
    }

    /* access modifiers changed from: protected */
    public void drawSeries(XYSeries series, Canvas canvas, Paint paint, List<Float> pointsList, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, XYMultipleSeriesRenderer.Orientation or, int startIndex) {
        this.mCharts[seriesIndex].setScreenR(getScreenR());
        this.mCharts[seriesIndex].setCalcRange(getCalcRange(this.mDataset.getSeriesAt(seriesIndex).getScaleNumber()), 0);
        this.mCharts[seriesIndex].drawSeries(series, canvas, paint, pointsList, seriesRenderer, yAxisValue, 0, or, startIndex);
    }

    public int getLegendShapeWidth(int seriesIndex) {
        return this.mCharts[seriesIndex].getLegendShapeWidth(0);
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        this.mCharts[seriesIndex].drawLegendShape(canvas, renderer, x, y, 0, paint);
    }

    public String getChartType() {
        return "Combined";
    }
}
