package np.com.roshanadhikary.services;

import np.com.roshanadhikary.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer addOrUpdateCustomer(Customer customer) {
        if (customer != null) {
//            when creating a new Customer, the id is null since there's ...
//            ... no option to assign an ID in the customerForm
//            but when updating a customer, the customer already has their ID
            if (customer.getId() == null) {
                customer.setId(getNextId());
            }
            customers.put(customer.getId(), customer);
            return customer;
        } else {
            throw new RuntimeException("Customer cannot be null!");
        }
    }

    private Integer getNextId() {
        return Collections.max(customers.keySet()) + 1;
    }

    @Override
    public void deleteCustomer(Integer id) {

    }


    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("john@demogroup.com");
        customer1.setAddressLineOne("Versailles");
        customer1.setAddressLineTwo("USA");
        customer1.setCity("Stamford");
        customer1.setState("Idaho");
        customer1.setZipCode("12345");
        customers.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Jane");
        customer2.setLastName("Matilda");
        customer2.setEmail("jane@demogroup.com");
        customer2.setAddressLineOne("Kansas");
        customer2.setAddressLineTwo("Arizona");
        customer2.setCity("Bellford");
        customer2.setState("North Dakota");
        customer2.setZipCode("67891");
        customers.put(customer2.getId(), customer2);


        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Ursula");
        customer3.setLastName("Phoenix");
        customer3.setEmail("ursula@demogroup.com");
        customer3.setAddressLineOne("Lilli");
        customer3.setAddressLineTwo("French Village");
        customer3.setCity("Rochester");
        customer3.setState("California");
        customer3.setZipCode("91121");
        customers.put(customer3.getId(), customer3);
    }
}
