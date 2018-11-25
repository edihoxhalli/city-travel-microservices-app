package com.edi.citytravel.travelrecordsservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelRecordControllerTest {

    @Test
    public void whenMethodArgumentMismatch_thenBadRequest() {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer mockServer =
                MockRestServiceServer.bindTo(restTemplate).build();
        mockServer.expect(requestTo("/travel-record/sss"))
                .andRespond(withBadRequest());
    }

}
