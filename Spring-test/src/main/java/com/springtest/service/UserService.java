package com.springtest.service;

import com.springtest.dto.TermsDTO;
import com.springtest.dto.UserDTO;
import com.springtest.entity.Terms;
import com.springtest.entity.User;
import com.springtest.repository.TermsRepository;
import com.springtest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final TermsRepository termsRepository;
    private final PasswordEncoder passwordEncoder;

    public void insertUser(UserDTO userDTO) {
        //회원가입
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);

        User user = userDTO.toEntity();
        userRepository.save(user);
    }

    public UserDTO selectUser(String uid) {

        Optional<User> optUser = userRepository.findById(uid);

        if(optUser.isPresent()) {
            User user = optUser.get();
            return user.toDTO();
        }
        return null;
    }

    public TermsDTO selectTerms() {
    Terms terms = termsRepository.findterms();


        TermsDTO termsDTO = terms.toDTO();

    return termsDTO;

    }

    public boolean checkUserIdExists(String uid){
        return userRepository.existsById(uid);
    }
    public boolean checkUserNickExists(String nick){
        return userRepository.findUserNick(nick) > 0;
    }
    public boolean checkUserHpExists(String hp){
        return userRepository.findUserHp(hp) > 0;
    }
    public boolean checkUserEmailExists(String email){
        return userRepository.findUserEmail(email) > 0;
    }

}
