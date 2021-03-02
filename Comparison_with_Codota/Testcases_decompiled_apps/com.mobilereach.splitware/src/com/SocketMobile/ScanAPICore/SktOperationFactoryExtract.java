package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryExtract extends SktOperationFactory {
    SktOperationFactoryExtract() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationExtract(dataEditing);
        return 0;
    }
}
