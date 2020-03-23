package spring_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.time.OffsetDateTime;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(EntityListener.class)
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_timestamp", nullable = false)
    private OffsetDateTime createTimestamp;

    @Column(name = "update_timestamp", nullable = false)
    private OffsetDateTime updateTimestamp;

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;
}
