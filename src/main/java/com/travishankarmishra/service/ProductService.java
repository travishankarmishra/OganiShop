package com.travishankarmishra.service;

import java.util.List;

import com.travishankarmishra.model.ProductImages;
import com.travishankarmishra.model.ProductModel;

public interface ProductService {

	ProductModel read_product(); // to read single Product

	List<ProductModel> read_all_product();

	List<ProductModel> read_product(List<Integer> serial_no);

	void insert_product(ProductModel pm, ProductImages pi); // to read single Product

}
