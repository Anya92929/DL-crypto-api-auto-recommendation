package p006nl.volkerinfradesign.checkandroid.database;

import android.location.Location;
import android.util.Pair;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemsTable;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemConstants */
public interface InspectionItemConstants {
    public static final String ACTION_IDS = "action_ids";
    public static final String CHOICES = "choices";
    public static final String CREATION_DATE = "creation_date";
    public static final String CUSTOM_LOCATION_ID = "custom_location_id";
    public static final String DESCRIPTION = "description";
    public static final String DESCRIPTIVE_IMAGE_URL = "desc_img_url";
    public static final String FORM_ACTION_IDS = "form_action_ids";
    public static final String FORM_ITEM_SERVER_ID = "form_item_server_id";
    public static final String GUID = "item_guid";
    public static final String HYPERLINKS = "hyperlinks";
    public static final String INAPPLICABLE = "inapplicable";
    public static final String INAPPLICABLE_POSSIBLE = "inapp_possible";
    public static final String INSPECTION_ID = "inspection_id";
    public static final String INSPECTION_ITEM_TYPE = "component_type";
    public static final String INSPECTION_ITEM_VALUE = "item_value";
    public static final int INVALID_PARENT_ORDINAL = -1;
    public static final String LOCATION_ID = "location_id";
    public static final String LOCATION_REQUIRED = "location_required";
    public static final String MODIFIED_DATE = "mod_date";
    public static final String ORDINAL = "ordinal";
    public static final String PARENT_ORDINAL = "parent_header";
    public static final String PICTURE_REQUIRED = "picture_required";
    public static final String RECORD_TYPE = "item_type";
    public static final String REMARK = "remark";
    public static final String REQUIRED = "required";
    public static final String ROOT_INSPECTION_ID = "root_inspection_id";
    public static final String SERVER_ID = "form_item_server_id";
    public static final String SUB_INSPECTION_ID = "sub_inspection_id";
    public static final String TABLE_NAME = "inspection_items_table";
    public static final String TITLE = "title";
    public static final String TRIGGERS = "triggers";

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemConstants$HeaderCursor */
    public interface HeaderCursor extends ViTaCursor {
        String getDescription();

        long getInspectionId();

        long getModifiedMillis();

        int getOrdinal();

        InspectionItemsTable.RecordType getRecordType();

        Long getServerId();

        String getTitle();

        Pair<Integer, Integer> getValidChildCount();

        boolean hasServerId();

        boolean isDummy();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.InspectionItemConstants$ItemCursor */
    public interface ItemCursor extends HeaderCursor, ViTaCursor {
        boolean addSubInspection();

        JsonArray getChoices() throws IllegalStateException;

        LocationsTable.LocationsCursor getCustomLocation();

        String getDescriptiveImageUrl();

        long getFormItemServerId();

        JsonArray getHyperlinks() throws IllegalStateException;

        PictureKey[] getImages();

        InspectionKey getInspectionKey();

        InspectionItemKey getKey();

        String getRemark();

        long getRootInspectionId();

        String getStringValue();

        long getSubFormServerId();

        InspectionsTable.DataCursor getSubInspections(boolean z);

        InspectionItemType getType();

        Object getValue();

        LocationsTable.LocationsCursor getlocation();

        boolean hasCustomlocation();

        boolean hasDescriptiveImageUrl();

        boolean hasRemark();

        boolean hasSignature();

        boolean hasSubForm();

        boolean hasSubInspections();

        boolean hasTriggeredCondition();

        boolean hasValue();

        boolean isCustomLocationRequired();

        boolean isHeader();

        boolean isInapplicable();

        boolean isInapplicablePossible();

        boolean isPictureRequired();

        boolean isRequired();

        boolean isTable();

        boolean isValid();

        void removeSignature(PictureKey pictureKey, Location location);

        boolean setInapplicable(boolean z, Location location);

        boolean setProjectSelected(long j, Location location);

        boolean setRemark(String str, Location location);

        boolean setValue(Object obj, Location location);

        JsonObject toJson();
    }
}
