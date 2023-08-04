package visit.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visit.model.service.BookService;
import visit.model.vo.Book;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/visit/book.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/visit/book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		BookService service = new BookService();
		Book book = null;
		try {
			String userName = request.getParameter("user-name");
			String userPhone = request.getParameter("user-phone");
			String point = request.getParameter("point");
//		LocalDate date = LocalDate.parse(request.getParameter("select-date"), dateTimeFormatter);
//		Date selectDate = Date.valueOf(date);
			Date date = format.parse(request.getParameter("select-date"));
			java.sql.Date selectDate = new java.sql.Date(date.getTime());
			String concern = request.getParameter("concerns");
			String house = request.getParameter("house");
			String houseHold = request.getParameter("house-hold");
			book = new Book(userName, userPhone, point, selectDate, concern, house, houseHold);
			int result = service.insertBook(book);
			if(result > 0) {
				request.setAttribute("msg", "방문예약이 완료되었습니다.");
				request.setAttribute("url", "/index.jsp");
				request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp")
				.forward(request, response);
			}else {
				request.setAttribute("msg", "방문예약에 실패하였습니다.");
				request.setAttribute("url", "/visit/book.jsp");
				request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
				.forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
