# selenium-test

Para executar a automação:

1) Este é um projeto maven, portanto caso não possua a aplicação faça o download no site:
	https://maven.apache.org/download.cgi

	Extraia os arquivos para o diretório de sua preferência e adicione o diretório raiz ao path do sistema operacional.
	
	Ex: "C:\Users\<User>\apache-maven-3.6.1"
	
2) Aqui existem duas formas de carregar os arquivos no seu sistema :

	2.1) Clonar o repo via git, executar:
	
	  	git clone https://github.com/mcoradini/selenium-test.git
		
	2.2) Ou faça o download do arquivo .zip e extraia o seu conteúdo em um diretório.
	
3) Importe o projeto na sua IDE. No eclipse:

	3.1) Acesse o menu "File -> Import...".
  
	3.2) Na janela Import, selecione "Maven -> Existing Maven Projects" e clique <Next>.
  
	3.3) Em "Root Directory" selecione o diretório no qual o clone foi realizado no passo 2.
  
	3.4) No campo "Projets" deve aparecer o arquivo pom do projeto. Marque o checkbox.
  
	3.5) Marque o checkbox "Add project(s) to working set" e em seguida clique em <Finish>.
	
	Aguarde o processo de importação ser finalizado.

4) Ajustar local onde esta seu executável chromedriver:

	4.1) Modificar no arquivo src/test/java/test/SeleniumTestStart.java
				Linha 15 - Alterar o diretório para o local onde esta o programa "chromedriver.exe" no seu computador.
	
5) Para executar o teste:

	5.1) Botão direito no arquivo src/test/java/test/StoreTest.java
	
	5.2) No menu de contexto, selecionar "Run As -> JUnit Test"
