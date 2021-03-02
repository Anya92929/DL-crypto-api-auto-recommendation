package p006nl.volkerinfradesign.checkandroid.environments.folders;

import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.folders.FolderCursor */
public interface FolderCursor extends ViTaCursor {
    FolderCursor getChildren();

    String getDescription();

    String getHyperlinks();

    FolderCursor getParent();

    String getTitle();

    boolean hasChildren();

    boolean hasHyperlinks();

    boolean hasParent();

    boolean isLeaf();
}
