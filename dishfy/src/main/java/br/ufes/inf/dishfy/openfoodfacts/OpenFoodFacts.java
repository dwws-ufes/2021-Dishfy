package br.ufes.inf.dishfy.openfoodfacts;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.expr.ExprNotComparableException;
import org.apache.jena.tdb.TDBFactory;

import br.ufes.inf.dishfy.domain.Ingrediente;

public class OpenFoodFacts {

    public OpenFoodFacts() {
    }
    
    public static String getResourceOpenFoodFacts(String uri, String compare){
        
        String query = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"+
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"+
                "PREFIX vocab: <http://localhost:2020/resource/vocab/>\n"+
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"+
                "PREFIX map: <http://localhost:2020/resource/#>"+
                "PREFIX db: <http://localhost:2020/resource/>\n"+
                "SELECT DISTINCT ?resource ?value\n"+"WHERE {\n"+
                "?resource <http://localhost:2020/resource/vocab/products_generic_name>"+
                "?value\n"+
                "} ORDER BY ?resource ?value";
        
        QueryExecution queryExecution = QueryExecutionFactory.sparqlService(uri, query);
        ResultSet results = queryExecution.execSelect();
        QuerySolution querySolution;
        String resource;
        String value;
        while(results.hasNext()){
        
            querySolution = results.next();
            
            resource = querySolution.get("resource").toString();
            value = querySolution.get("value").toString();
            if (value.equals(compare)){
                
                return resource;
             
            }
        
        }
         
      return null;  
    }
    public static String getPropertyNutriments(String uri, String resource){

        String query = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"+
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"+
                "PREFIX vocab: <http://localhost:2020/resource/vocab/>\n"+
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"+
                "PREFIX map: <http://localhost:2020/resource/#>"+
                "PREFIX db: <http://localhost:2020/resource/>\n"+
                "SELECT DISTINCT ?property ?hasValue ?isValueOf\n"+
                "WHERE {\n"+
                "{ <"+resource+"> ?property ?hasValue }\n"+
                "UNION\n"+
                "{ ?isValueOf ?property <"+resource+"> }\n"+
                "}\n"+
                "ORDER BY (!BOUND(?hasValue)) ?property ?hasValue ?isValueOf";
        
        QueryExecution queryExecution = QueryExecutionFactory.sparqlService(uri, query);
        ResultSet results = queryExecution.execSelect();
        if(results.hasNext()){
            QuerySolution querySolution;
            querySolution = results.next();
            querySolution = results.next();
            querySolution = results.next();
            querySolution = results.next();
            querySolution = results.next();
            return querySolution.get("hasValue").toString();   
                     
        }
        else {
            return null;

        }
        
        
    }

    public static Ingrediente getIngredienteOpenFoodFacts(String nome, String nutriments, String uri){

        String query = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"+
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"+
                "PREFIX vocab: <http://localhost:2020/resource/vocab/>\n"+
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"+
                "PREFIX map: <http://localhost:2020/resource/#>"+
                "PREFIX db: <http://localhost:2020/resource/>\n"+
                "SELECT DISTINCT ?property ?hasValue ?isValueOf\n"+
                "WHERE {\n"+
                "{ <"+nutriments+"> ?property ?hasValue }\n"+
                "UNION\n"+
                "{ ?isValueOf ?property <"+nutriments+"> }\n"+
                "}\n"+
                "ORDER BY (!BOUND(?hasValue)) ?property ?hasValue ?isValueOf";
        
        QueryExecution queryExecution = QueryExecutionFactory.sparqlService(uri, query); 
        ResultSet results = queryExecution.execSelect();
        QuerySolution querySolution;
        //String resource;
       // String value;
        
       if(results.hasNext()){
           
            querySolution = results.next();
            querySolution = results.next();
            
            String grandeza = querySolution.get("hasValue").toString();
            querySolution = results.next();
            
            String teste = querySolution.get("hasValue").toString();
            String rcv = teste.substring(0,teste.indexOf("^"));
            double caloria = Double.parseDouble(rcv);
            
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNome(nome);
            ingrediente.setCalorias(caloria);
            ingrediente.setGrandeza(grandeza);

            return ingrediente;

       }else{
           return null;
       } 
    }

    public static Ingrediente getIngredienteAPI(String nome, String uri){

        String param = getResourceOpenFoodFacts(uri,nome);

        if (param!=null){

            String param2 = getPropertyNutriments(uri, param);

            if(param!=null){

                return getIngredienteOpenFoodFacts(nome,param2,uri);

            }

        }
        
        return null;
        
        
    }
}
