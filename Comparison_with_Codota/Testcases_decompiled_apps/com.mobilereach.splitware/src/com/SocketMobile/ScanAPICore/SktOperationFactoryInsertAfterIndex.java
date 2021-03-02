package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryInsertAfterIndex extends SktOperationFactory {
    SktOperationFactoryInsertAfterIndex() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationInsertAfterIndex(dataEditing);
        return 0;
    }
}
