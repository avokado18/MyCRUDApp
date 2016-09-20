package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientServiceProxy");
        clientService.deleteClient(id);
        return new ModelAndView("redirect:/clients");
    }
}
//<form action="/del" method="post">
//<input type="hidden" name="id" value="<%=client.getId()%>"/>
//<input type="submit" value="Удалить"/>
//</form>