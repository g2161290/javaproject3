package co.jiye.prjdb.notice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.jiye.prjdb.notice.service.ReplyService;
import co.jiye.prjdb.notice.service.ReplyVO;
import co.jiye.prjdb.notice.serviceImpl.ReplyServiceImpl;

@WebServlet("/AjaxReplyList.do")
public class AjaxReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxReplyList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nid = request.getParameter("nid");
		// 추가
		String param = request.getParameter("param");
		System.out.println(nid);
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		list = svc.listReply(Integer.parseInt(nid));

		if (param == null) {
			ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()); // json 형태의 데이터로 변환
			String json = objectMapper.writeValueAsString(list);

			response.setContentType("text/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
		} else {
			// {"data": [ ["값"],[],....]
			String json = "{\"data\":[";
			int cnt=0;
			for (ReplyVO vo : list) {
				json += "[" + "\"" + vo.getReplyId() + "\"," + 
						"\"" + vo.getReply() + "\"," + 
						"\"" + vo.getReplyer() + "\"," + 
						"\"" + vo.getReplyDate() + "\"" + "]";
				if(++cnt != list.size()) {
					json += ",";
				}
			}

			json += "]}";
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
