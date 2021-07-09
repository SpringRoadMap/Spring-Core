package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @DisplayName("VIP는 10% 할인이 적용되야 한다")
    @Test
    void vipTest() {
        //given
        Member member = new Member(1L, "VIP", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @DisplayName("VIP가 아니면 할인이 적용되지 않는다")
    @Test
    void nonVipTest() {
        Member member = new Member(1L, "basic", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
    }
}