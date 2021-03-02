package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

public final class CharsToNameCanonicalizer {
    protected static final int DEFAULT_TABLE_SIZE = 64;
    public static final int HASH_MULT = 33;
    static final int MAX_COLL_CHAIN_FOR_REUSE = 63;
    static final int MAX_COLL_CHAIN_LENGTH = 255;
    static final int MAX_ENTRIES_FOR_REUSE = 12000;
    protected static final int MAX_TABLE_SIZE = 65536;
    static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
    protected Bucket[] _buckets;
    protected final boolean _canonicalize;
    protected boolean _dirty;
    private final int _hashSeed;
    protected int _indexMask;
    protected final boolean _intern;
    protected int _longestCollisionList;
    protected CharsToNameCanonicalizer _parent;
    protected int _size;
    protected int _sizeThreshold;
    protected String[] _symbols;

    public static CharsToNameCanonicalizer createRoot() {
        long now = System.currentTimeMillis();
        return createRoot((((int) now) + ((int) (now >>> 32))) | 1);
    }

    protected static CharsToNameCanonicalizer createRoot(int hashSeed) {
        return sBootstrapSymbolTable.makeOrphan(hashSeed);
    }

    private CharsToNameCanonicalizer() {
        this._canonicalize = true;
        this._intern = true;
        this._dirty = true;
        this._hashSeed = 0;
        this._longestCollisionList = 0;
        initTables(64);
    }

    private void initTables(int initialSize) {
        this._symbols = new String[initialSize];
        this._buckets = new Bucket[(initialSize >> 1)];
        this._indexMask = initialSize - 1;
        this._size = 0;
        this._longestCollisionList = 0;
        this._sizeThreshold = _thresholdSize(initialSize);
    }

    private static int _thresholdSize(int hashAreaSize) {
        return hashAreaSize - (hashAreaSize >> 2);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer parent, boolean canonicalize, boolean intern, String[] symbols, Bucket[] buckets, int size, int hashSeed, int longestColl) {
        this._parent = parent;
        this._canonicalize = canonicalize;
        this._intern = intern;
        this._symbols = symbols;
        this._buckets = buckets;
        this._size = size;
        this._hashSeed = hashSeed;
        int arrayLen = symbols.length;
        this._sizeThreshold = _thresholdSize(arrayLen);
        this._indexMask = arrayLen - 1;
        this._longestCollisionList = longestColl;
        this._dirty = false;
    }

    public CharsToNameCanonicalizer makeChild(boolean canonicalize, boolean intern) {
        String[] symbols;
        Bucket[] buckets;
        int size;
        int hashSeed;
        int longestCollisionList;
        synchronized (this) {
            symbols = this._symbols;
            buckets = this._buckets;
            size = this._size;
            hashSeed = this._hashSeed;
            longestCollisionList = this._longestCollisionList;
        }
        return new CharsToNameCanonicalizer(this, canonicalize, intern, symbols, buckets, size, hashSeed, longestCollisionList);
    }

    private CharsToNameCanonicalizer makeOrphan(int seed) {
        return new CharsToNameCanonicalizer((CharsToNameCanonicalizer) null, true, true, this._symbols, this._buckets, this._size, seed, this._longestCollisionList);
    }

    private void mergeChild(CharsToNameCanonicalizer child) {
        if (child.size() > MAX_ENTRIES_FOR_REUSE || child._longestCollisionList > MAX_COLL_CHAIN_FOR_REUSE) {
            synchronized (this) {
                initTables(64);
                this._dirty = false;
            }
        } else if (child.size() > size()) {
            synchronized (this) {
                this._symbols = child._symbols;
                this._buckets = child._buckets;
                this._size = child._size;
                this._sizeThreshold = child._sizeThreshold;
                this._indexMask = child._indexMask;
                this._longestCollisionList = child._longestCollisionList;
                this._dirty = false;
            }
        }
    }

    public void release() {
        if (maybeDirty() && this._parent != null) {
            this._parent.mergeChild(this);
            this._dirty = false;
        }
    }

    public int size() {
        return this._size;
    }

    public int bucketCount() {
        return this._symbols.length;
    }

    public boolean maybeDirty() {
        return this._dirty;
    }

    public int hashSeed() {
        return this._hashSeed;
    }

    public int collisionCount() {
        int count = 0;
        for (Bucket bucket : this._buckets) {
            if (bucket != null) {
                count += bucket.length();
            }
        }
        return count;
    }

    public int maxCollisionLength() {
        return this._longestCollisionList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[LOOP:0: B:11:0x0023->B:29:0x0069, LOOP_START, PHI: r2 
      PHI: (r2v1 'i' int) = (r2v0 'i' int), (r2v2 'i' int) binds: [B:10:0x0022, B:29:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String findSymbol(char[] r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            r10 = 255(0xff, float:3.57E-43)
            r9 = 1
            if (r14 >= r9) goto L_0x0008
            java.lang.String r6 = ""
        L_0x0007:
            return r6
        L_0x0008:
            boolean r7 = r11._canonicalize
            if (r7 != 0) goto L_0x0012
            java.lang.String r6 = new java.lang.String
            r6.<init>(r12, r13, r14)
            goto L_0x0007
        L_0x0012:
            int r3 = r11._hashToIndex(r15)
            java.lang.String[] r7 = r11._symbols
            r6 = r7[r3]
            if (r6 == 0) goto L_0x003d
            int r7 = r6.length()
            if (r7 != r14) goto L_0x002f
            r2 = 0
        L_0x0023:
            char r7 = r6.charAt(r2)
            int r8 = r13 + r2
            char r8 = r12[r8]
            if (r7 == r8) goto L_0x0067
        L_0x002d:
            if (r2 == r14) goto L_0x0007
        L_0x002f:
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$Bucket[] r7 = r11._buckets
            int r8 = r3 >> 1
            r0 = r7[r8]
            if (r0 == 0) goto L_0x003d
            java.lang.String r6 = r0.find(r12, r13, r14)
            if (r6 != 0) goto L_0x0007
        L_0x003d:
            boolean r7 = r11._dirty
            if (r7 != 0) goto L_0x006c
            r11.copyArrays()
            r11._dirty = r9
        L_0x0046:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r12, r13, r14)
            boolean r7 = r11._intern
            if (r7 == 0) goto L_0x0055
            com.fasterxml.jackson.core.util.InternCache r7 = com.fasterxml.jackson.core.util.InternCache.instance
            java.lang.String r5 = r7.intern(r5)
        L_0x0055:
            int r7 = r11._size
            int r7 = r7 + 1
            r11._size = r7
            java.lang.String[] r7 = r11._symbols
            r7 = r7[r3]
            if (r7 != 0) goto L_0x007e
            java.lang.String[] r7 = r11._symbols
            r7[r3] = r5
        L_0x0065:
            r6 = r5
            goto L_0x0007
        L_0x0067:
            int r2 = r2 + 1
            if (r2 < r14) goto L_0x0023
            goto L_0x002d
        L_0x006c:
            int r7 = r11._size
            int r8 = r11._sizeThreshold
            if (r7 < r8) goto L_0x0046
            r11.rehash()
            int r7 = r11.calcHash(r12, r13, r14)
            int r3 = r11._hashToIndex(r7)
            goto L_0x0046
        L_0x007e:
            int r1 = r3 >> 1
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$Bucket r4 = new com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$Bucket
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$Bucket[] r7 = r11._buckets
            r7 = r7[r1]
            r4.<init>(r5, r7)
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$Bucket[] r7 = r11._buckets
            r7[r1] = r4
            int r7 = r4.length()
            int r8 = r11._longestCollisionList
            int r7 = java.lang.Math.max(r7, r8)
            r11._longestCollisionList = r7
            int r7 = r11._longestCollisionList
            if (r7 <= r10) goto L_0x0065
            r11.reportTooManyCollisions(r10)
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.findSymbol(char[], int, int, int):java.lang.String");
    }

    public int _hashToIndex(int rawHash) {
        return this._indexMask & (rawHash + (rawHash >>> 15));
    }

    public int calcHash(char[] buffer, int start, int len) {
        int hash = this._hashSeed;
        for (int i = 0; i < len; i++) {
            hash = (hash * 33) + buffer[i];
        }
        if (hash == 0) {
            return 1;
        }
        return hash;
    }

    public int calcHash(String key) {
        int len = key.length();
        int hash = this._hashSeed;
        for (int i = 0; i < len; i++) {
            hash = (hash * 33) + key.charAt(i);
        }
        if (hash == 0) {
            return 1;
        }
        return hash;
    }

    private void copyArrays() {
        String[] oldSyms = this._symbols;
        int size = oldSyms.length;
        this._symbols = new String[size];
        System.arraycopy(oldSyms, 0, this._symbols, 0, size);
        Bucket[] oldBuckets = this._buckets;
        int size2 = oldBuckets.length;
        this._buckets = new Bucket[size2];
        System.arraycopy(oldBuckets, 0, this._buckets, 0, size2);
    }

    private void rehash() {
        int size = this._symbols.length;
        int newSize = size + size;
        if (newSize > 65536) {
            this._size = 0;
            Arrays.fill(this._symbols, (Object) null);
            Arrays.fill(this._buckets, (Object) null);
            this._dirty = true;
            return;
        }
        String[] oldSyms = this._symbols;
        Bucket[] oldBuckets = this._buckets;
        this._symbols = new String[newSize];
        this._buckets = new Bucket[(newSize >> 1)];
        this._indexMask = newSize - 1;
        this._sizeThreshold = _thresholdSize(newSize);
        int count = 0;
        int maxColl = 0;
        for (int i = 0; i < size; i++) {
            String symbol = oldSyms[i];
            if (symbol != null) {
                count++;
                int index = _hashToIndex(calcHash(symbol));
                if (this._symbols[index] == null) {
                    this._symbols[index] = symbol;
                } else {
                    int bix = index >> 1;
                    Bucket newB = new Bucket(symbol, this._buckets[bix]);
                    this._buckets[bix] = newB;
                    maxColl = Math.max(maxColl, newB.length());
                }
            }
        }
        int size2 = size >> 1;
        for (int i2 = 0; i2 < size2; i2++) {
            for (Bucket b = oldBuckets[i2]; b != null; b = b.getNext()) {
                count++;
                String symbol2 = b.getSymbol();
                int index2 = _hashToIndex(calcHash(symbol2));
                if (this._symbols[index2] == null) {
                    this._symbols[index2] = symbol2;
                } else {
                    int bix2 = index2 >> 1;
                    Bucket newB2 = new Bucket(symbol2, this._buckets[bix2]);
                    this._buckets[bix2] = newB2;
                    maxColl = Math.max(maxColl, newB2.length());
                }
            }
        }
        this._longestCollisionList = maxColl;
        if (count != this._size) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + count + ".");
        }
    }

    /* access modifiers changed from: protected */
    public void reportTooManyCollisions(int maxLen) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this._size + ") now exceeds maximum, " + maxLen + " -- suspect a DoS attack based on hash collisions");
    }

    static final class Bucket {
        private final int _length;
        private final Bucket _next;
        private final String _symbol;

        public Bucket(String symbol, Bucket next) {
            this._symbol = symbol;
            this._next = next;
            this._length = next == null ? 1 : next._length + 1;
        }

        public String getSymbol() {
            return this._symbol;
        }

        public Bucket getNext() {
            return this._next;
        }

        public int length() {
            return this._length;
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000b A[LOOP:1: B:4:0x000b->B:8:0x001a, LOOP_START, PHI: r1 
          PHI: (r1v1 'i' int) = (r1v0 'i' int), (r1v2 'i' int) binds: [B:3:0x000a, B:8:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String find(char[] r6, int r7, int r8) {
            /*
                r5 = this;
                java.lang.String r2 = r5._symbol
                com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$Bucket r0 = r5._next
            L_0x0004:
                int r3 = r2.length()
                if (r3 != r8) goto L_0x001d
                r1 = 0
            L_0x000b:
                char r3 = r2.charAt(r1)
                int r4 = r7 + r1
                char r4 = r6[r4]
                if (r3 == r4) goto L_0x0018
            L_0x0015:
                if (r1 != r8) goto L_0x001d
            L_0x0017:
                return r2
            L_0x0018:
                int r1 = r1 + 1
                if (r1 < r8) goto L_0x000b
                goto L_0x0015
            L_0x001d:
                if (r0 != 0) goto L_0x0021
                r2 = 0
                goto L_0x0017
            L_0x0021:
                java.lang.String r2 = r0.getSymbol()
                com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$Bucket r0 = r0.getNext()
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.Bucket.find(char[], int, int):java.lang.String");
        }
    }
}
