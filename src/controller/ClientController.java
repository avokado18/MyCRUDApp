package controller;

import model.Client;
import org.springframework.web.bind.annotation.*;
import service.ClientService;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController{
    ClientService clientService;

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Client>  listClient(){
        List<Client> clients = clientService.getAllClients();
        return clients;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client  clientById(@PathVariable(value = "id") String id){
        Client client = clientService.getClientById(Integer.parseInt(id));
        return client;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Client createClient(@RequestBody Client client){
        clientService.addClient(client);
        return client;
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Client updateClient(@RequestBody Client client){
        clientService.updateClient(client);
        return client;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteClient(@PathVariable(value = "id") String id){
        clientService.deleteClient(Integer.parseInt(id));
        return id;
    }
}