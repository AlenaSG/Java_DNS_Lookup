# Java_DNS_Lookup
In this assignment, we are building a Java application that investigates a website and displays information about the network services involved in accessing it.
The goal is to connect concepts from class such as DNS, IP addresses, HTTP, HTTPS, and TLS to a real-world application.

### Compile and run directly
```bash
javac NetworkInspector.java
java NetworkInspector <hostname>

### Sample Run
java NetworkInspector microsoft.com

Hostname:
microsoft.com

Resolved Addresses:
13.107.246.38
13.107.213.38

HTTPS Connection Successful

Status Code:
200

TLS Version:
TLSv1.3

Response Size:
197524 bytes
