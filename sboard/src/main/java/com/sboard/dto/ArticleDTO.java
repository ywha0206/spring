package com.sboard.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private int no;

    @Builder.Default
    private String cate = "free";

    private String title;
    private String content;
    private int comment;

    private List<MultipartFile> files;

    @Builder.Default
    private int file = 0;

    @Builder.Default
    private int hit = 0;

    private String writer;
    private String regip;
    private String rdate;


    //추가필드
    private String nick;

    /*
    Entity 변환 메서드 대신 ModelMapper 사용
    */

}
