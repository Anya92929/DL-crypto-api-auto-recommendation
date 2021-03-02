package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryTruncateBeforeIndex extends SktOperationFactory {
    SktOperationFactoryTruncateBeforeIndex() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationTruncateBeforeIndex(dataEditing);
        return 0;
    }
}
