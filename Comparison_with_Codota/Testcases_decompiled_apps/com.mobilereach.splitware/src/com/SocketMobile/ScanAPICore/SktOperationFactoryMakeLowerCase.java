package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryMakeLowerCase extends SktOperationFactory {
    SktOperationFactoryMakeLowerCase() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationMakeLowerCase(dataEditing);
        return 0;
    }
}
