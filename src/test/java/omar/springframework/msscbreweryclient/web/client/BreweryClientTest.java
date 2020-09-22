package omar.springframework.msscbreweryclient.web.client;

import omar.springframework.msscbreweryclient.web.model.BeerDto;
import omar.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }
    @Test
    void saveNewBeer(){
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();

        URI location = client.saveNewBeer(dto);

        assertNotNull(location.toString());
    }
    @Test
    void updateBeer(){
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }


    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("New Omar").build();

        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri.toString());
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("New Omar").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}