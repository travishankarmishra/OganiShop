package com.travishankarmishra.controller;

import java.io.IOException;
import com.travishankarmishra.model.ProductImages;
import com.travishankarmishra.model.ProductModel;
import com.travishankarmishra.model.User;
import com.travishankarmishra.repository.ProductRepository;
import com.travishankarmishra.repository.UserRepository;
import com.travishankarmishra.service.ProductService;
import com.travishankarmishra.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet({ "/admin", "/register", "/registerlink", "/productregister" })
@MultipartConfig(fileSizeThreshold = 1000000000, maxFileSize = 1000000, maxRequestSize = 10000000)
public class AdminController extends HttpServlet {

	UserService us;
	ProductService ps;

	@Override
	public void init(ServletConfig config) throws ServletException {
		us = new UserRepository();
		ps = new ProductRepository();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getServletPath().equals("/register")) {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String mobile = req.getParameter("mobile");
			String file_name = req.getPart("file").getSubmittedFileName();
			upload(req);
			User u = new User(0, name, email, password, mobile, file_name);
			if (us.Insert(u)) {
				RequestDispatcher rd = req.getRequestDispatcher("dynamic/login.jsp");
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("register");
				rd.forward(req, resp);
			}
		} else if (req.getServletPath().equals("/admin")) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			User u = new User(email, password);
			String name = us.fetch(u);
			if (!name.equals(null)) {
				HttpSession session = req.getSession();
				session.setAttribute("name", name);
				session.setMaxInactiveInterval(60 * 60 * 15);
				RequestDispatcher rd = req.getRequestDispatcher("dynamic/dashboard.jsp");
				rd.forward(req, resp);
			}
		} else if (req.getServletPath().equals("/productregister")) {
			String category = req.getParameter("category");
			String name = req.getParameter("name");
			String rate = req.getParameter("rate");
			String price = req.getParameter("price");
			String currency = req.getParameter("currency");
			String briefintro = req.getParameter("briefintro");
			String Availablequantity = req.getParameter("Availablequantity");
			String pincode = req.getParameter("pincode");
			String weight = req.getParameter("weight");
			String description = req.getParameter("description");
			String image = req.getPart("image").getSubmittedFileName();

			for (Part p0 : req.getParts()) {
				p0.write("/home/ducat/Documents/Java_Projects/OganiShop/src/main/webapp/static/img/upload/" + image);
			}

			ProductModel pm = new ProductModel(category, 0, null, name, Integer.parseInt(rate), Float.parseFloat(price),
					currency, briefintro, Integer.parseInt(Availablequantity), Integer.parseInt(pincode),
					Integer.parseInt(weight), description, null);
			// dummy serial number must update
			ProductImages pi = new ProductImages(1, 0, image);

			ps.insert_product(pm, pi);

		}

	}

	void upload(HttpServletRequest req) {
		try {
			for (Part p0 : req.getParts()) {
				p0.write("/home/ducat/Documents/Java_Projects/OganiShop/src/main/webapp/static/img/upload/"
						+ req.getPart("file").getSubmittedFileName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("dynamic/register.jsp");
		rd.forward(req, resp);
	}
}
