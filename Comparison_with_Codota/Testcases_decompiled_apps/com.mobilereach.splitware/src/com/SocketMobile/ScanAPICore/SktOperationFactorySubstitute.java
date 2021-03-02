package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactorySubstitute extends SktOperationFactory {
    SktOperationFactorySubstitute() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationSubstitute(dataEditing);
        return 0;
    }
}
