package com.actionbarsherlock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import com.actionbarsherlock.C0051R;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.view.MenuItem;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MenuInflater {
    /* access modifiers changed from: private */
    public static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    /* access modifiers changed from: private */
    public static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = {Context.class};
    private static final String LOG_TAG = "MenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    /* access modifiers changed from: private */
    public final Object[] mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    /* access modifiers changed from: private */
    public final Object[] mActionViewConstructorArguments;
    /* access modifiers changed from: private */
    public Context mContext;

    public MenuInflater(Context context) {
        this.mContext = context;
        this.mActionViewConstructorArguments = new Object[]{context};
    }

    public void inflate(int menuRes, Menu menu) {
        XmlResourceParser parser = null;
        try {
            parser = this.mContext.getResources().getLayout(menuRes);
            parseMenu(parser, Xml.asAttributeSet(parser), menu);
            if (parser != null) {
                parser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
            throw th;
        }
    }

    private void parseMenu(XmlPullParser parser, AttributeSet attrs, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);
        int eventType = parser.getEventType();
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;
        while (true) {
            if (eventType != 2) {
                eventType = parser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String tagName = parser.getName();
                if (tagName.equals(XML_MENU)) {
                    eventType = parser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + tagName);
                }
            }
        }
        boolean reachedEndOfMenu = false;
        while (!reachedEndOfMenu) {
            switch (eventType) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (lookingForEndOfUnknownTag) {
                        break;
                    } else {
                        String tagName2 = parser.getName();
                        if (!tagName2.equals(XML_GROUP)) {
                            if (!tagName2.equals("item")) {
                                if (!tagName2.equals(XML_MENU)) {
                                    lookingForEndOfUnknownTag = true;
                                    unknownTagName = tagName2;
                                    break;
                                } else {
                                    parseMenu(parser, attrs, menuState.addSubMenuItem());
                                    break;
                                }
                            } else {
                                menuState.readItem(attrs);
                                break;
                            }
                        } else {
                            menuState.readGroup(attrs);
                            break;
                        }
                    }
                case 3:
                    String tagName3 = parser.getName();
                    if (!lookingForEndOfUnknownTag || !tagName3.equals(unknownTagName)) {
                        if (!tagName3.equals(XML_GROUP)) {
                            if (!tagName3.equals("item")) {
                                if (!tagName3.equals(XML_MENU)) {
                                    break;
                                } else {
                                    reachedEndOfMenu = true;
                                    break;
                                }
                            } else if (!menuState.hasAddedItem()) {
                                if (menuState.itemActionProvider != null && menuState.itemActionProvider.hasSubMenu()) {
                                    menuState.addSubMenuItem();
                                    break;
                                } else {
                                    menuState.addItem();
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            menuState.resetGroup();
                            break;
                        }
                    } else {
                        lookingForEndOfUnknownTag = false;
                        unknownTagName = null;
                        break;
                    }
            }
            eventType = parser.next();
        }
    }

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = {MenuItem.class};
        private Context mContext;
        private Method mMethod;

        public InflatedOnMenuItemClickListener(Context context, String methodName) {
            this.mContext = context;
            Class<?> c = context.getClass();
            try {
                this.mMethod = c.getMethod(methodName, PARAM_TYPES);
            } catch (Exception e) {
                InflateException ex = new InflateException("Couldn't resolve menu item onClick handler " + methodName + " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            }
        }

        public boolean onMenuItemClick(MenuItem item) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.mContext, new Object[]{item})).booleanValue();
                }
                this.mMethod.invoke(this.mContext, new Object[]{item});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        /* access modifiers changed from: private */
        public ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private boolean itemEnabled;
        private int itemIconResId;
        private int itemId;
        private String itemListenerMethodName;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private boolean itemVisible;
        private Menu menu;

        public MenuState(Menu menu2) {
            this.menu = menu2;
            resetGroup();
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        public void readGroup(AttributeSet attrs) {
            TypedArray a = MenuInflater.this.mContext.obtainStyledAttributes(attrs, C0051R.styleable.SherlockMenuGroup);
            this.groupId = a.getResourceId(1, 0);
            this.groupCategory = a.getInt(3, 0);
            this.groupOrder = a.getInt(4, 0);
            this.groupCheckable = a.getInt(5, 0);
            this.groupVisible = a.getBoolean(2, true);
            this.groupEnabled = a.getBoolean(0, true);
            a.recycle();
        }

        public void readItem(AttributeSet attrs) {
            boolean hasActionProvider;
            int i;
            TypedArray a = MenuInflater.this.mContext.obtainStyledAttributes(attrs, C0051R.styleable.SherlockMenuItem);
            this.itemId = a.getResourceId(2, 0);
            this.itemCategoryOrder = (-65536 & a.getInt(5, this.groupCategory)) | (65535 & a.getInt(6, this.groupOrder));
            this.itemTitle = a.getText(7);
            this.itemTitleCondensed = a.getText(8);
            this.itemIconResId = a.getResourceId(0, 0);
            this.itemAlphabeticShortcut = getShortcut(a.getString(9));
            this.itemNumericShortcut = getShortcut(a.getString(10));
            if (a.hasValue(11)) {
                if (a.getBoolean(11, defaultItemChecked)) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.itemCheckable = i;
            } else {
                this.itemCheckable = this.groupCheckable;
            }
            this.itemChecked = a.getBoolean(3, defaultItemChecked);
            this.itemVisible = a.getBoolean(4, this.groupVisible);
            this.itemEnabled = a.getBoolean(1, this.groupEnabled);
            TypedValue value = new TypedValue();
            a.getValue(13, value);
            this.itemShowAsAction = value.type == 17 ? value.data : -1;
            this.itemListenerMethodName = a.getString(12);
            this.itemActionViewLayout = a.getResourceId(14, 0);
            this.itemActionViewClassName = a.getString(15);
            this.itemActionProviderClassName = a.getString(16);
            if (this.itemActionProviderClassName != null) {
                hasActionProvider = true;
            } else {
                hasActionProvider = false;
            }
            if (hasActionProvider && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionProviderConstructorArguments);
            } else {
                if (hasActionProvider) {
                    Log.w(MenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.itemActionProvider = null;
            }
            a.recycle();
            this.itemAdded = defaultItemChecked;
        }

        private char getShortcut(String shortcutString) {
            if (shortcutString == null) {
                return 0;
            }
            return shortcutString.charAt(0);
        }

        private void setItem(MenuItem item) {
            item.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1 ? true : defaultItemChecked).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
            if (this.itemShowAsAction >= 0) {
                item.setShowAsAction(this.itemShowAsAction);
            }
            if (this.itemListenerMethodName != null) {
                if (MenuInflater.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                item.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(MenuInflater.this.mContext, this.itemListenerMethodName));
            }
            if (this.itemCheckable >= 2) {
                if (item instanceof MenuItemImpl) {
                    ((MenuItemImpl) item).setExclusiveCheckable(true);
                } else {
                    this.menu.setGroupCheckable(this.groupId, true, true);
                }
            }
            boolean actionViewSpecified = defaultItemChecked;
            if (this.itemActionViewClassName != null) {
                item.setActionView((View) newInstance(this.itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionViewConstructorArguments));
                actionViewSpecified = true;
            }
            if (this.itemActionViewLayout > 0) {
                if (!actionViewSpecified) {
                    item.setActionView(this.itemActionViewLayout);
                } else {
                    Log.w(MenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.itemActionProvider != null) {
                item.setActionProvider(this.itemActionProvider);
            }
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu subMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(subMenu.getItem());
            return subMenu;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        private <T> T newInstance(String className, Class<?>[] constructorSignature, Object[] arguments) {
            try {
                return MenuInflater.this.mContext.getClassLoader().loadClass(className).getConstructor(constructorSignature).newInstance(arguments);
            } catch (Exception e) {
                Log.w(MenuInflater.LOG_TAG, "Cannot instantiate class: " + className, e);
                return null;
            }
        }
    }
}
