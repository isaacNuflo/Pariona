import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

public class Main {
	static ArrayList<String> lineas;
	static ArrayList<String> vInt;
	ArrayList<String> vChar;
	static ArrayList<String> vFloat;
	ArrayList<String> vBool;
	ArrayList<String> funciones;
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		lineas=new ArrayList<String>();
		vInt=new ArrayList<String>();
		vFloat=new ArrayList<String>();
        //String cadena=leedorTexto();
		String cadena="";
        String funcion="(int|float|char|bool)\\s+[a-zA-Z][\\w]*\\s*(((\\())|((=\\s*'?\\w+'?[\\.]?(\\d+)?)?\\s*(,|=))|(\\s*,?\\s*[a-zA-z][\\w]*\\s*))*";
        Pattern limpiar = Pattern.compile(funcion);
        Matcher buscar = limpiar.matcher(cadena);
        while(buscar.find()){
        	System.out.println(buscar.group());
        	lineas.add(buscar.group());
        }
        for(int i=0;i<lineas.size();i++){
        	asignarTipo(lineas.get(i));
        }
	}
	private static void asignarTipo(String linea) {
		// TODO Auto-generated method stub
		StringTokenizer token=new StringTokenizer(linea);
		String tipo=token.nextToken();
		if(tipo.equals("int")){
			separacionN(linea,vInt);
		}
		else if(tipo.equals("float")){
			separacionN(linea,vFloat);
		}
	}
	private static void separacionN(String linea,ArrayList vars) {
		// TODO Auto-generated method stub
		ArrayList<String> variables;
		variables=separacion(linea);
		StringBuilder var;
		for(int i=0;i<variables.size();i++){
			var=new StringBuilder();
			for(int j=0;j<variables.get(i).length();){
				if(variables.get(i).charAt(j)==' '||variables.get(i).charAt(j)==','||variables.get(i).charAt(j)=='='){
					j++;
				}
				else{
					var.append(variables.get(i).charAt(j));
					j++;
				}
			}
			System.out.println(var);
			vars.add(new String(var));
		}
	}
	private static ArrayList<String> separacion(String linea) {
		// TODO Auto-generated method stub
		ArrayList<String> lineas=new ArrayList<String>();
		String funcion="(\\s*\\s*[a-zA-Z][\\w]*\\s*)|(\\s*[a-zA-Z][\\w]*\\s*$)|(\\s*[a-z][A-Z]*\\s*=)|(,\\s*[a-zA-Z][\\w]*\\s*(,|=))|(=\\s*[a-zA-Z][\\w]*\\s*,)";
        Pattern limpiar = Pattern.compile(funcion);
        Matcher buscar = limpiar.matcher(linea);
        while(buscar.find()){
        	lineas.add(buscar.group());
        }
		return lineas;
	}
	public static String leedorTexto() {
		String cadena="";
        JFileChooser selectorDeArchivo = new JFileChooser();
        selectorDeArchivo.showOpenDialog(selectorDeArchivo);

        try {
            String rutaDeArchivo = selectorDeArchivo.getSelectedFile().getAbsolutePath();
            /* Buscar ruta del archivo */
            FileInputStream entradaDeArchivo = new FileInputStream(rutaDeArchivo);
            /* Objeto de entrada a leer */
            DataInputStream leedorDeTexto = new DataInputStream(entradaDeArchivo);
            /* Buffer de lectura */

            BufferedReader buffer = new BufferedReader(new InputStreamReader(leedorDeTexto));

            String texto = "";

            while ((texto = buffer.readLine()) != null) {
                /* Asigna y compara */
                cadena += texto + "\n";
                /* Cargamos texto asignado */
            }
            leedorDeTexto.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return limpiarEspacios(cadena);
    }
	private static String limpiarEspacios(String cadena) {
		// TODO Auto-generated method stub
		StringBuilder stb=new StringBuilder();
		for(int i=0;i<cadena.length();i++){
			if(cadena.charAt(i)=='\n'){
				stb.append("");
			}
			else stb.append(cadena.charAt(i));
		}
		cadena=new String(stb);
		return cadena;
	}

}
