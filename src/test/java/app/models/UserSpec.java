package app.models;

import static org.junit.Assert.*;

import org.javalite.activeweb.DBSpec;
import org.junit.Test;

import app.models.User.NonAuthenticatedUser;

public class UserSpec extends DBSpec {

  @Test
  public void authenticate() throws Exception {
    AppUser user = User.authenticate("admin", "admin");
    assertFalse(user instanceof NonAuthenticatedUser);
  }

  @Test
  public void autchenticate_incorrect_username() throws Exception {
    AppUser user = User.authenticate("admina", "admin");
    assertTrue(user instanceof NonAuthenticatedUser);
  }

  @Test
  public void authenticate_incorrect_passwrod() throws Exception {
    AppUser user = User.authenticate("admin", "admina");
    assertTrue(user instanceof NonAuthenticatedUser);
  }
}
