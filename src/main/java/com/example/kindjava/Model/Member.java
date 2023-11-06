package com.example.kindjava.Model;

public class Member {
    String name;
    String phone;
    String addr;

    String fullAddress(String address){
        return Loc.Kor + " " +address;
    }

    private Member(String name, String phone, String addr){
        this.name = name;
        this.phone = phone;
        this.addr = fullAddress(addr);
    };

    public static Member createMember(String name, String phone, String addr ) {
        return new Member(name, phone, addr);
    }


   public String getName(){
        return this.name;
    }

   public String getPhone(){
        return this.phone;
    }

   public String getAddr(){
        return this.addr;
    }
}
