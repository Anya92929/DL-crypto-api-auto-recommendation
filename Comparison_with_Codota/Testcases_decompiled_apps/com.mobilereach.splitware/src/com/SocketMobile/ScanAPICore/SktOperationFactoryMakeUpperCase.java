package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryMakeUpperCase extends SktOperationFactory {
    SktOperationFactoryMakeUpperCase() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationMakeUpperCase(dataEditing);
        return 0;
    }
}
