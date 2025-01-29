package airline.booking.store;

import airline.booking.entity.BaseEntity;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStore<T extends BaseEntity> {

    private final Map<String, T> entityMap;

    public AbstractStore() {
        this.entityMap = new HashMap<>();
    }

    public Map<String, T> getEntityMap() {
        return entityMap;
    }

    public void addEntity(T entity) {
        entityMap.put(entity.getId(), entity);
    }
}
