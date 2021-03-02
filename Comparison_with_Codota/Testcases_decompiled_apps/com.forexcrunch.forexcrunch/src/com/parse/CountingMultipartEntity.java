package com.parse;

import com.parse.entity.mime.HttpMultipartMode;
import com.parse.entity.mime.MultipartEntity;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

class CountingMultipartEntity extends MultipartEntity {
    private final ProgressCallback progressCallback;

    public CountingMultipartEntity(ProgressCallback progressCallback2) {
        this.progressCallback = progressCallback2;
    }

    public CountingMultipartEntity(HttpMultipartMode mode, ProgressCallback progressCallback2) {
        super(mode);
        this.progressCallback = progressCallback2;
    }

    public CountingMultipartEntity(HttpMultipartMode mode, String boundary, Charset charset, ProgressCallback progressCallback2) {
        super(mode, boundary, charset);
        this.progressCallback = progressCallback2;
    }

    public void writeTo(OutputStream outstream) throws IOException {
        super.writeTo(new CountingOutputStream(outstream, this.progressCallback, getContentLength()));
    }

    public static class CountingOutputStream extends FilterOutputStream {
        private boolean hasReportedDone = false;
        private final ProgressCallback progressCallback;
        private long totalSize;
        private long uploadedSize;

        public CountingOutputStream(OutputStream out, ProgressCallback progressCallback2, long totalSize2) {
            super(out);
            this.progressCallback = progressCallback2;
            this.totalSize = totalSize2;
            this.uploadedSize = 0;
        }

        public void write(byte[] b, int off, int len) throws IOException {
            this.out.write(b, off, len);
            this.uploadedSize += (long) len;
            notifyCallback();
        }

        public void write(int b) throws IOException {
            this.out.write(b);
            this.uploadedSize++;
            notifyCallback();
        }

        private void notifyCallback() {
            if (!this.hasReportedDone) {
                int progressToReport = Math.round((((float) this.uploadedSize) / ((float) this.totalSize)) * 100.0f);
                Parse.callbackOnMainThreadAsync(Task.forResult(Integer.valueOf(progressToReport)), this.progressCallback);
                if (progressToReport == 100) {
                    this.hasReportedDone = true;
                }
            }
        }
    }
}
