package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryInsertBeforeIndex extends SktOperationFactory {
    SktOperationFactoryInsertBeforeIndex() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationInsertBeforeIndex(dataEditing);
        return 0;
    }
}
