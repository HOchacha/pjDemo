package com.example.pjdemo.dto;

import jakarta.persistence.Column;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private String name;
    private String gender;
    private int age;
    private String major;
    private String plan;
}
