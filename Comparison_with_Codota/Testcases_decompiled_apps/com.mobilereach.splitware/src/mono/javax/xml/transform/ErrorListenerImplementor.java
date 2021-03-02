package mono.javax.xml.transform;

import java.util.ArrayList;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ErrorListenerImplementor implements IGCUserPeer, ErrorListener {
    public static final String __md_methods = "n_error:(Ljavax/xml/transform/TransformerException;)V:GetError_Ljavax_xml_transform_TransformerException_Handler:Javax.Xml.Transform.IErrorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_fatalError:(Ljavax/xml/transform/TransformerException;)V:GetFatalError_Ljavax_xml_transform_TransformerException_Handler:Javax.Xml.Transform.IErrorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_warning:(Ljavax/xml/transform/TransformerException;)V:GetWarning_Ljavax_xml_transform_TransformerException_Handler:Javax.Xml.Transform.IErrorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_error(TransformerException transformerException);

    private native void n_fatalError(TransformerException transformerException);

    private native void n_warning(TransformerException transformerException);

    static {
        Runtime.register("Javax.Xml.Transform.IErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ErrorListenerImplementor.class, __md_methods);
    }

    public ErrorListenerImplementor() throws Throwable {
        if (getClass() == ErrorListenerImplementor.class) {
            TypeManager.Activate("Javax.Xml.Transform.IErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void error(TransformerException transformerException) {
        n_error(transformerException);
    }

    public void fatalError(TransformerException transformerException) {
        n_fatalError(transformerException);
    }

    public void warning(TransformerException transformerException) {
        n_warning(transformerException);
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
