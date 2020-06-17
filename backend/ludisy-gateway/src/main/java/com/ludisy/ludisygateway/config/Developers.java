package com.ludisy.ludisygateway.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.FileReader;
import java.io.IOException;

public class Developers {


//    String REDIRECT_URI = "http://localhost:8016/login/oauth2/code/google";

    public static void main(String[] args) throws IOException {


        String clientId = "734778652233-k08r0s5q8gqfo833akp50j38gh6b44u8.apps.googleusercontent.com";
        String clientSecret = "L6zXJ2H6fBjEtW29iHlbO9DL";
        String REDIRECT_URI = "";

        String authCode = "ya29.a0AfH6SMAbOeOe9ECuEVIKJm9V-e_geLmVcsNDhUZKc2tHPFW0cx1nzAEadGBuU_yrtJFldqYdgCF4aRlUuxU6SlPJeuXJZeBQ8OIGiI3fhpVveOS8daeK9V70ntPmGZrCBr1tDCweswkhGAMpwtUAlecpGqndMdEXxJQ";

        GoogleTokenResponse tokenResponse =
                new GoogleAuthorizationCodeTokenRequest(
                        new NetHttpTransport(),
                        JacksonFactory.getDefaultInstance(),
                        "https://oauth2.googleapis.com/token",
                        clientId,
                        clientSecret,
                        authCode,
                        REDIRECT_URI)
                        .execute();

        String accessToken = tokenResponse.getAccessToken();

        System.out.println(accessToken);

//// Use access token to call API
//        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
//        Drive drive =
//                new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
//                        .setApplicationName("Auth Code Exchange Demo")
//                        .build();
//        File file = drive.files().get("appfolder").execute();
//
//// Get profile info from ID token
//        GoogleIdToken idToken = tokenResponse.parseIdToken();
//        GoogleIdToken.Payload payload = idToken.getPayload();
//        String userId = payload.getSubject();  // Use this value as a key to identify a user.
//        String email = payload.getEmail();
//        boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
//        String name = (String) payload.get("name");
//        String pictureUrl = (String) payload.get("picture");
//        String locale = (String) payload.get("locale");
//        String familyName = (String) payload.get("family_name");
//        String givenName = (String) payload.get("given_name")
    }
}
