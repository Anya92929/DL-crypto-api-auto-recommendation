package com.google.gson.stream;

final class StringPool {
    private final String[] pool = new String[512];

    StringPool() {
    }

    public String get(char[] array, int start, int length) {
        int hashCode = 0;
        for (int i = start; i < start + length; i++) {
            hashCode = (hashCode * 31) + array[i];
        }
        int hashCode2 = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        int index = (hashCode2 ^ ((hashCode2 >>> 7) ^ (hashCode2 >>> 4))) & (this.pool.length - 1);
        String pooled = this.pool[index];
        if (pooled == null || pooled.length() != length) {
            String result = new String(array, start, length);
            this.pool[index] = result;
            return result;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (pooled.charAt(i2) != array[start + i2]) {
                String result2 = new String(array, start, length);
                this.pool[index] = result2;
                return result2;
            }
        }
        return pooled;
    }
}
