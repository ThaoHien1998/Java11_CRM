package cybersoft.java11.crm.servlet;

<<<<<<< Updated upstream
public class HomeServlet {

=======
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.biz.HomeBiz;

@WebServlet(name="homeServlet", urlPatterns = {"/health"})
public class HomeServlet extends HttpServlet{
	private HomeBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new HomeBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// create a new cookie: username is cookie, tuanphan is value of cookie
		Cookie cookie = new Cookie("username", "tuanphan");
		// set time to live  for cookie is 20 seconds
		cookie.setMaxAge(20);
		// add cookie to response to send to client
		resp.addCookie(cookie);
		
		Date curTime = Calendar.getInstance().getTime();
		String now = "" + curTime.getHours()
						+"." + curTime.getMinutes()
						+"." + curTime.getSeconds()
						+"." + curTime.getDate()
						+"." + curTime.getMonth()
						+"." + curTime.getYear();
		
		Cookie anotherCookie = new Cookie("lastAccess", now);
		cookie.setMaxAge(60);
		resp.addCookie(anotherCookie);
		
		HttpSession currentSession = req.getSession();
		
		System.out.println(currentSession.getAttribute("loggedUser"));
		
		if (currentSession.getAttribute("loggedUser")==null) {
			currentSession.setAttribute("loggedUser", "thaohien98");
			//set time to wait for another request from client
			currentSession.setMaxInactiveInterval(20);
		}
		
		boolean databaseCheckResult = biz.checkHealth();
		if (databaseCheckResult)
			resp.getWriter().append("Connection to databae has been made successfully!");
		else
			resp.getWriter().append("Connection to databae has been made unsuccessfully!");
	}
	
>>>>>>> Stashed changes
}
