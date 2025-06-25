package C06EtcClass;

public class C03EnumMain {
    public static void main(String[] args) {
////        classGrade를 일반문자열로 세팅할 경우 -> 정해진 문자열이 아닌, 개별적으로 생성된 문자열 삽입문제.(중구난방임)
//        Student s1 = new Student("hong","1학년");
//        Student s2 = new Student("hong2","FIRSTGRADE");
//        Student s3 = new Student("hong3","FIRST_GRADE");

////        static final을 통해 변수값 관리하는 방법 -> 타입이 String이므로 얼마든지 자유롭게 세팅이 가능한 문제.(중구난방임)
//        Student s1 = new Student("hong",ClassGrade.c1);
//        Student s2 = new Student("hong2",ClassGrade."FIRST_GRADE");
//        Student s3 = new Student("hong3",ClassGrade.c2);

//        Enum클래스를 활용한 ClassGrade세팅
//                                              클래스명     enum
        Student s1 = new Student("hong",ClassGrade.FIRST_GRADE);
//        Student s2 = new Student("hong2","SECOND_GRADE");   //타입불일치에러
        Student s3 = new Student("hong3",ClassGrade.THIRD_GRADE);

        System.out.println(s1);
//        System.out.println(s2);
        System.out.println(s3);
//        enum클래스의 내부에는 값이 지정된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(s1.getClassGrede().ordinal()); //getClassGrede() : FIRST_GRADE, getClassGrede().ordinal() : 0

    }
}
class Student {
    private String name;
    private ClassGrade classGrede;  //enum타입

    public Student(String name, ClassGrade classGrede) {
        this.name = name;
        this.classGrede = classGrede;
    }

    public String getName() {
        return name;
    }

    public ClassGrade getClassGrede() {
        return classGrede;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classGrede=" + classGrede +
                '}';
    }
}
//class ClassGrade {
//    static final String c1 = "FIRST_GRADE";
//    static final String c2 = "SECOND_GRADE";
//    static final String c3 = "THIRD_GRADEe";
//}
enum ClassGrade {
//      0              1            2
    FIRST_GRADE, SECOND_GRADE, THIRD_GRADE
}