package co.jiye.prjdb.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jiye.prjdb.common.ViewResolve;
import co.jiye.prjdb.notice.service.DessertService;
import co.jiye.prjdb.notice.service.DessertVO;
import co.jiye.prjdb.notice.serviceImpl.DessertServiceImpl;

@WebServlet("/dessertList.do")
public class dessertList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dessertList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DessertService dao = new DessertServiceImpl();
		List<DessertVO> desserts = new ArrayList<DessertVO>();
		desserts=dao.dessertSelectList();
		
		request.setAttribute("desserts", desserts);
		String page = "../../boot-shop/index";
		ViewResolve.views(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
