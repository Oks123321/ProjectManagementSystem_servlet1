package ua.goit.dev6.controller.company;

import ua.goit.dev6.config.HibernateProvider;
import ua.goit.dev6.model.dto.CompanyDto;
import ua.goit.dev6.repository.CompanyRepository;
import ua.goit.dev6.service.CompanyService;
import ua.goit.dev6.service.converter.CompanyConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/companyEdit")
public class CompanyUpdatePageController extends HttpServlet {
    private CompanyService companyService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();

        CompanyRepository companyRepository = new CompanyRepository(dbProvider);
        CompanyConverter companyConverter = new CompanyConverter();
        companyService = new CompanyService(companyRepository, companyConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        CompanyDto companyDto = companyService.findById(id).orElseGet(CompanyDto::new);
        req.setAttribute("company", companyDto);
        req.getRequestDispatcher("/WEB-INF/jsp/company/companyUpdate.jsp").forward(req, resp);
    }
}
