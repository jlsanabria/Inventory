package tech.icei.product.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tech.icei.product.enums.Status;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Auditable {

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 3, nullable = false)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "created_by", nullable = false, length = 50)
    private String createdBy;
}
