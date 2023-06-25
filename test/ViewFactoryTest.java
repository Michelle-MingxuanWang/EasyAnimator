import org.junit.Before;
import org.junit.Test;


import view.IView;
import view.ViewFactory;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the ViewFactory class.
 */
public class ViewFactoryTest {
  
  @Before
  public void setup() {
    // Do nothing
  }
  
  /**
   * Test the makeView method.
   */
  @Test
  public void testbuildShape() {
    IView textView = ViewFactory.makeView("text", 2);
    assertEquals(2, textView.getSpeed());
  }
}