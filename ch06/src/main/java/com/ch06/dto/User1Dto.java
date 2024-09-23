package com.ch06.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1Dto {

    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

}
