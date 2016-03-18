package ar.com.ponele.mascotapp.amazon;

import android.support.v4.app.FragmentActivity;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient;

public class AmazonConnector {

    public static final String IDENTITY_POOL_ID = "ap-northeast-1:ab39b2b8-105e-48f2-9a41-c66d0a5b64c5";

    public static DynamoDBMapper createDynamoDBMapper(FragmentActivity activity) {

        // Initialize the Amazon Cognito credentials provider
        final CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                activity.getApplicationContext(),
                IDENTITY_POOL_ID, // Identity Pool ID
                Regions.AP_NORTHEAST_1 // Region
        );
        final AmazonDynamoDBAsyncClient ddbClient = new AmazonDynamoDBAsyncClient(credentialsProvider);
        ddbClient.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
        return new DynamoDBMapper(ddbClient);

    }
}
