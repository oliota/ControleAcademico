use BancoProway;


INSERT Perfil (nome) VALUES ('Administrador'); 
INSERT Perfil (nome) VALUES ('Usu�rio'); 


select * from Perfil;

------------------------------------------

INSERT Usuario  
   (nome, email, Logon ,senha,perfilid)  
VALUES  
   (
	   'Rubem Oliota',
	   'rubemoliota@gmail.com',
	   'admin',
	   '123',
	   ( select IdPerfil from Perfil where nome = 'Administrador')
   ); 

INSERT Usuario  
   (nome, email, Logon ,senha,perfilid)  
VALUES  
   (
	   'Fulano',
	   'fulano@gmail.com',
	   'fulano',
	   '123',
	   ( select IdPerfil from Perfil where nome = 'Usu�rio')
   ); 
    
select * from Usuario;

select u.IdUsuario,u.nome,u.email,u.Logon,u.senha,f.nome as perfil
from Usuario u
inner join Perfil f on f.IdPerfil= u.perfilid;



------------------------------------------




INSERT Categoria (nome) VALUES ('A��o'); 
INSERT Categoria (nome) VALUES ('Com�dia'); 
INSERT Categoria (nome) VALUES ('Terror'); 
INSERT Categoria (nome) VALUES ('Drama'); 
INSERT Categoria (nome) VALUES ('Fic��o'); 
INSERT Categoria (nome) VALUES ('Aventura'); 
INSERT Categoria (nome) VALUES ('Fantasia'); 
INSERT Categoria (nome) VALUES ('Anime'); 

select * from Categoria;




------------------------------------------

