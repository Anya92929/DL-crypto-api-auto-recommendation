package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryDecodedData extends SktOperationFactory {
    SktOperationFactoryDecodedData() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationDecodedData(dataEditing);
        return 0;
    }
}
