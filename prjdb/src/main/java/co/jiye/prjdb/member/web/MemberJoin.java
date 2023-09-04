package co.jiye.prjdb.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jiye.prjdb.common.Sha256;
import co.jiye.prjdb.common.ViewResolve;
import co.jiye.prjdb.member.service.MemberService;
import co.jiye.prjdb.member.service.MemberVO;
import co.jiye.prjdb.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberjoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberJoin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao= new MemberServiceImpl();
		MemberVO vo= new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(Sha256.encrypt(request.getParameter("memberPassword")));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		
		int n = dao.memberInsert(vo);
		if(n!=0) {
			request.setAttribute("message", "회원가입이 정상 처리되었습니다.");
		} else {
			request.setAttribute("message", "회원가입이 실패하였습니다.");
		}
		
		String page= "member/membermessage";
		ViewResolve.views(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
