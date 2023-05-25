package com.travishankarmishra.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.travishankarmishra.model.ProductImages;
import com.travishankarmishra.model.ProductModel;
import com.travishankarmishra.query.CustomQuery;
import com.travishankarmishra.service.ProductService;

public class ProductRepository extends CustomQuery implements ProductService {

	private Connection conn = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;

	public ProductRepository() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(db_url, user_name, password);
			stm = conn.createStatement();
			stm.execute(product_create_query);
			// stm.execute(image_create_query);
			stm.execute(related_create_query);
			// stm.execute(image_create_query_modify);
			stm.execute(related_create_query_modify1);
			stm.execute(related_create_query_modify2);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public ProductModel read_product() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> read_all_product() {
		ArrayList<ProductModel> data = new ArrayList<>();
		try
		{
		pstm = conn.prepareStatement("select * from Product");
		ResultSet set = pstm.executeQuery();
		while (set.next()) {
			String category = set.getString(1);
			int serial_no = set.getInt(2);
			List<ProductImages> img_urls = new ArrayList<>();
			PreparedStatement pstm2 = conn.prepareStatement("select * from ProductImage where serial_no =?");
			pstm2.setInt(1, serial_no);

			ResultSet set2 = pstm2.executeQuery();
			while (set2.next()) {
				ProductImages pi = new ProductImages(serial_no, set2.getInt(2), set2.getString(3));
				img_urls.add(pi);
			}
			String name = set.getString(3);
			int rate = set.getInt(4);
			float price = set.getFloat(5);
			String currency = set.getString(6);
			String brief_intro = set.getString(7);
			int Available_quantity = set.getInt(8);
			int pincode = set.getInt(9);
			float weight = set.getFloat(10);
			String description = set.getString(11);

			ProductModel pm = new ProductModel(category, serial_no, img_urls, name, rate, price, currency, brief_intro,
					Available_quantity, pincode, weight, description, null);
			data.add(pm);
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	@Override
	public List<ProductModel> read_product(List<Integer> serial_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert_product(ProductModel pm, ProductImages pi) {
		try {
			pstm = conn.prepareStatement(
					"insert into Product(category,name,rate,price,currency,brief_intro,Available_quantity,pincode,weight,description) values(?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, pm.getCategory());
			pstm.setString(2, pm.getName());
			pstm.setInt(3, pm.getRate());
			pstm.setFloat(4, pm.getPrice());
			pstm.setString(5, pm.getCurrency());
			pstm.setString(6, pm.getBrief_intro());
			pstm.setInt(7, pm.getAvailable_quantity());
			pstm.setInt(8, pm.getPincode());
			pstm.setFloat(9, pm.getWeight());
			pstm.setString(10, pm.getDescription());
			pstm.executeUpdate();
			pstm.close();

			pstm = conn.prepareStatement(
					"select serial_no from Product where category=? and name=? and rate=? and price=? and currency=? and brief_intro=? and Available_quantity=? and pincode=? and weight=? and description=?");
			pstm.setString(1, pm.getCategory());
			pstm.setString(2, pm.getName());
			pstm.setInt(3, pm.getRate());
			pstm.setFloat(4, pm.getPrice());
			pstm.setString(5, pm.getCurrency());
			pstm.setString(6, pm.getBrief_intro());
			pstm.setInt(7, pm.getAvailable_quantity());
			pstm.setInt(8, pm.getPincode());
			pstm.setFloat(9, pm.getWeight());
			pstm.setString(10, pm.getDescription());
			ResultSet set = pstm.executeQuery();
			int serial_no = 0;
			if (set.next()) {
				serial_no = set.getInt(1);
			}

			pstm.close();
			pstm = conn.prepareStatement("insert into ProductImage (serial_no,Imageurl) values(?,?) ");
			pstm.setInt(1, serial_no);
			pstm.setString(2, pi.getImageurl());
			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
