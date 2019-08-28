package net.autodata.linuxtest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//talk to the database
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    //custom query to search contacts by id or name
    Contact findByName(String name);
}
