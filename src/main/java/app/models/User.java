package app.models;

import java.util.List;

import org.javalite.activejdbc.Model;

public class User extends Model implements AppUser {
  // id int(11) default null auto_increment primary key,
  // username varchar(128),
  // password varchar(255),
  // name varchar(128),
  // created_at datetime,
  // updated_at datetime
  static {
    validatePresenceOf("username", "name");
  }

  public static AppUser authenticate(String uname, String password) {
    List<User> users = where("username = ?", uname);
    if(users.isEmpty()){
      return new NonAuthenticatedUser();
    }
    if(!password.equals(users.get(0).get("password"))){
      return new NonAuthenticatedUser();
    }
    return users.get(0);
  }

  public boolean authorized() {
    return true;
  }
  
  @Override
  public Integer getId(){
    return (Integer)super.getId();
  }

  public static class NonAuthenticatedUser implements AppUser {
    public boolean authorized() {
      return false;
    }

    public Integer getId() {
      return -1;
    }

  }
}
