package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

//    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping
    public String homeLogin(@CookieValue(value = "memberId", required = false) Long memberId, Model model){
        if(Objects.isNull(memberId)) return "home";
        else{
            Member loginMember = memberRepository.findById(memberId);
            if(Objects.isNull(loginMember)) return "home";
            else{
                model.addAttribute("member", loginMember);
                return "loginHome";
            }
        }
    }
}