package com.ch09.dto;

import com.ch09.entity.User1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {
    @NotBlank // null, "", " " 모두 허용 안 함
    @Pattern(regexp = "^[a-z0-9]{4,18}$",message = "영어 소문자와 숫자로 최소 4~10자 입력")
    private String uid;

    @NotEmpty //null, "" 둘 다 허용 안 함 공백은 허용
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "이름은 한글 2~10자 입력")
    private String name;

    @NotNull
    private String birth;

    private String hp;

    @Min(1)
    @Max(120)
    private int age;

    public User1 toEntity() {
        return User1
                .builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
