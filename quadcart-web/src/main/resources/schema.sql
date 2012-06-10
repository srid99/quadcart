CREATE TABLE Product
(
   product_id  INTEGER IDENTITY  ,
   name  VARCHAR  (50)	,
   description  VARCHAR  (100)	,
   manufacturer_id  INTEGER ,
   price  INTEGER  
);

CREATE TABLE Manufacturer
(
   manufacturer_id  INTEGER IDENTITY  ,
   name  VARCHAR  (50)	
);


