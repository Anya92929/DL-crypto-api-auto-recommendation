package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryEscapeCharacter extends SktOperationFactory {
    SktOperationFactoryEscapeCharacter() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationEscapeCharacter(dataEditing);
        return 0;
    }
}
