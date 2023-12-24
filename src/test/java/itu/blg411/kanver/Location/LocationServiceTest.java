//package itu.blg411.kanver.Location;
//
//import itu.blg411.kanver.hospital.model.Hospital;
//import itu.blg411.kanver.location.LocationService;
//import itu.blg411.kanver.location.model.Location;
//import itu.blg411.kanver.location.model.LocationRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class LocationServiceTest {
//
//    @Mock
//    private LocationRepository locationRepository;
//
//    @InjectMocks
//    private LocationService locationService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetLocationById() {
//        Long locationId = 1L;
//        Location expectedLocation = new Location();
//        expectedLocation.setId(locationId);
//
//        when(locationRepository.findById(locationId)).thenReturn(Optional.of(expectedLocation));
//
//        Location actualLocation = locationService.getLocationById(locationId);
//
//        assertEquals(expectedLocation, actualLocation);
//    }
//
//    @Test
//    void testGetLocationByIdNotFound() {
//        Long locationId = 1L;
//
//        when(locationRepository.findById(locationId)).thenReturn(Optional.empty());
//
//        assertThrows(ResponseStatusException.class, () -> locationService.getLocationById(locationId));
//    }
//
//    @Test
//    void testGetAllLocations() {
//        List<Location> expectedLocations = Collections.singletonList(new Location());
//
//        when(locationRepository.findAll()).thenReturn(expectedLocations);
//
//        List<Location> actualLocations = locationService.getAllLocations();
//
//        assertEquals(expectedLocations, actualLocations);
//    }
//
//    @Test
//    void testGetHospitalsByCity() {
//        String cityName = "Istanbul";
//        Location location = new Location();
//        Hospital hospital = new Hospital();
//        location.getHospitals().add(hospital);
//
//        when(locationRepository.findByCity(cityName)).thenReturn(Collections.singletonList(location));
//
//        List<Hospital> hospitals = locationService.getHospitalsByCity(cityName);
//
//        assertEquals(Collections.singletonList(hospital), hospitals);
//    }
//
//    @Test
//    void testGetHospitalsByCityNoLocations() {
//        String cityName = "Istanbul";
//
//        when(locationRepository.findByCity(cityName)).thenReturn(Collections.emptyList());
//
//        List<Hospital> hospitals = locationService.getHospitalsByCity(cityName);
//
//        assertTrue(hospitals.isEmpty());
//    }
//}
