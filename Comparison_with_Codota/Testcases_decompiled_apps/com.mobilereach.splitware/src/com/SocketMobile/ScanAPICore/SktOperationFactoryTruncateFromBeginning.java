package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryTruncateFromBeginning extends SktOperationFactory {
    SktOperationFactoryTruncateFromBeginning() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationTruncateFromBeginning(dataEditing);
        return 0;
    }
}
