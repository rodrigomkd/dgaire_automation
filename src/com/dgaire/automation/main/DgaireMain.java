package com.dgaire.automation.main;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DgaireMain {
	private static final String DRIVER_PATH = "";
	private static final String KEY = "";
	private static final String PASSWORD = "";
	
	private WebDriver driver;
	
	public void setUp() throws InterruptedException {
		System.out.println(System.getProperty("user.dir"));
		
        System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + DRIVER_PATH);
        driver = new OperaDriver();
        
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        //open url
        driver.navigate().to("http://dgaire.jalisco.gob.mx/scejal/");
        driver.switchTo().frame("index");
        driver.findElement(By.xpath("//*[@id=\"escuelasInfo\"]")).click();
        
        //set credentials
        driver.findElement(By.xpath("//*[@id=\"txtUser\"]")).sendKeys(KEY);
        driver.findElement(By.xpath("//*[@id=\"txtPass\"]")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//*[@id=\"btnIngresar\"]")).click();
        
        //close modal
        driver.findElement(By.xpath("//*[@id=\"btnCancelar\"]")).click();
      
        //navigate to alumnos
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/html/div/div[2]/div/div[1]/div[3]/a")).click();      
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/html/div/div[2]/div/div[2]/div[2]/a")).click(); 
        driver.findElement(By.xpath("//*[@id=\"btnBuscar\"]")).click(); 
        
        //for each to 10, set page 1
        int i = 2; 
        while(i <= 12) {
        	//switch tab
        	//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/a[3]")).click();
        	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/a[1]")).click();
	
        	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div["+i+"]/div[8]/div[1]/a")).click();
        	driver.findElement(By.xpath("//*[@id=\"mat_A00\"]")).sendKeys("");
        	driver.findElement(By.xpath("//*[@id=\"mat_A00\"]")).sendKeys(getLanguage());
        	driver.findElement(By.xpath("//*[@id=\"mat_A01\"]")).sendKeys(getMath());
        	driver.findElement(By.xpath("//*[@id=\"mat_A02\"]")).sendKeys(getExploration());
        	
        	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[2]/ul/li[2]/a")).click();
        	driver.findElement(By.xpath("//*[@id=\"mat_A03\"]")).sendKeys(getArt());
        	driver.findElement(By.xpath("//*[@id=\"mat_A04\"]")).sendKeys(getEducation());
        	driver.findElement(By.xpath("//*[@id=\"mat_A05\"]")).sendKeys(getPhysical());
        	
        	driver.findElement(By.xpath("//*[@id=\"btnBuscar\"]")).click();
        	//close alert
        	Thread.sleep(1000);
        	driver.switchTo().alert().accept();
        	driver.findElement(By.xpath("//*[@id=\"btnVolver\"]")).click();
        	i++;     	
        }
        
        driver.close();
    }
	
	private String getLanguage() {
		int random = new Random().nextInt(8);
		while(random == 0) {
			random = new Random().nextInt(8);
		}
		switch(random) {
		case 1: return "Escucha, memoriza y compartes canciones infantiles. Identifica las vocales, consonantes y la formación de silabas y los colores.";
		case 2: return "Identifica las vocales y colores. Las palabras las identifica así como la formación de la silaba, intenta plasmar la idea.";
		case 3: return "Identifica, nombra y escribe de forma correcta los colores,  las vocales, las consonantes y la formación de silabas, en el trazo no es muy preciso.";
		case 4: return "Reconoce las vocales, consonantes, la formación de silabas.";
		case 5: return "Identifica bien las vocales, consonantes, las silabas. Reconoce los colores, y su trazo es moderado.";
		case 6: return "Escucha, memoriza y comparte canciones adivinanzas. Identifica las vocales, las consonantes, y la formación de silabas, los colores. Comienza a escribir su nombre.";
		case 7: return "Escucha, memoriza y compartes canciones infantiles. Identifica las vocales, consonantes y la formación de silabas y los colores. Comienza a escribir su nombre de forma correcta.";
		case 8: return "Escucha, memoriza y compartes canciones infantiles. Identifica las vocales, consonantes y la formación de silabas y los colores. Nombra, usa y escribe  su nombre de forma correcta.";
		}
		
		throw new IllegalArgumentException("No found language for random() " + random);
	}
	
	private String getMath() {
		int random = new Random().nextInt(8);
		while(random == 0) {
			random = new Random().nextInt(8);
		}
		switch(random) {
		case 1: return "Identifica de forma correcta las figuras geométricas, los números los nombra  del 1-15 de forma ascendente, los tamaños de objetos observa bien sus características.";
		case 2: return "Identifica las figuras geométricas, espacio y tiempo, nombra y escribe forma correcta los números del 1-15, así como reconoce bien los tamaños de objetos y sus características.";
		case 3: return "Identifica las figuras geométricas, los números los nombra  del 1-15 de forma ascendente, los tamaños de objetos observa bien sus características.";
		case 4: return "Identifica de forma correcta las figuras geométricas, los números los nombra  del 1-15 de forma ascendente, los tamaños de objetos observa bien sus características.";
		case 5: return "Comunica posiciones y desplazamientos de objetos y personas utilizando términos como dentro, fuera, arriba, abajo, encima, cerca, lejos, adelante, etc.";
		case 6: return "Identifica, usa y nombra los números que sabe, en orden ascendente, empezando por el 1-15. Comunica posiciones y desplazamiento de objetos. Reconoce las figuras geométricas.";
		case 7: return "Identifica y nombra los números que sabe. Reconoce las figuras geométricas.";
		case 8: return "Identifica los números del  1-15. Comunica posiciones y desplazamientos de objetos y personas utilizando términos como dentro, fuera, arriba, abajo, encima, cerca, lejos, adelante.";
		}
		
		throw new IllegalArgumentException("No found Math for random() " + random);
	}
	
	private String getExploration() {
		int random = new Random().nextInt(8);
		while(random == 0) {
			random = new Random().nextInt(8);
		}
		switch(random) {
		case 1: return "Comienza a identificar aquellas cosas actividades de higiene que él hace diariamente, así como los alimentos sanos como lo es la carne, frutas y verduras.";
		case 2: return "Identifica materiales que son peligrosos para su integridad, características de los insectos, el estado de tiempo en el cual se encuentra y el que le es más agradable.";
		case 3: return "Comienza a identificar aquellas actividades de higiene que él hace diariamente, así como los alimentos que son sanos.";
		case 4: return "Pregunta para saber más y escucha con atención a quien le informa. Indaga sobre su historia personal y familiar. Identifica los alimentos sanos.";
		case 5: return "Identifica los alimentos sanos como lo es la carne, frutas, verduras y cereales, sobre su higiene personal, la conformación y características de los insectos.";
		case 6: return "Identifica los alimentos sanos como lo es la carne, frutas, verduras y cereales. Pregunta para saber más y escucha con atención a quien le informa.";
		case 7: return "Identifica la conformación y características de los insectos.";
		case 8: return "Pregunta para saber más y escucha con atención a quien le informa. Indaga sobre su historia personal y familiar.";
		}
		
		throw new IllegalArgumentException("Not found Exploration for random() " + random);
	}
	
	private String getArt() {
		int random = new Random().nextInt(8);
		while(random == 0) {
			random = new Random().nextInt(8);
		}
		switch(random) {
		case 1: return "Reconoce con exactitud las emociones básicas como: alegría, miedo, tristeza, enojo y sorpresa.";
		case 2: return "Experimenta con materiales, herramientas y técnicas de las expresiones plásticas. Le gusta cantar y expresar sus emociones a través del canto.";
		case 3: return "Reconoce, nombra y plasma las emociones básicas como: alegría, miedo, tristeza, enojo y sorpresa.";
		case 4: return "Experimenta con materiales, herramientas y técnicas de las expresiones plásticas. Le gusta cantar y expresar sus emociones a través del canto.";
		case 5: return "Identifica  las emociones básicas como: alegría, miedo, tristeza, enojo y sorpresa.";
		case 6: return "Experimenta con materiales, herramientas y técnicas de las expresiones plásticas";
		case 7: return "Escucha, canta canciones y participa en juegos y rondas, reconoce las emociones básicas.";
		case 8: return "Experimenta con materiales, herramientas y técnicas de la expresión plástica, como acuarelas, pintura dactilar.";
		}
		
		throw new IllegalArgumentException("Not found Art for random() " + random);
	}
	
	private String getEducation() {
		int random = new Random().nextInt(8);
		while(random == 0) {
			random = new Random().nextInt(8);
		}
		switch(random) {
		case 1: return "Reconoce e identifica  con exactitud las emociones básicas ya mencionada, y las expresa de forma clara.";
		case 2: return "Identifica muy bien a los que conforman su familia y principalmente se reconoce él mismo.";
		case 3: return "Se reconoce a si mismo con todas sus características personales.";
		case 4: return "Reconoce las emociones básicas, las expresa de forma clara, identifica muy bien a los que conforman su familia y su perfecto auto reconocimiento.";
		case 5: return "Identifica muy bien a los que conforman su familia y principalmente se reconoce él mismo.";
		case 6: return "Habla de cómo es ella, de lo que le gusta y/o disgusta. Identifica bien las emociones básicas y los integrantes de su familia.";
		case 7: return "Identifica las emociones básicas, habla de cómo es ella, de lo que le gusta y le disgusta.";
		case 8: return "Muestra interés al realizar las actividades, identifica los integrantes de su familia.";
		}
		
		throw new IllegalArgumentException("Not found Education for random() " + random);
	}
	
	private String getPhysical() {
		int random = new Random().nextInt(8);
		while(random == 0) {
			random = new Random().nextInt(8);
		}
		switch(random) {
		case 1: return "Muestra dificultad a actividades que impliquen ubicación espacial, en proceso de relacionar la proximidad con la lejanía de los objetos respecto a él como a sus compañeros.";
		case 2: return "Logra responder a actividades que implican ubicación espacial, muestra proceso de relacionar la proximidad con la lejanía de los objetos respecto a el como a sus compañeros al practicar.";
		case 3: return "En proceso de responder por consignas sencillas que impliquen la orientación espacial.";
		case 4: return "Identifica la proximidad y la lejanía de los objetos al practicar.";
		case 5: return "Su nivel se encuentra en dominio sobresaliente en los aprendizajes esperados.";
		case 6: return "Tiene destreza al utilizar objetos como lápices, crayolas y pinceles, con facilidad coordina sus movimientos al usar las tijeras.";
		case 7: return "Logra responder a actividades que implican ubicación espacial.";
		case 8: return "Logra practicar medidas de prevención para su persona, evitando chocar entre compañeros, reconoce los riesgos que implican el no tener cuidado.";
		}
		
		throw new IllegalArgumentException("Not found Physical for random() " + random);
	}
	
	public static void main(String [] mkd) {
		DgaireMain main = new DgaireMain();
		try {
			main.setUp();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
