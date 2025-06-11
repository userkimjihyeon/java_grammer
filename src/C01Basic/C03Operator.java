package C01Basic;

public class C03Operator {
    public static void main(String[] args) {
        // 산술연산자 : 사칙연산
//        int n1 = 8;
//        int n2 = 3;
//        // * : 곱셈, / : 나눗셈(몫), % : 나머지
//        System.out.println("n1 * n2 = "+ (n1*n2));
//        System.out.println("n1 / n2 = "+ (n1/n2));
//        System.out.println("n1 % n2 = "+ (n1%n2));

        // 대입연산자
//        int n1 = 7;
//        int n2 = 7;
//        int n3 = 7;
//        n1 = n1-3;
//        n2 -= 3;
//        n3 = -3;
//        System.out.println(n1);
//        System.out.println(n2);
//        System.out.println(n3);
//
//        int n4 = 10;
//        int n5 = 10;
//        n4 /= 3;
//        n5 %= 3;
//        System.out.println(n4);
//        System.out.println(n5);

        // 증감연산자
//        int a = 10;
//        a = a + 1;
//        System.out.println(a); // 11
//        a += 1;
//        System.out.println(a); // 12
//        a++; // 13  후위증감연산자
//        ++a; // 14 전위증감연산자
//        System.out.println(a);

        // a++ : 현재 라인의 명령문이 실행되고 나서 증가
        // ++a : 현재 라인의 명령문이 실행되기 전에 증가
//        int a = 10;
//        System.out.println(a++); // 10이 출력됨
//
//        int a = 10;
//        a++; // 증감연산자는 이런식으로 따로 쓰자!
//        System.out.println(a);
//        int b = 5;
//        int c = b++; // c:5
//        int d = ++b; // c:7


        // 비교연산자 : ==, !=. >. >= 등 => return 값은 boolean
//        char ch1 = 'a';
//        char ch2 = 'b';
//        System.out.println(ch1==ch2);
//        System.out.println(ch1!=ch2);

        // 논리연산자 : &&, ||, !
//        int num1 = 10;
//        int num2 = 20;
//        boolean b1 = num1>5 && num1<20;
//        System.out.println(b1);
//
//        // num2가 10과 30사이에 있는지 여부를 b2에 값 세팅
//        boolean b2 = num2>=10 && num2<=30;
//        boolean b3 = !(num2<10  num2>30);

        // 비트연산자 : 컴퓨터의 2진체계에서의 연산방식. & | ^ << >>
        int n1=5;   //0101
        int n2=4;   //0100
//        두 수를 &비트연산하게 되면 각 자릿수에 모두 1이 있어야 1의 결과값이 나옴
        System.out.println(n1&n2);  //0100
        System.out.println(n1|n2);  //0101
        System.out.println(n1^n2);  //0001
//        왼쪽으로 1칸 옮긴다는 의미는 해당 숫자값에 x2 한다는 의미
//        오른쪽으로 1칸 옮기게 되면 해당 숫자값에 /2 하게되는 것을 의미
        System.out.println(n1<<1);  //1010
    }
}