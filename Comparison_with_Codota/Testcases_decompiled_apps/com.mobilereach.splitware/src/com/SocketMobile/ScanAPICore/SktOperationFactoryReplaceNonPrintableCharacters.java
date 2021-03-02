package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryReplaceNonPrintableCharacters extends SktOperationFactory {
    SktOperationFactoryReplaceNonPrintableCharacters() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationReplaceNonPrintableCharacters(dataEditing);
        return 0;
    }
}
