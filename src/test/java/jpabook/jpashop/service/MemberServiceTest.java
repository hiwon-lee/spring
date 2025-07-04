package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    // @Rollback(false)를 붙이면 해당 작업이 db에 반영된다.
    public void 회원가입() throws Exception {
        // Given
        Member member = new Member();
        member.setName("kim");

        // When
        Long saveId = memberService.join(member);

        // Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복회원예외() throws Exception {
        // Given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");

        // When
        memberService.join(member1);

        System.out.println("여기!");

        // Then
        //IllegalStateException 예외가 발생하지 않으면 테스트 슬패
        assertThrows(IllegalAccessError.class, () ->
                memberService.join(member2));


    }

}