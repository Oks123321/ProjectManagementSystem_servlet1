package ua.goit.dev6.controller.customer;

import ua.goit.dev6.config.HibernateProvider;
import ua.goit.dev6.model.dto.CustomerDto;
import ua.goit.dev6.repository.CustomerRepository;
import ua.goit.dev6.service.CustomerService;
import ua.goit.dev6.service.converter.CustomersConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerEdit")
public class CustomerUpdatePageController extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        CustomerRepository customerRepository = new CustomerRepository(dbProvider);
        CustomersConverter customersConverter = new CustomersConverter();
        customerService = new CustomerService(customerRepository, customersConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        CustomerDto customerDto = customerService.findById(id).orElseGet(CustomerDto::new);
        req.setAttribute("customer", customerDto);
        req.getRequestDispatcher("/WEB-INF/jsp/customer/customerUpdate.jsp").forward(req, resp);
    }
}
