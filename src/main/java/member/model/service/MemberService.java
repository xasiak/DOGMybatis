package member.model.service;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
		
	}
	
	public int insertMember(Member member) {
		return 0;
	}

	public Member selectCheckLogin(Member member) {
		return null;
	}

	public int updateMember(Member member) {
		return 0;
	}

	public Member selectOneByEmail(String memberEmail) {
		return null;
	}

}
