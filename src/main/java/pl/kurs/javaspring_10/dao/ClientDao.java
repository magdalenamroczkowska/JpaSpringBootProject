package pl.kurs.javaspring_10.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.javaspring_10.model.Client;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long>{

    //nadpisuje generyka, klasą, którą będzie tu działać
//    ClientDao() {
//        super(Client.class);
//    }
}
