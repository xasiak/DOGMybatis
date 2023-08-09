package visit.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import visit.model.vo.Book;

public class BookDAO {

	public int insertBook(SqlSession session, Book book) {
		int result = session.insert("BookMapper.insertBook", book);
		return result;
	}

	public List<Book> selectBookList(SqlSession session, String userEmail) {
		List<Book> bList = session.selectList("BookMapper.selectBookList", userEmail);
		return bList;
	}
	

}
