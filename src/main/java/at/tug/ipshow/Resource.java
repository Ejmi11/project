package at.tug.ipshow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import io.vertx.core.http.HttpServerRequest;

@Path("/show_my_ip")
public class Resource {
    private static final Logger LOG = Logger.getLogger(Resource.class);

    @Context
    HttpServerRequest request;

    @Context
    UriInfo pathInfo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        final String path = pathInfo.getPath();
        final String address = request.remoteAddress().toString();

        LOG.infof("Requested path %s from IP %s", path, address);

        //output example {“ip”: “127.0.0.1”}
        return "{" + "\"ip" + "\""+":"+ " " + "\"" + address.split(":")[0] + "\"" + "}" + "\n";
    }
}