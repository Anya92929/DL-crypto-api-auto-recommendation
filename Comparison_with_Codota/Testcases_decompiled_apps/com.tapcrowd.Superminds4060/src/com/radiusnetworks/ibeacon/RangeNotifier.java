package com.radiusnetworks.ibeacon;

import java.util.Collection;

public interface RangeNotifier {
    void didRangeBeaconsInRegion(Collection<IBeacon> collection, Region region);
}
