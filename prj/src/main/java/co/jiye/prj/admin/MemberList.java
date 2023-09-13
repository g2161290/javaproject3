package co.jiye.prj.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jiye.prj.common.ViewResolve;
import co.jiye.prj.member.service.MemberService;
import co.jiye.prj.member.service.MemberVO;
import co.jiye.prj.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberlist.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao= new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();
		
		members=dao.memberSelectList();
		request.setAttribute("members", members);
		
		String page="admin/management/memberlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
