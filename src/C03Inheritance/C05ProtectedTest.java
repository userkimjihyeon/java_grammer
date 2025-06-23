package C03Inheritance;

public class C05ProtectedTest {
    public static void main(String[] args) {
        C04ProtectedClass p1 = new C04ProtectedClass(); //static 아니니까 객체생성

        p1.st1 = "hello python";
//        p1.st2 = "hello python";   //private 접근불가
        p1.st3 = "hello python";
    }
}
