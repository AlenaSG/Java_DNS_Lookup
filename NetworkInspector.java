import java.net.InetAddress;
import java.net.UnknownHostException;

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
            
        // TODO:build HttpClient (with redirects) and HttpRequest for https://<hostname>
        //send request and capture HttpResponse(bytes[])

        // TODO: extract and print status code, TLS protocol from sslSession(), and response body length in bytes
        } catch (UnknownHostException e){
            System.err.println("Error: Could not resolve " + hostname);
        }

    }
}
