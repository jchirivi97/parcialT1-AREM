package edu.escuelaing.arem.app;


import edu.escuelaing.arem.app.MergeSort; 
import static spark.Spark.get;
import static spark.Spark.port;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class SparkPrin {

	 public static void main(String[] args) {
	        port(getPort());
	        get("/inputdata", (req, res) -> inputDataPage(req, res));
	        get("/results", (req, res) -> mergePage(req,res));
	    }

	   

		private static String inputDataPage(Request req, Response res) {
	    	String pagina
		        = "<!DOCTYPE html>"
		        + "<html>"
		        + "<body>"
		        + "<h2>ORDENADOR Y ADICION DE NUMEROS</h2>"
		        + "<form action=\"/results\" >"
		        + "  Inserte los numeros que desee ordenar:<br>"
		        + "  <input type=\"text\" name=\"numero\">"
		        + "  </br>"
		        + "  <br></br>"
		        + "  <input type=\"submit\" value=\"Ordernar\">"
		        + "	 </form>"
		        + "  <br></br>"
		        + "  <br></br>"
		        + "</body>"
		        + "</html>";
	    	return pagina;
	    }

	    private static String mergePage(Request req, Response res) {
	    	String [] datos = req.queryParams("numero").split(",") ;
			int [] numeros = new int[datos.length];
			String respt = ""; 
			
			String sum ;
			int temp = 0;
			for(int i = 0; i < datos.length; i++) {
				 numeros[i] = Integer.parseInt(datos[i]);
			}	
			
			for(int i = 0; i < numeros.length;i++) {
				temp += numeros[i];
			}
			
			numeros = MergeSort.printArray(numeros);
			
			for (int i=0; i < numeros.length;i++) {
				if(i==0) {respt = respt + numeros[i];}
				else {respt = respt +" , "+ numeros[i]; }
			}
			
			sum = String.valueOf(temp);
	        
	        String respuesta = 
	        		"<!DOCTYPE html>"
	                + "<html>"
	                + "<body>"
	                + "<h2>NUMEROS ORDENADOS</h2>"
	                + "<p>" + respt + "</p>"
	                + "<h2>SUMA DE NUMEROS</h2>"
	                + "<p>" + sum + "</p>"
	                + "</body>"
	                + "</html>";
			
			return respuesta;
	    }
	    
	   
	    

	    /**
	     * This method reads the default port as specified by the PORT variable in
	     * the environment.
	     *
	     * Heroku provides the port automatically so you need this to run the
	     * project on Heroku.
	     */
	    static int getPort() {
	        if (System.getenv("PORT") != null) {
	            return Integer.parseInt(System.getenv("PORT"));
	        }
	        return 36000;
	    }

}
