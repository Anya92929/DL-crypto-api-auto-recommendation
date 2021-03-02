package com.parse;

import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseACL {
    private static final String PUBLIC_KEY = "*";
    private static final String UNRESOLVED_KEY = "*unresolved";
    private static ParseACL defaultACL;
    private static boolean defaultACLUsesCurrentUser;
    private static ParseACL defaultACLWithCurrentUser;
    private static WeakReference<ParseUser> lastCurrentUser;
    private JSONObject permissionsById;
    private boolean shared;
    private ParseUser unresolvedUser;

    private static class UserResolutionListener extends GetCallback<ParseObject> {
        private final WeakReference<ParseACL> parent;

        public UserResolutionListener(ParseACL parent2) {
            this.parent = new WeakReference<>(parent2);
        }

        public void done(ParseObject object, ParseException e) {
            try {
                ParseACL parent2 = (ParseACL) this.parent.get();
                if (parent2 != null) {
                    parent2.resolveUser((ParseUser) object);
                }
            } finally {
                object.unregisterSaveListener(this);
            }
        }
    }

    public ParseACL() {
        this.permissionsById = new JSONObject();
    }

    /* access modifiers changed from: package-private */
    public ParseACL copy() {
        ParseACL copy = new ParseACL();
        try {
            copy.permissionsById = new JSONObject(this.permissionsById.toString());
            copy.unresolvedUser = this.unresolvedUser;
            if (this.unresolvedUser != null) {
                this.unresolvedUser.registerSaveListener(new UserResolutionListener(copy));
            }
            return copy;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isShared() {
        return this.shared;
    }

    /* access modifiers changed from: package-private */
    public void setShared(boolean shared2) {
        this.shared = shared2;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSONObject() {
        return this.permissionsById;
    }

    static ParseACL createACLFromJSONObject(JSONObject object) {
        ParseACL acl = new ParseACL();
        for (String userId : Parse.keys(object)) {
            try {
                for (String accessType : Parse.keys(object.getJSONObject(userId))) {
                    acl.setAccess(accessType, userId, true);
                }
            } catch (JSONException e) {
                throw new RuntimeException("could not decode ACL: " + e.getMessage());
            }
        }
        return acl;
    }

    public ParseACL(ParseUser owner) {
        this();
        setReadAccess(owner, true);
        setWriteAccess(owner, true);
    }

    /* access modifiers changed from: private */
    public void resolveUser(ParseUser user) {
        if (user == this.unresolvedUser) {
            try {
                if (this.permissionsById.has(UNRESOLVED_KEY)) {
                    this.permissionsById.put(user.getObjectId(), this.permissionsById.get(UNRESOLVED_KEY));
                    this.permissionsById.remove(UNRESOLVED_KEY);
                }
                this.unresolvedUser = null;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasUnresolvedUser() {
        return this.unresolvedUser != null;
    }

    private void setAccess(String accessType, String userId, boolean allowed) {
        try {
            JSONObject permissions = this.permissionsById.optJSONObject(userId);
            if (permissions == null) {
                if (allowed) {
                    permissions = new JSONObject();
                    this.permissionsById.put(userId, permissions);
                } else {
                    return;
                }
            }
            if (allowed) {
                permissions.put(accessType, true);
                return;
            }
            permissions.remove(accessType);
            if (permissions.length() == 0) {
                this.permissionsById.remove(userId);
            }
        } catch (JSONException e) {
            throw new RuntimeException("JSON failure with ACL: " + e.getMessage());
        }
    }

    private boolean getAccess(String accessType, String userId) {
        try {
            JSONObject permissions = this.permissionsById.optJSONObject(userId);
            if (permissions != null && permissions.has(accessType)) {
                return permissions.getBoolean(accessType);
            }
            return false;
        } catch (JSONException e) {
            throw new RuntimeException("JSON failure with ACL: " + e.getMessage());
        }
    }

    public void setPublicReadAccess(boolean allowed) {
        setReadAccess(PUBLIC_KEY, allowed);
    }

    public boolean getPublicReadAccess() {
        return getReadAccess(PUBLIC_KEY);
    }

    public void setPublicWriteAccess(boolean allowed) {
        setWriteAccess(PUBLIC_KEY, allowed);
    }

    public boolean getPublicWriteAccess() {
        return getWriteAccess(PUBLIC_KEY);
    }

    public void setReadAccess(String userId, boolean allowed) {
        if (userId == null) {
            throw new IllegalArgumentException("cannot setReadAccess for null userId");
        }
        setAccess("read", userId, allowed);
    }

    public boolean getReadAccess(String userId) {
        if (userId != null) {
            return getAccess("read", userId);
        }
        throw new IllegalArgumentException("cannot getReadAccess for null userId");
    }

    public void setWriteAccess(String userId, boolean allowed) {
        if (userId == null) {
            throw new IllegalArgumentException("cannot setWriteAccess for null userId");
        }
        setAccess("write", userId, allowed);
    }

    public boolean getWriteAccess(String userId) {
        if (userId != null) {
            return getAccess("write", userId);
        }
        throw new IllegalArgumentException("cannot getWriteAccess for null userId");
    }

    public void setReadAccess(ParseUser user, boolean allowed) {
        if (user.getObjectId() != null) {
            setReadAccess(user.getObjectId(), allowed);
        } else if (user.isLazy()) {
            setUnresolvedReadAccess(user, allowed);
        } else {
            throw new IllegalArgumentException("cannot setReadAccess for a user with null id");
        }
    }

    private void setUnresolvedReadAccess(ParseUser user, boolean allowed) {
        prepareUnresolvedUser(user);
        setReadAccess(UNRESOLVED_KEY, allowed);
    }

    private void setUnresolvedWriteAccess(ParseUser user, boolean allowed) {
        prepareUnresolvedUser(user);
        setWriteAccess(UNRESOLVED_KEY, allowed);
    }

    private void prepareUnresolvedUser(ParseUser user) {
        if (this.unresolvedUser != user) {
            this.permissionsById.remove(UNRESOLVED_KEY);
            this.unresolvedUser = user;
            user.registerSaveListener(new UserResolutionListener(this));
        }
    }

    public boolean getReadAccess(ParseUser user) {
        if (user == this.unresolvedUser) {
            return getReadAccess(UNRESOLVED_KEY);
        }
        if (user.getObjectId() != null) {
            return getReadAccess(user.getObjectId());
        }
        throw new IllegalArgumentException("cannot getReadAccess for a user with null id");
    }

    public void setWriteAccess(ParseUser user, boolean allowed) {
        if (user.getObjectId() != null) {
            setWriteAccess(user.getObjectId(), allowed);
        } else if (user.isLazy()) {
            setUnresolvedWriteAccess(user, allowed);
        } else {
            throw new IllegalArgumentException("cannot setWriteAccess for a user with null id");
        }
    }

    public boolean getWriteAccess(ParseUser user) {
        if (user == this.unresolvedUser) {
            return getWriteAccess(UNRESOLVED_KEY);
        }
        if (user.getObjectId() != null) {
            return getWriteAccess(user.getObjectId());
        }
        throw new IllegalArgumentException("cannot getWriteAccess for a user with null id");
    }

    public boolean getRoleReadAccess(String roleName) {
        return getReadAccess("role:" + roleName);
    }

    public void setRoleReadAccess(String roleName, boolean allowed) {
        setReadAccess("role:" + roleName, allowed);
    }

    public boolean getRoleWriteAccess(String roleName) {
        return getWriteAccess("role:" + roleName);
    }

    public void setRoleWriteAccess(String roleName, boolean allowed) {
        setWriteAccess("role:" + roleName, allowed);
    }

    private static void validateRoleState(ParseRole role) {
        if (role.getObjectId() == null) {
            throw new IllegalArgumentException("Roles must be saved to the server before they can be used in an ACL.");
        }
    }

    public boolean getRoleReadAccess(ParseRole role) {
        validateRoleState(role);
        return getRoleReadAccess(role.getName());
    }

    public void setRoleReadAccess(ParseRole role, boolean allowed) {
        validateRoleState(role);
        setRoleReadAccess(role.getName(), allowed);
    }

    public boolean getRoleWriteAccess(ParseRole role) {
        validateRoleState(role);
        return getRoleWriteAccess(role.getName());
    }

    public void setRoleWriteAccess(ParseRole role, boolean allowed) {
        validateRoleState(role);
        setRoleWriteAccess(role.getName(), allowed);
    }

    public static void setDefaultACL(ParseACL acl, boolean withAccessForCurrentUser) {
        defaultACLWithCurrentUser = null;
        lastCurrentUser = null;
        if (acl != null) {
            defaultACL = acl.copy();
            defaultACL.setShared(true);
            defaultACLUsesCurrentUser = withAccessForCurrentUser;
            return;
        }
        defaultACL = null;
    }

    static ParseACL getDefaultACL() {
        if (!defaultACLUsesCurrentUser || defaultACL == null) {
            return defaultACL;
        }
        ParseUser last = lastCurrentUser != null ? (ParseUser) lastCurrentUser.get() : null;
        if (ParseUser.getCurrentUser() == null) {
            return defaultACL;
        }
        if (last != ParseUser.getCurrentUser()) {
            defaultACLWithCurrentUser = defaultACL.copy();
            defaultACLWithCurrentUser.setShared(true);
            defaultACLWithCurrentUser.setReadAccess(ParseUser.getCurrentUser(), true);
            defaultACLWithCurrentUser.setWriteAccess(ParseUser.getCurrentUser(), true);
            lastCurrentUser = new WeakReference<>(ParseUser.getCurrentUser());
        }
        return defaultACLWithCurrentUser;
    }
}
