package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public abstract class BaseDiscCache implements DiscCacheAware {
    protected File cacheDir;
    private FileNameGenerator fileNameGenerator;

    public BaseDiscCache(File cacheDir2) {
        this(cacheDir2, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiscCache(File cacheDir2, FileNameGenerator fileNameGenerator2) {
        this.cacheDir = cacheDir2;
        this.fileNameGenerator = fileNameGenerator2;
    }

    public File get(String key) {
        return new File(this.cacheDir, this.fileNameGenerator.generate(key));
    }

    public void clear() {
        File[] files = this.cacheDir.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }
    }
}
