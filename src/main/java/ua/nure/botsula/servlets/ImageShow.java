package ua.nure.botsula.servlets;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import net.proselyte.springsecurityapp.model.DefaultImage;
import net.proselyte.springsecurityapp.model.SystemFacade;
import net.proselyte.springsecurityapp.service.SecurityService;
import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ImageShow",
		urlPatterns = {"/ImageShow"})
public class ImageShow extends HttpServlet {

	@Autowired
	private UserService userService;
	private DefaultImage defaultImage;
/*
	@Autowired
	private PlayerService playerService;
*/
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

//    private static Map<Long, Byte[]> imageMap = new HashMap();
	/**
	 * Processes requests for both HTTP
	 * <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws javax.servlet.ServletException if a servlet-specific error occurs
	 * @throws java.io.IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		try {

				Long index = Long.valueOf(request.getParameter("id"));
				String type = request.getParameter("type");

			SystemFacade systemFacade =(SystemFacade)getServletContext().getAttribute("systemFacade");
			byte[] image;
			if(type.equals("tournament")){
				image = systemFacade.getTournament(index).getIcon();
				response.setContentLength(image.length);
			}else if(type.equals("user")){
				image = systemFacade.getUser(index).getImage();
				response.setContentLength(image.length);

			}else if(type.equals("team")){
					image = systemFacade.getTeam(index).getSymbol();
				response.setContentLength(image.length);

			}else if(type.equals("player")){
				image= systemFacade.getPlayer(index).getPhoto();
				response.setContentLength(image.length);
			}
			else {
				image = systemFacade.getTournament(index).getIcon();
				response.setContentLength(image.length);
			}


			out.write(image);
	} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}


	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws javax.servlet.ServletException if a servlet-specific error occurs
	 * @throws java.io.IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws javax.servlet.ServletException if a servlet-specific error occurs
	 * @throws java.io.IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
