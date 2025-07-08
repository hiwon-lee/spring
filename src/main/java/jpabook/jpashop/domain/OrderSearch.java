package jpabook.jpashop.domain;

import lombok.Getter;

public class OrderSearch {



    @Getter

    private String memberName;  // 회원 이름


    @Getter
    private OrderStatus orderStatus;    // 주문 상태[ORDER, CANCEL]

    // Getter, Setter

}
