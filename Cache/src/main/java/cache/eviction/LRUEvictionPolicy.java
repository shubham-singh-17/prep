package cache.eviction;

import cache.datstructure.DoublyLinkedList;
import cache.datstructure.DoublyLinkedListNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private final DoublyLinkedList<Key> dll;
    private final Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccess(Key key) {
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> node = dll.addElementAtLast(key);
            mapper.put(key, node);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> node = dll.getFirstNode();
        if (Objects.isNull(node)) {
            return null;
        }

        dll.detachNode(node);
        return node.getElement();
    }
}
