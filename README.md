# Kind Java class 23/11/03

### RFP Title 
Development of Member and Location Classes in Java 


### 1. Introduction
Create a class in Java with a method for self-introduction and instantiate an object of that class.

### 2. Scope of Work
a. Member Class Development 

- Create a Member class that includes the necessary variables and methods.

b. Loc Class Development 

- Develop a Loc class with a static variable named Kor.
- Assign the string "대한민국" (Korea) to this static variable.

c. Functionality Implementation

- Implement an introduce() method in the Member class.
- The method should generate an introduction string as specified.

### 3. Input and Output Requirements
The vendor must ensure that the implementation of the classes allows the following code snippet to execute and produce the expected output

Member member = new Member(); 

member.name = '홍길동';

member.phone = 01012341344;

member.addr = Loc.Kor + '서울시 특별시';

member.indroduce(); // 대한민국 서울시 특별시 사는 홍길동이고 전화번호는 010-1234-1344 입니다. 

-----------------------------------------------------

### RPF 
자바에서의 Member 및 Location 클래스 개발

### 1. 개요
자바로 클래스를 생성하고 그 클래스의 객체를 인스턴스화하여 자기 소개하는 메소드를 가진 클래스를 개발


### 2. 작업 범위
a. Member 클래스 개발

- 필요한 변수와 메서드를 포함하는 Member 클래스를 생성.

b. Loc 클래스 개발

- 'Kor'라는 이름의 static 변수를 가진 Loc 클래스를 개발
- 이 static 변수에 "대한민국"이라는 문자열을 할당.

c. 기능 구현

- Member 클래스 안에 introduce() 메서드를 구현.
- 이 메서드는 지정된 대로 소개 문자열을 생성해야함.

### 3.입력 , 출력 요구사항

Member member = new Member();

member.name = '홍길동';

member.phone = 01012341344;

member.addr = Loc.Kor + '서울시 특별시';

member.introduce(); // 출력: 대한민국 서울시 특별시에 사는 홍길동이고 전화번호는 010-1234-1344입니다.

### 4.출력 결과 코드에서 의도한것
1.제가 사는 곳은 대한민국 서초구, 제 이름은 서동희입니다. 제 전화번호는 01092001234 입니다.
2.제가 사는 곳은 대한민국 서초구, 제 이름은 서동희입니다. 제 전화번호는 0109200**** 입니다.

전화번호등 개인정보에 민감한 사항은 특정한 부분을 블러처리 하였습니다.





