package test;

import Decorateur.FieldName;
import Decorateur.LengthMax;
import Decorateur.NotNull;
import Decorateur.TableName;


@TableName(name = "Utilisateur")
public class UserWithDecorator {
    private int id;

    @FieldName(name = "prenom")
    @LengthMax(length = 10)
    @NotNull(errorMessage = "Firstname required")
    private String firstname;
    
    @FieldName(name = "nom")
    private String lastname;

    public UserWithDecorator(){
        this.id = 0;
        this.firstname = "";
        this.lastname = "";
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setprenom(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return this.lastname;
    }

    public void setnom(String lastname) {
        this.lastname = lastname;
    }

    public UserWithDecorator(int i, String f, String l){
        this.id = i;
        this.firstname = f;
        this.lastname = l;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("UserWithDecorator : ").append(this.id).append(" ").append(this.firstname).append(" ").append(this.lastname);
        return str.toString();
    }
}
