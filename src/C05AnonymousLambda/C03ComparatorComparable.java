package C05AnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
////        자바에서는 비교를 위한 인터페이스를 대표적으로 2개 제공
////        Comparable인터페이스 : compareTo메서드 선언
////        Comparator인터페이스 : compare메서드 선언
//
////        String클래스에 compareTo메서드 내장
////       ⭐String클래스 및 java의 많은 클래스에서 Comparable을 상속하여 compareTo메서드를 구현.
//        String a = "hello";
//        String b = "world";
//        System.out.println(a.compareTo(b)); //h-w : 마이너스출력
//
//        List<String> myList = new ArrayList<>();
//        myList.add("java");
//        myList.add("python");
//        myList.add("javascript");
////        ⭐String안에 compareTo메서드를 사용하여 정렬이 이루어짐.
//        Collections.sort(myList);                   //⭐Collections.sort(myList); == myList.sort(null);

//        직접만든 Student를 List에 담아 정렬
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kim", 24));
        studentList.add(new Student("lee", 15));
        studentList.add(new Student("park", 33));
        studentList.add(new Student("hwang", 21));
        studentList.add(new Student("kang", 24));

////        정렬방법1. Student객체에서 Comparable을 직접 구현한 방식.
////        단점 : Student객체를 직접 수정해야하므로, 유연성이 떨어짐.
////        Collections.sort에서 Comparable을 구현한 객체를 요구.
//        Collections.sort(studentList);
//        System.out.println(studentList);

//        정렬방법2. Comparator를 구현한 익명객체를 사용.
//        Comparator 활용도가 높은 이유는 많은 정렬 메서드에서 Comparator객체를 요구하기 때문.
        //2-1)new Comparator
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //2-2)람다
        studentList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));    //⭐암기 studentList.sort(람다식);
        System.out.println(studentList);


        String[] stArr = {"hello", "java", "C++", "world2"};
        Arrays.sort(stArr);
        Arrays.sort(stArr, Comparator.reverseOrder());
//        ⭐글자길이를 기준으로 내림차순 정렬
        //1. new Comparator<String>() {비교식 작성}
        Arrays.sort(stArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        //2. 람다
        Arrays.sort(stArr, (o1, o2) -> o2.length()-o1.length());
        System.out.println(Arrays.toString(stArr));

//        백준 : 단어 정렬 -> 다시 풀기
//        백준 : 절댓값힙 -> 절대값 구하는 법 Math.abs(-1) -> 다시 풀기

//        배열 안의 배열 정렬
//        [4,5], [1,2], [5,0], [3,1]
        List<int[]> myList = new ArrayList<>();
        myList.add(new int[]{4,5});
        myList.add(new int[]{1,2});
        myList.add(new int[]{5,0});
        myList.add(new int[]{3,1});
//        정렬 : 리스트안의 배열에 index 1번째값을 기준으로 오름차순
        myList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(int[] m : myList) {
            System.out.println(Arrays.toString(m));
        }

//        ⭐백준 : 선긋기 -> 다시 풀기

    }
}
//class Student implements Comparable<Student> {  //⭐1. Comparable
class Student {  //⭐2. Comparator
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + ", age=" + age + '}';
    }

//    //⭐ 복잡도 nlogn
////    정렬은 결국 2개의 값을 비교하는 것으로 , A와 B대상 2개만 있으면 충분.
////    두수(또는문자)의 비교의 경우 음수,0,양수 세 값중에 하나만 return. 이를 통해 정렬수행.
////    this가 앞에 있을땐 오름차순, this가 뒤에 있으면 내림차순으로 내부적으로 정렬로직 동작
//    @Override
//    public int compareTo(Student o) {   //this와 o가 계속 비교
//        return this.getAge()-o.getAge();   //나이기준 오름차순
////        return this.getName().compareTo(o.getName());   //이름기준 오름차순
////        return o.getName().compareTo(this.getName());   //이름기준 내림차순
//    }
}