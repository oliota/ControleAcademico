--inserir dados da serie Avatar: A Lenda de Aang
use BancoProway;
 
  --seleciona os episidos das series
   select s.nome,s.ano,s.sinopse,
   t.sequencial temporada,
   e.sequencial episodio,
   e.nome titulo,
   e.sinopse
   from episodio e
   inner join temporada t on t.IdTemporada= e.TemporadaId
   inner join serie s on s.IdSerie=t.SerieId
   order by s.nome,t.sequencial,e.sequencial

   select * from serie ;
   

   --conta as temporadas de cada serie
	select s.nome, count(*)as temporadas
	from serie s
	inner join temporada t on t.SerieId= s.IdSerie
	group by s.nome;


   
INSERT serie
   (nome, ano, sinopse ,categoriaid)  
VALUES  
   (
	   'Avatar: A Lenda de Aang',
	   2005  ,
	   'Os irm�os Katara e Sokka acordam o jovem Aang de uma longa hiberna��o e descobrem que ele � um Avatar, com poderes que podem derrotar a Na��o do Fogo.',
	   ( select IdCategoria from categoria where nome = 'Fantasia')
   ); 




   
-- incrementa uma temporada na serie
INSERT temporada
   (serieid, sequencial )  
VALUES  
	( 
		( select IdSerie from serie where nome = 'Avatar: A Lenda de Aang'),
		( 
			select isnull(max(t.sequencial),0)+1 
			from temporada t
			inner join serie s on s.IdSerie=t.SerieId and s.nome = 'Avatar: A Lenda de Aang'
		)
	); 




--incrementa um episodio na temporada da serie
	INSERT episodio
   (nome, sinopse, TemporadaId ,sequencial)  
VALUES  
   (
	   'O Garoto no Iceberg',
	   'Nesses tempos de guerra, a m�e de Sokka e Katara, dois adolescentes da Tribo da �gua do Sul, foi morta pela Na��o do Fogo e seu pai est� lutando na guerra. Muitos acreditam que o Avatar, o �nico que consegue dominar os quatro elementos morreu. Mas Katara, a �nica dominadora de �gua da Tribo do Sul, acredita que ele ainda est� vivo. Os dois irm�os um dia encontram um garoto congelado num iceberg chamado Aang. Surpreendem-se ao ver que ele � um dominador de ar. Pr�ncipe Zuko, o pr�ncipe banido da Na��o do Fogo e seu tio Iroh est�o � procura do Avatar para captur�-lo. Ao verem o dominador de ar de longe, acreditam que ele � o Avatar.'  ,
	   ( 
	   --busca o id da temporada
	   select t.IdTemporada from temporada t
	   inner join serie s on s.IdSerie= t.SerieId and sequencial=1 and s.nome='Avatar: A Lenda de Aang' 
	   ),
	   ( 
			--busca o ultimo sequencial da tamporada
			select isnull(max(e.sequencial),0)+1 
			from episodio e
			inner join temporada t on t.IdTemporada= e.TemporadaId and t.sequencial=1   
			inner join serie s on s.IdSerie=t.SerieId and  s.nome='Avatar: A Lenda de Aang'
		)
   ); 


   
--incrementa um episodio na temporada da serie
	INSERT episodio  
   (nome, sinopse, TemporadaId ,sequencial)  
VALUES  
   (
	   'O Regresso do Avatar',
	   'Ap�s explorarem um navio da Na��o do Fogo abandonado Aang e Katara acidentalmente ativam um sinalizador, revelando a Tribo da �gua, onde Zuko est� indo para capturar Aang (que mais tarde se revela ser o Avatar). Aang se entrega para salvar a aldeia, mas Sokka e Katara o salvam e juntam-se a ele.'  ,
	   ( 
	   --busca o id da temporada
	   select t.IdTemporada from temporada t
	   inner join serie s on s.IdSerie= t.SerieId and sequencial=1 and s.nome='Avatar: A Lenda de Aang' 
	   ),
	   ( 
			--busca o ultimo sequencial da tamporada
			select isnull(max(e.sequencial),0)+1 
			from episodio e
			inner join temporada t on t.IdTemporada= e.TemporadaId and t.sequencial=1   
			inner join serie s on s.IdSerie=t.SerieId and  s.nome='Avatar: A Lenda de Aang'
		)
   ); 

  
--incrementa um episodio na temporada da serie
	INSERT episodio  
   (nome, sinopse, TemporadaId ,sequencial)  
VALUES  
   (
	   'O Templo de Ar do Sul',
	   'O grupo visita a casa de Aang, o Templo de Ar do Sul. Mas n�o tem ningu�m l�. Descobrem que a Na��o do Fogo exterminou todos os dominadores de ar, pois sabiam que o pr�ximo Avatar nasceria entre eles. Aang entre no Estado Avatar pela segunda vez ao ver o esqueleto de seu antigo treinador Monge Gyatso, assim revelando �s tr�s Na��es que o Avatar retornou. Enquanto isso Zuko e Iroh param seu navio num porto, para concert�-lo, mas encontram-se com o desprez�vel Comandante Zhao, que provoca Zuko quando descobre que ele perdeu o Avatar. Eles duelam e Zuko ganha. Ao tentar atac�-lo por tr�s, Iroh salva Zuko de Zhao e o chama de desonrado por agir assim na derrota.'  ,
	   ( 
	   --busca o id da temporada
	   select t.IdTemporada from temporada t
	   inner join serie s on s.IdSerie= t.SerieId and sequencial=1 and s.nome='Avatar: A Lenda de Aang' 
	   ),
	   ( 
			--busca o ultimo sequencial da tamporada
			select isnull(max(e.sequencial),0)+1 
			from episodio e
			inner join temporada t on t.IdTemporada= e.TemporadaId and t.sequencial=1   
			inner join serie s on s.IdSerie=t.SerieId and  s.nome='Avatar: A Lenda de Aang'
		)
   ); 


   

    