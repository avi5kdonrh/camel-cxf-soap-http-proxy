package com.redhat.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class EntityInput implements Serializable {
    private String name;
    private int id;
    private String detail;
    private Date event;

    private String remarks;
}
