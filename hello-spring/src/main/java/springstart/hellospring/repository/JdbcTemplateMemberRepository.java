//package springstart.hellospring.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import springstart.hellospring.domain.Member;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//public class JdbcTemplateMemberRepository implements MemberRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcTemplateMemberRepository(DataSource dataSource){
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public Member save(Member member) {
//        jdbcTemplate.query("select * from member where id = ?",memberRowMapper());
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return null;
//    }
//
//    private RowMapper<Member> memberRowMapper(){
//        return (rs, rowNum) -> {
//            Member member = new Member();
//            member.setId(rs.getLong("id"));
//            member.setName(rs.getString("name"));
//            return member;
//        }
//    }
//}
