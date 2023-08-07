package post.model.dao;

import java.sql.Connection;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import post.model.vo.Post;


public class PostDAO {
	
	public List<Post> selectPostList(SqlSession session, int currentPage) {
		int limit = 8;
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Post> pList = session.selectList("PostMapper.selectPostList", null, rowBounds);
		
		return pList;
		
	}

	public Post selectOneByNo(SqlSession session, int postNo) {
		Post post = session.selectOne("PostMapper.selectOneByNo", postNo);
		return post;
	}

	public String generatePageNavi(SqlSession session, int currentPage) {
		int totalCount = getTotalCount(session);	// 전체 게시물의 갯수를 동적으로 가지고 와야함!
		int recordCountPerPage = 8;
		int naviCountPerPage = 5;
		int totalNaviCount;
		if(totalCount % recordCountPerPage > 0) {
			totalNaviCount = totalCount / recordCountPerPage + 1;
		}else {
			totalNaviCount = totalCount / recordCountPerPage;
		}
		
		int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > totalNaviCount) {
			endNavi = totalNaviCount;
		}
		StringBuffer result = new StringBuffer();
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi != 1) {
			result.append("<a href='/post/postlist.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='/post/postlist.do?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;");
		}
		if(endNavi != totalNaviCount) {
			result.append("<a href='/post/postlist.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		return result.toString();
	}
	

	private int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("PostMapper.getTotalCount");
		return totalCount;
	}
	
}
