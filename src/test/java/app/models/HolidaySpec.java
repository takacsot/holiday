package app.models;

import static org.junit.Assert.*;

import java.util.Date;

import org.javalite.activeweb.DBSpec;
import org.junit.*;
import org.junit.rules.ExpectedException;

import com.google.common.collect.ImmutableMap;

public class HolidaySpec extends DBSpec {

  @Test
  public void valid() throws Exception {
    Holiday h = new Holiday();
    // a(h).shouldNotBe("valid");
    h.set("from_date", new Date(), "to_date", new Date(), "step", "s", "category", "x", "comment", "c");
    a(h).shouldBe("valid");
  }

  @Test
  public void create_as_draft() throws Exception {
    Holiday h = Holiday.draft(ImmutableMap.<String, String> of());
    a(h.get("step")).shouldBeEqual("draft");
  }

  @Test
  public void toRequested() throws Exception {
    Holiday h = Holiday.draft(ImmutableMap.<String, String> of());
    h.toRequested();
    a(h.get("step")).shouldBeEqual("requested");
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void rejectNonRequested() throws Exception {
    expectedEx.expect(IllegalStateException.class);
    expectedEx.expectMessage("Must be in state requested");
    Holiday h = Holiday.draft(ImmutableMap.<String, String> of());
    h.reject();
  }

  @Test
  public void rejectRequested() throws Exception {
    Holiday h = Holiday.draft(ImmutableMap.<String, String> of());
    h.toRequested();
    h.reject();
    a(h.getStep()).shouldBeEqual("rejected");
  }

  @Test
  public void cancelFinalState() throws Exception {
    expectedEx.expect(IllegalStateException.class);
    expectedEx.expectMessage("Must be in state non final state");
    Holiday h = new Holiday();
    h.setStep("rejected");
    h.cancel();
  }

  @Test
  public void cancelRequested() throws Exception {
    Holiday h = Holiday.draft(ImmutableMap.<String, String> of());
    h.toRequested();
    h.cancel();
    a(h.getStep()).shouldBeEqual("canceled");
  }
  
  Holiday h = new Holiday();
  @Test
  public void confirm() throws Exception {
    h.setStep("requested");
    h.confirm();
    a(h.getStep()).shouldBeEqual("confirmed");
  }
  
  @Test
  public void non_confirmable() throws Exception {
    
  }
  
  @Test
  public void getCategory() throws Exception {
    h= new Holiday();
    assertEquals(HolidayCategory.HOLIDAY, h.getCategory());
    h.set("category", "OTHER");
    assertEquals(HolidayCategory.OTHER, h.getCategory());
  }
}
