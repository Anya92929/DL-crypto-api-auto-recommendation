package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f6299a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static BufferedSource buffer(Source source) {
        if (source != null) {
            return new C1314je(source);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static BufferedSink buffer(Sink sink) {
        if (sink != null) {
            return new C1312jd(sink);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return m6907a(outputStream, new Timeout());
    }

    /* renamed from: a */
    private static Sink m6907a(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new Sink() {
                public void write(Buffer buffer, long j) throws IOException {
                    C1319ji.m5708a(buffer.f6272b, 0, j);
                    while (j > 0) {
                        timeout.throwIfReached();
                        C1316jf jfVar = buffer.f6271a;
                        int min = (int) Math.min(j, (long) (jfVar.f4572c - jfVar.f4571b));
                        outputStream.write(jfVar.f4570a, jfVar.f4571b, min);
                        jfVar.f4571b += min;
                        j -= (long) min;
                        buffer.f6272b -= (long) min;
                        if (jfVar.f4571b == jfVar.f4572c) {
                            buffer.f6271a = jfVar.mo8800a();
                            C1317jg.m5701a(jfVar);
                        }
                    }
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public void close() throws IOException {
                    outputStream.close();
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        AsyncTimeout a = m6906a(socket);
        return a.sink(m6907a(socket.getOutputStream(), (Timeout) a));
    }

    public static Source source(InputStream inputStream) {
        return m6908a(inputStream, new Timeout());
    }

    /* renamed from: a */
    private static Source m6908a(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new Source() {
                public long read(Buffer buffer, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        timeout.throwIfReached();
                        C1316jf a = buffer.mo11169a(1);
                        int read = inputStream.read(a.f4570a, a.f4572c, (int) Math.min(j, (long) (2048 - a.f4572c)));
                        if (read == -1) {
                            return -1;
                        }
                        a.f4572c += read;
                        buffer.f6272b += (long) read;
                        return (long) read;
                    }
                }

                public void close() throws IOException {
                    inputStream.close();
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        AsyncTimeout a = m6906a(socket);
        return a.source(m6908a(socket.getInputStream(), (Timeout) a));
    }

    /* renamed from: a */
    private static AsyncTimeout m6906a(final Socket socket) {
        return new AsyncTimeout() {
            /* access modifiers changed from: protected */
            public IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            public void timedOut() {
                try {
                    socket.close();
                } catch (Exception e) {
                    Okio.f6299a.log(Level.WARNING, "Failed to close timed out socket " + socket, e);
                } catch (AssertionError e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    Okio.f6299a.log(Level.WARNING, "Failed to close timed out socket " + socket, e2);
                }
            }
        };
    }
}
