package springstudy.firstproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 싱글톤 적용
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 자동 스프링 빈 등록에서 제외할 대상 설정
) // @Component가 붙은 클래스를 자동으로 스프링 빈 등록
public class AutoAppConfig {
}
