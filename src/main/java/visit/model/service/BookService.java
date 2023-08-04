package visit.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import visit.model.dao.BookDAO;
import visit.model.vo.Book;

public class BookService {

	private JDBCTemplate jdbcTemplate;
	private BookDAO bDao;
	
	public BookService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		bDao = new BookDAO();
	}
	
	public int insertBook(Book book) {
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출
		int result = bDao.insertBook(conn, book);
		// 커밋/롤백
		if(result>0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		}else {
			// 실패 - 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
}
