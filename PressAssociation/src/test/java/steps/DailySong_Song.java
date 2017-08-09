package steps;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;


/**
 * Created by paul.hunter on 09/08/2017.
 */
public class DailySong_Song {
    @When("^I request a list of songs$")
    public void iRequestAListOfSongs() throws Throwable {

        Response response = Request.Get("http://turing.niallbunting.com:3009/api/video")
                .addHeader("Content-Type", "application/json")
                .execute();

        HttpResponse httpResponse = response.returnResponse();
        int responseCode = httpResponse.getStatusLine().getStatusCode();
        //String content = EntityUtils.toString(httpResponse.getEntity());
        byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
        //Need to extract the content from the bytes above

        //String content = EntityUtils.toByteArray(httpResponse.getEntity().getContent().toString());

        //int responseCode = response.returnResponse().getStatusLine().getStatusCode();
        //At this point the request has been consumed and the next line will not run successfully
        //String data = response.returnContent().toString();

        throw new PendingException();
    }

    @Then("^response code is (\\d+)$")
    public void response_code_is(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^list of all songs is returned$")
    public void list_of_all_songs_is_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song id is (\\d+)cac(\\d+)f(\\d+)db(\\d+)$")
    public void song_id_is_cac_f_db(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song Artist is Ed Sheeran$")
    public void song_Artist_is_Ed_Sheeran() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song Title Galway Girl$")
    public void song_Title_Galway_Girl() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song V value is (\\d+)$")
    public void song_V_value_is(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song publish date is (\\d+)-(\\d+)-(\\d+)T(\\d+):(\\d+):(\\d+)\\.(\\d+)Z$")
    public void song_publish_date_is_T_Z(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song date created is (\\d+)-(\\d+)-(\\d+)T(\\d+):(\\d+):(\\d+)\\.(\\d+)Z$")
    public void song_date_created_is_T_Z(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song id is (\\d+)cbda(\\d+)ed(\\d+)c(\\d+)a(\\d+)b(\\d+)$")
    public void song_id_is_cbda_ed_c_a_b(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song Artist is Lady Gaga$")
    public void song_Artist_is_Lady_Gaga() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song Title Poker face$")
    public void song_Title_Poker_face() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^song id is (\\d+)cc(\\d+)b(\\d+)ed(\\d+)c(\\d+)a(\\d+)b(\\d+)$")
    public void song_id_is_cc_b_ed_c_a_b(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I request details for a song with (\\d+)cbda(\\d+)ed(\\d+)c(\\d+)a(\\d+)b(\\d+)$")
    public void i_request_details_for_a_song_with_cbda_ed_c_a_b(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^only details of one song are returned$")
    public void only_details_of_one_song_are_returned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I request details for a song with (\\d+)cc(\\d+)b(\\d+)ed(\\d+)c(\\d+)a(\\d+)b(\\d+)$")
    public void i_request_details_for_a_song_with_cc_b_ed_c_a_b(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^new song Artist is Lady Gaga$")
    public void new_song_Artist_is_Lady_Gaga() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^new song Title Poker face$")
    public void new_song_Title_Poker_face() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^new song publish date is (\\d+)-(\\d+)-(\\d+)T(\\d+):(\\d+):(\\d+)\\.(\\d+)Z$")
    public void new_song_publish_date_is_T_Z(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I post a new song$")
    public void i_post_a_new_song() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        String requestBody = new JSONObject()
//                            .put("artist", "Lady Gaga")
//                            .put("song", "Poker face")
//                            .put("publishDate", "2017-09-01")
//                            .toString();
//        String response = Request.Post("http://turing.niallbunting.com:3009/api/video")
//                .addHeader("Content-Type", "application/json")
//                .bodyString(requestBody, ContentType.APPLICATION_JSON )
//                .execute()
//                .returnResponse()
//                .toString();
        throw new PendingException();
    }

    @Then("^song id is (\\d+)cabbe(\\d+)f(\\d+)db(\\d+)$")
    public void song_id_is_cabbe_f_db(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I post an update to an existing song$")
    public void i_post_an_update_to_an_existing_song() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Response body will be Not implemented$")
    public void response_body_will_be_Not_implemented() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
