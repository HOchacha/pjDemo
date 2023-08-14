package com.example.pjdemo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50)
    private String gender;

    @Column
    private Integer age;

    @Column
    private String major;

    @Column
    private String plan;

    @Builder
    public Member( String name, String gender, Integer age, String major, String plan){

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.major = major;
        this.plan = plan;
    }
}
