# IBM-Challenge-One
Repositório com o código fonte do desafio 1 


Neste desafio usei as seguintes versões : 

Versão spring boot - 2.3.4
Java 8

Importante resaltar que configurei a porta para 8081, pois é menos provavel de estarem utilizando no momento do teste, ja que por padrão vem definido a 8080. 

Criei 2 testes unitarios para facilitar o entendimento do negocio e manter a qualidade da entrega, os mesmos foram criados principalemte pensando na parte de consumir o json disposto. Para fazer isso utilizei do RestTemplate. Adicionei uma anootation para deixar a porta randomica para os testes, assim evitando algum possivel problema. 

Para ter acesso aos titles , basta apontar no browser ou em alguma ferramenta (postman por exemplo) os seguintes links depois que a aplicação ja estiver no ar : 

http://localhost:8081/movies/{titulo}
desta forma trazendo de forma ordenada todos os titulos dispostos com o nome buscado. 


http://localhost:8081/movies/{titulo}/{page} 
desta forma selecionando e trazendo de forma ordenada apenas os titulos com o nome buscado e pagina selecionada. 


Desafios encontrados : 
- No momento de validar o json, notei que o mesmo ao selecionar so o Titulo ele traz as informações somente da pagina 1 e não do conteudo todo. 
- Ao selecionar paginas negativas ou de valor "0" o retorno continuava sendo da primeira pagina. 
- Na parte do RestTemplate, não estava conseguindo buscar o array interno do json, mesmo adicionando um Model com os mesmos nomes de campos ... até que encontrei a soluçao atraves das annotations (@JsonProperty por exemplo).

Criei um tratamento de erro simples , para validar a parte de PageNotFoundException. 






