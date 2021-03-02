package com.nostra13.universalimageloader.core;

import android.net.Uri;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import java.util.concurrent.locks.ReentrantLock;

final class ImageLoadingInfo {
    final ImageView imageView;
    final ImageLoadingListener listener;
    final ReentrantLock loadFromUriLock;
    final String memoryCacheKey;
    final DisplayImageOptions options;
    final ImageSize targetSize;
    final String uri;

    public ImageLoadingInfo(String uri2, ImageView imageView2, ImageSize targetSize2, DisplayImageOptions options2, ImageLoadingListener listener2, ReentrantLock loadFromUriLock2) {
        this.uri = Uri.encode(uri2, "@#&=*+-_.,:!?()/~'%");
        this.imageView = imageView2;
        this.targetSize = targetSize2;
        this.options = options2;
        this.listener = listener2;
        this.loadFromUriLock = loadFromUriLock2;
        this.memoryCacheKey = MemoryCacheUtil.generateKey(uri2, targetSize2);
    }
}
