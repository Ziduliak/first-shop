package sk.ziduliakmaros.first_shop;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sk.ziduliakmaros.first_shop.model.dto.controller.customer.AddCustomerRequest;
import sk.ziduliakmaros.first_shop.model.dto.controller.customer.AddCustomerResponse;


import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetCustomers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Maros"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surname").value("Majsky"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("klop12345@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address").value("Hlavna 53"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(28))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber").value("0905687356"));
    }

    @Test
    public void testGetCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Maros"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Majsky"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("klop12345@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Hlavna 53"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(28))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("0905687356"));
    }
    @Test
    public void testAddCustomer() throws Exception {
        AddCustomerRequest request = new AddCustomerRequest();
        request.setName("John");
        request.setSurname("Doe");
        request.setEmail("johndoe@example.com");
        request.setAddress("123 Main St");
        request.setAge(30);
        request.setPhoneNumber("555-555-5555");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/customer/addCustomer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer.name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer.surname").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer.email").value("johndoe@example.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer.address").value("123 Main St"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer.age").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer.phoneNumber").value("555-555-5555"))
                .andReturn();

        String responseString = result.getResponse().getContentAsString();
        AddCustomerResponse response = objectMapper.readValue(responseString, AddCustomerResponse.class);
        Integer id = response.getCustomer().getCustomerId();
        assertNotNull(id);

        // use the ID to delete the customer from the database
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testDeleteCustomer() throws Exception {
        Integer id = 502;
        // delete the customer
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/"+id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}