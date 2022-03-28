package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("choi");

        Long savedId = memberService.join(member);

        Assertions.assertThat(member.getId()).isEqualTo(savedId);
        //assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        Member member1 = new Member();
        member1.setName("choi");
        Member member2 = new Member();
        member2.setName("choi");

        memberService.join(member1);
        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }
}