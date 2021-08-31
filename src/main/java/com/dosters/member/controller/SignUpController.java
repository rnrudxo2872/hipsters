package com.dosters.member.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/signup")
public class SignUpController {


    
    @GetMapping("")
    public String signup(Model model) {
        
        model.addAttribute("title", "signup");

        return "member/signup";
    }

    @GetMapping("email")
    public String email(){ //이메일 체크페이지

        return "member/emailCheck";
    }
  
    @Autowired
    private JavaMailSender mailSender;

    @ResponseBody
    @PostMapping("emailCK")
    public String emailCK(String userEmail) {//이메일 인증키
        Random random = new Random();
        String key = "";

        
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(userEmail);
        
        int ranNum = random.nextInt(999999); //6자리 랜덤숫자
        key += ranNum;
        
        msg.setSubject("DOSTERS 회원가입 이메일 인증번호입니다.");
        msg.setText("인증번호를 입력란에 입력해주세요.");
        msg.setText("인증번호 : " + key);
        
        mailSender.send(msg);

        return key;
    }
    


}
