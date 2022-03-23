package com.example.taskmanager.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> {


    @Column(nullable = false, updatable = false, name = "created_date_time")
    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

    @Column(name = "last_updated_date_time")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDateTime;

    @Column(updatable = false, name = "created_user")
    @CreatedBy
    private UUID createdUser;

    @Column(name = "last_updated_user")
    @LastModifiedBy
    private UUID lastUpdatedUser;
}
