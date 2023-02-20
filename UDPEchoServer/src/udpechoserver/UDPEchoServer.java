/**
 *
 * @author giova
 */
package udpechoserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

    private static final int ECHOMAX = 25;

    public static void main(String[] args) throws IOException {
//        if (args.length != 1) {
//            throw new IllegalArgumentException("Paramater(s)<Port>");
//        }
//        int servPort = Integer.parseInt(args[0]);

        byte[] archivo = leerArchivoTexto("C:\\Users\\giova\\Desktop\\Prueba.txt");
        System.out.println(archivo.length);

//        int servPort = 80;
//        DatagramSocket socket = new DatagramSocket(servPort);
//        DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
//        while(true){
//            socket.receive(packet);
//            System.out.println("Handling client at "+packet.getAddress().getHostAddress()
//            +"on port"+packet.getPort());
//            System.out.println(new String(packet.getData()));
//            socket.send(packet);
//            packet.setLength(ECHOMAX);
//            
//        }
    }

    public static byte[] leerArchivoTexto(String ruta) {
        // TODO code application logic here
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            while (true) {
                if (br.readLine() == null) {
                    break;
                }
                linea += br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return linea.getBytes();
    }
}
