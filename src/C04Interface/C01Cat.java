package C04Interface;

//extends : 기능의 중복제거
//implements : 메서드의 명세 정의
public class C01Cat implements C01AnimalInterface1, C01AnimalInterface2 {

    @Override
    public void makeSound() {
        System.out.println("야옹야옹");
    }

    @Override
    public String play(String a, String b) {
        return a + "와 " + b + "가 그루밍합니다.";
    }
}
