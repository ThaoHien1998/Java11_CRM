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
import cybersoft.java11.crm.utils.JSPPathConst;
import cybersoft.java11.crm.utils.URLContants;

@WebServlet(name="authSevlet",urlPatterns= {
		URLContants.AUTH_LOGIN,
		URLContants.AUTH_LOGOUT,
		URLContants.AUTH_REGISTER}
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
		case URLContants.AUTH_LOGIN:
			req.getRequestDispatcher(JSPPathConst.LOGIN).forward(req, resp);
			break;

		default:
			break;
		}
	
		
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
			
			if (user != null)// logged in successfully
				resp.sendRedirect(req.getContextPath()+URLContants.HOME);
			else
				req.getRequestDispatcher(JSPPathConst.LOGIN).forward(req, resp);
			break;

		default:
			break;
		}
	}
}
