package com.example.kindjava;

public class Member {
    String name;
    String phone;
    String addr;

    String fullAddress(String address){
        return Loc.Kor + " " +address;
    }

   void introduce(String name ,String phone , String addr) {
        System.out.println(fullAddress(addr) +" "+ "살고 있는" +" "+ name + "이며 " + "전화번호는" +" "+phone+ " 입니다");
    }
   String getHiddenPhone(String phone, int index){
       String hiddenData = phone.substring(0, index);
       for (int i = 0; i < phone.length() - index; i++) {
           hiddenData += "*";
       }
       return hiddenData;
   }
   void hiddenIntroduce(String name, String phone ,String addr){
       System.out.println(fullAddress(addr) +" "+ "살고 있는" +" "+ name + "이며 " + "전화번호는" +" "+getHiddenPhone(phone,7)+ " 입니다");
   }

}
