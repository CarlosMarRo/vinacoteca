Drop database if exists vinacoteca;
Create database vinacoteca;
use vinacoteca;

Create table Uva(
	Cod_Tipo_Uva int primary key,
	Nombre varchar(50) not null,
	Caracteristica varchar(50) not null,
	Color  varchar(30)
);


Create table Vino(
	Cod_Vino int primary key,
	Nombre varchar(60) not null,
	Precio decimal (6,2)  not null,	
	Origen varchar(50) not null,
	fecha date not null,
	denominacion boolean not null,
	Cod_Tipo_Uva int,
	Constraint cod_tipo_uva1 
            Foreign key (Cod_Tipo_Uva)
		references Uva (Cod_Tipo_Uva)	
);

Insert into Uva(Cod_Tipo_Uva, Nombre, Caracteristica,Color)values(00001,'Tempranillo','Uva tinta de piel gruesa', 'Negro azulado');
Insert into Uva(Cod_Tipo_Uva, Nombre, Caracteristica,Color)values(00002,'Mencia','Uva tinta de piel gruesa y racimo pequeño','Negro azulado');
Insert into Uva(Cod_Tipo_Uva, Nombre, Caracteristica,Color)values(00003,'Albariño','Uva blanca de sabor suave y fresco','Amarillo palido');
Insert into Uva(Cod_Tipo_Uva, Nombre, Caracteristica,Color)values(00004,'Alarije','Uva blanca de sabor suave y fresco','Blanca');
Insert into Uva(Cod_Tipo_Uva, Nombre, Caracteristica,Color)values(00005,'Airén','Racimos grandes y apretados','Blanca');
Insert into Uva(Cod_Tipo_Uva, Nombre, Caracteristica,Color)values(00006,'Albarello','Uva blanca de sabor suave y fresco','Blanca');

Insert into Vino(Cod_Vino, Nombre, Precio,Origen,fecha, denominacion, Cod_Tipo_Uva) values(00001,'Corullón',35.95,'Bierzo','2012-02-19',true, 00001);
Insert into Vino(Cod_Vino, Nombre, Precio,Origen,fecha, denominacion, Cod_Tipo_Uva) values(00002,'Artadi Pagos Viejos',61.85,'La Rioja','2007-04-13',false, 00002);
Insert into Vino(Cod_Vino, Nombre, Precio,Origen,fecha, denominacion, Cod_Tipo_Uva) values(00003,'Iwine',21.95,'Rias Baixas','2014-06-02',true, 00003);
