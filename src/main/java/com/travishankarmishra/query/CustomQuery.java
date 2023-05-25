package com.travishankarmishra.query;

public abstract class CustomQuery {

	protected String db_url = "jdbc:mysql://localhost:3306/OganiShop";
	protected String user_name = "root";
	protected String password = "ducat";

	protected String product_create_query = "CREATE TABLE if not exists Product (" + "    category VARCHAR(255),"
			+ "    serial_no INT PRIMARY KEY auto_increment," + "    name VARCHAR(255)," + "    rate INT,"
			+ "    price FLOAT," + "    currency VARCHAR(10)," + "    brief_intro TEXT," + "    Available_quantity INT,"
			+ "    pincode INT," + "    weight FLOAT," + "    description TEXT" + ")";

	protected String image_create_query = "CREATE TABLE if not exists ProductImage (" + "    serial_no INT,"
			+ "    imageid INT PRIMARY KEY auto_increment ," + "    Imageurl TEXT" + ")";

	protected String image_create_query_modify = "alter table ProductImage  "
			+ "add constraint fk_ProductImage foreign key(serial_no) " + "references Product(serial_no)";

	protected String related_create_query = "CREATE TABLE if not exists RelatedProduct (" + "    serial_no INT ,"
			+ "    relatedid INT PRIMARY KEY auto_increment ," + "    related_serial_no int " + ")";

	protected String related_create_query_modify1 = "alter table RelatedProduct "
			+ "add constraint fk1_RelatedProduct foreign key(serial_no) " + "references  Product(serial_no)";

	protected String related_create_query_modify2 = "alter table RelatedProduct "
			+ "add constraint fk2_RelatedProduct foreign key(related_serial_no) " + "references  Product(serial_no)";

	protected String user_create_query = "create table if not exists admin(sno int auto_increment primary key, name text,email text, password text,mobile text, image text )";
}
