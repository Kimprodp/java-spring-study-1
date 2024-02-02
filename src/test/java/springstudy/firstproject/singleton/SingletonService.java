package springstudy.firstproject.singleton;

public class SingletonService {

    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    // 2. 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    // 3. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    // 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    /*
        <싱글톤 패턴 문제점>
        - 위 public 메서드를 위해서 위와 같은 코드가 필요 (싱글톤 구현 코드 자체가 많아짐)
        - 의존 관계상 클라이언트가 구체 클래스에 의존함 (DIP 위반)
        - 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높음
        - 테스트하기 어려움
        - 내부 속성을 변경하거나 초기화 하기 어려움
        - private 생성자로 자식 클래스를 만들기 어려움
        - 결론적으로 유연성이 떨어짐
        - 안티패턴으로 불리기도 함
     */
}
