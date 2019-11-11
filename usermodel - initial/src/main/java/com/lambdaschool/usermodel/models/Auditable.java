package com.lambdaschool.usermodel.models;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//runs in background when something happens it makes changes in background
abstract class Auditable
{
    @CreatedBy
    protected String createdby;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)//adds time to date
    protected Date createddate;
    @LastModifiedBy
    protected String lastmodifiedby;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastmodifieddate;

}
