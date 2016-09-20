package controller;

import model.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Map;

public class AddController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")){
            return null;
        }
        else{//POST
            Client client = new Client();
            Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
            client.setId(Integer.parseInt(httpServletRequest.getParameter("Id").trim()));
            client.setSurname(httpServletRequest.getParameter("Surname"));
            client.setName(httpServletRequest.getParameter("Name"));
            client.setPatronymic(httpServletRequest.getParameter("Patronymic"));
            client.setBirthday(new SimpleDateFormat("dd-MM-yyyy").parse(httpServletRequest.getParameter("Birthday")));
            client.setAccNumber(Integer.parseInt(httpServletRequest.getParameter("AccNum").trim()));
            System.out.println(client);
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
            ClientService clientService = (ClientService) context.getBean("clientService");
            clientService.addClient(client);
            System.out.println("added");
            return new ModelAndView("redirect:/clients");
        }
    }
}