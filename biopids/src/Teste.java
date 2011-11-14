import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Teste{

	public static void main(String[] args) {


		// Define o CEP
		String cep = JOptionPane.showInputDialog(null,"Informe o CEP");
		
		// String da url		
		String urlString = "http://www.buscarcep.com.br/index.php";

		// Parametros a serem enviados
		Properties parameters = new Properties();
		parameters.setProperty("cep", cep);
		parameters.setProperty("formato", "xml");

		// Iterador
		Iterator i = parameters.keySet().iterator();
		// Contador
		int counter = 0;

		// Enquanto ainda existir parametros
		while (i.hasNext()) {

			// Nome
			String name = (String) i.next();
			// Valor
			String value = parameters.getProperty(name);

			// Adiciona com um conector (? ou &)
			// Separa a url por ?, e as vari�veis com &
			urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;
			
		}

		try {
			// Objeto URL
			URL url = new URL(urlString);

			// Objeto HttpURLConnection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// M�todo
			connection.setRequestProperty("Request-Method", "GET");

			// V�ariavel do resultado
			connection.setDoInput(true);
			connection.setDoOutput(false);

			// Faz a conex�o
			connection.connect();

			// Abre a conex�o
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// L� a conex�o
			StringBuffer newData = new StringBuffer();
			String s = "";
			while (null != ((s = br.readLine()))) {
				newData.append(s);
			}
			br.close();

                        String comHtml = new String(newData);
                        Pattern p = Pattern.compile("<.*?>");
                        Matcher m = p.matcher(comHtml);
                        String semHtml = m.replaceAll(" ");
                        String endereco[] = semHtml.split("  ");
                        try {
                        System.out.println(endereco[1]);
                        }
                         catch(Exception e){
                        
                        }
                        try{
                        System.out.println(endereco[2]);
                        }
                         catch(Exception e){
                             
                        
                         }
                         try{
                        System.out.println(endereco[3]);
                         }
                         catch(Exception e){
                        }
                          try{
                        System.out.println(endereco[4]);
                          } 
                        catch(Exception e){
                        }
                          try{
                         System.out.println(endereco[5]);
                          }
                         catch(Exception e){
                        }
                          try{
                        System.out.println(endereco[6]);
                        String end ="CEP: " +endereco[1]+"\nEstado: "+endereco[2]+"\nCidade: "+endereco[3]+"\nBairro: "+endereco[4]+"\nLogradouro: "+endereco[5]+" "+endereco[6];
                        JOptionPane.showMessageDialog(null,end);
                          } 
                        catch(Exception e){
                            JOptionPane.showMessageDialog(null,"CEP n�o consta no banco de dados");
                        }


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
