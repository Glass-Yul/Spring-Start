package springstart.hellospring;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springstart.hellospring.repository.JpaMemberRepository;
import springstart.hellospring.repository.MemberRepository;
import springstart.hellospring.repository.MemotyMemberRepository;
import springstart.hellospring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final  MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService((JpaMemberRepository) memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
//      return new MemoryMemberRepository();
//      return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
        return new MemberService(memberRepository);
    }
}
