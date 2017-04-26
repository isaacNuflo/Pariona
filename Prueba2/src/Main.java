import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena="float floats, d=.3,   e=z12";
		String funcion="(\\s*\\s*[a-zA-Z][\\w]*\\s*)|(\\s*[a-zA-Z][\\w]*\\s*$)|(\\s*[a-z][A-Z]*\\s*=)|(,\\s*[a-zA-Z][\\w]*\\s*(,|=))|(=\\s*[a-zA-Z][\\w]*\\s*,)";
        Pattern limpiar = Pattern.compile(funcion);
        Matcher buscar = limpiar.matcher(cadena);
        while(buscar.find()){
        	System.out.println(buscar.group());
        }
	}

}
