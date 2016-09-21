package controller;

import model.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class ClientController{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Client>  listClient(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        List<Client> clients = clientService.getAllClients();
        return clients;
    }
//    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        ClientService clientService = (ClientService) context.getBean("clientService");
//        List<Client> clients = clientService.getAllClients();
//        Map<String, List<Client>> data = new HashMap<String, List<Client>>();
//        data.put("clients", clients);
//        return new ModelAndView("clients", data);
//    }
}