package com.google.zxing.pdf417.detector;

import com.actionbarsherlock.widget.ActivityChooserView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import java.util.Arrays;
import java.util.Map;

public final class Detector {
    private static final int INTEGER_MATH_SHIFT = 8;
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;
    private static final int PATTERN_MATCH_RESULT_SCALE_FACTOR = 256;
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] START_PATTERN_REVERSE = {3, 1, 1, 1, 1, 1, 1, 8};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static final int[] STOP_PATTERN_REVERSE = {1, 2, 1, 1, 1, 3, 1, 1, 7};
    private final BinaryBitmap image;

    public Detector(BinaryBitmap image2) {
        this.image = image2;
    }

    public DetectorResult detect() throws NotFoundException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException {
        BitMatrix matrix = this.image.getBlackMatrix();
        ResultPoint[] vertices = findVertices(matrix, 8);
        if (vertices == null) {
            vertices = findVertices180(matrix, 8);
            if (vertices != null) {
                correctVertices(matrix, vertices, true);
            }
        } else {
            correctVertices(matrix, vertices, false);
        }
        if (vertices == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float moduleWidth = computeModuleWidth(vertices);
        if (moduleWidth < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int dimension = computeDimension(vertices[12], vertices[14], vertices[13], vertices[15], moduleWidth);
        if (dimension < 1) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new DetectorResult(new LinesSampler(sampleLines(vertices, dimension, Math.max(computeYDimension(vertices[12], vertices[14], vertices[13], vertices[15], moduleWidth), dimension)), dimension).sample(), new ResultPoint[]{vertices[5], vertices[4], vertices[6], vertices[7]});
    }

    private static ResultPoint[] findVertices(BitMatrix matrix, int rowStep) {
        int height = matrix.getHeight();
        int width = matrix.getWidth();
        ResultPoint[] result = new ResultPoint[16];
        boolean found = false;
        int[] counters = new int[START_PATTERN.length];
        int i = 0;
        while (true) {
            if (i >= height) {
                break;
            }
            int[] loc = findGuardPattern(matrix, 0, i, width, false, START_PATTERN, counters);
            if (loc != null) {
                result[0] = new ResultPoint((float) loc[0], (float) i);
                result[4] = new ResultPoint((float) loc[1], (float) i);
                found = true;
                break;
            }
            i += rowStep;
        }
        if (found) {
            found = false;
            int i2 = height - 1;
            while (true) {
                if (i2 <= 0) {
                    break;
                }
                int[] loc2 = findGuardPattern(matrix, 0, i2, width, false, START_PATTERN, counters);
                if (loc2 != null) {
                    result[1] = new ResultPoint((float) loc2[0], (float) i2);
                    result[5] = new ResultPoint((float) loc2[1], (float) i2);
                    found = true;
                    break;
                }
                i2 -= rowStep;
            }
        }
        int[] counters2 = new int[STOP_PATTERN.length];
        if (found) {
            found = false;
            int i3 = 0;
            while (true) {
                if (i3 >= height) {
                    break;
                }
                int[] loc3 = findGuardPattern(matrix, 0, i3, width, false, STOP_PATTERN, counters2);
                if (loc3 != null) {
                    result[2] = new ResultPoint((float) loc3[1], (float) i3);
                    result[6] = new ResultPoint((float) loc3[0], (float) i3);
                    found = true;
                    break;
                }
                i3 += rowStep;
            }
        }
        if (found) {
            found = false;
            int i4 = height - 1;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                int[] loc4 = findGuardPattern(matrix, 0, i4, width, false, STOP_PATTERN, counters2);
                if (loc4 != null) {
                    result[3] = new ResultPoint((float) loc4[1], (float) i4);
                    result[7] = new ResultPoint((float) loc4[0], (float) i4);
                    found = true;
                    break;
                }
                i4 -= rowStep;
            }
        }
        if (found) {
            return result;
        }
        return null;
    }

    private static ResultPoint[] findVertices180(BitMatrix matrix, int rowStep) {
        int height = matrix.getHeight();
        int halfWidth = matrix.getWidth() >> 1;
        ResultPoint[] result = new ResultPoint[16];
        boolean found = false;
        int[] counters = new int[START_PATTERN_REVERSE.length];
        int i = height - 1;
        while (true) {
            if (i <= 0) {
                break;
            }
            int[] loc = findGuardPattern(matrix, halfWidth, i, halfWidth, true, START_PATTERN_REVERSE, counters);
            if (loc != null) {
                result[0] = new ResultPoint((float) loc[1], (float) i);
                result[4] = new ResultPoint((float) loc[0], (float) i);
                found = true;
                break;
            }
            i -= rowStep;
        }
        if (found) {
            found = false;
            int i2 = 0;
            while (true) {
                if (i2 >= height) {
                    break;
                }
                int[] loc2 = findGuardPattern(matrix, halfWidth, i2, halfWidth, true, START_PATTERN_REVERSE, counters);
                if (loc2 != null) {
                    result[1] = new ResultPoint((float) loc2[1], (float) i2);
                    result[5] = new ResultPoint((float) loc2[0], (float) i2);
                    found = true;
                    break;
                }
                i2 += rowStep;
            }
        }
        int[] counters2 = new int[STOP_PATTERN_REVERSE.length];
        if (found) {
            found = false;
            int i3 = height - 1;
            while (true) {
                if (i3 <= 0) {
                    break;
                }
                int[] loc3 = findGuardPattern(matrix, 0, i3, halfWidth, false, STOP_PATTERN_REVERSE, counters2);
                if (loc3 != null) {
                    result[2] = new ResultPoint((float) loc3[0], (float) i3);
                    result[6] = new ResultPoint((float) loc3[1], (float) i3);
                    found = true;
                    break;
                }
                i3 -= rowStep;
            }
        }
        if (found) {
            found = false;
            int i4 = 0;
            while (true) {
                if (i4 >= height) {
                    break;
                }
                int[] loc4 = findGuardPattern(matrix, 0, i4, halfWidth, false, STOP_PATTERN_REVERSE, counters2);
                if (loc4 != null) {
                    result[3] = new ResultPoint((float) loc4[0], (float) i4);
                    result[7] = new ResultPoint((float) loc4[1], (float) i4);
                    found = true;
                    break;
                }
                i4 += rowStep;
            }
        }
        if (found) {
            return result;
        }
        return null;
    }

    private static int[] findGuardPattern(BitMatrix matrix, int column, int row, int width, boolean whiteFirst, int[] pattern, int[] counters) {
        Arrays.fill(counters, 0, counters.length, 0);
        int patternLength = pattern.length;
        boolean isWhite = whiteFirst;
        int counterPosition = 0;
        int patternStart = column;
        for (int x = column; x < column + width; x++) {
            if (matrix.get(x, row) ^ isWhite) {
                counters[counterPosition] = counters[counterPosition] + 1;
            } else {
                if (counterPosition != patternLength - 1) {
                    counterPosition++;
                } else if (patternMatchVariance(counters, pattern, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                    return new int[]{patternStart, x};
                } else {
                    patternStart += counters[0] + counters[1];
                    System.arraycopy(counters, 2, counters, 0, patternLength - 2);
                    counters[patternLength - 2] = 0;
                    counters[patternLength - 1] = 0;
                    counterPosition--;
                }
                counters[counterPosition] = 1;
                isWhite = !isWhite;
            }
        }
        return null;
    }

    private static int patternMatchVariance(int[] counters, int[] pattern, int maxIndividualVariance) {
        int numCounters = counters.length;
        int total = 0;
        int patternLength = 0;
        for (int i = 0; i < numCounters; i++) {
            total += counters[i];
            patternLength += pattern[i];
        }
        if (total < patternLength) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        int unitBarWidth = (total << 8) / patternLength;
        int maxIndividualVariance2 = (maxIndividualVariance * unitBarWidth) >> 8;
        int totalVariance = 0;
        for (int x = 0; x < numCounters; x++) {
            int counter = counters[x] << 8;
            int scaledPattern = pattern[x] * unitBarWidth;
            int variance = counter > scaledPattern ? counter - scaledPattern : scaledPattern - counter;
            if (variance > maxIndividualVariance2) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            totalVariance += variance;
        }
        return totalVariance / total;
    }

    private static void correctVertices(BitMatrix matrix, ResultPoint[] vertices, boolean upsideDown) throws NotFoundException {
        boolean isLowLeft = ((double) Math.abs(vertices[4].getY() - vertices[5].getY())) < 20.0d;
        boolean isLowRight = ((double) Math.abs(vertices[6].getY() - vertices[7].getY())) < 20.0d;
        if (isLowLeft || isLowRight) {
            throw NotFoundException.getNotFoundInstance();
        }
        findWideBarTopBottom(matrix, vertices, 0, 0, 8, 17, upsideDown ? 1 : -1);
        findWideBarTopBottom(matrix, vertices, 1, 0, 8, 17, upsideDown ? -1 : 1);
        findWideBarTopBottom(matrix, vertices, 2, 11, 7, 18, upsideDown ? 1 : -1);
        findWideBarTopBottom(matrix, vertices, 3, 11, 7, 18, upsideDown ? -1 : 1);
        findCrossingPoint(vertices, 12, 4, 5, 8, 10, matrix);
        findCrossingPoint(vertices, 13, 4, 5, 9, 11, matrix);
        findCrossingPoint(vertices, 14, 6, 7, 8, 10, matrix);
        findCrossingPoint(vertices, 15, 6, 7, 9, 11, matrix);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void findWideBarTopBottom(com.google.zxing.common.BitMatrix r16, com.google.zxing.ResultPoint[] r17, int r18, int r19, int r20, int r21, int r22) {
        /*
            r8 = r17[r18]
            int r12 = r18 + 4
            r7 = r17[r12]
            int r4 = r19 + r20
            float r12 = r7.getX()
            float r13 = r8.getX()
            float r1 = r12 - r13
            float r12 = r8.getX()
            r0 = r19
            float r13 = (float) r0
            float r13 = r13 * r1
            r0 = r21
            float r14 = (float) r0
            float r13 = r13 / r14
            float r3 = r12 + r13
            float r12 = r8.getX()
            float r13 = (float) r4
            float r13 = r13 * r1
            r0 = r21
            float r14 = (float) r0
            float r13 = r13 / r14
            float r2 = r12 + r13
            float r12 = r3 + r2
            r13 = 1073741824(0x40000000, float:2.0)
            float r12 = r12 / r13
            int r9 = java.lang.Math.round(r12)
            float r12 = r8.getY()
            int r11 = java.lang.Math.round(r12)
            r10 = r11
            float r12 = java.lang.Math.max(r3, r2)
            int r12 = (int) r12
            int r6 = r12 + 1
        L_0x0045:
            int r12 = r16.getWidth()
            if (r6 >= r12) goto L_0x005d
            int r12 = r6 + -1
            r0 = r16
            boolean r12 = r0.get(r12, r10)
            if (r12 != 0) goto L_0x008e
            r0 = r16
            boolean r12 = r0.get(r6, r10)
            if (r12 == 0) goto L_0x008e
        L_0x005d:
            int r6 = r6 - r9
            r5 = 0
        L_0x005f:
            if (r5 != 0) goto L_0x00bd
            r0 = r16
            boolean r12 = r0.get(r9, r10)
            if (r12 == 0) goto L_0x0093
            int r12 = r9 + r6
            r0 = r16
            boolean r12 = r0.get(r12, r10)
            if (r12 != 0) goto L_0x0091
            int r12 = r9 + r6
            int r12 = r12 + 1
            r0 = r16
            boolean r12 = r0.get(r12, r10)
            if (r12 != 0) goto L_0x0091
            r5 = 1
        L_0x0080:
            int r10 = r10 + r22
            if (r10 <= 0) goto L_0x008c
            int r12 = r16.getHeight()
            int r12 = r12 + -1
            if (r10 < r12) goto L_0x005f
        L_0x008c:
            r5 = 1
            goto L_0x005f
        L_0x008e:
            int r6 = r6 + 1
            goto L_0x0045
        L_0x0091:
            r5 = 0
            goto L_0x0080
        L_0x0093:
            if (r9 <= 0) goto L_0x00a2
            int r12 = r9 + -1
            r0 = r16
            boolean r12 = r0.get(r12, r10)
            if (r12 == 0) goto L_0x00a2
            int r9 = r9 + -1
            goto L_0x005f
        L_0x00a2:
            int r12 = r16.getWidth()
            int r12 = r12 + -1
            if (r9 >= r12) goto L_0x00b7
            int r12 = r9 + 1
            r0 = r16
            boolean r12 = r0.get(r12, r10)
            if (r12 == 0) goto L_0x00b7
            int r9 = r9 + 1
            goto L_0x005f
        L_0x00b7:
            r5 = 1
            if (r10 == r11) goto L_0x005f
            int r10 = r10 - r22
            goto L_0x005f
        L_0x00bd:
            int r12 = r18 + 8
            com.google.zxing.ResultPoint r13 = new com.google.zxing.ResultPoint
            float r14 = (float) r9
            float r15 = (float) r10
            r13.<init>(r14, r15)
            r17[r12] = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.findWideBarTopBottom(com.google.zxing.common.BitMatrix, com.google.zxing.ResultPoint[], int, int, int, int, int):void");
    }

    private static void findCrossingPoint(ResultPoint[] vertices, int idxResult, int idxLineA1, int idxLineA2, int idxLineB1, int idxLineB2, BitMatrix matrix) throws NotFoundException {
        ResultPoint result = intersection(vertices[idxLineA1], vertices[idxLineA2], vertices[idxLineB1], vertices[idxLineB2]);
        if (result == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int x = Math.round(result.getX());
        int y = Math.round(result.getY());
        if (x < 0 || x >= matrix.getWidth() || y < 0 || y >= matrix.getHeight()) {
            throw NotFoundException.getNotFoundInstance();
        }
        vertices[idxResult] = result;
    }

    private static ResultPoint intersection(ResultPoint a1, ResultPoint a2, ResultPoint b1, ResultPoint b2) {
        float dxa = a1.getX() - a2.getX();
        float dxb = b1.getX() - b2.getX();
        float dya = a1.getY() - a2.getY();
        float dyb = b1.getY() - b2.getY();
        float p = (a1.getX() * a2.getY()) - (a1.getY() * a2.getX());
        float q = (b1.getX() * b2.getY()) - (b1.getY() * b2.getX());
        float denom = (dxa * dyb) - (dya * dxb);
        if (denom == BitmapDescriptorFactory.HUE_RED) {
            return null;
        }
        return new ResultPoint(((p * dxb) - (dxa * q)) / denom, ((p * dyb) - (dya * q)) / denom);
    }

    private static float computeModuleWidth(ResultPoint[] vertices) {
        return (((ResultPoint.distance(vertices[0], vertices[4]) + ResultPoint.distance(vertices[1], vertices[5])) / 34.0f) + ((ResultPoint.distance(vertices[6], vertices[2]) + ResultPoint.distance(vertices[7], vertices[3])) / 36.0f)) / 2.0f;
    }

    private static int computeDimension(ResultPoint topLeft, ResultPoint topRight, ResultPoint bottomLeft, ResultPoint bottomRight, float moduleWidth) {
        return ((((MathUtils.round(ResultPoint.distance(topLeft, topRight) / moduleWidth) + MathUtils.round(ResultPoint.distance(bottomLeft, bottomRight) / moduleWidth)) >> 1) + 8) / 17) * 17;
    }

    private static int computeYDimension(ResultPoint topLeft, ResultPoint topRight, ResultPoint bottomLeft, ResultPoint bottomRight, float moduleWidth) {
        return (MathUtils.round(ResultPoint.distance(topLeft, bottomLeft) / moduleWidth) + MathUtils.round(ResultPoint.distance(topRight, bottomRight) / moduleWidth)) >> 1;
    }

    private BitMatrix sampleLines(ResultPoint[] vertices, int dimension, int yDimension) throws NotFoundException {
        int sampleDimensionX = dimension * 8;
        int sampleDimensionY = yDimension * 4;
        return GridSampler.getInstance().sampleGrid(this.image.getBlackMatrix(), sampleDimensionX, sampleDimensionY, PerspectiveTransform.quadrilateralToQuadrilateral(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) sampleDimensionX, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) sampleDimensionY, (float) sampleDimensionX, (float) sampleDimensionY, vertices[12].getX(), vertices[12].getY(), vertices[14].getX(), vertices[14].getY(), vertices[13].getX(), vertices[13].getY(), vertices[15].getX(), vertices[15].getY()));
    }
}
