package com.ch10.controller;

import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.jwt.JwtProvider;
import com.ch10.security.MyUserDetails;
import com.ch10.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserService userService;

    @GetMapping("/user/login")
    public ResponseEntity user(Authentication authentication) {

        User user  =(User) authentication.getPrincipal();

        UserDTO userDTO = userService.selectUser(user.getUid());
        userDTO.setPass(null);

        return ResponseEntity
                .ok()
                .body(userDTO);

    }

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        log.info("login1 : "+userDTO);

        try {//(인증에 실패해서 null인 경우가 있음)
            UsernamePasswordAuthenticationToken authToken
                    = new UsernamePasswordAuthenticationToken(userDTO.getUid(),userDTO.getPass());

            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info("login2 : "+userDTO);


            //인증된 사용자 객체 가져오기
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            log.info("login3 : "+userDTO + myUserDetails);

            User user = myUserDetails.getUser();
            log.info("login4 : "+user);

            //토큰 생성
            String accessToken = jwtProvider.createToken(user, 1);
            String refreshToken = jwtProvider.createToken(user, 7);
            log.info("login5 : "+accessToken +" "+userDTO);

            //리프레시 토큰 DB 저장

            //Access, Refresh 토큰 전송
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("access_token", accessToken);
            resultMap.put("refresh_token", refreshToken);

            return ResponseEntity
                    .ok()
                    .body(resultMap);



        } catch (Exception e) {
            //인증실패 아이디나 비번 틀렸을때
            log.info("login6 : catch!!! "+userDTO);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }

}
