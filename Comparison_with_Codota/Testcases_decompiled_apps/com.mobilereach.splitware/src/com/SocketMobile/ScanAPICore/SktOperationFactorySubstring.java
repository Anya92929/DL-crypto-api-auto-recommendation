package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactorySubstring extends SktOperationFactory {
    SktOperationFactorySubstring() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationSubstring(dataEditing);
        return 0;
    }
}
