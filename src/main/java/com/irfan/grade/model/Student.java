package com.irfan.grade.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String nim;
    private String name;

    private Score score;
}
