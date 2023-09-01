package co.jiye.project.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jiye.project.common.ViewResolve;
import co.jiye.project.member.service.MemberService;
import co.jiye.project.member.service.MemberVO;
import co.jiye.project.member.serviceImpl.MemberServiceImpl;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo= new MemberVO();
		// Service 생성
		// MemberVO
		// vo 넘어온 값 담고
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = dao.memberSelect(vo);
		// dao 호출
		if(vo != null) {
			request.setAttribute("message", "로그인 성공");
		} else {
			request.setAttribute("message", "로그인 실패!!!!!");
		}
		// 결과처리
		String page = "member/membermessage";
		ViewResolve.views(request, response, page);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
