package jpabook.jpashop.web;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수입니다ㅏ.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
