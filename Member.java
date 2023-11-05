import java.util.List;
public class Member {
    int id;
    String name;
    String addr;
    int phone;
    String transPhone(int phone){
        String octal ="0";
        octal += Integer.toOctalString(phone);
        return String.format("%s-%s-%s", octal.substring(0, 3), octal.substring(3, 7), octal.substring(7));
    }


    public void introduce(){
        System.out.println(addr + "에 사는 " + name + "이고 전화번호는 " + transPhone(phone) + " 입니다.");
    }
}
