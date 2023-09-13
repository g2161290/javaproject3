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

import co.jiye.prjdb.notice.service.DessertService;
import co.jiye.prjdb.notice.service.DessertVO;
import co.jiye.prjdb.notice.service.ReplyVO;
import co.jiye.prjdb.notice.serviceImpl.DessertServiceImpl;

@WebServlet("/AjaxDessert.do")
public class AjaxDessert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxDessert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nid = request.getParameter("nid");
		// 추가
		String param = request.getParameter("param");
		System.out.println(nid);
		DessertService svc = new DessertServiceImpl();
		List<DessertVO> list = new ArrayList<DessertVO>();

		response.setContentType("text/json;charset=utf-8");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
