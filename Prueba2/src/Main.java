import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena="char a='v',v=92,g";
		System.out.println(cadena);
		String funcion="(\\s*\\s*[a-zA-Z][\\w]*\\s*)|(\\s*[a-zA-Z][\\w]*\\s*$)|(\\s*[a-z][A-Z]*\\s*=)|(,\\s*[a-zA-Z][\\w]*\\s*(,|=))|(=\\s*[a-zA-Z][\\w]*\\s*,)";
        Pattern limpiar = Pattern.compile(funcion);
        Matcher buscar = limpiar.matcher(cadena);
        while(buscar.find()){
        	System.out.println(buscar.group());
        }
	}

}
