package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryFindFirstFromIndex extends SktOperationFactory {
    SktOperationFactoryFindFirstFromIndex() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationFindFirstFromIndex(dataEditing);
        return 0;
    }
}
