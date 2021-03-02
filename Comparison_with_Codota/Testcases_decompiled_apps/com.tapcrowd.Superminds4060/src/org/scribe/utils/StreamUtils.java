package org.scribe.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StreamUtils {
    public static String getStreamContents(InputStream is) {
        int read;
        Preconditions.checkNotNull(is, "Cannot get String from a null object");
        try {
            char[] buffer = new char[65536];
            StringBuilder out = new StringBuilder();
            Reader in = new InputStreamReader(is, "UTF-8");
            do {
                read = in.read(buffer, 0, buffer.length);
                if (read > 0) {
                    out.append(buffer, 0, read);
                    continue;
                }
            } while (read >= 0);
            in.close();
            return out.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Error while reading response body", ioe);
        }
    }
}
