package C02ClassBasic;

public class C04Person {
//    private 접근제어자는 해당 클래스 내에서만 접근 가능
//    클래스에서 객체변수는 일반적으로 변수의 안정성을 위해 private으로 설정
    private String name;
    private String email;
    private int age;

//    매서드는 public하게 별도로 만들어서 의도를 명확히 하여, 변수의 안정성 향상
//    생성 -> 게터 & 세터
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//   리턴값 필요
    public String printPerson() {
        return "이름은: " + this.name + " 이메일은: " + this.email + " 나이는: " + this.age;
    }
////   리턴값 불필요
//    public void printPerson(String name, String email, int age) {
//      System.out.println("이름은: " + name + " 이메일은: " + email + " 나이는: " + age);
//    }

////    객체 메서드들끼리의 호출은 객체가 만들어져 있다는 것을 가정하고 있으므로, 문제없이 호출가능.
//    public String printPerson2() {
//        String temp = this.printPerson();       //⭐객체메서드에서 또다른 객체메서드호출시 this 사용
//        return temp;
//    }
////    클래스메서드는 기본적으로 객체생성을 가정하지 않으므로, 클래스메서드내에서 객체메서드를 호출하는 것은 논리적 모순.
//    public static String printPerson3() {
////        String temp = this.printPerson();   //불가능
//        return null;
//    }
////    1. 클래스 메서드에서 객체 메서드 호출 ? X
////    2. 객체 메서드에서 객체 메서드 호출 ? O
////    3. 객체 메서드에서 클래스 메서드 호출 ? O

}
