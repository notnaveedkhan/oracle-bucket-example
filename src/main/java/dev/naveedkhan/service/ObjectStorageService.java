package dev.naveedkhan.service;

import com.oracle.bmc.Region;
import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.auth.SimpleAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.model.CreatePreauthenticatedRequestDetails;
import com.oracle.bmc.objectstorage.requests.CreatePreauthenticatedRequestRequest;
import com.oracle.bmc.objectstorage.responses.CreatePreauthenticatedRequestResponse;

import java.io.ByteArrayInputStream;
import java.time.Instant;
import java.util.Date;

public class ObjectStorageService {

    private final ObjectStorageClient client;
    private final String bucketName;
    private final String namespaceName;

    public ObjectStorageService(String bucketName, String namespaceName, String tenantId, String userId, String fingerprint, String passPhrase, Region region) {
        this.bucketName = bucketName;
        this.namespaceName = namespaceName;
        AuthenticationDetailsProvider authenticationDetailsProvider = SimpleAuthenticationDetailsProvider.builder()
                .tenantId(tenantId)
                .userId(userId)
                .fingerprint(fingerprint)
                .privateKeySupplier(() -> new ByteArrayInputStream(passPhrase.getBytes()))
                .passPhrase(passPhrase)
                .region(region)
                .build();
        this.client = ObjectStorageClient.builder()
                .build(authenticationDetailsProvider);
    }

    public String getUploadPreSignedUrl(String objectName) {
        CreatePreauthenticatedRequestRequest request = CreatePreauthenticatedRequestRequest.builder()
                .bucketName(bucketName)
                .namespaceName(namespaceName)
                .createPreauthenticatedRequestDetails(
                        CreatePreauthenticatedRequestDetails.builder()
                                .name(objectName)
                                .objectName(objectName)
                                .accessType(CreatePreauthenticatedRequestDetails.AccessType.ObjectWrite)
                                .timeExpires(Date.from(Instant.now().plusSeconds(60 * 60)))
                                .build()
                )
                .build();
        CreatePreauthenticatedRequestResponse response = client.createPreauthenticatedRequest(request);
        return response.getPreauthenticatedRequest().getFullPath();
    }

    public String getDownloadPreSignedUrl(String objectName) {
        CreatePreauthenticatedRequestRequest request = CreatePreauthenticatedRequestRequest.builder()
                .bucketName(bucketName)
                .namespaceName(namespaceName)
                .createPreauthenticatedRequestDetails(
                        CreatePreauthenticatedRequestDetails.builder()
                                .name(objectName)
                                .objectName(objectName)
                                .accessType(CreatePreauthenticatedRequestDetails.AccessType.ObjectRead)
                                .timeExpires(Date.from(Instant.now().plusSeconds(60 * 60)))
                                .build()
                )
                .build();
        CreatePreauthenticatedRequestResponse response = client.createPreauthenticatedRequest(request);
        return response.getPreauthenticatedRequest().getFullPath();
    }

}
