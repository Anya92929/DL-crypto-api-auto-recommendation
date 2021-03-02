package com.google.android.gms.fitness.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AggregateDataTypes {
    public static final DataType ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", Fields.ACTIVITY, Fields.DURATION, Fields.NUM_SEGMENTS);
    public static final DataType DISTANCE_DELTA = DataTypes.DISTANCE_DELTA;
    public static final DataType HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", Fields.AVERAGE, Fields.MAX, Fields.MIN);
    public static final Set<DataType> INPUT_TYPES = new HashSet(Arrays.asList(new DataType[]{DataTypes.STEP_COUNT_DELTA, DataTypes.DISTANCE_DELTA, DataTypes.ACTIVITY_SEGMENT, DataTypes.SPEED, DataTypes.HEART_RATE_BPM, DataTypes.WEIGHT, DataTypes.LOCATION_SAMPLE}));
    public static final DataType LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", Fields.LOW_LATITUDE, Fields.LOW_LONGITUDE, Fields.HIGH_LATITUDE, Fields.HIGH_LONGITUDE);
    public static final DataType POWER_SUMMARY = new DataType("com.google.power.summary", Fields.AVERAGE, Fields.MAX, Fields.MIN);
    public static final DataType SPEED_SUMMARY = new DataType("com.google.speed.summary", Fields.AVERAGE, Fields.MAX, Fields.MIN);
    public static final DataType STEP_COUNT_DELTA = DataTypes.STEP_COUNT_DELTA;

    /* renamed from: Sm */
    public static final DataType[] f1283Sm = {ACTIVITY_SUMMARY, DISTANCE_DELTA, HEART_RATE_SUMMARY, LOCATION_BOUNDING_BOX, POWER_SUMMARY, SPEED_SUMMARY, STEP_COUNT_DELTA, WEIGHT_SUMMARY};

    /* renamed from: Sn */
    public static final String[] f1284Sn = {ACTIVITY_SUMMARY.getName(), DISTANCE_DELTA.getName(), HEART_RATE_SUMMARY.getName(), LOCATION_BOUNDING_BOX.getName(), POWER_SUMMARY.getName(), SPEED_SUMMARY.getName(), STEP_COUNT_DELTA.getName(), WEIGHT_SUMMARY.getName()};

    /* renamed from: So */
    private static final Map<DataType, List<DataType>> f1285So = new HashMap<DataType, List<DataType>>() {
        {
            put(DataTypes.STEP_COUNT_DELTA, Arrays.asList(new DataType[]{DataTypes.STEP_COUNT_DELTA}));
            put(DataTypes.DISTANCE_DELTA, Arrays.asList(new DataType[]{DataTypes.DISTANCE_DELTA}));
            put(DataTypes.ACTIVITY_SEGMENT, Arrays.asList(new DataType[]{AggregateDataTypes.ACTIVITY_SUMMARY}));
            put(DataTypes.SPEED, Arrays.asList(new DataType[]{AggregateDataTypes.SPEED_SUMMARY}));
            put(DataTypes.HEART_RATE_BPM, Arrays.asList(new DataType[]{AggregateDataTypes.HEART_RATE_SUMMARY}));
            put(DataTypes.WEIGHT, Arrays.asList(new DataType[]{AggregateDataTypes.WEIGHT_SUMMARY}));
            put(DataTypes.LOCATION_SAMPLE, Arrays.asList(new DataType[]{AggregateDataTypes.LOCATION_BOUNDING_BOX}));
        }
    };
    public static final DataType WEIGHT_SUMMARY = new DataType("com.google.weight.summary", Fields.AVERAGE, Fields.MAX, Fields.MIN);

    private AggregateDataTypes() {
    }

    public static List<DataType> getForInput(DataType inputDataType) {
        List list = f1285So.get(inputDataType);
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }
}
