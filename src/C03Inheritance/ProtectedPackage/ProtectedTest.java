package C03Inheritance.ProtectedPackage;

//다른 패키지의 클래스는 import 필요
//패키지 바로 하위의 모든 'class'는 *로 import가능. 다만, 패키지내의 '내부패키지의 class'는 *로 import 불가
import C03Inheritance.*;

public class ProtectedTest extends C04ProtectedClass {
    public static void main(String[] args) {
        //⭐C04ProtectedClass p1 = new ProtectedTest(); 아닌 이유 -> 부모 클래스의 멤버(메서드, 변수)만 사용할 수 있고 자식 클래스의 멤버에는 직접 접근할 수 없기 때문에.
        //    자식                   자식
        ProtectedTest p1 = new ProtectedTest(); //⭐상속받은 protected 멤버(st4)에 다른 패키지라도 자식 클래스니까 직접 접근 가능하기 때문입니다!

//        public접근제어자는 프로젝트 전역에서 접근가능
        p1.st1 = "hello python";
//        private접근제어자는 같은 클래스내에서 접근가능
//        패키지가 달라졌으므로 default변수는 접근불가
//        p1.st3 = "hello python";
//        상속관계가 있을경우, 패키지가 달라도 protected변수에 접근가능
        p1.st4 = "hello python";

        //      부모                      부모
        C04ProtectedClass p2 = new C04ProtectedClass();
//        ⭐protected : 패키지를 벗어나더라도 상속관계인경우에는 접근가능
//        ⭐p2는 부모클래스의 객체이므로, 상속관계가 있는 객체가 아니므로, protected변수에 접근불가.
//        p2.st4 = "hello python";
    }
}
