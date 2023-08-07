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

	public String generatePageNavi(int currentPage) {
		int totalCount = 200;	// 전체 게시물의 갯수를 동적으로 가지고 와야함!
		int recordCountPerPage = 15;
		int naviTotalCount = 0;
		if(totalCount % recordCountPerPage > 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		}else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 10;
		// currentPage				startNavi		 endNavi
		//  1,2,3,4,5					1				5
		// 	6,7,8,9,10					6				10
		// 	11,12,13,14,15				11				15
		// 	16,17,18,19,20				16				20
		int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// endNavi값이 총 범위의 갯수보다 커지는 것을 막아주는 코드
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == naviTotalCount) {
			needNext = false;
		}
//		String result = "";
		StringBuilder result = new StringBuilder();	// 메모리 아끼기 위해 사용
		if(needPrev) {
			result.append("<a href='/post/postlist.do?currentPage="+(startNavi-1)+"'>[이전]</a>"); 
		}
		for(int i = startNavi; i <= endNavi; i++) {
//			result += "<a href=\"#\">1</a>";
			result.append("<a href='/post/postlist.do?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;"); 	// \" -> ' 대체 가능
		}
		if(needNext) {
			result.append("<a href='/post/postlist.do?currentPage="+(endNavi+1)+"'>[다음]</a>"); 
		}
		return result.toString();
	}
	
}
