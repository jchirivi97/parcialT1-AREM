package edu.escuelaing.arem.app;

import edu.escuelaing.arem.app.MergeSort;  
import static spark.Spark.get;
import static spark.Spark.port;

import spark.Request;
import spark.Response;

public class SparkPrincipal {	
	
	
	public void main (String arg[]) {
		port(getPort());
		get("/principal", (req, res) -> PrincipalPage(req, res));
	}

	private String PrincipalPage(Request req, Response res) {
			String pagina
		        = "<!DOCTYPE html>"
		        + "<html>"
		        + "<body>"
		        + "<h2>ORDENADOR Y ADICION DE NUMEROS</h2>"
		        + "<form action=\"/results\">"
		        + "  Inserte los numeros que desee ordenar o sumar:<br>"
		        + "  <input type=\"text\" name=\"numero\">"
		        + "  </br>"
		        + "  <br></br>"
		        + "  <input type=\"submit\" value=\"Calcular\">"
		        + "</form>"
		        + "</body>"
		        + "</html>";
			return pagina;
	}
	
	
	/*private String MergePage(Request req,Response res) {
		
		String [] datos =  req.queryParams("numero").split(",");
		int [] numeros = null;
		for (int i=0; i < datos.length;i++ ) {
			numeros[i] = Integer.parseInt(datos[i]) ;
		}
		
		MergeSort ob = new MergeSort(); 
        ob.sort(numeros, 0, numeros.length-1);
		
		
		
		
		return null;
		
	}*/
	
	





	static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
       return 4176; 
    }
}
