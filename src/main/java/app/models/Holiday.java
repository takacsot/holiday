package app.models;

import static com.google.common.base.Preconditions.checkState;
import static java.util.Arrays.asList;

import java.util.*;

import org.javalite.activejdbc.*;

import com.google.common.base.Preconditions;

public class Holiday extends Model {
  // create table holidays(
  // id int(11) default null auto_increment primary key,
  // user_id int(11),
  // from_date date,
  // to_date date,
  // status varchar(16),
  // category varchar(16),
  // comment varchar(2147483647)
  // );
  public Object getStep() {
    return get("step");
  }

  public void setStep(String status) {
    set("step", status);
  }

  public static Holiday draft(Map<String, String> input) {
    Holiday r = new Holiday();
    r.fromMap(input);
    r.set("step", "draft");
    return r;
  }

  public void toRequested() {
    checkState("draft".equals(get("step")), "Must be in draft status");
    set("step", "requested");
  }

  public void reject() {
    checkState("requested".equals(getStep()), "Must be in state requested");
    setStep("rejected");
  }

  public void cancel() {
    checkState(asList("requested", "draft").contains(getStep()), "Must be in state non final state");
    setStep("canceled");
  }

  public void confirm() {
    checkState("requested".equals(getStep()));
    setStep("confirmed");
  }
  
  public User getUser(){
    return super.parent(User.class);
  }

  public static LazyList<Holiday> findAllForUser(User user) {
    return where("user_id = ?", user.getId());
  }
}
