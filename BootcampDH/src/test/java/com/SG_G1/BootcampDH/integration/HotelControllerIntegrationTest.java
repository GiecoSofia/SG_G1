package com.SG_G1.BootcampDH.integration;

import com.SG_G1.BootcampDH.dto.responsive.DTOresponsive3;
import com.SG_G1.BootcampDH.dto.resquest.DTOresquest3;
import com.SG_G1.BootcampDH.model.HotelModel;
import com.SG_G1.BootcampDH.utils.DTORequestHotelFactory;
import com.SG_G1.BootcampDH.utils.DTOResponseHotelFactory;
import com.SG_G1.BootcampDH.utils.HotelFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerIntegrationTest {

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
    public void ListHotel() throws Exception {

        // Arrange
        List<HotelModel> expected = HotelFactory.hotelList();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v1/hotels");


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
    public void ListHotelDisp() throws Exception {

        // Arrange
        //Params

        //Expected
        List<HotelModel> expected = new ArrayList<>();
        HotelModel hotel = HotelFactory.hotel5();
        expected.add(hotel);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v1/hotelss?dateFrom=17/04/2022&dateTo=23/05/2022&destination=Tucumán");


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
        DTOresquest3 params = DTORequestHotelFactory.DTORequest3();

        //Expected
        DTOresponsive3 expected = DTOResponseHotelFactory.DTOResponsive3();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/booking")
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
