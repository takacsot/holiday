package app.models;

import static java.util.Arrays.asList;

import org.javalite.activejdbc.validation.ValidatorAdapter;

public class HolidayCategoryValidator extends ValidatorAdapter<Holiday> {
  
  @Override
  public void validate(Holiday m) {
    if(!asList(HolidayCategory.values()).contains(m.get("category"))){
      setMessage("Categories must be withing " + HolidayCategory.values());
    }
  }
}
