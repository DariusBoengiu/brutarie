package com.capgemini.bakery.taxonomy.area.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.capgemini.bakery.taxonomy.area.model.dto.AreaDTO;
import com.capgemini.bakery.taxonomy.area.service.AreaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AreaController.class})
@ExtendWith(SpringExtension.class)
class AreaControllerTest {
    @Autowired
    private AreaController areaController;

    @MockBean
    private AreaService areaService;

    /**
     * Method under test: {@link AreaController#getAllAreas()}
     */
    @Test
    void testGetAllAreas() throws Exception {
        when(this.areaService.getAllAreas()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bakery/v1/taxonomy/area/");
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AreaController#getAllAreas()}
     */
    @Test
    void testGetAllAreas2() throws Exception {
        when(this.areaService.getAllAreas()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/bakery/v1/taxonomy/area/");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AreaController#getAreaByID(Integer)}
     */
    @Test
    void testGetAreaByID() throws Exception {
        when(this.areaService.getAreaByID((Integer) any())).thenReturn(new AreaDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bakery/v1/taxonomy/area/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"areaId\":null,\"code\":null,\"name\":null}"));
    }

    /**
     * Method under test: {@link AreaController#getAreaByID(Integer)}
     */
    @Test
    void testGetAreaByID2() throws Exception {
        when(this.areaService.getAreaByID((Integer) any())).thenReturn(new AreaDTO());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/bakery/v1/taxonomy/area/{id}", 1);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"areaId\":null,\"code\":null,\"name\":null}"));
    }

    /**
     * Method under test: {@link AreaController#getAreaByID(Integer)}
     */
    @Test
    void testGetAreaByID3() throws Exception {
        when(this.areaService.getAllAreas()).thenReturn(new ArrayList<>());
        when(this.areaService.getAreaByID((Integer) any())).thenReturn(new AreaDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bakery/v1/taxonomy/area/{id}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AreaController#getAreaByID(Integer)}
     */
    @Test
    void testGetAreaByID4() throws Exception {
        when(this.areaService.getAllAreas()).thenReturn(new ArrayList<>());
        when(this.areaService.getAreaByID((Integer) any())).thenReturn(new AreaDTO());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/bakery/v1/taxonomy/area/{id}", "",
                "Uri Vars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AreaController#deleteByID(Integer)}
     */
    @Test
    void testDeleteByID() throws Exception {
        when(this.areaService.deleteByID((Integer) any())).thenReturn(new AreaDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/bakery/v1/taxonomy/area/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"areaId\":null,\"code\":null,\"name\":null}"));
    }

    /**
     * Method under test: {@link AreaController#deleteByID(Integer)}
     */
    @Test
    void testDeleteByID2() throws Exception {
        when(this.areaService.deleteByID((Integer) any())).thenReturn(new AreaDTO());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/bakery/v1/taxonomy/area/{id}", 1);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"areaId\":null,\"code\":null,\"name\":null}"));
    }

    /**
     * Method under test: {@link AreaController#postArea(AreaDTO)}
     */
    @Test
    void testPostArea() throws Exception {
        when(this.areaService.addArea((AreaDTO) any())).thenReturn(new AreaDTO());

        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaId(123);
        areaDTO.setCode("Code");
        areaDTO.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(areaDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bakery/v1/taxonomy/area/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"areaId\":null,\"code\":null,\"name\":null}"));
    }

    /**
     * Method under test: {@link AreaController#updateByID(Integer, AreaDTO)}
     */
    @Test
    void testUpdateByID() throws Exception {
        when(this.areaService.updateAreaByID((Integer) any(), (AreaDTO) any())).thenReturn(new AreaDTO());

        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaId(123);
        areaDTO.setCode("Code");
        areaDTO.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(areaDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/bakery/v1/taxonomy/area/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.areaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"areaId\":null,\"code\":null,\"name\":null}"));
    }
}

