package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryTruncateAfterIndex extends SktOperationFactory {
    SktOperationFactoryTruncateAfterIndex() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationTruncateAfterIndex(dataEditing);
        return 0;
    }
}
