package visit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visit.model.service.BookService;
import visit.model.vo.Book;

/**
 * Servlet implementation class BookListController
 */
@WebServlet("/visit/bookList.do")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookService();
		List<Book> bList = service.selectBookList();
		if(!bList.isEmpty()) {
			request.setAttribute("bList", bList);
			request.getRequestDispatcher("/WEB-INF/views/visit/bookList.jsp");
		}else {
			request.setAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
			request.setAttribute("url", "/member/myPage.jsp");
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
