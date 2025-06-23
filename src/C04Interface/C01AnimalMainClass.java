package C04Interface;

// C01AnimalInterface3를 implements 하면 -> 1, 2 인터페이스의 메서드를 모두 구현해야 합니다.
public class C01AnimalMainClass implements C01AnimalInterface3 {
    @Override
    public void makeSound() {

    }

    @Override
    public String play(String a, String b) {
        return "";
    }
}
