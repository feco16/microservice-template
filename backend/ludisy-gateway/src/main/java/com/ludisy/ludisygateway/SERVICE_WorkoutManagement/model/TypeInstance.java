package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TypeInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TYPE_INSTANCE_ID")
    private long typeInstanceId;

    @Column(name = "VALUE")
    private String value;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private TypeArgument typeArgument;


    public long getTypeInstanceId() {
        return typeInstanceId;
    }

    public void setTypeInstanceId(long typeInstanceId) {
        this.typeInstanceId = typeInstanceId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TypeArgument getTypeArgument() {
        return typeArgument;
    }

    public void setTypeArgument(TypeArgument typeArgument) {
        this.typeArgument = typeArgument;
    }
}
