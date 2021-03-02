package p006nl.volkerinfradesign.checkandroid.environments.folders;

import android.database.DataSetObserver;
import java.io.IOException;
import java.net.MalformedURLException;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.folders.Tree */
public interface Tree {
    int download() throws MalformedURLException, IOException;

    FolderCursor getChildren(long j);

    FolderCursor getChildren(FolderCursor folderCursor);

    FolderCursor getLeafs();

    FolderCursor getParent(long j);

    FolderCursor getParent(FolderCursor folderCursor);

    FolderCursor getRoot();

    int getVersion();

    boolean hasChildren(FolderCursor folderCursor);

    boolean hasParent(FolderCursor folderCursor);

    boolean isEmpty();

    boolean isLeaf(FolderCursor folderCursor);

    void registerObserver(DataSetObserver dataSetObserver);

    void unregisterObserver(DataSetObserver dataSetObserver);
}
