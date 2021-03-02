package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryFindLastFromIndex extends SktOperationFactory {
    SktOperationFactoryFindLastFromIndex() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationFindLastFromIndex(dataEditing);
        return 0;
    }
}
