package visit.model.service;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import visit.model.dao.BookDAO;
import visit.model.vo.Book;

public class BookService {

	private BookDAO bDao;
	
	public BookService() {
		bDao = new BookDAO();
	}
	
	public int insertBook(Book book) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = bDao.insertBook(session, book);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public List<Book> selectBookList() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Book> bList = bDao.selectBookList(session);
		session.close();
		return bList;
	}
	
	
}
