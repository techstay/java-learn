package yitian.study;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LibraryTest {
  private MyApp app;

  @BeforeTest
  public void setUp() {
    app = new MyApp();
  }

  @Test
  public void testShouldReturnTrue() {
    Assert.assertTrue(app.shouldReturnTrue(), "should return true");
  }

  @Test
  public void testShouldReturn42() {
    Assert.assertEquals(app.shouldReturn42(), 42, "should return 42");
  }

  @Test
  public void testPlus() {
    Assert.assertEquals(app.plus(5, 3), 8, "5+3=8");
  }

  @Test
  public void testWrongPlus() {
    Assert.assertEquals(app.wrongPlus(5, 3), 8, "5+3=8");
  }
}
