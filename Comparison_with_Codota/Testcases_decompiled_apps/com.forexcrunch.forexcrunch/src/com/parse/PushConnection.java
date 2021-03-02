package com.parse;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.parse.ConnectivityNotifier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class PushConnection {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final String TAG = "com.parse.push.connection";
    static int connectTimeout = 40000;
    static long generalTimeout = 1800000;
    private ConnectivityNotifier.ConnectivityListener listener = new ConnectivityNotifier.ConnectivityListener() {
        public void networkConnectivityStatusChanged(Intent intent) {
            PushConnection.this.close();
        }
    };
    private int port;
    private BufferedReader reader = null;
    private Thread readerThread = null;
    private String server;
    private Socket socket;
    private Object socketLock = new Object();
    private OutputStreamWriter writer = null;

    static {
        boolean z;
        if (!PushConnection.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = $assertionsDisabled;
        }
        $assertionsDisabled = z;
    }

    public PushConnection(Context context) {
        ConnectivityNotifier.getNotifier().addListener(this.listener, context);
    }

    public void connect(String pushServer, int pushPort, boolean forceReconnect) {
        boolean shouldCreateSocket = forceReconnect;
        Socket cachedSocket = null;
        if (!shouldCreateSocket) {
            synchronized (this.socketLock) {
                shouldCreateSocket = (this.socket == null || this.socket.isClosed() || this.server != pushServer || this.port != pushPort) ? true : $assertionsDisabled;
                cachedSocket = this.socket;
            }
        }
        if (shouldCreateSocket) {
            try {
                Parse.logV(TAG, "connecting to push server at " + pushServer + ":" + pushPort);
                InetSocketAddress address = new InetSocketAddress(pushServer, pushPort);
                Socket newSocket = new Socket();
                try {
                    newSocket.setKeepAlive(true);
                    newSocket.connect(address, connectTimeout);
                    if ($assertionsDisabled || !newSocket.isClosed()) {
                        synchronized (this.socketLock) {
                            if (this.socket == cachedSocket) {
                                close();
                                this.socket = newSocket;
                                this.server = pushServer;
                                this.port = pushPort;
                                return;
                            }
                            return;
                        }
                    }
                    throw new AssertionError();
                } catch (UnknownHostException e) {
                    e = e;
                    Socket socket2 = newSocket;
                    Parse.logV(TAG, "unknown host " + e.toString());
                    close();
                } catch (IOException e2) {
                    e = e2;
                    Socket socket3 = newSocket;
                    Parse.logV(TAG, "could not connect to push server " + e.toString());
                    close();
                }
            } catch (UnknownHostException e3) {
                e = e3;
                Parse.logV(TAG, "unknown host " + e.toString());
                close();
            } catch (IOException e4) {
                e = e4;
                Parse.logV(TAG, "could not connect to push server " + e.toString());
                close();
            }
        }
    }

    public void close() {
        BufferedReader cachedReader;
        OutputStreamWriter cachedWriter;
        Socket cachedSocket;
        ConnectivityNotifier.getNotifier().removeListener(this.listener);
        synchronized (this.socketLock) {
            cachedReader = this.reader;
            cachedWriter = this.writer;
            cachedSocket = this.socket;
            if (this.readerThread != null) {
                Parse.logV(TAG, "Trying to interrupt long poll in another thread");
                this.readerThread.interrupt();
            }
            this.reader = null;
            this.writer = null;
            this.socket = null;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (cachedReader != null) {
                try {
                    synchronized (cachedReader) {
                        cachedReader.close();
                    }
                } catch (IOException e) {
                    Parse.logV(TAG, "error closing socket", e);
                    return;
                }
            }
            if (cachedWriter != null) {
                synchronized (cachedWriter) {
                    cachedWriter.close();
                }
            }
            if (cachedSocket != null) {
                synchronized (cachedSocket) {
                    cachedSocket.close();
                }
            }
        }
    }

    public String readLine() throws IOException {
        String str = null;
        synchronized (this.socketLock) {
            if (this.socket != null && !this.socket.isClosed()) {
                if (this.reader == null) {
                    Parse.logV(TAG, "Creating a new reader");
                    this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                }
                BufferedReader cachedReader = this.reader;
                if ($assertionsDisabled || this.readerThread == null) {
                    this.readerThread = Thread.currentThread();
                    synchronized (cachedReader) {
                        try {
                            str = cachedReader.readLine();
                            synchronized (this.socketLock) {
                                this.readerThread = null;
                            }
                        } catch (IOException e) {
                            Parse.logV(TAG, "IOException in blocking read: " + e.toString());
                            synchronized (this.socketLock) {
                                this.readerThread = null;
                            }
                        } catch (Throwable th) {
                            synchronized (this.socketLock) {
                                this.readerThread = null;
                                throw th;
                            }
                        }
                    }
                } else {
                    throw new AssertionError();
                }
            }
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return $assertionsDisabled;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean trySend(java.lang.String r8) {
        /*
            r7 = this;
            r2 = 0
            r0 = 0
            java.lang.Object r3 = r7.socketLock
            monitor-enter(r3)
            java.net.Socket r4 = r7.socket     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0011
            java.net.Socket r4 = r7.socket     // Catch:{ all -> 0x0064 }
            boolean r4 = r4.isClosed()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0013
        L_0x0011:
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
        L_0x0012:
            return r2
        L_0x0013:
            java.io.OutputStreamWriter r4 = r7.writer     // Catch:{ all -> 0x0064 }
            if (r4 != 0) goto L_0x0026
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x005a }
            java.net.Socket r5 = r7.socket     // Catch:{ IOException -> 0x005a }
            java.io.OutputStream r5 = r5.getOutputStream()     // Catch:{ IOException -> 0x005a }
            java.lang.String r6 = "UTF-8"
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x005a }
            r7.writer = r4     // Catch:{ IOException -> 0x005a }
        L_0x0026:
            java.io.OutputStreamWriter r0 = r7.writer     // Catch:{ all -> 0x0064 }
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
            monitor-enter(r0)
            java.lang.String r3 = "com.parse.push.connection"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            java.lang.String r5 = "Sending message "
            r4.<init>(r5)     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            java.lang.String r4 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            com.parse.Parse.logV(r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            java.lang.String r4 = java.lang.String.valueOf(r8)     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            r3.<init>(r4)     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            java.lang.String r4 = "\n"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            java.lang.String r3 = r3.toString()     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            r0.write(r3)     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            r0.flush()     // Catch:{ UnsupportedEncodingException -> 0x0067, IOException -> 0x0074 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            r2 = 1
            goto L_0x0012
        L_0x005a:
            r1 = move-exception
            java.lang.String r4 = "com.parse.push.connection"
            java.lang.String r5 = "Failed to open write socket"
            com.parse.Parse.logE(r4, r5, r1)     // Catch:{ all -> 0x0064 }
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
            goto L_0x0012
        L_0x0064:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
            throw r2
        L_0x0067:
            r1 = move-exception
            java.lang.String r3 = "com.parse.push.connection"
            java.lang.String r4 = "unsupported encoding"
            com.parse.Parse.logE(r3, r4, r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            goto L_0x0012
        L_0x0071:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r2
        L_0x0074:
            r1 = move-exception
            java.lang.String r3 = "com.parse.push.connection"
            java.lang.String r4 = "could not construct writer"
            com.parse.Parse.logE(r3, r4, r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.PushConnection.trySend(java.lang.String):boolean");
    }
}
