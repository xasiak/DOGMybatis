package post.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.PostService;
import post.model.vo.PageData;
import post.model.vo.Post;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post/postlist.do")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostService service = new PostService();
		String page = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1";
		int currentPage = Integer.parseInt(page);
		PageData pd = service.selectPostList(currentPage);
		List<Post> pList = pd.getpList();
		String pageNavi = pd.getPageNavi();
		if(!pList.isEmpty()) {
			request.setAttribute("pList", pList);
			request.setAttribute("pageNavi", pageNavi);
			request.getRequestDispatcher("/WEB-INF/views/post/postlist.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "데이터가 존재하지 않습니다.");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
