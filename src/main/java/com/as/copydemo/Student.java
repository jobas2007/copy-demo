package com.as.copydemo;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "clmPushApiSeq")
    @SequenceGenerator(sequenceName = "CLM_PUSH_API_AUDIT_SEQ", allocationSize = 1, name = "clmPushApiSeq")
    @Column(name = "id", nullable = false, updatable = false)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private Integer origId;

    public void setId(Integer id) {
        this.id = id;
        if (origId == null) {
            origId = id;
        }
    }

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String email;

}
