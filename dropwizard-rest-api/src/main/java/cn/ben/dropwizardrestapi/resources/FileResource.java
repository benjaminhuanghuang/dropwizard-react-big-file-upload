package cn.ben.dropwizardrestapi.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

//import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataParam;


@Path("/file")
@Produces(MediaType.APPLICATION_JSON)
public class FileResource {
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public Response upload(@FormDataParam("file") InputStream fileInputStream,
//                                  @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception {
//        String UPLOAD_PATH = "./ben-temp/";
//        String uploadedFileLocation = UPLOAD_PATH + fileMetaData.getFileName();
//
//        // save it
//        writeToFile(fileInputStream, uploadedFileLocation);
//
//        return Response.ok("Data uploaded successfully !!").build();
//    }
    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
                             String uploadedFileLocation) {

        try {
            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @GET
    public Response hello() {
        return Response.ok("Hello Dropwizard!").build();
    }
}
