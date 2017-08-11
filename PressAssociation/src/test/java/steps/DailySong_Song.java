package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.GetAPICallSongs;
import functions.APICalls;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by paul.hunter on 09/08/2017.
 */

public class DailySong_Song {
    int statusCode;
    String responseContent = null;
    JSONArray responseJSON;
    //JSONObject dataJSON;

    @When("^I request a list of songs$")
    public void iRequestAListOfSongs() throws Throwable {
        GetAPICallSongs.GetAPICallSongs("http://turing.niallbunting.com:3009/api/video");
        responseContent = GetAPICallSongs.responseContent;
        responseJSON = new JSONArray(responseContent);
        int length = responseJSON.length();

//        throw new PendingException();
    }

    @When("^I request details for a song with (.*)$")
    public void i_request_details_for_a_song_with_id(String songId) throws Throwable {
        GetAPICallSongs.GetAPICallSongs("http://turing.niallbunting.com:3009/api/video/" + songId);
        responseContent = "[" + GetAPICallSongs.responseContent + "]";
        //responseContent = "[" + responseContent + "]";
        responseJSON = new JSONArray(responseContent);
    }

    @Then("^response code is (.*)$")
    public void responseCodeIs(int expectedStatusCode) throws Throwable {
        statusCode = GetAPICallSongs.statusCode;
        assertEquals(expectedStatusCode, statusCode);
//        throw new PendingException();
    }

    @And("^list of all songs is returned$")
    public void listOfAllSongsIsReturned(DataTable songDetails) throws Throwable {
        //Set the expected results
        List<List<String>> data = songDetails.raw();
        for (int i = 1; i < data.size(); i++) {
            String id = data.get(i).get(0);
            String artist = data.get(i).get(1);
            String song = data.get(i).get(2);
            String publishDate = data.get(i).get(3);
            String v = data.get(i).get(4);
            String dateCreated = data.get(i).get(5);

            //Initialise variables for results returned from API
            int length = responseJSON.length();
            String idActual = "";
            String songActual = "";
            String artistActual = "";
            String publishDateActual = "";
            String vActual = "";
            String dateCreatedActual = "";

            // Look for the id specified in the JSON response.
            // If not present the following asserts will fail
            // If present the for look will break and the following asserts performed on the current JSON object
            for (int j = 0; j < length; j++) {
                JSONObject dataJSON = responseJSON.getJSONObject(j);
                idActual = dataJSON.getString("_id");
                System.out.println("idActual: " + idActual + ", id:" + id + ", Equals: " + idActual.equals(id));
                if (idActual.equals(id)) {
                    songActual = dataJSON.getString("song");
                    artistActual = dataJSON.getString("artist");
                    publishDateActual = dataJSON.getString("publishDate");
                    vActual = dataJSON.getString("__v");
                    dateCreatedActual = dataJSON.getString("date_created");
                    break;
                }
            }
            assertEquals(id, idActual);
            assertEquals(artist, artistActual);
            assertEquals(song, songActual);
            assertEquals(publishDate, publishDateActual);
            assertEquals(v, vActual);
            assertEquals(dateCreated, dateCreatedActual);
        }
    }

    @And("^details of (.*) song are returned$")
    public void DetailsOfSongsAreReturned(int numberOfSongs) throws Throwable {
        int length = responseJSON.length();
        assertEquals(numberOfSongs, length);
    }

    @When("^i post a new song with artist (.*), song (.*), and publish date (.*)$")
    public void iPostANewSongWithArtistSongAndPublishDate(String artist, String song, String publishDate) throws Throwable {
        JSONObject jsonData = new JSONObject();
        jsonData.put("artist", artist)
                .put("song", song)
                .put("publishDate", publishDate);

        APICalls.APICalls("POST", "http://turing.niallbunting.com:3009/api/video", jsonData);
    }

    @And("^(.*) value is (.*)$")
    public void itemValueIs(String itemName, String itemValue) throws Throwable {
        JSONObject dataJSON = responseJSON.getJSONObject(0);
        String testValue = dataJSON.getString(itemName);

        if (itemValue.equals("not blank")){
            assertNotNull(testValue);
        }else if (itemName.equals("date_created")) {
            //extract yyyy-mm-dd from today's date
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(cal.getTime());
            String todayDate = format1.format(cal.getTime());

            //extract yyyy-mm-dd from response date
            String createDate = itemValue.substring(0,10);

            assertEquals(todayDate, createDate);
        }else if (itemName.equals("publishDate")){
            //extract yyyy-mm-dd from response date to string
            String publishDate = itemValue.substring(0,10);

            assertEquals(itemValue, publishDate);
        }else{
            assertEquals(itemValue, testValue);
        }

        System.out.println(itemName + " vale is: " + dataJSON.getString(itemName));
    }

    @When("^I post an update to an existing song with Id (.*)$")
    public void iPostAnUpdateToAnExistingSongWithIdId(String idToUpdate) throws Throwable {
        APICalls.APICalls("PATCH", "http://turing.niallbunting.com:3009/api/video/" + idToUpdate, null);
    }

    @And("^response body will be (.*)$")
    public void responseBodyWillBe(String expectedResponse) throws Throwable {
        //need to check that responseContent actually contains string "N/A"
        assertEquals(expectedResponse, APICalls.responseContent);
    }

    @When("^I delete a video$")
    public void iDeleteAVideo() throws Throwable {
        //Find the id for the latest video in the list
        GetAPICallSongs.GetAPICallSongs("http://turing.niallbunting.com:3009/api/video");
        responseContent = GetAPICallSongs.responseContent;
        responseJSON = new JSONArray(responseContent);
        int length = responseJSON.length();
        JSONObject dataJSON = responseJSON.getJSONObject(length-1);
        String idToDelete = dataJSON.getString("_id");

        //Delete the video
        APICalls.APICalls("DELETE", "http://turing.niallbunting.com:3009/api/video/" + idToDelete, null);

    }
}
