package com.redhat.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntityOutput {
    private int id;
    private String info;
    private String remarks;
    private Date event;
}
