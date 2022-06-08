package com.capgemini.bakery.taxonomy.area.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.bakery.taxonomy.area.model.Area;
import com.capgemini.bakery.taxonomy.area.model.dto.AreaDTO;
import com.capgemini.bakery.taxonomy.area.repository.AreaRepository;
import com.capgemini.bakery.taxonomy.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AreaService.class})
@ExtendWith(SpringExtension.class)
class AreaServiceTest {
    @MockBean
    private AreaRepository areaRepository;

    @Autowired
    private AreaService areaService;

    /**
     * Method under test: {@link AreaService#addArea(AreaDTO)}
     */
    @Test
    void testAddArea() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        when(this.areaRepository.save((Area) any())).thenReturn(area);
        AreaDTO actualAddAreaResult = this.areaService.addArea(new AreaDTO());
        assertEquals(123, actualAddAreaResult.getAreaId().intValue());
        assertEquals("Name", actualAddAreaResult.getName());
        assertEquals("Code", actualAddAreaResult.getCode());
        verify(this.areaRepository).save((Area) any());
    }

    /**
     * Method under test: {@link AreaService#addArea(AreaDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddArea2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.dozer.MappingException: Source object must not be null
        //       at org.dozer.util.MappingUtils.throwMappingException(MappingUtils.java:87)
        //       at org.dozer.util.MappingValidator.validateMappingRequest(MappingValidator.java:37)
        //       at org.dozer.util.MappingValidator.validateMappingRequest(MappingValidator.java:49)
        //       at org.dozer.MappingProcessor.map(MappingProcessor.java:123)
        //       at org.dozer.MappingProcessor.map(MappingProcessor.java:119)
        //       at org.dozer.DozerBeanMapper.map(DozerBeanMapper.java:120)
        //       at com.capgemini.bakery.taxonomy.area.model.mapper.AreaMapper.toArea(AreaMapper.java:15)
        //       at com.capgemini.bakery.taxonomy.area.service.AreaService.addArea(AreaService.java:27)
        //   In order to prevent addArea(AreaDTO)
        //   from throwing MappingException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addArea(AreaDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        when(this.areaRepository.save((Area) any())).thenReturn(area);
        this.areaService.addArea(null);
    }

    /**
     * Method under test: {@link AreaService#getAllAreas()}
     */
    @Test
    void testGetAllAreas() {
        when(this.areaRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.areaService.getAllAreas().isEmpty());
        verify(this.areaRepository).findAll();
    }

    /**
     * Method under test: {@link AreaService#getAllAreas()}
     */
    @Test
    void testGetAllAreas2() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");

        ArrayList<Area> areaList = new ArrayList<>();
        areaList.add(area);
        when(this.areaRepository.findAll()).thenReturn(areaList);
        List<AreaDTO> actualAllAreas = this.areaService.getAllAreas();
        assertEquals(1, actualAllAreas.size());
        AreaDTO getResult = actualAllAreas.get(0);
        assertEquals(123, getResult.getAreaId().intValue());
        assertEquals("Name", getResult.getName());
        assertEquals("Code", getResult.getCode());
        verify(this.areaRepository).findAll();
    }

    /**
     * Method under test: {@link AreaService#getAllAreas()}
     */
    @Test
    void testGetAllAreas3() {
        when(this.areaRepository.findAll()).thenThrow(new ResourceNotFoundException("Msg"));
        assertThrows(ResourceNotFoundException.class, () -> this.areaService.getAllAreas());
        verify(this.areaRepository).findAll();
    }

    /**
     * Method under test: {@link AreaService#getAllAreas()}
     */
    @Test
    void testGetAllAreas4() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");

        Area area1 = new Area();
        area1.setAreaId(123);
        area1.setCode("Code");
        area1.setName("Name");

        ArrayList<Area> areaList = new ArrayList<>();
        areaList.add(area1);
        areaList.add(area);
        when(this.areaRepository.findAll()).thenReturn(areaList);
        List<AreaDTO> actualAllAreas = this.areaService.getAllAreas();
        assertEquals(2, actualAllAreas.size());
        AreaDTO getResult = actualAllAreas.get(0);
        assertEquals("Name", getResult.getName());
        AreaDTO getResult1 = actualAllAreas.get(1);
        assertEquals("Name", getResult1.getName());
        assertEquals("Code", getResult1.getCode());
        assertEquals(123, getResult1.getAreaId().intValue());
        assertEquals("Code", getResult.getCode());
        assertEquals(123, getResult.getAreaId().intValue());
        verify(this.areaRepository).findAll();
    }

    /**
     * Method under test: {@link AreaService#getAreaByID(Integer)}
     */
    @Test
    void testGetAreaByID() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        Optional<Area> ofResult = Optional.of(area);
        when(this.areaRepository.findById((Integer) any())).thenReturn(ofResult);
        AreaDTO actualAreaByID = this.areaService.getAreaByID(123);
        assertEquals(123, actualAreaByID.getAreaId().intValue());
        assertEquals("Name", actualAreaByID.getName());
        assertEquals("Code", actualAreaByID.getCode());
        verify(this.areaRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#getAreaByID(Integer)}
     */
    @Test
    void testGetAreaByID2() {
        when(this.areaRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> this.areaService.getAreaByID(123));
        verify(this.areaRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#getAreaByID(Integer)}
     */
    @Test
    void testGetAreaByID3() {
        when(this.areaRepository.findById((Integer) any())).thenThrow(new ResourceNotFoundException("Msg"));
        assertThrows(ResourceNotFoundException.class, () -> this.areaService.getAreaByID(123));
        verify(this.areaRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#deleteByID(Integer)}
     */
    @Test
    void testDeleteByID() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        Optional<Area> ofResult = Optional.of(area);
        doNothing().when(this.areaRepository).deleteById((Integer) any());
        when(this.areaRepository.findById((Integer) any())).thenReturn(ofResult);
        AreaDTO actualDeleteByIDResult = this.areaService.deleteByID(123);
        assertEquals(123, actualDeleteByIDResult.getAreaId().intValue());
        assertEquals("Name", actualDeleteByIDResult.getName());
        assertEquals("Code", actualDeleteByIDResult.getCode());
        verify(this.areaRepository).findById((Integer) any());
        verify(this.areaRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#deleteByID(Integer)}
     */
    @Test
    void testDeleteByID2() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        Optional<Area> ofResult = Optional.of(area);
        doThrow(new ResourceNotFoundException("Msg")).when(this.areaRepository).deleteById((Integer) any());
        when(this.areaRepository.findById((Integer) any())).thenReturn(ofResult);
        assertThrows(ResourceNotFoundException.class, () -> this.areaService.deleteByID(123));
        verify(this.areaRepository).findById((Integer) any());
        verify(this.areaRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#deleteByID(Integer)}
     */
    @Test
    void testDeleteByID3() {
        doNothing().when(this.areaRepository).deleteById((Integer) any());
        when(this.areaRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> this.areaService.deleteByID(123));
        verify(this.areaRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#updateAreaByID(Integer, AreaDTO)}
     */
    @Test
    void testUpdateAreaByID() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        Optional<Area> ofResult = Optional.of(area);

        Area area1 = new Area();
        area1.setAreaId(123);
        area1.setCode("Code");
        area1.setName("Name");
        when(this.areaRepository.save((Area) any())).thenReturn(area1);
        when(this.areaRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals(123, this.areaService.updateAreaByID(123, new AreaDTO()).getAreaId().intValue());
        verify(this.areaRepository).save((Area) any());
        verify(this.areaRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#updateAreaByID(Integer, AreaDTO)}
     */
    @Test
    void testUpdateAreaByID2() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        Optional<Area> ofResult = Optional.of(area);
        when(this.areaRepository.save((Area) any())).thenThrow(new ResourceNotFoundException("Msg"));
        when(this.areaRepository.findById((Integer) any())).thenReturn(ofResult);
        assertThrows(ResourceNotFoundException.class, () -> this.areaService.updateAreaByID(123, new AreaDTO()));
        verify(this.areaRepository).save((Area) any());
        verify(this.areaRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#updateAreaByID(Integer, AreaDTO)}
     */
    @Test
    void testUpdateAreaByID3() {
        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        when(this.areaRepository.save((Area) any())).thenReturn(area);
        when(this.areaRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> this.areaService.updateAreaByID(123, new AreaDTO()));
        verify(this.areaRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link AreaService#updateAreaByID(Integer, AreaDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateAreaByID4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.dozer.MappingException: Source object must not be null
        //       at org.dozer.util.MappingUtils.throwMappingException(MappingUtils.java:87)
        //       at org.dozer.util.MappingValidator.validateMappingRequest(MappingValidator.java:37)
        //       at org.dozer.util.MappingValidator.validateMappingRequest(MappingValidator.java:49)
        //       at org.dozer.MappingProcessor.map(MappingProcessor.java:123)
        //       at org.dozer.MappingProcessor.map(MappingProcessor.java:119)
        //       at org.dozer.DozerBeanMapper.map(DozerBeanMapper.java:120)
        //       at com.capgemini.bakery.taxonomy.area.model.mapper.AreaMapper.toArea(AreaMapper.java:15)
        //       at com.capgemini.bakery.taxonomy.area.service.AreaService.updateAreaByID(AreaService.java:51)
        //   In order to prevent updateAreaByID(Integer, AreaDTO)
        //   from throwing MappingException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateAreaByID(Integer, AreaDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Area area = new Area();
        area.setAreaId(123);
        area.setCode("Code");
        area.setName("Name");
        Optional<Area> ofResult = Optional.of(area);

        Area area1 = new Area();
        area1.setAreaId(123);
        area1.setCode("Code");
        area1.setName("Name");
        when(this.areaRepository.save((Area) any())).thenReturn(area1);
        when(this.areaRepository.findById((Integer) any())).thenReturn(ofResult);
        this.areaService.updateAreaByID(123, null);
    }
}

