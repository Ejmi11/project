# Sample Project using Qaurks framework
task: Show my IP

tools used to code and run the project

Openjdk version "14.0.2" 2020-07-14
OpenJDK Runtime Environment (build 14.0.2+12-46)
Apache Maven 3.6.3 
Jetbrains Intellij

I started by creating a sample Quarks project using Maven:

mvn io.quarkus:quarkus-maven-plugin:1.8.0.CR1:create "-DprojectGroupId=at.tug" "-DprojectArtifactId=show-ip" "-DclassName=at.tug.ipshow.Resource" "-Dpath=/show_my_ip"

than I opened the project in intellij
edited the Resource class Resource.java
added annotation @Context, to inject an 
object instance related to the context of HTTP requests.

    @Context
    HttpServerRequest request; //used to get the remote Address

    and 

    @Context
    UriInfo info; // to get the called path

   
Than after each path call the remote adress will be returned
    
    final String address = request.remoteAddress().toString();

    //output example {“ip”: “127.0.0.1”}
    return "{" + "\"ip" + "\""+":"+ " " + "\"" + address.split(":")[0] + "\"" + "}" + "\n";

to run the application:  mvn quarkus:dev
