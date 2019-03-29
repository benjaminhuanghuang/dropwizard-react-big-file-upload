package cn.ben.dropwizardrestapi.resources;

import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileUploadIT {

    @Test
    public void uploadPdfFile() {
        //
        String inputFilePath = "~/Downloads/bigfile.bin";
        byte[] inputBytes = null;
        try {
            inputBytes = Files.readAllBytes(new File(inputFilePath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:4444/file");
        //target = target.queryParam("pass", "mypass123");
        target = target.queryParam("inputFileName", "bigfile.bin");
        Invocation.Builder builder = target.request(MediaType.MULTIPART_FORM_DATA);

        Response resp = builder.put(Entity.entity(inputBytes, MediaType.MULTIPART_FORM_DATA));
        System.out.println("response = " + resp.getStatus());

    }
}