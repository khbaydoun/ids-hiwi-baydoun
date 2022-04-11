CREATE TABLE employee (
	id serial PRIMARY KEY,
	name VARCHAR ( 50 )  NULL,
	email VARCHAR ( 50 )  NULL,
	password VARCHAR ( 255 )  NULL ,
	about VARCHAR ( 50 )  NULL,
	token text, 
	country VARCHAR ( 50 )  NULL , 
	location VARCHAR ( 50 )  NULL, 
	lng Integer  , 
	lat Integer, 
	dob VARCHAR ( 50 )  NULL, 
	gender Integer , 
	user_type Integer , 
	user_status Integer , 
	profile_picture text, 
	cover_picture text,
	enable_follow_me  boolean,
	send_me_notifications boolean, 
	send_text_messages boolean, 
	enable_tagging boolean,
	created_at VARCHAR ( 50 )  NULL,  
	updated_at VARCHAR ( 50 )  NULL, 
	live_lng numeric,
	live_lat numeric,
	live_location text, 
	credit_balance INTEGER, 
	my_cash INTEGER
);
				