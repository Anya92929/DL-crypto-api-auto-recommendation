package okhttp3.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.p008io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: a */
    static final Pattern f5957a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b */
    static final /* synthetic */ boolean f5958b = (!DiskLruCache.class.desiredAssertionStatus());
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static final Sink f5959u = new Sink() {
        public void write(Buffer buffer, long j) throws IOException {
            buffer.skip(j);
        }

        public void flush() throws IOException {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void close() throws IOException {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final FileSystem f5960c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final File f5961d;

    /* renamed from: e */
    private final File f5962e;

    /* renamed from: f */
    private final File f5963f;

    /* renamed from: g */
    private final File f5964g;

    /* renamed from: h */
    private final int f5965h;

    /* renamed from: i */
    private long f5966i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final int f5967j;

    /* renamed from: k */
    private long f5968k = 0;

    /* renamed from: l */
    private BufferedSink f5969l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final LinkedHashMap<String, C1780a> f5970m = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f5971n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f5972o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f5973p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f5974q;

    /* renamed from: r */
    private long f5975r = 0;

    /* renamed from: s */
    private final Executor f5976s;

    /* renamed from: t */
    private final Runnable f5977t = new Runnable() {
        public void run() {
            boolean z = false;
            synchronized (DiskLruCache.this) {
                if (!DiskLruCache.this.f5973p) {
                    z = true;
                }
                if (!z && !DiskLruCache.this.f5974q) {
                    try {
                        DiskLruCache.this.m6652h();
                        if (DiskLruCache.this.m6648f()) {
                            DiskLruCache.this.m6645e();
                            int unused = DiskLruCache.this.f5971n = 0;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    };

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.f5960c = fileSystem;
        this.f5961d = file;
        this.f5965h = i;
        this.f5962e = new File(file, "journal");
        this.f5963f = new File(file, "journal.tmp");
        this.f5964g = new File(file, "journal.bkp");
        this.f5967j = i2;
        this.f5966i = j;
        this.f5976s = executor;
    }

    public synchronized void initialize() throws IOException {
        if (!f5958b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.f5973p) {
            if (this.f5960c.exists(this.f5964g)) {
                if (this.f5960c.exists(this.f5962e)) {
                    this.f5960c.delete(this.f5964g);
                } else {
                    this.f5960c.rename(this.f5964g, this.f5962e);
                }
            }
            if (this.f5960c.exists(this.f5962e)) {
                try {
                    m6638b();
                    m6643d();
                    this.f5973p = true;
                } catch (IOException e) {
                    Platform.get().logW("DiskLruCache " + this.f5961d + " is corrupt: " + e.getMessage() + ", removing");
                    delete();
                    this.f5974q = false;
                }
            }
            m6645e();
            this.f5973p = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
    }

    /* renamed from: b */
    private void m6638b() throws IOException {
        int i;
        BufferedSource buffer = Okio.buffer(this.f5960c.source(this.f5962e));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.f5965h).equals(readUtf8LineStrict3) || !Integer.toString(this.f5967j).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            i = 0;
            while (true) {
                m6631a(buffer.readUtf8LineStrict());
                i++;
            }
        } catch (EOFException e) {
            this.f5971n = i - this.f5970m.size();
            if (!buffer.exhausted()) {
                m6645e();
            } else {
                this.f5969l = m6641c();
            }
            Util.closeQuietly((Closeable) buffer);
        } catch (Throwable th) {
            Util.closeQuietly((Closeable) buffer);
            throw th;
        }
    }

    /* renamed from: c */
    private BufferedSink m6641c() throws FileNotFoundException {
        return Okio.buffer((Sink) new C1299iw(this.f5960c.appendingSink(this.f5962e)) {

            /* renamed from: a */
            static final /* synthetic */ boolean f5979a = (!DiskLruCache.class.desiredAssertionStatus());

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo8702a(IOException iOException) {
                if (f5979a || Thread.holdsLock(DiskLruCache.this)) {
                    boolean unused = DiskLruCache.this.f5972o = true;
                    return;
                }
                throw new AssertionError();
            }
        });
    }

    /* renamed from: a */
    private void m6631a(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf != "REMOVE".length() || !str.startsWith("REMOVE")) {
                str2 = substring;
            } else {
                this.f5970m.remove(substring);
                return;
            }
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C1780a aVar = this.f5970m.get(str2);
        if (aVar == null) {
            aVar = new C1780a(str2);
            this.f5970m.put(str2, aVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            boolean unused = aVar.f6001f = true;
            Editor unused2 = aVar.f6002g = null;
            aVar.m6665a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            Editor unused3 = aVar.f6002g = new Editor(aVar);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: d */
    private void m6643d() throws IOException {
        this.f5960c.delete(this.f5963f);
        Iterator<C1780a> it = this.f5970m.values().iterator();
        while (it.hasNext()) {
            C1780a next = it.next();
            if (next.f6002g == null) {
                for (int i = 0; i < this.f5967j; i++) {
                    this.f5968k += next.f5998c[i];
                }
            } else {
                Editor unused = next.f6002g = null;
                for (int i2 = 0; i2 < this.f5967j; i2++) {
                    this.f5960c.delete(next.f5999d[i2]);
                    this.f5960c.delete(next.f6000e[i2]);
                }
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m6645e() throws IOException {
        if (this.f5969l != null) {
            this.f5969l.close();
        }
        BufferedSink buffer = Okio.buffer(this.f5960c.sink(this.f5963f));
        try {
            buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong((long) this.f5965h).writeByte(10);
            buffer.writeDecimalLong((long) this.f5967j).writeByte(10);
            buffer.writeByte(10);
            for (C1780a next : this.f5970m.values()) {
                if (next.f6002g != null) {
                    buffer.writeUtf8("DIRTY").writeByte(32);
                    buffer.writeUtf8(next.f5997b);
                    buffer.writeByte(10);
                } else {
                    buffer.writeUtf8("CLEAN").writeByte(32);
                    buffer.writeUtf8(next.f5997b);
                    next.mo10948a(buffer);
                    buffer.writeByte(10);
                }
            }
            buffer.close();
            if (this.f5960c.exists(this.f5962e)) {
                this.f5960c.rename(this.f5962e, this.f5964g);
            }
            this.f5960c.rename(this.f5963f, this.f5962e);
            this.f5960c.delete(this.f5964g);
            this.f5969l = m6641c();
            this.f5972o = false;
        } catch (Throwable th) {
            buffer.close();
            throw th;
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        Snapshot snapshot;
        initialize();
        m6650g();
        m6639b(str);
        C1780a aVar = this.f5970m.get(str);
        if (aVar == null || !aVar.f6001f) {
            snapshot = null;
        } else {
            snapshot = aVar.mo10947a();
            if (snapshot == null) {
                snapshot = null;
            } else {
                this.f5971n++;
                this.f5969l.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
                if (m6648f()) {
                    this.f5976s.execute(this.f5977t);
                }
            }
        }
        return snapshot;
    }

    public Editor edit(String str) throws IOException {
        return m6628a(str, -1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Editor m6628a(String str, long j) throws IOException {
        C1780a aVar;
        Editor editor;
        initialize();
        m6650g();
        m6639b(str);
        C1780a aVar2 = this.f5970m.get(str);
        if (j == -1 || (aVar2 != null && aVar2.f6003h == j)) {
            if (aVar2 != null) {
                if (aVar2.f6002g != null) {
                    editor = null;
                }
            }
            this.f5969l.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
            this.f5969l.flush();
            if (this.f5972o) {
                editor = null;
            } else {
                if (aVar2 == null) {
                    C1780a aVar3 = new C1780a(str);
                    this.f5970m.put(str, aVar3);
                    aVar = aVar3;
                } else {
                    aVar = aVar2;
                }
                editor = new Editor(aVar);
                Editor unused = aVar.f6002g = editor;
            }
        } else {
            editor = null;
        }
        return editor;
    }

    public File getDirectory() {
        return this.f5961d;
    }

    public synchronized long getMaxSize() {
        return this.f5966i;
    }

    public synchronized void setMaxSize(long j) {
        this.f5966i = j;
        if (this.f5973p) {
            this.f5976s.execute(this.f5977t);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.f5968k;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m6632a(Editor editor, boolean z) throws IOException {
        synchronized (this) {
            C1780a a = editor.f5986b;
            if (a.f6002g != editor) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f6001f) {
                    int i = 0;
                    while (true) {
                        if (i < this.f5967j) {
                            if (!editor.f5987c[i]) {
                                editor.abort();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                            } else if (!this.f5960c.exists(a.f6000e[i])) {
                                editor.abort();
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
            for (int i2 = 0; i2 < this.f5967j; i2++) {
                File file = a.f6000e[i2];
                if (!z) {
                    this.f5960c.delete(file);
                } else if (this.f5960c.exists(file)) {
                    File file2 = a.f5999d[i2];
                    this.f5960c.rename(file, file2);
                    long j = a.f5998c[i2];
                    long size = this.f5960c.size(file2);
                    a.f5998c[i2] = size;
                    this.f5968k = (this.f5968k - j) + size;
                }
            }
            this.f5971n++;
            Editor unused = a.f6002g = null;
            if (a.f6001f || z) {
                boolean unused2 = a.f6001f = true;
                this.f5969l.writeUtf8("CLEAN").writeByte(32);
                this.f5969l.writeUtf8(a.f5997b);
                a.mo10948a(this.f5969l);
                this.f5969l.writeByte(10);
                if (z) {
                    long j2 = this.f5975r;
                    this.f5975r = 1 + j2;
                    long unused3 = a.f6003h = j2;
                }
            } else {
                this.f5970m.remove(a.f5997b);
                this.f5969l.writeUtf8("REMOVE").writeByte(32);
                this.f5969l.writeUtf8(a.f5997b);
                this.f5969l.writeByte(10);
            }
            this.f5969l.flush();
            if (this.f5968k > this.f5966i || m6648f()) {
                this.f5976s.execute(this.f5977t);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m6648f() {
        return this.f5971n >= 2000 && this.f5971n >= this.f5970m.size();
    }

    public synchronized boolean remove(String str) throws IOException {
        boolean a;
        initialize();
        m6650g();
        m6639b(str);
        C1780a aVar = this.f5970m.get(str);
        if (aVar == null) {
            a = false;
        } else {
            a = m6634a(aVar);
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6634a(C1780a aVar) throws IOException {
        if (aVar.f6002g != null) {
            boolean unused = aVar.f6002g.f5988d = true;
        }
        for (int i = 0; i < this.f5967j; i++) {
            this.f5960c.delete(aVar.f5999d[i]);
            this.f5968k -= aVar.f5998c[i];
            aVar.f5998c[i] = 0;
        }
        this.f5971n++;
        this.f5969l.writeUtf8("REMOVE").writeByte(32).writeUtf8(aVar.f5997b).writeByte(10);
        this.f5970m.remove(aVar.f5997b);
        if (m6648f()) {
            this.f5976s.execute(this.f5977t);
        }
        return true;
    }

    public synchronized boolean isClosed() {
        return this.f5974q;
    }

    /* renamed from: g */
    private synchronized void m6650g() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f5973p) {
            m6650g();
            m6652h();
            this.f5969l.flush();
        }
    }

    public synchronized void close() throws IOException {
        if (!this.f5973p || this.f5974q) {
            this.f5974q = true;
        } else {
            for (C1780a aVar : (C1780a[]) this.f5970m.values().toArray(new C1780a[this.f5970m.size()])) {
                if (aVar.f6002g != null) {
                    aVar.f6002g.abort();
                }
            }
            m6652h();
            this.f5969l.close();
            this.f5969l = null;
            this.f5974q = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6652h() throws IOException {
        while (this.f5968k > this.f5966i) {
            m6634a(this.f5970m.values().iterator().next());
        }
    }

    public void delete() throws IOException {
        close();
        this.f5960c.deleteContents(this.f5961d);
    }

    public synchronized void evictAll() throws IOException {
        initialize();
        for (C1780a a : (C1780a[]) this.f5970m.values().toArray(new C1780a[this.f5970m.size()])) {
            m6634a(a);
        }
    }

    /* renamed from: b */
    private void m6639b(String str) {
        if (!f5957a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() {

            /* renamed from: a */
            final Iterator<C1780a> f5981a = new ArrayList(DiskLruCache.this.f5970m.values()).iterator();

            /* renamed from: b */
            Snapshot f5982b;

            /* renamed from: c */
            Snapshot f5983c;

            public boolean hasNext() {
                if (this.f5982b != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.f5974q) {
                        return false;
                    }
                    while (this.f5981a.hasNext()) {
                        Snapshot a = this.f5981a.next().mo10947a();
                        if (a != null) {
                            this.f5982b = a;
                            return true;
                        }
                    }
                    return false;
                }
            }

            /* renamed from: a */
            public Snapshot next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f5983c = this.f5982b;
                this.f5982b = null;
                return this.f5983c;
            }

            public void remove() {
                if (this.f5983c == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    DiskLruCache.this.remove(this.f5983c.f5992b);
                } catch (IOException e) {
                } finally {
                    this.f5983c = null;
                }
            }
        };
    }

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f5992b;

        /* renamed from: c */
        private final long f5993c;

        /* renamed from: d */
        private final Source[] f5994d;

        /* renamed from: e */
        private final long[] f5995e;

        private Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.f5992b = str;
            this.f5993c = j;
            this.f5994d = sourceArr;
            this.f5995e = jArr;
        }

        public String key() {
            return this.f5992b;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.m6628a(this.f5992b, this.f5993c);
        }

        public Source getSource(int i) {
            return this.f5994d[i];
        }

        public long getLength(int i) {
            return this.f5995e[i];
        }

        public void close() {
            for (Source closeQuietly : this.f5994d) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }
    }

    public final class Editor {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C1780a f5986b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final boolean[] f5987c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f5988d;

        /* renamed from: e */
        private boolean f5989e;

        private Editor(C1780a aVar) {
            this.f5986b = aVar;
            this.f5987c = aVar.f6001f ? null : new boolean[DiskLruCache.this.f5967j];
        }

        public Source newSource(int i) throws IOException {
            Source source = null;
            synchronized (DiskLruCache.this) {
                if (this.f5986b.f6002g != this) {
                    throw new IllegalStateException();
                } else if (this.f5986b.f6001f) {
                    try {
                        source = DiskLruCache.this.f5960c.source(this.f5986b.f5999d[i]);
                    } catch (FileNotFoundException e) {
                    }
                }
            }
            return source;
        }

        public Sink newSink(int i) throws IOException {
            Sink a;
            synchronized (DiskLruCache.this) {
                if (this.f5986b.f6002g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f5986b.f6001f) {
                    this.f5987c[i] = true;
                }
                try {
                    a = new C1299iw(DiskLruCache.this.f5960c.sink(this.f5986b.f6000e[i])) {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public void mo8702a(IOException iOException) {
                            synchronized (DiskLruCache.this) {
                                boolean unused = Editor.this.f5988d = true;
                            }
                        }
                    };
                } catch (FileNotFoundException e) {
                    a = DiskLruCache.f5959u;
                }
            }
            return a;
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f5988d) {
                    DiskLruCache.this.m6632a(this, false);
                    boolean unused = DiskLruCache.this.m6634a(this.f5986b);
                } else {
                    DiskLruCache.this.m6632a(this, true);
                }
                this.f5989e = true;
            }
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.m6632a(this, false);
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.f5989e) {
                    try {
                        DiskLruCache.this.m6632a(this, false);
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.DiskLruCache$a */
    final class C1780a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f5997b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final long[] f5998c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final File[] f5999d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final File[] f6000e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f6001f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Editor f6002g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public long f6003h;

        private C1780a(String str) {
            this.f5997b = str;
            this.f5998c = new long[DiskLruCache.this.f5967j];
            this.f5999d = new File[DiskLruCache.this.f5967j];
            this.f6000e = new File[DiskLruCache.this.f5967j];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < DiskLruCache.this.f5967j; i++) {
                append.append(i);
                this.f5999d[i] = new File(DiskLruCache.this.f5961d, append.toString());
                append.append(".tmp");
                this.f6000e[i] = new File(DiskLruCache.this.f5961d, append.toString());
                append.setLength(length);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6665a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f5967j) {
                throw m6667b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f5998c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m6667b(strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10948a(BufferedSink bufferedSink) throws IOException {
            for (long writeDecimalLong : this.f5998c) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }

        /* renamed from: b */
        private IOException m6667b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Snapshot mo10947a() {
            int i = 0;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.f5967j];
            long[] jArr = (long[]) this.f5998c.clone();
            int i2 = 0;
            while (i2 < DiskLruCache.this.f5967j) {
                try {
                    sourceArr[i2] = DiskLruCache.this.f5960c.source(this.f5999d[i2]);
                    i2++;
                } catch (FileNotFoundException e) {
                    while (i < DiskLruCache.this.f5967j && sourceArr[i] != null) {
                        Util.closeQuietly((Closeable) sourceArr[i]);
                        i++;
                    }
                    return null;
                }
            }
            return new Snapshot(this.f5997b, this.f6003h, sourceArr, jArr);
        }
    }
}
