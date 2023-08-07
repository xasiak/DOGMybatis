package member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
		
	}
	
	public int insertMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.insertMember(session, member);
		if(result > 0) {
			// 성공 -> commit
			session.commit();
		} else {
			// 실패 -> rollback
			session.rollback();
		}
		session.close();
		return result;
	}

	public Member selectCheckLogin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectCheckLogin(session, member);
		session.close();
		return mOne;
	}

	public int updateMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.updateMember(session, member);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public Member selectOneByEmail(String memberEmail) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member member = mDao.selectOneByEmail(session, memberEmail);
		session.close();
		return member;
	}

}
