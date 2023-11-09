package main.java.member;

import java.util.regex.Pattern;

public class Member {

    private final String name;
    private final String phone;
    private final String addr;

    public Member(String name, String phone, String addr) {
        this.name = name;
        this.phone = phone;
        this.addr = addr;
    }

    public void introduce() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return addr + " 사는 " +
                name + "이고 전화번호는 " +
                phoneFormat() + " 입니다.";
    }

    private String phoneFormat() {
        String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
        if(!Pattern.matches(regEx, phone)) return phone;
        return phone.replaceAll(regEx, "$1-$2-$3");
    }
}
