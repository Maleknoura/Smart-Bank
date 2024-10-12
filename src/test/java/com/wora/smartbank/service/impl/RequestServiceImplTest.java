package com.wora.smartbank.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.wora.smartbank.dao.RequestDao;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.util.ValidationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class RequestServiceImplTest {

    @Mock
    private RequestDao requestDao;

    @Mock
    private ValidationUtil validationUtil;

    @InjectMocks
    private RequestServiceImpl requestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Request request1 = new Request(1L, "John", "Doe", "CIN123", null, null, Double.valueOf(3000.0), false, "firsttest.doe@example.com", "123456789", null, null, 1000.00, 12, BigDecimal.valueOf(100), null);
        Request request2 = new Request(2L, "Jane", "Doe", "CIN456", null, null, Double.valueOf(3500.0), false, "test.@example.com", "987654321", null, null, 2000.08, 24, BigDecimal.valueOf(200), null);

        List<Request> expectedRequests = Arrays.asList(request1, request2);

        when(requestDao.findAll()).thenReturn(expectedRequests);

        List<Request> actualRequests = requestService.findall();

        assertEquals(expectedRequests.size(), actualRequests.size());
        assertEquals(expectedRequests.get(0).getFirstName(), actualRequests.get(0).getFirstName());
        assertEquals(expectedRequests.get(1).getFirstName(), actualRequests.get(1).getFirstName());
    }

    @Test
    void testFindAll_WithMultipleRequests() {
        Request request1 = new Request(1L, "John", "Doe", "CIN123", null, null, Double.valueOf(3000.0), false, "firsttest.doe@example.com", "123456789", null, null, 2000.08, 12, BigDecimal.valueOf(100), null);
        Request request2 = new Request(2L, "Jane", "Doe", "CIN456", null, null, Double.valueOf(3500.0), false, "test.@example.com", "987654321", null, null, 2000.08, 24, BigDecimal.valueOf(200), null);

        List<Request> expectedRequests = Arrays.asList(request1, request2);
        when(requestDao.findAll()).thenReturn(expectedRequests);

        List<Request> actualRequests = requestService.findall();

        assertEquals(expectedRequests.size(), actualRequests.size());
        assertEquals(expectedRequests.get(0).getFirstName(), actualRequests.get(0).getFirstName());
        assertEquals(expectedRequests.get(1).getFirstName(), actualRequests.get(1).getFirstName());
    }

    @Test
    void testFindAll_WithEmptyList() {
        when(requestDao.findAll()).thenReturn(Collections.emptyList());

        List<Request> actualRequests = requestService.findall();

        assertTrue(actualRequests.isEmpty());
    }

    @Test
    void testFindAll_WithNullValues() {
        Request request = new Request(1L, null, "Doe", null, null, null, Double.valueOf(0.0), false, null, null, null, null, 2000.08, 0, BigDecimal.ZERO, null);
        when(requestDao.findAll()).thenReturn(Collections.singletonList(request));

        List<Request> actualRequests = requestService.findall();

        assertEquals(1, actualRequests.size());
        assertNull(actualRequests.get(0).getFirstName());
        assertEquals("Doe", actualRequests.get(0).getLastName());
    }

    @Test
    void testFindAll_WithDuplicateRequests() {
        Request request1 = new Request(1L, "John", "Doe", "CIN123", null, null, Double.valueOf(3000.0), false, "firsttest.doe@example.com", "123456789", null, null, 2000.08, 12, BigDecimal.valueOf(100), null);
        Request request2 = new Request(1L, "John", "Doe", "CIN123", null, null, Double.valueOf(3000.0), false, "firsttest.doe@example.com", "123456789", null, null, 2000.08, 12, BigDecimal.valueOf(100), null);

        List<Request> expectedRequests = Arrays.asList(request1, request2);
        when(requestDao.findAll()).thenReturn(expectedRequests);

        List<Request> actualRequests = requestService.findall();

        assertEquals(expectedRequests.size(), actualRequests.size());
        assertEquals(expectedRequests.get(0).getFirstName(), actualRequests.get(0).getFirstName());
        assertEquals(expectedRequests.get(1).getFirstName(), actualRequests.get(1).getFirstName());
    }

    @Test
    void testFindAll_DatabaseFailure() {
        when(requestDao.findAll()).thenThrow(new RuntimeException("Database error"));

        Exception exception = assertThrows(RuntimeException.class, () -> requestService.findall());
        assertEquals("Database error", exception.getMessage());
    }
}