package co.jiye.prjdb.notice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jiye.prjdb.common.ViewResolve;

@WebServlet("/TodoList.do")
public class TodoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "notice/todo2";
		ViewResolve.views(request, response, page);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
