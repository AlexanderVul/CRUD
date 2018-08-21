

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("Password");
		String userEmail = request.getParameter("userEmail");
		String userGender = request.getParameter("userGender");
		String userCountry = request.getParameter("userCountry");
		
		List<User> userList = session.getAttribute("userList") != null ? (List<User>)session.getAttribute("userList") : new ArrayList<User>();
//		for(User user : userList){
//			new User();
//			user.setName(userName);
//			user.setPassword(userPassword);
//			user.setEmail(userEmail);
//			user.setGender(userGender);
//			user.setCountry(userCountry);
//			
//		}
		User user = new User();
		user.setName(userName);
		user.setPassword(userPassword);
		user.setEmail(userEmail);
		user.setGender(userGender);
		user.setCountry(userCountry);
		userList.add(user);
		session.setAttribute("userList", userList);
		
		response.sendRedirect("adduser-success.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
