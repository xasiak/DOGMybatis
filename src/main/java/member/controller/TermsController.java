package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EnrollController
 */
@WebServlet("/member/terms.do")
public class TermsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TermsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/terms.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String memberEmail = request.getParameter("member-email");
//		String memberPw = request.getParameter("member-pw");
//		String memberName = request.getParameter("member-name");
//		String memberPhone = request.getParameter("member-phone");
//		
//		Member member = new Member(memberEmail, memberPw, memberName, memberPhone);
//		
//		MemberService service = new MemberService();
//		
//		int result = service.insertMember(member);
//		if(result>0) {
//			request.setAttribute("msg", "회원가입 성공했어요");
//			request.setAttribute("url", "/index.jsp");
//			request.getRequestDispatcher("/member/serviceSuccess.jsp")
//			.forward(request, response);
//		}else {
//			request.setAttribute("msg", "회원가입 실패했어요");
//		}
	}

}
