package C05AnonymousLambda;

public class C01InnerClass {
    public static void main(String[] args) {
        MemberInnerClass m1 = new MemberInnerClass();
        System.out.println(m1.getA());  //10

        //Wow....
//         내부클래스       static내부클래스
        MemberInnerClass.StaticInnerClass ms1 = new MemberInnerClass.StaticInnerClass();
        ms1.display();  //20
    }
}
//(일반)내부클래스
class MemberInnerClass {
    int a;

    MemberInnerClass() {
        this.a = 10;
    }

    int getA(){
        return this.a;
    }

//    static내부클래스 : MemberInnerClass의 static변수처럼 활용.
    static class StaticInnerClass {
        int b = 20;
        void display() {
            System.out.println(this.b);
        }
    }
}
