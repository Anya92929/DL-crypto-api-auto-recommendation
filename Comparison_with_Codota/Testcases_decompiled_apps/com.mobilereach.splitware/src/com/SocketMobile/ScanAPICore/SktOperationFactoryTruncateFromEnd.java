package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryTruncateFromEnd extends SktOperationFactory {
    SktOperationFactoryTruncateFromEnd() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationTruncateFromEnd(dataEditing);
        return 0;
    }
}
