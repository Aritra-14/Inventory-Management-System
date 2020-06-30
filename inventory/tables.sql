// table
create table garments_table(
reg_id		int(5) primary key auto_increment,
StockID		varchar(100) not null,
SupplierID		varchar(100) not null,
SupplierName		varchar(100) not null,
stock_desc	varchar(200) not null,
cost_price	varchar(100) not null,
estimated_selling_price varchar(100) not null,
quantities_in_stock varchar(100) not null,
total_cost_price varchar(100) not null,
total_selling_price varchar(100) not null,
brand_name varchar(200) not null,
size varchar(100) not null
);

