package net.autodata.linuxtest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;


//annotation tells Spring that this is a controller
@RestController
public class LinuxTestController {
    //so can use ContactRepository anywhere within the controller without to instantiate it
    @Autowired
    ContactRepository contactRepository;

    //get an instance from the mocked database
//    ContactMockedData contactMockedData = ContactMockedData.getInstance();

    //annotation means any request to the root url will be handled by the index() method
    @RequestMapping("/")
    public String index(){
        return "hello there";
    }


    @RequestMapping("/contacts")
    public List<Contact> getAll(){
        return contactRepository.findAll();
    }

    //search by id method
    @RequestMapping(value ="/contacts/{id}", method= RequestMethod.GET)
    public Optional<Contact> searchById(@PathVariable (name = "id") String id){
        int contactId = Integer.parseInt(id);
        return contactRepository.findById(contactId);
    }
    //Spring mvc not able to decide which method to call from front end

   // search by name method
    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public Contact searchByName (@PathVariable (name = "name") String name){
        System.out.println("hi");
        return contactRepository.findByName(name);
    }


    @PostMapping(value = "/create/{id}")
    public Contact createContact(@PathVariable Integer id, @RequestBody Map<String, String> body){
        String name = body.get("name");
        String mobile = body.get("mobile");
        return contactRepository.save(new Contact(id, name, mobile));
    }

    @PutMapping("/update/{id}")
    public Contact updateContact(@PathVariable Integer id, @RequestBody Map<String, String> body){
        //int contactId = Integer.parseInt(id);
        Contact contact = contactRepository.findById(id).orElse(null);
     contact.setName(body.get("name"));
     contact.setMobile(body.get("mobile"));
      return contactRepository.save(contact);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteContact(@PathVariable Integer id) {
        contactRepository.deleteById(id);
        return true;
    }


}
