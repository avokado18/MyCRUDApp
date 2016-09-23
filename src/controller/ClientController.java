package controller;

import model.Client;
import org.springframework.web.bind.annotation.*;
import service.ClientService;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController{
    ClientService clientServiceCtrl;

    public void setClientService(ClientService clientServiceCtrl) {
        this.clientServiceCtrl = clientServiceCtrl;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Client>  listClient(){
        List<Client> clients = clientServiceCtrl.getAllClients();
        return clients;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client  clientById(@PathVariable(value = "id") String id){
        Client client = clientServiceCtrl.getClientById(Integer.parseInt(id));
        return client;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Client createClient(@RequestBody Client client){
        clientServiceCtrl.addClient(client);
        return client;
    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String updateClient(@PathVariable(value = "id") String id){
        clientServiceCtrl.updateClient(clientServiceCtrl.getClientById(Integer.parseInt(id)));
        return id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteClient(@PathVariable(value = "id") String id){
        clientServiceCtrl.deleteClient(Integer.parseInt(id));
        return id;
    }
}