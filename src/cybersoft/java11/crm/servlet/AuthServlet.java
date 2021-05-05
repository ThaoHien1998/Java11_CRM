package cybersoft.java11.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.biz.AuthBiz;
import cybersoft.java11.crm.model.User;

@WebServlet(name="authSevlet",urlPatterns= {
		"/login",
		"/logout",
		"/register"}
)
public class AuthServlet extends HttpServlet {
	AuthBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		 biz = new AuthBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: forward to login.jsp
		
		String path = req.getServletPath();
		
		switch (path) {
		case "/login":
			
			break;

		default:
			break;
		}
	
		req.getRequestDispatcher("/WEB-INF/Auth/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		
		switch (path) {
		case "/login":
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			System.out.printf("email: %s\n",email);
			System.out.printf("password: %s\n",password);
			
			User user = biz.login(email, password);
			
			HttpSession session = req.getSession();
			session.setAttribute("userID", ""+user.getId());
			session.setMaxInactiveInterval(120);
			
			if (user != null) { // logged in successfully
				resp.sendRedirect(req.getContextPath()+"/home");
			}
			else
				req.getRequestDispatcher("/WEB-INF/Auth/login.jsp").forward(req, resp);
			break;

		default:
			break;
		}
	}
}
