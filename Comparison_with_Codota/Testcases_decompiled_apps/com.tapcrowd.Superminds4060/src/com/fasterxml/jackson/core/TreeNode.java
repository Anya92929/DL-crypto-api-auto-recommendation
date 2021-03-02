package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;

public interface TreeNode {
    JsonToken asToken();

    JsonParser.NumberType numberType();

    JsonParser traverse();
}
