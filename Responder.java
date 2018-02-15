import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random aleatorio;
    ArrayList<String> responses;
    HashMap<String, String> responsesAboutInput;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        responses = new ArrayList <>();
        responsesAboutInput = new HashMap<>();

        responses.add("¿Cual es la media de ingenieria?");
        responses.add("¿A que edad se va uno de casa?");
        responses.add("¡Que sed tengo!");
        responses.add("El Madrid ganó la liga pasada");
        responses.add("¡Que ganas de programar!");

        responsesAboutInput.put("linux", "Our software is not designed to run on Linux");
        responsesAboutInput.put("free","In the future we want to offer our software for free");
        responsesAboutInput.put("windows","Our software runs perfectly on Windows");
        responsesAboutInput.put("crash","Our software has a known bug, we are working on it");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String response = null;
        Iterator <String> iterator = userInput.iterator();
        boolean searching = true;
        while(iterator.hasNext() && searching){
            response = responsesAboutInput.get(iterator.next());            
            if(response != null){
                searching = false;
            }
        }
        
        if(response == null){
                response = responses.get(aleatorio.nextInt(responses.size()));
            }
        return response;
    }
}
