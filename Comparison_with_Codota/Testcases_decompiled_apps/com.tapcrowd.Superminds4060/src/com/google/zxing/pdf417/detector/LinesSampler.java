package com.google.zxing.pdf417.detector;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.decoder.BitMatrixParser;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LinesSampler {
    private static final int BARCODE_START_OFFSET = 2;
    private static final int BARS_IN_SYMBOL = 8;
    private static final int MODULES_IN_SYMBOL = 17;
    private static final float[] RATIOS_TABLE = new float[(BitMatrixParser.SYMBOL_TABLE.length * 8)];
    private final int dimension;
    private final BitMatrix linesMatrix;
    private final int symbolsPerLine;

    static {
        float[][] table = (float[][]) Array.newInstance(Float.TYPE, new int[]{BitMatrixParser.SYMBOL_TABLE.length, 8});
        int x = 0;
        for (int i = 0; i < BitMatrixParser.SYMBOL_TABLE.length; i++) {
            int currentSymbol = BitMatrixParser.SYMBOL_TABLE[i];
            int currentBit = currentSymbol & 1;
            for (int j = 0; j < 8; j++) {
                float size = BitmapDescriptorFactory.HUE_RED;
                while ((currentSymbol & 1) == currentBit) {
                    size += 1.0f;
                    currentSymbol >>= 1;
                }
                currentBit = currentSymbol & 1;
                table[i][(8 - j) - 1] = size / 17.0f;
            }
            for (int j2 = 0; j2 < 8; j2++) {
                RATIOS_TABLE[x] = table[i][j2];
                x++;
            }
        }
    }

    public LinesSampler(BitMatrix linesMatrix2, int dimension2) {
        this.linesMatrix = linesMatrix2;
        this.symbolsPerLine = dimension2 / 17;
        this.dimension = dimension2;
    }

    public BitMatrix sample() throws NotFoundException {
        List<Float> symbolWidths = findSymbolWidths();
        int[][] codewords = new int[this.linesMatrix.getHeight()][];
        int[][] clusterNumbers = new int[this.linesMatrix.getHeight()][];
        linesMatrixToCodewords(codewords, clusterNumbers, symbolWidths);
        List<List<Map<Integer, Integer>>> votes = distributeVotes(codewords, clusterNumbers);
        List<List<Integer>> detectedCodeWords = new ArrayList<>();
        resize3(detectedCodeWords, votes.size());
        for (int i = 0; i < votes.size(); i++) {
            resize4(detectedCodeWords.get(i), votes.get(i).size());
            for (int j = 0; j < votes.get(i).size(); j++) {
                if (!((Map) votes.get(i).get(j)).isEmpty()) {
                    detectedCodeWords.get(i).set(j, Integer.valueOf(getValueWithMaxVotes((Map) votes.get(i).get(j)).getVote()));
                }
            }
        }
        resize3(detectedCodeWords, decodeRowCount(detectedCodeWords, findMissingLines(detectedCodeWords)));
        return codewordsToBitMatrix(detectedCodeWords, this.dimension, detectedCodeWords.size());
    }

    private List<Float> findSymbolWidths() {
        float expectedSymbolWidth;
        if (this.symbolsPerLine > 0) {
            expectedSymbolWidth = ((float) this.linesMatrix.getWidth()) / ((float) this.symbolsPerLine);
        } else {
            expectedSymbolWidth = (float) this.linesMatrix.getWidth();
        }
        List<Float> symbolWidths = new ArrayList<>();
        int symbolStart = 0;
        boolean lastWasSymbolStart = true;
        int[] blackCount = new int[this.linesMatrix.getWidth()];
        for (int x = 2; x < this.linesMatrix.getWidth(); x++) {
            for (int y = 0; y < this.linesMatrix.getHeight(); y++) {
                if (this.linesMatrix.get(x, y)) {
                    blackCount[x] = blackCount[x] + 1;
                }
            }
            if (blackCount[x] == this.linesMatrix.getHeight()) {
                if (!lastWasSymbolStart) {
                    float currentWidth = (float) (x - symbolStart);
                    if (((double) currentWidth) > 0.75d * ((double) expectedSymbolWidth)) {
                        while (((double) currentWidth) > 1.5d * ((double) expectedSymbolWidth)) {
                            symbolWidths.add(Float.valueOf(expectedSymbolWidth));
                            currentWidth -= expectedSymbolWidth;
                        }
                        symbolWidths.add(Float.valueOf(currentWidth));
                        lastWasSymbolStart = true;
                        symbolStart = x;
                    }
                }
            } else if (lastWasSymbolStart) {
                lastWasSymbolStart = false;
            }
        }
        float currentWidth2 = (float) (this.linesMatrix.getWidth() - symbolStart);
        while (((double) currentWidth2) > 1.5d * ((double) expectedSymbolWidth)) {
            symbolWidths.add(Float.valueOf(expectedSymbolWidth));
            currentWidth2 -= expectedSymbolWidth;
        }
        symbolWidths.add(Float.valueOf(currentWidth2));
        return symbolWidths;
    }

    private void linesMatrixToCodewords(int[][] codewords, int[][] clusterNumbers, List<Float> symbolWidths) throws NotFoundException {
        if (this.symbolsPerLine > symbolWidths.size()) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int y = 0; y < this.linesMatrix.getHeight(); y++) {
            codewords[y] = new int[this.symbolsPerLine];
            clusterNumbers[y] = new int[this.symbolsPerLine];
            Arrays.fill(clusterNumbers[y], 0, clusterNumbers[y].length, -1);
            List<Integer> barWidths = new ArrayList<>();
            barWidths.add(2);
            boolean isSetBar = true;
            for (int x = 2; x < this.linesMatrix.getWidth(); x++) {
                if (this.linesMatrix.get(x, y)) {
                    if (!isSetBar) {
                        isSetBar = true;
                        barWidths.add((Integer) null);
                    }
                } else if (isSetBar) {
                    isSetBar = false;
                    barWidths.add((Integer) null);
                }
                int lastIndex = barWidths.size() - 1;
                barWidths.set(lastIndex, Integer.valueOf(barWidths.get(lastIndex).intValue() + 1));
            }
            int[] cwStarts = new int[this.symbolsPerLine];
            cwStarts[0] = 0;
            int cwCount = 1;
            int cwWidth = 0;
            int i = 0;
            while (i < barWidths.size() && cwCount < this.symbolsPerLine) {
                cwWidth += barWidths.get(i).intValue();
                if (((float) cwWidth) > symbolWidths.get(cwCount - 1).floatValue()) {
                    if (i % 2 == 1) {
                        i++;
                    }
                    if (i < barWidths.size()) {
                        cwWidth = barWidths.get(i).intValue();
                    }
                    cwStarts[cwCount] = i;
                    cwCount++;
                }
                i++;
            }
            float[][] cwRatios = (float[][]) Array.newInstance(Float.TYPE, new int[]{this.symbolsPerLine, 8});
            int i2 = 0;
            while (i2 < this.symbolsPerLine) {
                int cwStart = cwStarts[i2];
                int cwLength = (i2 == this.symbolsPerLine + -1 ? barWidths.size() : cwStarts[i2 + 1]) - cwStart;
                if (cwLength >= 7 && cwLength <= 9) {
                    float cwWidthF = BitmapDescriptorFactory.HUE_RED;
                    for (int j = 0; j < Math.min(8, cwLength); j++) {
                        cwWidthF += (float) barWidths.get(cwStart + j).intValue();
                    }
                    if (cwLength == 7) {
                        for (int j2 = 0; j2 < cwLength; j2++) {
                            cwRatios[i2][j2] = ((float) barWidths.get(cwStart + j2).intValue()) / symbolWidths.get(i2).floatValue();
                        }
                        cwRatios[i2][7] = (symbolWidths.get(i2).floatValue() - cwWidthF) / symbolWidths.get(i2).floatValue();
                    } else {
                        for (int j3 = 0; j3 < cwRatios[i2].length; j3++) {
                            cwRatios[i2][j3] = ((float) barWidths.get(cwStart + j3).intValue()) / cwWidthF;
                        }
                    }
                    float bestMatchError = Float.MAX_VALUE;
                    int bestMatch = 0;
                    for (int j4 = 0; j4 < BitMatrixParser.SYMBOL_TABLE.length; j4++) {
                        float error = BitmapDescriptorFactory.HUE_RED;
                        for (int k = 0; k < 8; k++) {
                            float diff = RATIOS_TABLE[(j4 * 8) + k] - cwRatios[i2][k];
                            error += diff * diff;
                        }
                        if (error < bestMatchError) {
                            bestMatchError = error;
                            bestMatch = BitMatrixParser.SYMBOL_TABLE[j4];
                        }
                    }
                    codewords[y][i2] = bestMatch;
                    clusterNumbers[y][i2] = calculateClusterNumber(bestMatch);
                }
                i2++;
            }
        }
    }

    private List<List<Map<Integer, Integer>>> distributeVotes(int[][] codewords, int[][] clusterNumbers) {
        List<List<Map<Integer, Integer>>> votes = new ArrayList<>();
        votes.add(new ArrayList());
        resize2(votes.get(0), this.symbolsPerLine);
        int currentRow = 0;
        Map<Integer, Integer> clusterNumberVotes = new HashMap<>();
        int lastLineClusterNumber = -1;
        for (int y = 0; y < codewords.length; y++) {
            clusterNumberVotes.clear();
            for (int i = 0; i < codewords[y].length; i++) {
                if (clusterNumbers[y][i] != -1) {
                    clusterNumberVotes.put(Integer.valueOf(clusterNumbers[y][i]), Integer.valueOf(((Integer) defaultValue(clusterNumberVotes.get(Integer.valueOf(clusterNumbers[y][i])), 0)).intValue() + 1));
                }
            }
            if (!clusterNumberVotes.isEmpty()) {
                VoteResult voteResult = getValueWithMaxVotes(clusterNumberVotes);
                boolean lineClusterNumberIsIndecisive = voteResult.isIndecisive();
                int lineClusterNumber = voteResult.getVote();
                if (lineClusterNumberIsIndecisive) {
                    lineClusterNumber = lastLineClusterNumber;
                }
                if (!(lineClusterNumber == (lastLineClusterNumber + 3) % 9 || lastLineClusterNumber == -1)) {
                    lineClusterNumber = lastLineClusterNumber;
                }
                if ((lineClusterNumber == 0 && lastLineClusterNumber == -1) || lastLineClusterNumber != -1) {
                    if (lineClusterNumber == (lastLineClusterNumber + 3) % 9 && lastLineClusterNumber != -1) {
                        currentRow++;
                        if (votes.size() < currentRow + 1) {
                            resize1(votes, currentRow + 1);
                            resize2(votes.get(currentRow), this.symbolsPerLine);
                        }
                    }
                    if (lineClusterNumber == (lastLineClusterNumber + 6) % 9 && lastLineClusterNumber != -1) {
                        currentRow += 2;
                        if (votes.size() < currentRow + 1) {
                            resize1(votes, currentRow + 1);
                            resize2(votes.get(currentRow), this.symbolsPerLine);
                        }
                    }
                    for (int i2 = 0; i2 < codewords[y].length; i2++) {
                        if (clusterNumbers[y][i2] != -1) {
                            if (clusterNumbers[y][i2] == lineClusterNumber) {
                                Map<Integer, Integer> votesMap = (Map) votes.get(currentRow).get(i2);
                                votesMap.put(Integer.valueOf(codewords[y][i2]), Integer.valueOf(((Integer) defaultValue(votesMap.get(Integer.valueOf(codewords[y][i2])), 0)).intValue() + 1));
                            } else if (clusterNumbers[y][i2] == (lineClusterNumber + 3) % 9) {
                                if (votes.size() < currentRow + 2) {
                                    resize1(votes, currentRow + 2);
                                    resize2(votes.get(currentRow + 1), this.symbolsPerLine);
                                }
                                Map<Integer, Integer> votesMap2 = (Map) votes.get(currentRow + 1).get(i2);
                                votesMap2.put(Integer.valueOf(codewords[y][i2]), Integer.valueOf(((Integer) defaultValue(votesMap2.get(Integer.valueOf(codewords[y][i2])), 0)).intValue() + 1));
                            } else if (clusterNumbers[y][i2] == (lineClusterNumber + 6) % 9 && currentRow > 0) {
                                Map<Integer, Integer> votesMap3 = (Map) votes.get(currentRow - 1).get(i2);
                                votesMap3.put(Integer.valueOf(codewords[y][i2]), Integer.valueOf(((Integer) defaultValue(votesMap3.get(Integer.valueOf(codewords[y][i2])), 0)).intValue() + 1));
                            }
                        }
                    }
                    lastLineClusterNumber = lineClusterNumber;
                }
            }
        }
        return votes;
    }

    private List<Integer> findMissingLines(List<List<Integer>> detectedCodeWords) {
        List<Integer> insertLinesAt = new ArrayList<>();
        if (detectedCodeWords.size() > 1) {
            for (int i = 0; i < detectedCodeWords.size() - 1; i++) {
                int clusterNumberRow = -1;
                for (int j = 0; j < detectedCodeWords.get(i).size() && clusterNumberRow == -1; j++) {
                    int clusterNumber = calculateClusterNumber(((Integer) detectedCodeWords.get(i).get(j)).intValue());
                    if (clusterNumber != -1) {
                        clusterNumberRow = clusterNumber;
                    }
                }
                if (i == 0 && clusterNumberRow > 0) {
                    insertLinesAt.add(0);
                    if (clusterNumberRow > 3) {
                        insertLinesAt.add(0);
                    }
                }
                int clusterNumberNextRow = -1;
                for (int j2 = 0; j2 < detectedCodeWords.get(i + 1).size() && clusterNumberNextRow == -1; j2++) {
                    int clusterNumber2 = calculateClusterNumber(((Integer) detectedCodeWords.get(i + 1).get(j2)).intValue());
                    if (clusterNumber2 != -1) {
                        clusterNumberNextRow = clusterNumber2;
                    }
                }
                if (!((clusterNumberRow + 3) % 9 == clusterNumberNextRow || clusterNumberRow == -1 || clusterNumberNextRow == -1)) {
                    insertLinesAt.add(Integer.valueOf(i + 1));
                    if (clusterNumberRow == clusterNumberNextRow) {
                        insertLinesAt.add(Integer.valueOf(i + 1));
                    }
                }
            }
        }
        for (int i2 = 0; i2 < insertLinesAt.size(); i2++) {
            List<Integer> v = new ArrayList<>();
            for (int j3 = 0; j3 < this.symbolsPerLine; j3++) {
                v.add(0);
            }
            detectedCodeWords.add(insertLinesAt.get(i2).intValue() + i2, v);
        }
        return insertLinesAt;
    }

    private int decodeRowCount(List<List<Integer>> detectedCodeWords, List<Integer> insertLinesAt) {
        insertLinesAt.clear();
        Map<Integer, Integer> rowCountVotes = new HashMap<>();
        Map<Integer, Integer> ecLevelVotes = new HashMap<>();
        HashMap hashMap = new HashMap();
        int lastRowNumber = -1;
        for (int i = 0; i + 2 < detectedCodeWords.size(); i += 3) {
            hashMap.clear();
            int firstCodewordDecodedLeft = -1;
            if (((Integer) detectedCodeWords.get(i).get(0)).intValue() != 0) {
                firstCodewordDecodedLeft = BitMatrixParser.getCodeword((long) ((Integer) detectedCodeWords.get(i).get(0)).intValue());
            }
            int secondCodewordDecodedLeft = -1;
            if (((Integer) detectedCodeWords.get(i + 1).get(0)).intValue() != 0) {
                secondCodewordDecodedLeft = BitMatrixParser.getCodeword((long) ((Integer) detectedCodeWords.get(i + 1).get(0)).intValue());
            }
            int thirdCodewordDecodedLeft = -1;
            if (((Integer) detectedCodeWords.get(i + 2).get(0)).intValue() != 0) {
                thirdCodewordDecodedLeft = BitMatrixParser.getCodeword((long) ((Integer) detectedCodeWords.get(i + 2).get(0)).intValue());
            }
            int firstCodewordDecodedRight = -1;
            if (((Integer) detectedCodeWords.get(i).get(detectedCodeWords.get(i).size() - 1)).intValue() != 0) {
                firstCodewordDecodedRight = BitMatrixParser.getCodeword((long) ((Integer) detectedCodeWords.get(i).get(detectedCodeWords.get(i).size() - 1)).intValue());
            }
            int secondCodewordDecodedRight = -1;
            if (((Integer) detectedCodeWords.get(i + 1).get(detectedCodeWords.get(i + 1).size() - 1)).intValue() != 0) {
                secondCodewordDecodedRight = BitMatrixParser.getCodeword((long) ((Integer) detectedCodeWords.get(i + 1).get(detectedCodeWords.get(i + 1).size() - 1)).intValue());
            }
            int thirdCodewordDecodedRight = -1;
            if (((Integer) detectedCodeWords.get(i + 2).get(detectedCodeWords.get(i + 2).size() - 1)).intValue() != 0) {
                thirdCodewordDecodedRight = BitMatrixParser.getCodeword((long) ((Integer) detectedCodeWords.get(i + 2).get(detectedCodeWords.get(i + 2).size() - 1)).intValue());
            }
            if (!(firstCodewordDecodedLeft == -1 || secondCodewordDecodedLeft == -1)) {
                int leftRowCount = ((firstCodewordDecodedLeft % 30) * 3) + ((secondCodewordDecodedLeft % 30) % 3);
                int leftECLevel = (secondCodewordDecodedLeft % 30) / 3;
                rowCountVotes.put(Integer.valueOf(leftRowCount), Integer.valueOf(((Integer) defaultValue(rowCountVotes.get(Integer.valueOf(leftRowCount)), (Integer) null)).intValue() + 1));
                ecLevelVotes.put(Integer.valueOf(leftECLevel), Integer.valueOf(((Integer) defaultValue(ecLevelVotes.get(Integer.valueOf(leftECLevel)), (Integer) null)).intValue() + 1));
            }
            if (!(secondCodewordDecodedRight == -1 || thirdCodewordDecodedRight == -1)) {
                int rightRowCount = ((secondCodewordDecodedRight % 30) * 3) + ((thirdCodewordDecodedRight % 30) % 3);
                int rightECLevel = (thirdCodewordDecodedRight % 30) / 3;
                rowCountVotes.put(Integer.valueOf(rightRowCount), Integer.valueOf(((Integer) defaultValue(rowCountVotes.get(Integer.valueOf(rightRowCount)), (Integer) null)).intValue() + 1));
                ecLevelVotes.put(Integer.valueOf(rightECLevel), Integer.valueOf(((Integer) defaultValue(ecLevelVotes.get(Integer.valueOf(rightECLevel)), (Integer) null)).intValue() + 1));
            }
            if (firstCodewordDecodedLeft != -1) {
                int rowNumber = firstCodewordDecodedLeft / 30;
                hashMap.put(Integer.valueOf(rowNumber), Integer.valueOf(((Integer) defaultValue(hashMap.get(Integer.valueOf(rowNumber)), (Object) null)).intValue() + 1));
            }
            if (secondCodewordDecodedLeft != -1) {
                int rowNumber2 = secondCodewordDecodedLeft / 30;
                hashMap.put(Integer.valueOf(rowNumber2), Integer.valueOf(((Integer) defaultValue(hashMap.get(Integer.valueOf(rowNumber2)), (Object) null)).intValue() + 1));
            }
            if (thirdCodewordDecodedLeft != -1) {
                int rowNumber3 = thirdCodewordDecodedLeft / 30;
                hashMap.put(Integer.valueOf(rowNumber3), Integer.valueOf(((Integer) defaultValue(hashMap.get(Integer.valueOf(rowNumber3)), (Object) null)).intValue() + 1));
            }
            if (firstCodewordDecodedRight != -1) {
                int rowNumber4 = firstCodewordDecodedRight / 30;
                hashMap.put(Integer.valueOf(rowNumber4), Integer.valueOf(((Integer) defaultValue(hashMap.get(Integer.valueOf(rowNumber4)), (Object) null)).intValue() + 1));
            }
            if (secondCodewordDecodedRight != -1) {
                int rowNumber5 = secondCodewordDecodedRight / 30;
                hashMap.put(Integer.valueOf(rowNumber5), Integer.valueOf(((Integer) defaultValue(hashMap.get(Integer.valueOf(rowNumber5)), (Object) null)).intValue() + 1));
            }
            if (thirdCodewordDecodedRight != -1) {
                int rowNumber6 = thirdCodewordDecodedRight / 30;
                hashMap.put(Integer.valueOf(rowNumber6), Integer.valueOf(((Integer) defaultValue(hashMap.get(Integer.valueOf(rowNumber6)), (Object) null)).intValue() + 1));
            }
            int rowNumber7 = getValueWithMaxVotes(hashMap).getVote();
            if (lastRowNumber + 1 < rowNumber7) {
                for (int j = lastRowNumber + 1; j < rowNumber7; j++) {
                    insertLinesAt.add(Integer.valueOf(i));
                    insertLinesAt.add(Integer.valueOf(i));
                    insertLinesAt.add(Integer.valueOf(i));
                }
            }
            lastRowNumber = rowNumber7;
        }
        for (int i2 = 0; i2 < insertLinesAt.size(); i2++) {
            ArrayList arrayList = new ArrayList();
            for (int j2 = 0; j2 < this.symbolsPerLine; j2++) {
                arrayList.add(0);
            }
            detectedCodeWords.add(insertLinesAt.get(i2).intValue() + i2, arrayList);
        }
        return getValueWithMaxVotes(rowCountVotes).getVote() + 1;
    }

    private static class VoteResult {
        private boolean indecisive;
        private int vote;

        private VoteResult() {
        }

        /* access modifiers changed from: package-private */
        public boolean isIndecisive() {
            return this.indecisive;
        }

        /* access modifiers changed from: package-private */
        public void setIndecisive(boolean indecisive2) {
            this.indecisive = indecisive2;
        }

        /* access modifiers changed from: package-private */
        public int getVote() {
            return this.vote;
        }

        /* access modifiers changed from: package-private */
        public void setVote(int vote2) {
            this.vote = vote2;
        }
    }

    private static VoteResult getValueWithMaxVotes(Map<Integer, Integer> votes) {
        VoteResult result = new VoteResult();
        int maxVotes = 0;
        for (Map.Entry<Integer, Integer> entry : votes.entrySet()) {
            if (entry.getValue().intValue() > maxVotes) {
                maxVotes = entry.getValue().intValue();
                result.setVote(entry.getKey().intValue());
                result.setIndecisive(false);
            } else if (entry.getValue().intValue() == maxVotes) {
                result.setIndecisive(true);
            }
        }
        return result;
    }

    private static BitMatrix codewordsToBitMatrix(List<List<Integer>> codewords, int dimension2, int yDimension) {
        BitMatrix result = new BitMatrix(dimension2, yDimension);
        for (int i = 0; i < codewords.size(); i++) {
            for (int j = 0; j < codewords.get(i).size(); j++) {
                int moduleOffset = j * 17;
                for (int k = 0; k < 17; k++) {
                    if ((((Integer) codewords.get(i).get(j)).intValue() & (1 << ((17 - k) - 1))) > 0) {
                        result.set(moduleOffset + k, i);
                    }
                }
            }
        }
        return result;
    }

    private static int calculateClusterNumber(int codeword) {
        if (codeword == 0) {
            return -1;
        }
        int barNumber = 0;
        boolean blackBar = true;
        int clusterNumber = 0;
        for (int i = 0; i < 17; i++) {
            if (((1 << i) & codeword) > 0) {
                if (!blackBar) {
                    blackBar = true;
                    barNumber++;
                }
                if (barNumber % 2 == 0) {
                    clusterNumber++;
                } else {
                    clusterNumber--;
                }
            } else if (blackBar) {
                blackBar = false;
            }
        }
        return (clusterNumber + 9) % 9;
    }

    private static void resize1(List<List<Map<Integer, Integer>>> list, int size) {
        for (int i = size; i < list.size(); i++) {
            list.remove(i);
        }
        for (int i2 = list.size(); i2 < size; i2++) {
            list.add(new ArrayList());
        }
    }

    private static void resize2(List<Map<Integer, Integer>> list, int size) {
        for (int i = size; i < list.size(); i++) {
            list.remove(i);
        }
        for (int i2 = list.size(); i2 < size; i2++) {
            list.add(new HashMap());
        }
    }

    private static void resize3(List<List<Integer>> list, int size) {
        for (int i = size; i < list.size(); i++) {
            list.remove(i);
        }
        for (int i2 = list.size(); i2 < size; i2++) {
            list.add(new ArrayList());
        }
    }

    private static void resize4(List<Integer> list, int size) {
        for (int i = size; i < list.size(); i++) {
            list.remove(i);
        }
        for (int i2 = list.size(); i2 < size; i2++) {
            list.add(0);
        }
    }

    private static <T> T defaultValue(T value, T d) {
        return value == null ? d : value;
    }
}
