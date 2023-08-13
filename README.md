# Oracle Cloud Object Storage Setup Guide

This guide provides step-by-step instructions on how to set up and access Oracle Cloud Object Storage using Oracle Cloud SDK.

## Step 1: Set Up API Key for Access

To access Oracle Object Storage using the Oracle Cloud SDK, you need to set up an API key. Follow these steps:

1. Log in to your Oracle Cloud account.

2. Click on your profile icon and select "API Keys."

![image](https://github.com/notnaveedkhan/oracle-bucket-example/assets/62374539/b74ca411-5044-4c3d-837e-1bb7737539d6)

3. Click the "Add API Key" button.

![image](https://github.com/notnaveedkhan/oracle-bucket-example/assets/62374539/dcb18b89-1b1f-4714-bfcf-071188c9c0b5)

4. Download your public and private keys. Make sure to store them securely.

![image](https://github.com/notnaveedkhan/oracle-bucket-example/assets/62374539/a7db4b02-e02f-4132-a88b-6a3f1c8989a0)

5. If the key details are not shown, click on the three dots next to the key you added, and retrieve the key details.

![image](https://github.com/notnaveedkhan/oracle-bucket-example/assets/62374539/271d961f-82b8-46c5-83da-9dadfa51899d)

## Step 2: Create a Bucket

Once you have your API key set up, you can proceed to create a storage bucket. Follow these steps:

1. Navigate to the Object Storage section.

2. Click the "Create Bucket" button.

3. Provide a globally unique name for your bucket.

4. Choose the desired storage class and other configuration options.

5. Click "Create" to create the bucket.

![image](https://github.com/notnaveedkhan/oracle-bucket-example/assets/62374539/6d36d884-08b9-4fb4-8b11-f0275fe2a90b)

6. Get the bucket details (namespace & bucket name)

![image](https://github.com/notnaveedkhan/oracle-bucket-example/assets/62374539/8e16baf5-3e09-4099-b346-f368bd4cace4)

## Using the Oracle Cloud SDK

With the API key and bucket details in hand, you can now use the Oracle Cloud SDK to interact with your object storage. You can upload, download, and manage objects in your bucket programmatically.

For more information on how to use the Oracle Cloud SDK for object storage operations, refer to the official Oracle Cloud documentation.

## Conclusion

You have successfully set up access to Oracle Cloud Object Storage using API keys and created a storage bucket. You can now start utilizing the Oracle Cloud SDK to manage your objects within the bucket.

For further information and advanced usage, consult the [Oracle Cloud Object Storage documentation](https://docs.oracle.com/en-us/iaas/Content/Object/Concepts/objectstorageoverview.htm).
