package ncl.demo.postgres;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname") //ignore red lines
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    //setters getters and constructors
    public Customer(String _firstName, String _lastName){
        firstName = _firstName;
        lastName = _lastName;
    }
    public Customer(){}  //hibernate needs an empty constructor

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }


}
