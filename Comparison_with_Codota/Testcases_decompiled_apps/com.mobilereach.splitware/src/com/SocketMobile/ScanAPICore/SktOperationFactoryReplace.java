package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryReplace extends SktOperationFactory {
    SktOperationFactoryReplace() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationReplace(dataEditing);
        return 0;
    }
}
