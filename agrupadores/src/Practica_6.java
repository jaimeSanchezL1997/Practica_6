
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Practica_6 {

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner tecl = new Scanner(System.in);
        String cad,cadaux;
        System.out.println("porfavor escribe los agrupadores");
        cadaux = tecl.nextLine();
        cad = cadaux.toUpperCase();
        Practica_6 c = new Practica_6();
        c.guardar("guardado",cad);
        c.muestraContenido("guardado");
        c.leerOperadores("guardado");
    }

    public void guardar(String NombreArchivo,String cad){
        File out = new File(NombreArchivo);
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(NombreArchivo);
        }catch (FileNotFoundException e){
            e.printStackTrace(); }
        BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        try {
            for(int x=0;x<cad.length();x++) {
                bufferedWriter.write(cad.charAt(x));
            }
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void muestraContenido(String NombreArchivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(NombreArchivo);
        BufferedReader b = new BufferedReader(f);

        while ((cadena = b.readLine()) != null) {

        }
        b.close();
    }

    public void leerOperadores(String nombreArchivo)throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader(nombreArchivo));
        StringBuilder sb = new StringBuilder();
        Boolean x;

        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        String s = sb.toString();

        Stack<Character> st=new Stack<Character>();
        for (int i=0;i<s.length();++i)
        {
            if((s.charAt(i)=='(')||(s.charAt(i)=='{')||(s.charAt(i)=='['))
            {
                st.push(s.charAt(i));
            }
            else if(st.isEmpty()==false)
            {
                switch(s.charAt(i))
                {
                    case']':
                        if(st.pop()!='[')
                        {
                            x = false;
                            System.exit(0);
                        }
                        break;
                    case'}':
                        if(st.pop()!='{')
                        {
                            x = false;
                            System.exit(0);
                        }
                        break;
                    case')':
                        if(st.pop()!='(')
                        {
                            x = false;
                            System.exit(0);
                        }
                        break;
                }
            }
        }
        if(st.isEmpty())
        {
            x = true;
        }
        else
            x = false;

        System.out.println(s + " => " + x);
    }

}
