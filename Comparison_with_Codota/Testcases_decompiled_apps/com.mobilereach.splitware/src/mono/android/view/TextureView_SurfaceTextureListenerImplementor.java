package mono.android.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TextureView_SurfaceTextureListenerImplementor implements IGCUserPeer, TextureView.SurfaceTextureListener {
    public static final String __md_methods = "n_onSurfaceTextureAvailable:(Landroid/graphics/SurfaceTexture;II)V:GetOnSurfaceTextureAvailable_Landroid_graphics_SurfaceTexture_IIHandler:Android.Views.TextureView/ISurfaceTextureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSurfaceTextureDestroyed:(Landroid/graphics/SurfaceTexture;)Z:GetOnSurfaceTextureDestroyed_Landroid_graphics_SurfaceTexture_Handler:Android.Views.TextureView/ISurfaceTextureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSurfaceTextureSizeChanged:(Landroid/graphics/SurfaceTexture;II)V:GetOnSurfaceTextureSizeChanged_Landroid_graphics_SurfaceTexture_IIHandler:Android.Views.TextureView/ISurfaceTextureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSurfaceTextureUpdated:(Landroid/graphics/SurfaceTexture;)V:GetOnSurfaceTextureUpdated_Landroid_graphics_SurfaceTexture_Handler:Android.Views.TextureView/ISurfaceTextureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

    private native boolean n_onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

    private native void n_onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

    private native void n_onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

    static {
        Runtime.register("Android.Views.TextureView+ISurfaceTextureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", TextureView_SurfaceTextureListenerImplementor.class, __md_methods);
    }

    public TextureView_SurfaceTextureListenerImplementor() throws Throwable {
        if (getClass() == TextureView_SurfaceTextureListenerImplementor.class) {
            TypeManager.Activate("Android.Views.TextureView+ISurfaceTextureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        n_onSurfaceTextureAvailable(surfaceTexture, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return n_onSurfaceTextureDestroyed(surfaceTexture);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        n_onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        n_onSurfaceTextureUpdated(surfaceTexture);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
