package com.ludisy.ludisygateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.config.AppControllerAdvice;
import com.ludisy.ludisygateway.rest.GatewayController;
import com.ludisy.ludisygateway.shared.NotFoundException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static com.ludisy.ludisygateway.TestConstants.BASE_REQUEST_URI;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(GatewayController.class)
public class GatewatControllerTests {

    private MockMvc mockMvc;

    @InjectMocks
    private GatewayController controller;

    @Mock
    ApplicationUserService applicationUserService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(new AppControllerAdvice())
                .build();
    }

    @Test
    public void postUser() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String uuid = UUID.randomUUID().toString();
        ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();
        doReturn(applicationUserDTO)
                .when(applicationUserService)
                .createUser(any());

        mockMvc.
                perform(post(BASE_REQUEST_URI + "/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(applicationUserDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getUserById() throws Exception {

        String uuid = UUID.randomUUID().toString();
        ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();
        doReturn(applicationUserDTO).when(applicationUserService).getDTOById(uuid);

        mockMvc.
                perform(get(BASE_REQUEST_URI + "/user/" + uuid))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void getUserByIdNotFound() throws Exception {

        String uuid = UUID.randomUUID().toString();
        doThrow(NotFoundException.class).when(applicationUserService).getDTOById(uuid);

        mockMvc.
                perform(get(BASE_REQUEST_URI + "/user/" + uuid))
                .andExpect(status().isNotFound());

    }

    // TODO test all endpoints
    @Ignore
    @Test
    public void getWorkoutsByTimestamp() throws Exception {

        String uuid = UUID.randomUUID().toString();
        mockMvc.
                perform(get(BASE_REQUEST_URI + "/user/" + uuid + "/workouts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

}
