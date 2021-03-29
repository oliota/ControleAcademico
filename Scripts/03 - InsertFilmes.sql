use BancoProway;

select f.IdFilme,f.nome,f.ano,f.sinopse,c.nome as categoria
from Filme f
inner join Categoria c on c.IdCategoria= f.CategoriaId;
 

INSERT Filme  
   (nome, ano, sinopse ,CategoriaId)  
VALUES  
   (
	   'Matrix',
	   1999 ,
	   'Um jovem programador � atormentado por estranhos pesadelos nos quais sempre est� conectado por cabos a um imenso sistema de computadores do futuro. � medida que o sonho se repete, ele come�a a levantar d�vidas sobre a realidade. E quando encontra os misteriosos Morpheus e Trinity, ele descobre que � v�tima do Matrix, um sistema inteligente e artificial que manipula a mente das pessoas e cria a ilus�o de um mundo real enquanto usa os c�rebros e corpos dos indiv�duos para produzir energia.',
	   ( select IdCategoria from Categoria where nome = 'Fic��o')
   ); 


INSERT Filme  
   (nome, ano, sinopse ,CategoriaId)  
VALUES  
   (
	   'Extraordin�rio',
	   2017  ,
	   'Auggie Pullman � um garoto que nasceu com uma deformidade facial e precisou passar por 27 cirurgias pl�sticas. Aos 10 anos, ele finalmente come�a a frequentar uma escola regular, como qualquer outra crian�a, pela primeira vez. No quinto ano, ele precisa se esfor�ar para conseguir se encaixar em sua nova realidade.',
	   ( select IdCategoria from Categoria where nome = 'Drama')
   ); 


   INSERT Filme  
   (nome, ano, sinopse ,CategoriaId)  
VALUES  
   (
	   'Jumanji',
	   1995   ,
	   'Alan Parrish desapareceu quando era menino e ningu�m acredita na hist�ria de seu amigo de que ele foi sugado por um jogo. Vinte e seis anos depois, duas crian�as acham o jogo no s�t�o e, quando come�am a jogar, Alan � libertado. Mas o jogo ainda n�o acabou e Alan precisa terminar antes de ser realmente libertado.',
	   ( select IdCategoria from Categoria where nome = 'Aventura')
   ); 


