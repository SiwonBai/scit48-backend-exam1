package net.datasa.exam1.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import net.datasa.exam1.dto.UserDTO;
import net.datasa.exam1.entity.UserEntity;
import net.datasa.exam1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService service;

    /**
     * 회원가입 폼 요청
     * @return signUp.html
     */
    @GetMapping("/signUp")
    public String signUp() {

        return "signUp";
    }


    /**
     * 회원가입 처리 (id와 pwd 는 세션에 저장)
     * @param dto 사용자 정보 dto
     * @param session 세션
     * @return home.html
     */
    @PostMapping("/signUp")
    public String signUpProcess(
            @ModelAttribute UserDTO dto, HttpSession session) {
        log.info("User 정보: {}", dto);

        session.setAttribute("id", dto.getId()); // 세션에 id 저장
        session.setAttribute("pwd", dto.getPwd()); // 세션에 pw 저장
        log.info("세션에 저장된 ID: {}, PW: {}", session.getAttribute("id"), session.getAttribute("pwd"));

        service.signUp(dto);

        return "redirect:/";
    }

    /**
     * home.html 에서 login.html 로 이동
     * @return login.html
     */
    @GetMapping("/login")
    public String login() {

        return "login";
    }

    /**
     * 로그인 처리
     * @param id 입력받은 사용자 id
     * @param pwd 입력받은 사용자 pwd
     * @param session 세션
     * @return 로그인 성공시 loginSuccess 페이지, 실패시 login 리다이렉트
     */
    @PostMapping("/login")
    public String loginProcess(
            @RequestParam("id") String id,
            @RequestParam("pwd") String pwd,
            HttpSession session,
            Model model
    ) {
        log.info("ID: {}, PW: {}", id, pwd);

        String sessionId = (String) session.getAttribute("id");
        String sessionPwd = (String) session.getAttribute("pwd");

        // 세션에 저장된 id, pwd 가 입력값과 동일한지 체크
        if (!(sessionId.equals(id) && sessionPwd.equals(pwd))) {
            return "redirect:/login";
        } else {
            // 동일하다면, loginId를 모델에 담아 html로 넘기기
            session.setAttribute("loginId", sessionId);
            model.addAttribute("loginId", sessionId);
            return "loginSuccess";
        }
    }

    /**
     * 로그아웃 처리
     * @return home.html 이동
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 삭제
        return "redirect:/";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {

        List<UserDTO> list = service.showAll();
        model.addAttribute("list", list);

        return "list";
    }
}
