package com.SG_G1.BootcampDH.integration;

import com.SG_G1.BootcampDH.dto.responsive.FlightReservationDTO;
import com.SG_G1.BootcampDH.dto.resquest.FlightRequestDTO;
import com.SG_G1.BootcampDH.model.FlightModel;
import com.SG_G1.BootcampDH.utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@AutoConfigureMockMvc

public class FlightControllerIntegrationTest {


        @Autowired
        MockMvc mockMvc;

        ObjectWriter writer;

        @BeforeEach
        public void setupBeforeAll(){
            writer = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .writer();
        }

        @Test
        public void ListFlight() throws Exception {

            // Arrange
            List<FlightModel> expected = FlightFactory.flightList();

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v1/flights");


            // ResultMatchers

            ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
            ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


            //ACt y arrange

            mockMvc.perform(request)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(bodyExpected)
                    .andExpect(statusExpected)
                    .andExpect(contentTypeExpected);
        }

        @Test
        public void ListFlightDisp() throws Exception {

            // Arrange
            //Params

            //Expected
            List<FlightModel> expected = new ArrayList<>();
            FlightModel hotel = FlightFactory.flight3();
            expected.add(hotel);

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v1/flightss?dateFrom=10/02/2022&dateTo=21/02/2022&origin=Puerto Iguazú&destination=Bogotá");


            // ResultMatchers

            ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
            ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


            //ACt y arrange

            mockMvc.perform(request)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(bodyExpected)
                    .andExpect(statusExpected)
                    .andExpect(contentTypeExpected);
        }

        @Test
        public void Booking() throws Exception {

            // Arrange
            //Params
            FlightRequestDTO params = DTORequestFlightFactory.DTORequest6();
            //Expected
            FlightReservationDTO expected = DTOResponseFlightFactory.DTOResponsive6();

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/flight-reservation")
                    .content(writer.writeValueAsString(params))
                    .contentType(MediaType.APPLICATION_JSON);


            // ResultMatchers

            ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
            ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


            //ACt y arrange

            mockMvc.perform(request)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(bodyExpected)
                    .andExpect(statusExpected)
                    .andExpect(contentTypeExpected);
        }
    }

