public class NetworkInspector {
    public static void main(String[] args) {
      //ensure a correct command
        if (args.length < 1) {
            System.out.println("Run with arguments: java NetworkInspector <hostname>");
            return;
        }
        //receive user imput from the command-line argument
        String hostname = args[0];

        // TODO:perform DNS lookup using InetAddress.getAllByName(hostname)
        //print hostname and loop through resolved IP addresses

        // TODO:build HttpClient (with redirects) and HttpRequest for https://<hostname>
        //send request and capture HttpResponse(bytes[])

        // TODO: extract and print status code, TLS protocol from sslSession(), and response body length in bytes
    }
}
