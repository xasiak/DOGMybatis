package visit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import visit.model.vo.Book;

public class BookDAO {

	public int insertBook(Connection conn, Book book) {
		String query = "INSERT INTO BOOK_TBL VALUES(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getBookUserName());
			pstmt.setString(2, book.getBookUserPhone());
			pstmt.setString(3, book.getBookPoint());
			pstmt.setDate(4, book.getBookDate());
			pstmt.setString(5, book.getBookConcern());
			pstmt.setString(6, book.getBookUserHouse());
			pstmt.setString(7, book.getBookUserHouseHold());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
