package hello.login.pureJava;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void test1(){
        Member member = new Member();
        member.setId(1L);
        member.setLoginId("abc");
        member.setName("ttt");
        member.setPassword("123");

        Object obj = member;

        System.out.println("stop");
    }
}
