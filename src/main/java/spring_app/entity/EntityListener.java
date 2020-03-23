package spring_app.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.concurrent.atomic.AtomicReference;

public class EntityListener {

    private static AtomicReference<Clock> clockReference = new AtomicReference(Clock.systemDefaultZone());

    @PrePersist
    public void createdAt(BaseModel entity) {
        if (entity.getCreateTimestamp() == null) {
            entity.setCreateTimestamp(OffsetDateTime.now((Clock)clockReference.get()));
            entity.setUpdateTimestamp(entity.getCreateTimestamp());
        }
    }

    @PreUpdate
    public void updatedAt(BaseModel entity) {
        entity.setUpdateTimestamp(OffsetDateTime.now((Clock)clockReference.get()));
    }
}
