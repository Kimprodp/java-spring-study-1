# Java Spring Study
> [스프링 강의](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8)
<br>

# Spec
- Build : Gardle - Groovy
- Language : Java 17
- Spring Boot : 3.2.2
- Packaging : Jar
- Dependencies : None
<br>


### 실습 예제 비즈니스 요구사항
- 회원
  - 회원을 가입하고 조회할 수 있다.
  - 회원을 일반과 VIP 두 가지 등급이 있다.
  - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
- 주문과 할인 정책
  - 회원은 상품을 주문할 수 있다.
  - 회원 등급에 따라 할인 정책을 적용할 수 있다.
  - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
  - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)
  
### 주문 할인 도메인 설계
1. 주문 생성: 클라이언트는 주문 서비스에 주문 생성을 요청한다.
2. 회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회한다.
3. 할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
4. 주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.

### 역할과 구현을 분리
- 회원 관리 서비스 역할 <- [회원 서비스 구현체]
- 주문 서비스 역할 <- [주문 서비스 구현체]
- 회원 저장소 역할 <- [메모리 회원 저장소 구현체], [DB 회원 저장소 구현체]
- 할인 정책 역할 <- [정액 할인 정책 구현체], [정률 할인 정책 구현체]