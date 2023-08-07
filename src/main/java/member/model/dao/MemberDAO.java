package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDAO {

	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	public Member selectCheckLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectCheckLogin", member);
		return mOne;
	}
	
	private Member rsetToMember(ResultSet rset) throws SQLException {
		Member member = new Member();
		member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
		member.setMemberPw(rset.getString("MEMBER_PW"));
		member.setMemberName(rset.getString("MEMBER_NAME"));
		member.setMemberPhone(rset.getString("MEMBER_PHONE"));
		return member;
	}

	public int updateMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.updateMember", member);
		return result;
	}

	public Member selectOneByEmail(SqlSession session, String memberEmail) {
		Member member = session.selectOne("MemberMapper.selectOneByEmail", memberEmail);
		return member;
	}
	

}
