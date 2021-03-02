package org.apache.cordova;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.webkit.WebView;
import com.actionbarsherlock.widget.ActivityChooserView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.cordova.ContactAccessor;
import org.apache.cordova.api.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactAccessorSdk5 extends ContactAccessor {
    private static final String EMAIL_REGEXP = ".+@.+\\.+.+";
    private static final long MAX_PHOTO_SIZE = 1048576;
    private static final Map<String, String> dbMap = new HashMap();

    static {
        dbMap.put(DBFavorites.KEY_EVENT_ID, "contact_id");
        dbMap.put("displayName", "display_name");
        dbMap.put(DBFavorites.KEY_NAME, "data1");
        dbMap.put("name.formatted", "data1");
        dbMap.put("name.familyName", "data3");
        dbMap.put("name.givenName", "data2");
        dbMap.put("name.middleName", "data5");
        dbMap.put("name.honorificPrefix", "data4");
        dbMap.put("name.honorificSuffix", "data6");
        dbMap.put("nickname", "data1");
        dbMap.put("phoneNumbers", "data1");
        dbMap.put("phoneNumbers.value", "data1");
        dbMap.put("emails", "data1");
        dbMap.put("emails.value", "data1");
        dbMap.put("addresses", "data1");
        dbMap.put("addresses.formatted", "data1");
        dbMap.put("addresses.streetAddress", "data4");
        dbMap.put("addresses.locality", "data7");
        dbMap.put("addresses.region", "data8");
        dbMap.put("addresses.postalCode", "data9");
        dbMap.put("addresses.country", "data10");
        dbMap.put("ims", "data1");
        dbMap.put("ims.value", "data1");
        dbMap.put("organizations", "data1");
        dbMap.put("organizations.name", "data1");
        dbMap.put("organizations.department", "data5");
        dbMap.put("organizations.title", "data4");
        dbMap.put("birthday", "vnd.android.cursor.item/contact_event");
        dbMap.put("note", "data1");
        dbMap.put("photos.value", "vnd.android.cursor.item/photo");
        dbMap.put("urls", "data1");
        dbMap.put("urls.value", "data1");
    }

    public ContactAccessorSdk5(WebView view, CordovaInterface context) {
        this.mApp = context;
        this.mView = view;
    }

    public JSONArray search(JSONArray fields, JSONObject options) {
        String searchTerm;
        int limit = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (options != null) {
            String searchTerm2 = options.optString("filter");
            if (searchTerm2.length() == 0) {
                searchTerm = "%";
            } else {
                searchTerm = "%" + searchTerm2 + "%";
            }
            try {
                if (!options.getBoolean("multiple")) {
                    limit = 1;
                }
            } catch (JSONException e) {
            }
        } else {
            searchTerm = "%";
        }
        HashMap<String, Boolean> populate = buildPopulationSet(fields);
        ContactAccessor.WhereOptions whereOptions = buildWhereClause(fields, searchTerm);
        Cursor idCursor = this.mApp.getActivity().getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id"}, whereOptions.getWhere(), whereOptions.getWhereArgs(), "contact_id ASC");
        Set<String> contactIds = new HashSet<>();
        int idColumn = -1;
        while (idCursor.moveToNext()) {
            if (idColumn < 0) {
                idColumn = idCursor.getColumnIndex("contact_id");
            }
            contactIds.add(idCursor.getString(idColumn));
        }
        idCursor.close();
        ContactAccessor.WhereOptions idOptions = buildIdClause(contactIds, searchTerm);
        HashSet<String> columnsToFetch = new HashSet<>();
        columnsToFetch.add("contact_id");
        columnsToFetch.add("raw_contact_id");
        columnsToFetch.add("mimetype");
        if (isRequired("displayName", populate)) {
            columnsToFetch.add("data1");
        }
        if (isRequired(DBFavorites.KEY_NAME, populate)) {
            columnsToFetch.add("data3");
            columnsToFetch.add("data2");
            columnsToFetch.add("data5");
            columnsToFetch.add("data4");
            columnsToFetch.add("data6");
        }
        if (isRequired("phoneNumbers", populate)) {
            columnsToFetch.add(DBFavorites.KEY_ID);
            columnsToFetch.add("data1");
            columnsToFetch.add("data2");
        }
        if (isRequired("emails", populate)) {
            columnsToFetch.add("data1");
            columnsToFetch.add("data2");
        }
        if (isRequired("addresses", populate)) {
            columnsToFetch.add(DBFavorites.KEY_ID);
            columnsToFetch.add("data2");
            columnsToFetch.add("data1");
            columnsToFetch.add("data4");
            columnsToFetch.add("data7");
            columnsToFetch.add("data8");
            columnsToFetch.add("data9");
            columnsToFetch.add("data10");
        }
        if (isRequired("organizations", populate)) {
            columnsToFetch.add(DBFavorites.KEY_ID);
            columnsToFetch.add("data2");
            columnsToFetch.add("data5");
            columnsToFetch.add("data1");
            columnsToFetch.add("data4");
        }
        if (isRequired("ims", populate)) {
            columnsToFetch.add(DBFavorites.KEY_ID);
            columnsToFetch.add("data1");
            columnsToFetch.add("data2");
        }
        if (isRequired("note", populate)) {
            columnsToFetch.add("data1");
        }
        if (isRequired("nickname", populate)) {
            columnsToFetch.add("data1");
        }
        if (isRequired("urls", populate)) {
            columnsToFetch.add(DBFavorites.KEY_ID);
            columnsToFetch.add("data1");
            columnsToFetch.add("data2");
        }
        if (isRequired("birthday", populate)) {
            columnsToFetch.add("data1");
            columnsToFetch.add("data2");
        }
        if (isRequired("photos", populate)) {
            columnsToFetch.add(DBFavorites.KEY_ID);
        }
        return populateContactArray(limit, populate, this.mApp.getActivity().getContentResolver().query(ContactsContract.Data.CONTENT_URI, (String[]) columnsToFetch.toArray(new String[0]), idOptions.getWhere(), idOptions.getWhereArgs(), "contact_id ASC"));
    }

    public JSONObject getContactById(String id) throws JSONException {
        Cursor c = this.mApp.getActivity().getContentResolver().query(ContactsContract.Data.CONTENT_URI, (String[]) null, "contact_id = ? ", new String[]{id}, "contact_id ASC");
        JSONArray fields = new JSONArray();
        fields.put("*");
        JSONArray contacts = populateContactArray(1, buildPopulationSet(fields), c);
        if (contacts.length() == 1) {
            return contacts.getJSONObject(0);
        }
        return null;
    }

    private JSONArray populateContactArray(int limit, HashMap<String, Boolean> populate, Cursor c) {
        JSONArray organizations;
        JSONArray addresses;
        JSONArray phones;
        JSONArray emails;
        String contactId = "";
        String oldContactId = "";
        boolean newContact = true;
        JSONArray contacts = new JSONArray();
        JSONObject contact = new JSONObject();
        JSONArray organizations2 = new JSONArray();
        JSONArray addresses2 = new JSONArray();
        JSONArray phones2 = new JSONArray();
        JSONArray emails2 = new JSONArray();
        JSONArray ims = new JSONArray();
        JSONArray websites = new JSONArray();
        JSONArray photos = new JSONArray();
        int colContactId = c.getColumnIndex("contact_id");
        int colRawContactId = c.getColumnIndex("raw_contact_id");
        int colMimetype = c.getColumnIndex("mimetype");
        int colDisplayName = c.getColumnIndex("data1");
        int colNote = c.getColumnIndex("data1");
        int colNickname = c.getColumnIndex("data1");
        int colBirthday = c.getColumnIndex("data1");
        int colEventType = c.getColumnIndex("data2");
        if (c.getCount() > 0) {
            while (c.moveToNext() && contacts.length() <= limit - 1) {
                try {
                    contactId = c.getString(colContactId);
                    String rawId = c.getString(colRawContactId);
                    if (c.getPosition() == 0) {
                        oldContactId = contactId;
                    }
                    if (!oldContactId.equals(contactId)) {
                        contacts.put(populateContact(contact, organizations2, addresses2, phones2, emails2, ims, websites, photos));
                        JSONObject contact2 = new JSONObject();
                        try {
                            organizations = new JSONArray();
                        } catch (JSONException e) {
                            e = e;
                            contact = contact2;
                            Log.e("ContactsAccessor", e.getMessage(), e);
                            oldContactId = contactId;
                        }
                        try {
                            addresses = new JSONArray();
                            try {
                                phones = new JSONArray();
                                try {
                                    emails = new JSONArray();
                                } catch (JSONException e2) {
                                    e = e2;
                                    phones2 = phones;
                                    addresses2 = addresses;
                                    organizations2 = organizations;
                                    contact = contact2;
                                    Log.e("ContactsAccessor", e.getMessage(), e);
                                    oldContactId = contactId;
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                addresses2 = addresses;
                                organizations2 = organizations;
                                contact = contact2;
                                Log.e("ContactsAccessor", e.getMessage(), e);
                                oldContactId = contactId;
                            }
                        } catch (JSONException e4) {
                            e = e4;
                            organizations2 = organizations;
                            contact = contact2;
                            Log.e("ContactsAccessor", e.getMessage(), e);
                            oldContactId = contactId;
                        }
                        try {
                            JSONArray ims2 = new JSONArray();
                            try {
                                JSONArray websites2 = new JSONArray();
                                try {
                                    newContact = true;
                                    photos = new JSONArray();
                                    websites = websites2;
                                    ims = ims2;
                                    emails2 = emails;
                                    phones2 = phones;
                                    addresses2 = addresses;
                                    organizations2 = organizations;
                                    contact = contact2;
                                } catch (JSONException e5) {
                                    e = e5;
                                    websites = websites2;
                                    ims = ims2;
                                    emails2 = emails;
                                    phones2 = phones;
                                    addresses2 = addresses;
                                    organizations2 = organizations;
                                    contact = contact2;
                                    Log.e("ContactsAccessor", e.getMessage(), e);
                                    oldContactId = contactId;
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                ims = ims2;
                                emails2 = emails;
                                phones2 = phones;
                                addresses2 = addresses;
                                organizations2 = organizations;
                                contact = contact2;
                                Log.e("ContactsAccessor", e.getMessage(), e);
                                oldContactId = contactId;
                            }
                        } catch (JSONException e7) {
                            e = e7;
                            emails2 = emails;
                            phones2 = phones;
                            addresses2 = addresses;
                            organizations2 = organizations;
                            contact = contact2;
                            Log.e("ContactsAccessor", e.getMessage(), e);
                            oldContactId = contactId;
                        }
                    }
                    if (newContact) {
                        newContact = false;
                        contact.put(DBFavorites.KEY_EVENT_ID, contactId);
                        contact.put("rawId", rawId);
                    }
                    String mimetype = c.getString(colMimetype);
                    if (mimetype.equals("vnd.android.cursor.item/name")) {
                        contact.put("displayName", c.getString(colDisplayName));
                    }
                    if (mimetype.equals("vnd.android.cursor.item/name") && isRequired(DBFavorites.KEY_NAME, populate)) {
                        contact.put(DBFavorites.KEY_NAME, nameQuery(c));
                        oldContactId = contactId;
                    } else if (mimetype.equals("vnd.android.cursor.item/phone_v2") && isRequired("phoneNumbers", populate)) {
                        phones2.put(phoneQuery(c));
                        oldContactId = contactId;
                    } else if (mimetype.equals("vnd.android.cursor.item/email_v2") && isRequired("emails", populate)) {
                        emails2.put(emailQuery(c));
                        oldContactId = contactId;
                    } else if (mimetype.equals("vnd.android.cursor.item/postal-address_v2") && isRequired("addresses", populate)) {
                        addresses2.put(addressQuery(c));
                        oldContactId = contactId;
                    } else if (mimetype.equals("vnd.android.cursor.item/organization") && isRequired("organizations", populate)) {
                        organizations2.put(organizationQuery(c));
                        oldContactId = contactId;
                    } else if (mimetype.equals("vnd.android.cursor.item/im") && isRequired("ims", populate)) {
                        ims.put(imQuery(c));
                        oldContactId = contactId;
                    } else if (mimetype.equals("vnd.android.cursor.item/note") && isRequired("note", populate)) {
                        contact.put("note", c.getString(colNote));
                        oldContactId = contactId;
                    } else if (mimetype.equals("vnd.android.cursor.item/nickname") && isRequired("nickname", populate)) {
                        contact.put("nickname", c.getString(colNickname));
                        oldContactId = contactId;
                    } else if (!mimetype.equals("vnd.android.cursor.item/website") || !isRequired("urls", populate)) {
                        if (mimetype.equals("vnd.android.cursor.item/contact_event")) {
                            if (isRequired("birthday", populate) && 3 == c.getInt(colEventType)) {
                                contact.put("birthday", c.getString(colBirthday));
                            }
                        } else if (mimetype.equals("vnd.android.cursor.item/photo") && isRequired("photos", populate)) {
                            photos.put(photoQuery(c, contactId));
                        }
                        oldContactId = contactId;
                    } else {
                        websites.put(websiteQuery(c));
                        oldContactId = contactId;
                    }
                } catch (JSONException e8) {
                    e = e8;
                    Log.e("ContactsAccessor", e.getMessage(), e);
                    oldContactId = contactId;
                }
            }
            if (contacts.length() < limit) {
                contacts.put(populateContact(contact, organizations2, addresses2, phones2, emails2, ims, websites, photos));
            }
        }
        c.close();
        return contacts;
    }

    private ContactAccessor.WhereOptions buildIdClause(Set<String> contactIds, String searchTerm) {
        ContactAccessor.WhereOptions options = new ContactAccessor.WhereOptions();
        if (searchTerm.equals("%")) {
            options.setWhere("(contact_id LIKE ? )");
            options.setWhereArgs(new String[]{searchTerm});
        } else {
            Iterator<String> it = contactIds.iterator();
            StringBuffer buffer = new StringBuffer("(");
            while (it.hasNext()) {
                buffer.append("'" + it.next() + "'");
                if (it.hasNext()) {
                    buffer.append(",");
                }
            }
            buffer.append(")");
            options.setWhere("contact_id IN " + buffer.toString());
            options.setWhereArgs((String[]) null);
        }
        return options;
    }

    private JSONObject populateContact(JSONObject contact, JSONArray organizations, JSONArray addresses, JSONArray phones, JSONArray emails, JSONArray ims, JSONArray websites, JSONArray photos) {
        try {
            if (organizations.length() > 0) {
                contact.put("organizations", organizations);
            }
            if (addresses.length() > 0) {
                contact.put("addresses", addresses);
            }
            if (phones.length() > 0) {
                contact.put("phoneNumbers", phones);
            }
            if (emails.length() > 0) {
                contact.put("emails", emails);
            }
            if (ims.length() > 0) {
                contact.put("ims", ims);
            }
            if (websites.length() > 0) {
                contact.put("urls", websites);
            }
            if (photos.length() > 0) {
                contact.put("photos", photos);
            }
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return contact;
    }

    private ContactAccessor.WhereOptions buildWhereClause(JSONArray fields, String searchTerm) {
        ArrayList<String> where = new ArrayList<>();
        ArrayList<String> whereArgs = new ArrayList<>();
        ContactAccessor.WhereOptions options = new ContactAccessor.WhereOptions();
        if (isWildCardSearch(fields)) {
            if ("%".equals(searchTerm)) {
                options.setWhere("(display_name LIKE ? )");
                options.setWhereArgs(new String[]{searchTerm});
                return options;
            }
            where.add("(" + dbMap.get("displayName") + " LIKE ? )");
            whereArgs.add(searchTerm);
            where.add("(" + dbMap.get(DBFavorites.KEY_NAME) + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/name");
            where.add("(" + dbMap.get("nickname") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/nickname");
            where.add("(" + dbMap.get("phoneNumbers") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/phone_v2");
            where.add("(" + dbMap.get("emails") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/email_v2");
            where.add("(" + dbMap.get("addresses") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/postal-address_v2");
            where.add("(" + dbMap.get("ims") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/im");
            where.add("(" + dbMap.get("organizations") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/organization");
            where.add("(" + dbMap.get("note") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/note");
            where.add("(" + dbMap.get("urls") + " LIKE ? AND " + "mimetype" + " = ? )");
            whereArgs.add(searchTerm);
            whereArgs.add("vnd.android.cursor.item/website");
        }
        if ("%".equals(searchTerm)) {
            options.setWhere("(display_name LIKE ? )");
            options.setWhereArgs(new String[]{searchTerm});
        } else {
            int i = 0;
            while (i < fields.length()) {
                try {
                    String key = fields.getString(i);
                    if (key.equals(DBFavorites.KEY_EVENT_ID)) {
                        where.add("(" + dbMap.get(key) + " = ? )");
                        whereArgs.add(searchTerm.substring(1, searchTerm.length() - 1));
                    } else if (key.startsWith("displayName")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? )");
                        whereArgs.add(searchTerm);
                    } else if (key.startsWith(DBFavorites.KEY_NAME)) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/name");
                    } else if (key.startsWith("nickname")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/nickname");
                    } else if (key.startsWith("phoneNumbers")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/phone_v2");
                    } else if (key.startsWith("emails")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/email_v2");
                    } else if (key.startsWith("addresses")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/postal-address_v2");
                    } else if (key.startsWith("ims")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/im");
                    } else if (key.startsWith("organizations")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/organization");
                    } else if (key.startsWith("note")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/note");
                    } else if (key.startsWith("urls")) {
                        where.add("(" + dbMap.get(key) + " LIKE ? AND " + "mimetype" + " = ? )");
                        whereArgs.add(searchTerm);
                        whereArgs.add("vnd.android.cursor.item/website");
                    }
                    i++;
                } catch (JSONException e) {
                    Log.e("ContactsAccessor", e.getMessage(), e);
                }
            }
            StringBuffer selection = new StringBuffer();
            for (int i2 = 0; i2 < where.size(); i2++) {
                selection.append(where.get(i2));
                if (i2 != where.size() - 1) {
                    selection.append(" OR ");
                }
            }
            options.setWhere(selection.toString());
            String[] selectionArgs = new String[whereArgs.size()];
            for (int i3 = 0; i3 < whereArgs.size(); i3++) {
                selectionArgs[i3] = whereArgs.get(i3);
            }
            options.setWhereArgs(selectionArgs);
        }
        return options;
    }

    private boolean isWildCardSearch(JSONArray fields) {
        if (fields.length() == 1) {
            try {
                if ("*".equals(fields.getString(0))) {
                    return true;
                }
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private JSONObject organizationQuery(Cursor cursor) {
        JSONObject organization = new JSONObject();
        try {
            organization.put(DBFavorites.KEY_EVENT_ID, cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID)));
            organization.put("pref", false);
            organization.put(Globalization.TYPE, getOrgType(cursor.getInt(cursor.getColumnIndex("data2"))));
            organization.put("department", cursor.getString(cursor.getColumnIndex("data5")));
            organization.put(DBFavorites.KEY_NAME, cursor.getString(cursor.getColumnIndex("data1")));
            organization.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, cursor.getString(cursor.getColumnIndex("data4")));
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return organization;
    }

    private JSONObject addressQuery(Cursor cursor) {
        JSONObject address = new JSONObject();
        try {
            address.put(DBFavorites.KEY_EVENT_ID, cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID)));
            address.put("pref", false);
            address.put(Globalization.TYPE, getAddressType(cursor.getInt(cursor.getColumnIndex("data2"))));
            address.put("formatted", cursor.getString(cursor.getColumnIndex("data1")));
            address.put("streetAddress", cursor.getString(cursor.getColumnIndex("data4")));
            address.put("locality", cursor.getString(cursor.getColumnIndex("data7")));
            address.put("region", cursor.getString(cursor.getColumnIndex("data8")));
            address.put("postalCode", cursor.getString(cursor.getColumnIndex("data9")));
            address.put("country", cursor.getString(cursor.getColumnIndex("data10")));
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return address;
    }

    private JSONObject nameQuery(Cursor cursor) {
        JSONObject contactName = new JSONObject();
        try {
            String familyName = cursor.getString(cursor.getColumnIndex("data3"));
            String givenName = cursor.getString(cursor.getColumnIndex("data2"));
            String middleName = cursor.getString(cursor.getColumnIndex("data5"));
            String honorificPrefix = cursor.getString(cursor.getColumnIndex("data4"));
            String honorificSuffix = cursor.getString(cursor.getColumnIndex("data6"));
            StringBuffer formatted = new StringBuffer("");
            if (honorificPrefix != null) {
                formatted.append(honorificPrefix + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            if (givenName != null) {
                formatted.append(givenName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            if (middleName != null) {
                formatted.append(middleName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            if (familyName != null) {
                formatted.append(familyName);
            }
            if (honorificSuffix != null) {
                formatted.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + honorificSuffix);
            }
            contactName.put("familyName", familyName);
            contactName.put("givenName", givenName);
            contactName.put("middleName", middleName);
            contactName.put("honorificPrefix", honorificPrefix);
            contactName.put("honorificSuffix", honorificSuffix);
            contactName.put("formatted", formatted);
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return contactName;
    }

    private JSONObject phoneQuery(Cursor cursor) {
        JSONObject phoneNumber = new JSONObject();
        try {
            phoneNumber.put(DBFavorites.KEY_EVENT_ID, cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID)));
            phoneNumber.put("pref", false);
            phoneNumber.put("value", cursor.getString(cursor.getColumnIndex("data1")));
            phoneNumber.put(Globalization.TYPE, getPhoneType(cursor.getInt(cursor.getColumnIndex("data2"))));
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        } catch (Exception excp) {
            Log.e("ContactsAccessor", excp.getMessage(), excp);
        }
        return phoneNumber;
    }

    private JSONObject emailQuery(Cursor cursor) {
        JSONObject email = new JSONObject();
        try {
            email.put(DBFavorites.KEY_EVENT_ID, cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID)));
            email.put("pref", false);
            email.put("value", cursor.getString(cursor.getColumnIndex("data1")));
            email.put(Globalization.TYPE, getContactType(cursor.getInt(cursor.getColumnIndex("data2"))));
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return email;
    }

    private JSONObject imQuery(Cursor cursor) {
        JSONObject im = new JSONObject();
        try {
            im.put(DBFavorites.KEY_EVENT_ID, cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID)));
            im.put("pref", false);
            im.put("value", cursor.getString(cursor.getColumnIndex("data1")));
            im.put(Globalization.TYPE, getImType(new Integer(cursor.getString(cursor.getColumnIndex("data5"))).intValue()));
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return im;
    }

    private JSONObject websiteQuery(Cursor cursor) {
        JSONObject website = new JSONObject();
        try {
            website.put(DBFavorites.KEY_EVENT_ID, cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID)));
            website.put("pref", false);
            website.put("value", cursor.getString(cursor.getColumnIndex("data1")));
            website.put(Globalization.TYPE, getContactType(cursor.getInt(cursor.getColumnIndex("data2"))));
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return website;
    }

    private JSONObject photoQuery(Cursor cursor, String contactId) {
        JSONObject photo = new JSONObject();
        try {
            photo.put(DBFavorites.KEY_EVENT_ID, cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID)));
            photo.put("pref", false);
            photo.put(Globalization.TYPE, PlusShare.KEY_CALL_TO_ACTION_URL);
            photo.put("value", Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, new Long(contactId).longValue()), "photo").toString());
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
        return photo;
    }

    public String save(JSONObject contact) {
        Account[] accounts = AccountManager.get(this.mApp.getActivity()).getAccounts();
        String accountName = null;
        String accountType = null;
        if (accounts.length == 1) {
            accountName = accounts[0].name;
            accountType = accounts[0].type;
        } else if (accounts.length > 1) {
            Account[] arr$ = accounts;
            int len$ = arr$.length;
            int i$ = 0;
            while (true) {
                if (i$ >= len$) {
                    break;
                }
                Account a = arr$[i$];
                if (a.type.contains("eas") && a.name.matches(EMAIL_REGEXP)) {
                    accountName = a.name;
                    accountType = a.type;
                    break;
                }
                i$++;
            }
            if (accountName == null) {
                Account[] arr$2 = accounts;
                int len$2 = arr$2.length;
                int i$2 = 0;
                while (true) {
                    if (i$2 >= len$2) {
                        break;
                    }
                    Account a2 = arr$2[i$2];
                    if (a2.type.contains(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE) && a2.name.matches(EMAIL_REGEXP)) {
                        accountName = a2.name;
                        accountType = a2.type;
                        break;
                    }
                    i$2++;
                }
            }
            if (accountName == null) {
                Account[] arr$3 = accounts;
                int len$3 = arr$3.length;
                int i$3 = 0;
                while (true) {
                    if (i$3 >= len$3) {
                        break;
                    }
                    Account a3 = arr$3[i$3];
                    if (a3.name.matches(EMAIL_REGEXP)) {
                        accountName = a3.name;
                        accountType = a3.type;
                        break;
                    }
                    i$3++;
                }
            }
        }
        String id = getJsonString(contact, DBFavorites.KEY_EVENT_ID);
        if (id == null) {
            return createNewContact(contact, accountType, accountName);
        }
        return modifyContact(id, contact, accountType, accountName);
    }

    private String modifyContact(String id, JSONObject contact, String accountType, String accountName) {
        int rawId = new Integer(getJsonString(contact, "rawId")).intValue();
        ArrayList<ContentProviderOperation> ops = new ArrayList<>();
        ops.add(ContentProviderOperation.newUpdate(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", accountType).withValue("account_name", accountName).build());
        try {
            String displayName = getJsonString(contact, "displayName");
            JSONObject name = contact.getJSONObject(DBFavorites.KEY_NAME);
            if (!(displayName == null && name == null)) {
                ContentProviderOperation.Builder builder = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{id, "vnd.android.cursor.item/name"});
                if (displayName != null) {
                    builder.withValue("data1", displayName);
                }
                String familyName = getJsonString(name, "familyName");
                if (familyName != null) {
                    builder.withValue("data3", familyName);
                }
                String middleName = getJsonString(name, "middleName");
                if (middleName != null) {
                    builder.withValue("data5", middleName);
                }
                String givenName = getJsonString(name, "givenName");
                if (givenName != null) {
                    builder.withValue("data2", givenName);
                }
                String honorificPrefix = getJsonString(name, "honorificPrefix");
                if (honorificPrefix != null) {
                    builder.withValue("data4", honorificPrefix);
                }
                String honorificSuffix = getJsonString(name, "honorificSuffix");
                if (honorificSuffix != null) {
                    builder.withValue("data6", honorificSuffix);
                }
                ops.add(builder.build());
            }
        } catch (JSONException e) {
            Log.d("ContactsAccessor", "Could not get name");
        }
        try {
            JSONArray phones = contact.getJSONArray("phoneNumbers");
            if (phones != null) {
                if (phones.length() == 0) {
                    ops.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{"" + rawId, "vnd.android.cursor.item/phone_v2"}).build());
                } else {
                    for (int i = 0; i < phones.length(); i++) {
                        JSONObject phone = (JSONObject) phones.get(i);
                        String phoneId = getJsonString(phone, DBFavorites.KEY_EVENT_ID);
                        if (phoneId == null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("raw_contact_id", Integer.valueOf(rawId));
                            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                            contentValues.put("data1", getJsonString(phone, "value"));
                            contentValues.put("data2", Integer.valueOf(getPhoneType(getJsonString(phone, Globalization.TYPE))));
                            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(contentValues).build());
                        } else {
                            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=? AND mimetype=?", new String[]{phoneId, "vnd.android.cursor.item/phone_v2"}).withValue("data1", getJsonString(phone, "value")).withValue("data2", Integer.valueOf(getPhoneType(getJsonString(phone, Globalization.TYPE)))).build());
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            Log.d("ContactsAccessor", "Could not get phone numbers");
        }
        try {
            JSONArray emails = contact.getJSONArray("emails");
            if (emails != null) {
                if (emails.length() == 0) {
                    ops.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{"" + rawId, "vnd.android.cursor.item/email_v2"}).build());
                } else {
                    for (int i2 = 0; i2 < emails.length(); i2++) {
                        JSONObject email = (JSONObject) emails.get(i2);
                        String emailId = getJsonString(email, DBFavorites.KEY_EVENT_ID);
                        if (emailId == null) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("raw_contact_id", Integer.valueOf(rawId));
                            contentValues2.put("mimetype", "vnd.android.cursor.item/email_v2");
                            contentValues2.put("data1", getJsonString(email, "value"));
                            contentValues2.put("data2", Integer.valueOf(getContactType(getJsonString(email, Globalization.TYPE))));
                            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(contentValues2).build());
                        } else {
                            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=? AND mimetype=?", new String[]{emailId, "vnd.android.cursor.item/email_v2"}).withValue("data1", getJsonString(email, "value")).withValue("data2", Integer.valueOf(getContactType(getJsonString(email, Globalization.TYPE)))).build());
                        }
                    }
                }
            }
        } catch (JSONException e3) {
            Log.d("ContactsAccessor", "Could not get emails");
        }
        try {
            JSONArray addresses = contact.getJSONArray("addresses");
            if (addresses != null) {
                if (addresses.length() == 0) {
                    ops.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{"" + rawId, "vnd.android.cursor.item/postal-address_v2"}).build());
                } else {
                    for (int i3 = 0; i3 < addresses.length(); i3++) {
                        JSONObject address = (JSONObject) addresses.get(i3);
                        String addressId = getJsonString(address, DBFavorites.KEY_EVENT_ID);
                        if (addressId == null) {
                            ContentValues contentValues3 = new ContentValues();
                            contentValues3.put("raw_contact_id", Integer.valueOf(rawId));
                            contentValues3.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
                            contentValues3.put("data2", Integer.valueOf(getAddressType(getJsonString(address, Globalization.TYPE))));
                            contentValues3.put("data1", getJsonString(address, "formatted"));
                            contentValues3.put("data4", getJsonString(address, "streetAddress"));
                            contentValues3.put("data7", getJsonString(address, "locality"));
                            contentValues3.put("data8", getJsonString(address, "region"));
                            contentValues3.put("data9", getJsonString(address, "postalCode"));
                            contentValues3.put("data10", getJsonString(address, "country"));
                            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(contentValues3).build());
                        } else {
                            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=? AND mimetype=?", new String[]{addressId, "vnd.android.cursor.item/postal-address_v2"}).withValue("data2", Integer.valueOf(getAddressType(getJsonString(address, Globalization.TYPE)))).withValue("data1", getJsonString(address, "formatted")).withValue("data4", getJsonString(address, "streetAddress")).withValue("data7", getJsonString(address, "locality")).withValue("data8", getJsonString(address, "region")).withValue("data9", getJsonString(address, "postalCode")).withValue("data10", getJsonString(address, "country")).build());
                        }
                    }
                }
            }
        } catch (JSONException e4) {
            Log.d("ContactsAccessor", "Could not get addresses");
        }
        try {
            JSONArray organizations = contact.getJSONArray("organizations");
            if (organizations != null) {
                if (organizations.length() == 0) {
                    ops.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{"" + rawId, "vnd.android.cursor.item/organization"}).build());
                } else {
                    for (int i4 = 0; i4 < organizations.length(); i4++) {
                        JSONObject org2 = (JSONObject) organizations.get(i4);
                        String orgId = getJsonString(org2, DBFavorites.KEY_EVENT_ID);
                        if (orgId == null) {
                            ContentValues contentValues4 = new ContentValues();
                            contentValues4.put("raw_contact_id", Integer.valueOf(rawId));
                            contentValues4.put("mimetype", "vnd.android.cursor.item/organization");
                            contentValues4.put("data2", Integer.valueOf(getOrgType(getJsonString(org2, Globalization.TYPE))));
                            contentValues4.put("data5", getJsonString(org2, "department"));
                            contentValues4.put("data1", getJsonString(org2, DBFavorites.KEY_NAME));
                            contentValues4.put("data4", getJsonString(org2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(contentValues4).build());
                        } else {
                            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=? AND mimetype=?", new String[]{orgId, "vnd.android.cursor.item/organization"}).withValue("data2", Integer.valueOf(getOrgType(getJsonString(org2, Globalization.TYPE)))).withValue("data5", getJsonString(org2, "department")).withValue("data1", getJsonString(org2, DBFavorites.KEY_NAME)).withValue("data4", getJsonString(org2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)).build());
                        }
                    }
                }
            }
        } catch (JSONException e5) {
            Log.d("ContactsAccessor", "Could not get organizations");
        }
        try {
            JSONArray ims = contact.getJSONArray("ims");
            if (ims != null) {
                if (ims.length() == 0) {
                    ops.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{"" + rawId, "vnd.android.cursor.item/im"}).build());
                } else {
                    for (int i5 = 0; i5 < ims.length(); i5++) {
                        JSONObject im = (JSONObject) ims.get(i5);
                        String imId = getJsonString(im, DBFavorites.KEY_EVENT_ID);
                        if (imId == null) {
                            ContentValues contentValues5 = new ContentValues();
                            contentValues5.put("raw_contact_id", Integer.valueOf(rawId));
                            contentValues5.put("mimetype", "vnd.android.cursor.item/im");
                            contentValues5.put("data1", getJsonString(im, "value"));
                            contentValues5.put("data2", Integer.valueOf(getImType(getJsonString(im, Globalization.TYPE))));
                            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(contentValues5).build());
                        } else {
                            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=? AND mimetype=?", new String[]{imId, "vnd.android.cursor.item/im"}).withValue("data1", getJsonString(im, "value")).withValue("data2", Integer.valueOf(getContactType(getJsonString(im, Globalization.TYPE)))).build());
                        }
                    }
                }
            }
        } catch (JSONException e6) {
            Log.d("ContactsAccessor", "Could not get emails");
        }
        ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{id, "vnd.android.cursor.item/note"}).withValue("data1", getJsonString(contact, "note")).build());
        String nickname = getJsonString(contact, "nickname");
        if (nickname != null) {
            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{id, "vnd.android.cursor.item/nickname"}).withValue("data1", nickname).build());
        }
        try {
            JSONArray websites = contact.getJSONArray("urls");
            if (websites != null) {
                if (websites.length() == 0) {
                    Log.d("ContactsAccessor", "This means we should be deleting all the phone numbers.");
                    ops.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{"" + rawId, "vnd.android.cursor.item/website"}).build());
                } else {
                    for (int i6 = 0; i6 < websites.length(); i6++) {
                        JSONObject website = (JSONObject) websites.get(i6);
                        String websiteId = getJsonString(website, DBFavorites.KEY_EVENT_ID);
                        if (websiteId == null) {
                            ContentValues contentValues6 = new ContentValues();
                            contentValues6.put("raw_contact_id", Integer.valueOf(rawId));
                            contentValues6.put("mimetype", "vnd.android.cursor.item/website");
                            contentValues6.put("data1", getJsonString(website, "value"));
                            contentValues6.put("data2", Integer.valueOf(getContactType(getJsonString(website, Globalization.TYPE))));
                            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(contentValues6).build());
                        } else {
                            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=? AND mimetype=?", new String[]{websiteId, "vnd.android.cursor.item/website"}).withValue("data1", getJsonString(website, "value")).withValue("data2", Integer.valueOf(getContactType(getJsonString(website, Globalization.TYPE)))).build());
                        }
                    }
                }
            }
        } catch (JSONException e7) {
            Log.d("ContactsAccessor", "Could not get websites");
        }
        String birthday = getJsonString(contact, "birthday");
        if (birthday != null) {
            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=? AND data2=?", new String[]{id, "vnd.android.cursor.item/contact_event", new String("3")}).withValue("data2", 3).withValue("data1", birthday).build());
        }
        try {
            JSONArray photos = contact.getJSONArray("photos");
            if (photos != null) {
                if (photos.length() == 0) {
                    ops.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{"" + rawId, "vnd.android.cursor.item/photo"}).build());
                } else {
                    for (int i7 = 0; i7 < photos.length(); i7++) {
                        JSONObject photo = (JSONObject) photos.get(i7);
                        String photoId = getJsonString(photo, DBFavorites.KEY_EVENT_ID);
                        byte[] bytes = getPhotoBytes(getJsonString(photo, "value"));
                        if (photoId == null) {
                            ContentValues contentValues7 = new ContentValues();
                            contentValues7.put("raw_contact_id", Integer.valueOf(rawId));
                            contentValues7.put("mimetype", "vnd.android.cursor.item/photo");
                            contentValues7.put("is_super_primary", 1);
                            contentValues7.put("data15", bytes);
                            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(contentValues7).build());
                        } else {
                            ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=? AND mimetype=?", new String[]{photoId, "vnd.android.cursor.item/photo"}).withValue("is_super_primary", 1).withValue("data15", bytes).build());
                        }
                    }
                }
            }
        } catch (JSONException e8) {
            Log.d("ContactsAccessor", "Could not get photos");
        }
        boolean retVal = true;
        try {
            this.mApp.getActivity().getContentResolver().applyBatch("com.android.contacts", ops);
        } catch (RemoteException e9) {
            Log.e("ContactsAccessor", e9.getMessage(), e9);
            Log.e("ContactsAccessor", Log.getStackTraceString(e9), e9);
            retVal = false;
        } catch (OperationApplicationException e10) {
            Log.e("ContactsAccessor", e10.getMessage(), e10);
            Log.e("ContactsAccessor", Log.getStackTraceString(e10), e10);
            retVal = false;
        }
        if (retVal) {
            return id;
        }
        return null;
    }

    private void insertWebsite(ArrayList<ContentProviderOperation> ops, JSONObject website) {
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", getJsonString(website, "value")).withValue("data2", Integer.valueOf(getContactType(getJsonString(website, Globalization.TYPE)))).build());
    }

    private void insertIm(ArrayList<ContentProviderOperation> ops, JSONObject im) {
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", getJsonString(im, "value")).withValue("data2", Integer.valueOf(getImType(getJsonString(im, Globalization.TYPE)))).build());
    }

    private void insertOrganization(ArrayList<ContentProviderOperation> ops, JSONObject org2) {
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data2", Integer.valueOf(getOrgType(getJsonString(org2, Globalization.TYPE)))).withValue("data5", getJsonString(org2, "department")).withValue("data1", getJsonString(org2, DBFavorites.KEY_NAME)).withValue("data4", getJsonString(org2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)).build());
    }

    private void insertAddress(ArrayList<ContentProviderOperation> ops, JSONObject address) {
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(getAddressType(getJsonString(address, Globalization.TYPE)))).withValue("data1", getJsonString(address, "formatted")).withValue("data4", getJsonString(address, "streetAddress")).withValue("data7", getJsonString(address, "locality")).withValue("data8", getJsonString(address, "region")).withValue("data9", getJsonString(address, "postalCode")).withValue("data10", getJsonString(address, "country")).build());
    }

    private void insertEmail(ArrayList<ContentProviderOperation> ops, JSONObject email) {
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", getJsonString(email, "value")).withValue("data2", Integer.valueOf(getPhoneType(getJsonString(email, Globalization.TYPE)))).build());
    }

    private void insertPhone(ArrayList<ContentProviderOperation> ops, JSONObject phone) {
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", getJsonString(phone, "value")).withValue("data2", Integer.valueOf(getPhoneType(getJsonString(phone, Globalization.TYPE)))).build());
    }

    private void insertPhoto(ArrayList<ContentProviderOperation> ops, JSONObject photo) {
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("is_super_primary", 1).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", getPhotoBytes(getJsonString(photo, "value"))).build());
    }

    private byte[] getPhotoBytes(String filename) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        long totalBytesRead = 0;
        try {
            byte[] data = new byte[8192];
            InputStream in = getPathFromUri(filename);
            while (true) {
                int bytesRead = in.read(data, 0, data.length);
                if (bytesRead == -1 || totalBytesRead > MAX_PHOTO_SIZE) {
                    in.close();
                    buffer.flush();
                } else {
                    buffer.write(data, 0, bytesRead);
                    totalBytesRead += (long) bytesRead;
                }
            }
            in.close();
            buffer.flush();
        } catch (FileNotFoundException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        } catch (IOException e2) {
            Log.e("ContactsAccessor", e2.getMessage(), e2);
        }
        return buffer.toByteArray();
    }

    private InputStream getPathFromUri(String path) throws IOException {
        if (path.startsWith("content:")) {
            return this.mApp.getActivity().getContentResolver().openInputStream(Uri.parse(path));
        } else if (path.startsWith("http:") || path.startsWith("file:")) {
            return new URL(path).openStream();
        } else {
            return new FileInputStream(path);
        }
    }

    private String createNewContact(JSONObject contact, String accountType, String accountName) {
        ArrayList<ContentProviderOperation> ops = new ArrayList<>();
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", accountType).withValue("account_name", accountName).build());
        try {
            JSONObject name = contact.optJSONObject(DBFavorites.KEY_NAME);
            String displayName = contact.getString("displayName");
            if (!(displayName == null && name == null)) {
                ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", displayName).withValue("data3", getJsonString(name, "familyName")).withValue("data5", getJsonString(name, "middleName")).withValue("data2", getJsonString(name, "givenName")).withValue("data4", getJsonString(name, "honorificPrefix")).withValue("data6", getJsonString(name, "honorificSuffix")).build());
            }
        } catch (JSONException e) {
            Log.d("ContactsAccessor", "Could not get name object");
        }
        try {
            JSONArray phones = contact.getJSONArray("phoneNumbers");
            if (phones != null) {
                for (int i = 0; i < phones.length(); i++) {
                    insertPhone(ops, (JSONObject) phones.get(i));
                }
            }
        } catch (JSONException e2) {
            Log.d("ContactsAccessor", "Could not get phone numbers");
        }
        try {
            JSONArray emails = contact.getJSONArray("emails");
            if (emails != null) {
                for (int i2 = 0; i2 < emails.length(); i2++) {
                    insertEmail(ops, (JSONObject) emails.get(i2));
                }
            }
        } catch (JSONException e3) {
            Log.d("ContactsAccessor", "Could not get emails");
        }
        try {
            JSONArray addresses = contact.getJSONArray("addresses");
            if (addresses != null) {
                for (int i3 = 0; i3 < addresses.length(); i3++) {
                    insertAddress(ops, (JSONObject) addresses.get(i3));
                }
            }
        } catch (JSONException e4) {
            Log.d("ContactsAccessor", "Could not get addresses");
        }
        try {
            JSONArray organizations = contact.getJSONArray("organizations");
            if (organizations != null) {
                for (int i4 = 0; i4 < organizations.length(); i4++) {
                    insertOrganization(ops, (JSONObject) organizations.get(i4));
                }
            }
        } catch (JSONException e5) {
            Log.d("ContactsAccessor", "Could not get organizations");
        }
        try {
            JSONArray ims = contact.getJSONArray("ims");
            if (ims != null) {
                for (int i5 = 0; i5 < ims.length(); i5++) {
                    insertIm(ops, (JSONObject) ims.get(i5));
                }
            }
        } catch (JSONException e6) {
            Log.d("ContactsAccessor", "Could not get emails");
        }
        String note = getJsonString(contact, "note");
        if (note != null) {
            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", note).build());
        }
        String nickname = getJsonString(contact, "nickname");
        if (nickname != null) {
            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/nickname").withValue("data1", nickname).build());
        }
        try {
            JSONArray websites = contact.getJSONArray("urls");
            if (websites != null) {
                for (int i6 = 0; i6 < websites.length(); i6++) {
                    insertWebsite(ops, (JSONObject) websites.get(i6));
                }
            }
        } catch (JSONException e7) {
            Log.d("ContactsAccessor", "Could not get websites");
        }
        String birthday = getJsonString(contact, "birthday");
        if (birthday != null) {
            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data2", 3).withValue("data1", birthday).build());
        }
        try {
            JSONArray photos = contact.getJSONArray("photos");
            if (photos != null) {
                for (int i7 = 0; i7 < photos.length(); i7++) {
                    insertPhoto(ops, (JSONObject) photos.get(i7));
                }
            }
        } catch (JSONException e8) {
            Log.d("ContactsAccessor", "Could not get photos");
        }
        try {
            ContentProviderResult[] cpResults = this.mApp.getActivity().getContentResolver().applyBatch("com.android.contacts", ops);
            if (cpResults.length >= 0) {
                return cpResults[0].uri.getLastPathSegment();
            }
            return null;
        } catch (RemoteException e9) {
            Log.e("ContactsAccessor", e9.getMessage(), e9);
            return null;
        } catch (OperationApplicationException e10) {
            Log.e("ContactsAccessor", e10.getMessage(), e10);
            return null;
        }
    }

    public boolean remove(String id) {
        int result = 0;
        Cursor cursor = this.mApp.getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, (String[]) null, "_id = ?", new String[]{id}, (String) null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            result = this.mApp.getActivity().getContentResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, cursor.getString(cursor.getColumnIndex("lookup"))), (String) null, (String[]) null);
        } else {
            Log.d("ContactsAccessor", "Could not find contact with ID");
        }
        if (result > 0) {
            return true;
        }
        return false;
    }

    private int getPhoneType(String string) {
        if (string == null) {
            return 7;
        }
        if ("home".equals(string.toLowerCase())) {
            return 1;
        }
        if (NetworkManager.MOBILE.equals(string.toLowerCase())) {
            return 2;
        }
        if ("work".equals(string.toLowerCase())) {
            return 3;
        }
        if ("work fax".equals(string.toLowerCase())) {
            return 4;
        }
        if ("home fax".equals(string.toLowerCase())) {
            return 5;
        }
        if ("fax".equals(string.toLowerCase())) {
            return 4;
        }
        if ("pager".equals(string.toLowerCase())) {
            return 6;
        }
        if ("other".equals(string.toLowerCase())) {
            return 7;
        }
        if ("car".equals(string.toLowerCase())) {
            return 9;
        }
        if ("company main".equals(string.toLowerCase())) {
            return 10;
        }
        if ("isdn".equals(string.toLowerCase())) {
            return 11;
        }
        if ("main".equals(string.toLowerCase())) {
            return 12;
        }
        if ("other fax".equals(string.toLowerCase())) {
            return 13;
        }
        if ("radio".equals(string.toLowerCase())) {
            return 14;
        }
        if ("telex".equals(string.toLowerCase())) {
            return 15;
        }
        if ("work mobile".equals(string.toLowerCase())) {
            return 17;
        }
        if ("work pager".equals(string.toLowerCase())) {
            return 18;
        }
        if ("assistant".equals(string.toLowerCase())) {
            return 19;
        }
        if ("mms".equals(string.toLowerCase())) {
            return 20;
        }
        if ("callback".equals(string.toLowerCase())) {
            return 8;
        }
        if ("tty ttd".equals(string.toLowerCase())) {
            return 16;
        }
        if ("custom".equals(string.toLowerCase())) {
            return 0;
        }
        return 7;
    }

    private String getPhoneType(int type) {
        switch (type) {
            case 0:
                return "custom";
            case 1:
                return "home";
            case 2:
                return NetworkManager.MOBILE;
            case 3:
                return "work";
            case 4:
                return "work fax";
            case 5:
                return "home fax";
            case 6:
                return "pager";
            case 8:
                return "callback";
            case 9:
                return "car";
            case 10:
                return "company main";
            case 11:
                return "isdn";
            case 13:
                return "other fax";
            case 14:
                return "radio";
            case 15:
                return "telex";
            case 16:
                return "tty tdd";
            case 17:
                return "work mobile";
            case 18:
                return "work pager";
            case 19:
                return "assistant";
            case 20:
                return "mms";
            default:
                return "other";
        }
    }

    private int getContactType(String string) {
        if (string == null) {
            return 3;
        }
        if ("home".equals(string.toLowerCase())) {
            return 1;
        }
        if ("work".equals(string.toLowerCase())) {
            return 2;
        }
        if ("other".equals(string.toLowerCase())) {
            return 3;
        }
        if (NetworkManager.MOBILE.equals(string.toLowerCase())) {
            return 4;
        }
        if ("custom".equals(string.toLowerCase())) {
            return 0;
        }
        return 3;
    }

    private String getContactType(int type) {
        switch (type) {
            case 0:
                return "custom";
            case 1:
                return "home";
            case 2:
                return "work";
            case 4:
                return NetworkManager.MOBILE;
            default:
                return "other";
        }
    }

    private int getOrgType(String string) {
        if (string == null) {
            return 2;
        }
        if ("work".equals(string.toLowerCase())) {
            return 1;
        }
        if (!"other".equals(string.toLowerCase()) && "custom".equals(string.toLowerCase())) {
            return 0;
        }
        return 2;
    }

    private String getOrgType(int type) {
        switch (type) {
            case 0:
                return "custom";
            case 1:
                return "work";
            default:
                return "other";
        }
    }

    private int getAddressType(String string) {
        if (string == null) {
            return 3;
        }
        if ("work".equals(string.toLowerCase())) {
            return 2;
        }
        if (!"other".equals(string.toLowerCase()) && "home".equals(string.toLowerCase())) {
            return 1;
        }
        return 3;
    }

    private String getAddressType(int type) {
        switch (type) {
            case 1:
                return "home";
            case 2:
                return "work";
            default:
                return "other";
        }
    }

    private int getImType(String string) {
        if (string == null) {
            return -1;
        }
        if ("aim".equals(string.toLowerCase())) {
            return 0;
        }
        if ("google talk".equals(string.toLowerCase())) {
            return 5;
        }
        if ("icq".equals(string.toLowerCase())) {
            return 6;
        }
        if ("jabber".equals(string.toLowerCase())) {
            return 7;
        }
        if ("msn".equals(string.toLowerCase())) {
            return 1;
        }
        if ("netmeeting".equals(string.toLowerCase())) {
            return 8;
        }
        if ("qq".equals(string.toLowerCase())) {
            return 4;
        }
        if ("skype".equals(string.toLowerCase())) {
            return 3;
        }
        if ("yahoo".equals(string.toLowerCase())) {
            return 2;
        }
        return -1;
    }

    private String getImType(int type) {
        switch (type) {
            case 0:
                return "AIM";
            case 1:
                return "MSN";
            case 2:
                return "Yahoo";
            case 3:
                return "Skype";
            case 4:
                return "QQ";
            case 5:
                return "Google Talk";
            case 6:
                return "ICQ";
            case 7:
                return "Jabber";
            case 8:
                return "NetMeeting";
            default:
                return "custom";
        }
    }
}
