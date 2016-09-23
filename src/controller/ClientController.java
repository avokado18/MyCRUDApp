package controller;

import model.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import service.ClientService;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Client>  listClient(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        List<Client> clients = clientService.getAllClients();
        return clients;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client  clientById(@PathVariable(value = "id") String id){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        Client client = clientService.getClientById(Integer.parseInt(id));
        return client;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Client createClient(@RequestBody Client client){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        clientService.addClient(client);
        return client;
    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String updateClient(@PathVariable(value = "id") String id){
        System.out.println(id);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        clientService.updateClient(clientService.getClientById(Integer.parseInt(id)));
        return id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteClient(@PathVariable(value = "id") String id){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        clientService.deleteClient(Integer.parseInt(id));
        return id;
    }
}