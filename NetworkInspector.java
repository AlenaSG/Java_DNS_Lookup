import java.net.*; //InetAddress, UnknownHostException, URI
import java.net.http.*; //HttpClient, HttpRequest, HttpResponse

public class NetworkInspector {
    public static void main(String[] args) {
      //ensure a correct command
        if (args.length < 1) {
            System.out.println("Run with arguments: java NetworkInspector <hostname>");
            return;
        }
        //receive user input from the command-line argument
        String hostname = args[0];

        //performing DNS lookup
        try{
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            //printing hostname and looping through resolved IP addresses
            System.out.println("Hostname:\n"+ hostname + "\n");
            System.out.println("Resolved Addresses:");
            for(InetAddress addr : addresses){
                System.out.println(addr.getHostAddress());
            }
            //empty line for output separation
            System.out.println();
            
            //build HttpClient (with redirects) 
            HttpClient clnt = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
             //build HttpRequest for https://<hostname>
             HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://" + hostname))
                 .GET()
                .build();
            
            //send request and capture HttpResponse<byte[]>
            HttpResponse<byte[]> resp = clnt.send(req, HttpResponse.BodyHandlers.ofByteArray());

            //extract status code, TLS version, and response size in bytes
            int statusCode = resp.statusCode();
            String tlsVersion = resp.sslSession().get().getProtocol();
            int responseSize = resp.body().length;

            //print status code, TLS version, and response size in bytes
            System.out.println("HTTPS Connection Successful\n");
            System.out.println("Status Code:\n" + statusCode + "\n");
            System.out.println("TLS Version:\n" + tlsVersion + "\n");
            System.out.println("Response Size:\n" + responseSize + " bytes");

        } catch (UnknownHostException e){
            System.err.println("Error: Could not resolve " + hostname);
        }catch (Exception e) {
            System.err.println("Error connecting to " + hostname + " - " + e.getMessage());
        }

    }
}
