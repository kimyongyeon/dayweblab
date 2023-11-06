package com.example.kindjava.Model;

public class Member {
    String name;
    String phone;
    String addr;

    String fullAddress(String address){
        return Loc.Kor + " " +address;
    }

    public Member(String name, String phone, String addr){
        this.name = name;
        this.phone = phone;
        this.addr = fullAddress(addr);
    };


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
