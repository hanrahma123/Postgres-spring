package ncl.demo.postgres;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transactions")
public class Transactions implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname") //ignore red lines
    private String firstName;

    @Column(name = "amount")
    private String amount;

    //setters getters and constructors
    public Transactions(String _firstName, String _amount){
        firstName = _firstName;
        amount = _amount;
    }
//    public Transactions{}  //hibernate needs an empty constructor

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return amount;
    }


}
