package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationFactoryDecodedDataWithoutTrailer extends SktOperationFactory {
    SktOperationFactoryDecodedDataWithoutTrailer() {
    }

    public long createOperation(SktDataEditingProfile dataEditing, SktOperation[] ppOperation) {
        ppOperation[0] = new SktOperationDecodedDataWithoutTrailer(dataEditing);
        return 0;
    }
}
