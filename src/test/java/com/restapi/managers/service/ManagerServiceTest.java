package com.restapi.managers.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ManagerServiceTest {

	List mock = mock(List.class); 

	@Test
	void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {	
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());	
		assertEquals(10, mock.size());	
	}


}
