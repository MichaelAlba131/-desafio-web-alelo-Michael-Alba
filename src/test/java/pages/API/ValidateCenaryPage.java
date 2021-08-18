package pages.API;

import Base.BaseUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.cucumber.java.bs.A;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import steps.Hook;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.junit.Test;

public class ValidateCenaryPage {

    public static ValidateCenaryPage action() {
        return new ValidateCenaryPage();
    }

    public static boolean VerifyCountries(String response) {
        try {

            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            boolean findCountryBR = false;
            boolean findCountryAR = false;

            for (int i = 0; i < notificationsList.length(); i++) {
                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String metadata = jsonObject.get("metadata").toString();

                jsonObject = new JSONObject(metadata);
                String country = jsonObject.get("country").toString();

                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notification = jsonObject.get("content").toString();

                if (country.equals("BR"))
                    findCountryBR = true;
                else if (country.equals("AR"))
                    findCountryAR = true;

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "Country: " + country + " | Notification: " + notification, false);

            }

            if (findCountryBR && findCountryAR)
                return true;
            else
                return false;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Country not found", false);

            return false;
        }
    }

    public static boolean VerifyNotificationsCount(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            for (int i = 0; i < notificationsList.length(); i++) {

                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notification = jsonObject.get("content").toString();

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, (i + 1) + " - Notification: " + notification, false);

            }

            jsonObject = new JSONObject(response);
            dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            String pageState = jsonObject.get("pageState").toString();

            jsonObject = new JSONObject(pageState);
            String perPage = jsonObject.get("perPage").toString();

            BaseUtil.action()
                    .Report("INFO", false, Hook.nomeCenario, false, null, "perPage: " + perPage, false);

            if (notificationsList.length() == Integer.parseInt(perPage))
                return true;
            else
                return false;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Error in Count Page Itens", false);

            return false;
        }
    }

    public static boolean VerifyEncode64(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            for (int i = 0; i < notificationsList.length(); i++) {
                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notification = jsonObject.get("content").toString();

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "Notification: " + notification, false);

                byte[] decodedBytes = Base64.getDecoder().decode(notification);
                String decodedString = new String(decodedBytes);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Decode Notification: " + decodedString + "</pre>", false);

            }

            return true;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Error in Decode", false);

            return false;
        }

    }

    public static boolean VerifyGUID(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            for (int i = 0; i < notificationsList.length(); i++) {
                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notificationId = jsonObject.get("notificationId").toString();

                if (BaseUtil.isValidGUID(notificationId))
                    BaseUtil.action()
                            .Report("PASS", false, Hook.nomeCenario, false, null, "NotificationId: " + notificationId + " is valid", false);
                else
                    BaseUtil.action()
                            .Report("FAIL", false, Hook.nomeCenario, false, null, "NotificationId: " + notificationId + " is invalid", false);
            }

            return true;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Error in Decode", false);

            return false;
        }

    }

    public static boolean VerifyFindNotificationIdInsideDocument(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            for (int i = 0; i < notificationsList.length(); i++) {
                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notificationId = jsonObject.get("notificationId").toString();

                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notification = jsonObject.get("content").toString();

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "NotificationId: " + notificationId, false);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "Notification: " + notification, false);

                byte[] decodedBytes = Base64.getDecoder().decode(notification);
                String decodedString = new String(decodedBytes);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Decode Notification: " + decodedString + "</pre>", false);

                if (decodedString.contains(notificationId))
                    BaseUtil.action()
                            .Report("PASS", false, Hook.nomeCenario, false, null, "notificationId was found in the document", false);
                else
                    BaseUtil.action()
                            .Report("FAIL", false, Hook.nomeCenario, false, null, "notificationId was not found in the document", false);
            }

            return true;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Error in Decode", false);

            return false;
        }
    }

    public static boolean VerifyMessageStatusCode200(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            for (int i = 0; i < notificationsList.length(); i++) {

                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notification = jsonObject.get("content").toString();

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "Notification: " + notification, false);

                byte[] decodedBytes = Base64.getDecoder().decode(notification);
                String decodedString = new String(decodedBytes);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Decode Notification: " + decodedString + "</pre>", false);

                if (decodedString.contains("200"))
                    if (decodedString.contains("Document Authorized")) {
                        if (decodedString.contains("Document authorized successfully"))
                            BaseUtil.action()
                                    .Report("PASS", false, Hook.nomeCenario, false, null, "Message for Status code 200 OK", false);
                        else
                            BaseUtil.action()
                                    .Report("PASS", false, Hook.nomeCenario, false, null, "Message Document authorized successfully for Status code 200 NOK", false);
                    } else {
                        BaseUtil.action()
                                .Report("FAIL", false, Hook.nomeCenario, false, null, "Message Document Authorized for Status code 200 NOK", false);
                    }
            }

            return true;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Error in Verify Message", false);

            return false;
        }
    }

    public static boolean VerifyMessageStatusCode400(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            for (int i = 0; i < notificationsList.length(); i++) {

                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notification = jsonObject.get("content").toString();

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "Notification: " + notification, false);

                byte[] decodedBytes = Base64.getDecoder().decode(notification);
                String decodedString = new String(decodedBytes);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Decode Notification: " + decodedString + "</pre>", false);

                if (decodedString.contains("400"))
                    if (decodedString.contains("Document Rejected")) {
                        if (decodedString.contains("Document was rejected by tax authority"))
                            BaseUtil.action()
                                    .Report("PASS", false, Hook.nomeCenario, false, null, "Message for Status code 400 OK", false);
                        else
                            BaseUtil.action()
                                    .Report("PASS", false, Hook.nomeCenario, false, null, "Message Document authorized successfully for Status code 400 NOK", false);
                    } else {
                        BaseUtil.action()
                                .Report("FAIL", false, Hook.nomeCenario, false, null, "Message Document Authorized for Status code 400 NOK", false);
                    }
            }

            return true;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Error in Verify Message", false);

            return false;
        }
    }

    public static boolean VerifyMessageStatusCode400DisplayWarm(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataJson = jsonObject.get("data").toString();

            jsonObject = new JSONObject(dataJson);
            JSONArray notificationsList = (JSONArray) jsonObject.get("notifications");

            for (int i = 0; i < notificationsList.length(); i++) {

                jsonObject = new JSONObject(notificationsList.get(i).toString());
                String notification = jsonObject.get("content").toString();

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "Notification: " + notification, false);

                byte[] decodedBytes = Base64.getDecoder().decode(notification);
                String decodedString = new String(decodedBytes);

                BaseUtil.action()
                        .Report("INFO", false, Hook.nomeCenario, false, null, "<pre> Decode Notification: " + decodedString + "</pre>", false);

                if (decodedString.contains("400"))
                    if (decodedString.contains("Document Rejected")) {
                        if (decodedString.contains("Document was rejected by tax authority"))
                            BaseUtil.action()
                                    .Report("FAIL", false, Hook.nomeCenario, false, null, "!!!Message for Status code 400!!!", false);
                        else
                            BaseUtil.action()
                                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Message Document authorized successfully for Status code 400 NOK", false);
                    } else {
                        BaseUtil.action()
                                .Report("FAIL", false, Hook.nomeCenario, false, null, "Message Document Authorized for Status code 400 NOK", false);
                    }
            }

            return true;
        } catch (Exception e) {
            BaseUtil.action()
                    .Report("FAIL", false, Hook.nomeCenario, false, null, "Error in Verify Message", false);

            return false;
        }
    }
}
