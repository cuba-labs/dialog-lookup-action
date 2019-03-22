package com.company.demo.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "DEMO_CLIENT")
@Entity(name = "demo_Client")
public class Client extends StandardEntity {
    @Column(name = "TITLE")
    protected String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}