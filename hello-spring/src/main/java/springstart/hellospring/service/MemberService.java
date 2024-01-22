package springstart.hellospring.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import springstart.hellospring.domain.Member;
import springstart.hellospring.repository.JpaMemberRepository;
import springstart.hellospring.repository.MemberRepository;
import springstart.hellospring.repository.MemotyMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final JpaMemberRepository memberRepository;

    public MemberService(JpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        // 중복 회원 찾기
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { // null 일 경우를 막아줌
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){ // 전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
