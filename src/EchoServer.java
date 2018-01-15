import java.net.*;
import java.io.*;
 
public class EchoServer {
    public static final String hostName = "192.168.0.99";
    public static final int portNumber = 1030;
    public static void main(String[] args) throws IOException {
        try (
            ServerSocket serverSocket =new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept(); 
            PrintWriter out =new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while (true) {
            	if(in.ready())
            	{
            		inputLine=in.readLine();
            		out.println(inputLine);
            	}
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "+ portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}