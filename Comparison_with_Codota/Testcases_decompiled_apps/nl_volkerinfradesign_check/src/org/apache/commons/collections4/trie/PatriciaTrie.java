package org.apache.commons.collections4.trie;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;

public class PatriciaTrie<E> extends AbstractPatriciaTrie<String, E> {
    private static final long serialVersionUID = 4446367780901817838L;

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.get(obj);
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ OrderedMapIterator mapIterator() {
        return super.mapIterator();
    }

    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public PatriciaTrie() {
        super(new StringKeyAnalyzer());
    }

    public PatriciaTrie(Map<? extends String, ? extends E> map) {
        super(new StringKeyAnalyzer(), map);
    }
}
