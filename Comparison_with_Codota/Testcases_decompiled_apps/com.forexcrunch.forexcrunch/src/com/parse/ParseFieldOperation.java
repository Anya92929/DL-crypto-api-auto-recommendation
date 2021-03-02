package com.parse;

import org.json.JSONException;

interface ParseFieldOperation {
    Object apply(Object obj, ParseObject parseObject, String str);

    Object encode() throws JSONException;

    ParseFieldOperation mergeWithPrevious(ParseFieldOperation parseFieldOperation);
}
