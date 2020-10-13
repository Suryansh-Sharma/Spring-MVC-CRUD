package np.com.roshanadhikary.services;

import np.com.roshanadhikary.domain.Customer;

import java.util.List;

public interface CustomerService {
    public Customer getCustomerById(Integer id);

    public List<Customer> listCustomers();

    public Customer addOrUpdateCustomer(Customer customer);

    public void deleteCustomer(Integer id);
}
