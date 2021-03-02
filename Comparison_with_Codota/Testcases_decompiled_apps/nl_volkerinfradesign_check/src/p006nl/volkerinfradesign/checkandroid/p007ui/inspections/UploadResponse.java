package p006nl.volkerinfradesign.checkandroid.p007ui.inspections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.UploadResponse */
public class UploadResponse extends ArrayList<InspectionResponse> {
    private static final long serialVersionUID = 5049047341036669786L;

    public InspectionResponse add(long j, long j2) {
        InspectionResponse inspectionResponse = new InspectionResponse(j, j2);
        add(inspectionResponse);
        return inspectionResponse;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.UploadResponse$InspectionItemResponse */
    public class InspectionItemResponse implements Serializable {
        private static final long serialVersionUID = 5970521909093088599L;

        /* renamed from: b */
        private final long f5325b;

        /* renamed from: c */
        private final long f5326c;

        private InspectionItemResponse(long j, long j2) {
            this.f5325b = j;
            this.f5326c = j2;
        }

        public long getClientId() {
            return this.f5326c;
        }

        public long getServerId() {
            return this.f5325b;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspections.UploadResponse$InspectionResponse */
    public class InspectionResponse implements Serializable {
        private static final long serialVersionUID = -7201425027722561273L;

        /* renamed from: b */
        private final ArrayList<InspectionItemResponse> f5328b;

        /* renamed from: c */
        private final long f5329c;

        /* renamed from: d */
        private final long f5330d;

        private InspectionResponse(long j, long j2) {
            this.f5328b = new ArrayList<>();
            this.f5329c = j;
            this.f5330d = j2;
        }

        public InspectionItemResponse add(long j, long j2) {
            InspectionItemResponse inspectionItemResponse = new InspectionItemResponse(j, j2);
            this.f5328b.add(inspectionItemResponse);
            return inspectionItemResponse;
        }

        public long getClientId() {
            return this.f5330d;
        }

        public List<InspectionItemResponse> getItems() {
            return Collections.unmodifiableList(this.f5328b);
        }

        public long getServerId() {
            return this.f5329c;
        }
    }
}
