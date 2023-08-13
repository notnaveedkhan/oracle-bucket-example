package dev.naveedkhan;

import com.oracle.bmc.Region;
import dev.naveedkhan.service.ObjectStorageService;

import java.io.IOException;

public class Application {

    private static final String TENANT_ID = "YOUR TENANT ID";
    private static final String USER_ID = "YOUR USER ID";
    private static final String FINGERPRINT = "YOUR FINGERPRINT";
    private static final String BUCKET_NAME = "YOUR BUCKET NAME";
    private static final String NAMESPACE_NAME = "YOUR BUCKET'S NAMESPACE NAME";
    private static final String PASS_PHRASE = """
            YOUR PASS PHRASE/PRIVATE KEY""";


    public static void main(String[] args) throws IOException {
        ObjectStorageService objectStorageService = new ObjectStorageService(BUCKET_NAME, NAMESPACE_NAME, TENANT_ID,
                USER_ID, FINGERPRINT, PASS_PHRASE, Region.ME_DUBAI_1);

        final String objectName = "YOUR OBJECT NAME";
        System.out.println(objectStorageService.getUploadPreSignedUrl(objectName));
        System.out.println(objectStorageService.getDownloadPreSignedUrl(objectName));
    }

}