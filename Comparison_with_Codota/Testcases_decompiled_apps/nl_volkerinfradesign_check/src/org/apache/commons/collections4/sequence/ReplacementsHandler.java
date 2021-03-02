package org.apache.commons.collections4.sequence;

import java.util.List;

public interface ReplacementsHandler<T> {
    void handleReplacement(int i, List<T> list, List<T> list2);
}
