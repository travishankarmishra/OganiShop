package com.travishankarmishra.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.travishankarmishra.model.ProductModel;
import com.travishankarmishra.repository.ProductRepository;
import com.travishankarmishra.service.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/index", "/login", "/shop-grid", "/shop-details", "/shoping-cart", "/checkout", "/blog-details", "/blog",
		"/contact" })
public class WebController extends HttpServlet {

	ProductService ps;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ps = new ProductRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		switch (req.getServletPath()) {

		case "/index":
			List<ProductModel> data = ps.read_all_product();
			HashSet<String> categories = new HashSet<>();
			for (ProductModel pm0 : data) {
				categories.add(pm0.getCategory());
			}

			ArrayList cat = new ArrayList<>();
			for (String pm0 : categories) {
				cat.add(pm0);
			}
			req.setAttribute("data", data);
			req.setAttribute("categories", cat);
			RequestDispatcher rd1 = req.getRequestDispatcher("dynamic/index.jsp");
			rd1.forward(req, resp);
			break;

		case "/shop-grid":
			RequestDispatcher rd2 = req.getRequestDispatcher("dynamic/shop-grid.jsp");
			rd2.forward(req, resp);
			break;

		case "/shop-details":
			RequestDispatcher rd3 = req.getRequestDispatcher("dynamic/shop-details.jsp");
			rd3.forward(req, resp);
			break;

		case "/shoping-cart":
			RequestDispatcher rd4 = req.getRequestDispatcher("dynamic/shoping-cart.jsp");
			rd4.forward(req, resp);
			break;

		case "/checkout":
			RequestDispatcher rd5 = req.getRequestDispatcher("dynamic/checkout.jsp");
			rd5.forward(req, resp);
			break;

		case "/blog-details":
			RequestDispatcher rd6 = req.getRequestDispatcher("dynamic/blog-details.jsp");
			rd6.forward(req, resp);
			break;

		case "/blog":
			RequestDispatcher rd7 = req.getRequestDispatcher("dynamic/blog.jsp");
			rd7.forward(req, resp);
			break;

		case "/contact":
			RequestDispatcher rd8 = req.getRequestDispatcher("dynamic/contact.jsp");
			rd8.forward(req, resp);
			break;

		case "/login":
			RequestDispatcher rd9 = req.getRequestDispatcher("dynamic/login.jsp");
			rd9.forward(req, resp);
			break;

		default:
			break;
		}

	}

}
