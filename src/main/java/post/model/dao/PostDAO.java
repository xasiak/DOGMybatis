package post.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import post.model.vo.Post;


public class PostDAO {
	
	public List<Post> selectPostList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM POST_TBL ORDER BY POST_DATE DESC";
		List<Post> nList = new ArrayList<Post>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Post post = rsetToPost(rset);
				nList.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nList;
	}

	public Post selectOneByNo(Connection conn, int postNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM post_TBL WHERE post_NO = ?";
		Post post = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				post = rsetToPost(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return post;
	}
	
	private Post rsetToPost(ResultSet rset) throws SQLException {
		Post post = new Post();
		post.setPostNo(rset.getInt("POST_NO"));
		post.setPostTitle(rset.getString("POST_TITLE"));
		post.setPostContent(rset.getString("POST_CONTENT"));
		post.setPostWriter(rset.getString("POST_WRITER"));
		post.setPostLike(rset.getInt("POST_LIKE"));
		post.setPostDate(rset.getDate("POST_DATE"));
		post.setUpdateDate(rset.getDate("UPDATE_DATE"));
		post.setViewCount(rset.getInt("VIEW_COUNT"));
		return post;
	}

}
