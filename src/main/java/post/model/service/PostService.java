package post.model.service;

import java.sql.Connection;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import post.model.dao.PostDAO;
import post.model.vo.PageData;
import post.model.vo.Post;

public class PostService {

	private PostDAO pDao;
	
	public PostService() {
		pDao = new PostDAO();
	}
	
	public List<Post> selectPostList(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Post> pList = pDao.selectPostList(session, currentPage);
		String pageNavi = pDao.generatePageNavi(currentPage);
		PageData pd = new PageData(pList,pageNavi);
		session.close();
		return pList;
	}

	public Post selectOneByNo(int postNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Post post = pDao.selectOneByNo(session, postNo);
		session.close();
		return post;
	}
}
