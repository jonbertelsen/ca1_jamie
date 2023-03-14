package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AddressDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.Address;
import entities.Person;
import facades.PersonFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class RenameMeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static final PersonFacade personFacade =  PersonFacade.getPersonFacade(EMF);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello from Jon\"}";
    }

    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
       
        long count = FACADE.getRenameMeCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO

    }

    @GET
    @Path("persons")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons = personFacade.getAllPersons();

        return persons;
    }

    @GET
    @Path("person/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Person getPersonById(@PathParam("id") int id) {
        Person person = personFacade.getPerson(id);

        return person;
    }

    /*@POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addPerson(PersonDTO){
        RenameMeDTO rmdto = GSON.fromJson(PersonDTO), RenameMeDTO.class);
        System.out.println(rmdto);
        return Response.ok().entity(rmdto).build();
    }*/

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createPerson(String content){
        PersonDTO pd = GSON.fromJson(content, PersonDTO.class);
        Person p = personFacade.addPerson(pd.getFirstName(), pd.getLastName(), pd.getEmail());
        return Response.ok(GSON.toJson(new PersonDTO(p))).build();
    }
}
