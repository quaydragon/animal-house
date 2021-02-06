package test;

import static org.junit.Assert.assertEquals;

import driver.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DriverTest {
  public Driver drive;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }



  @Test
  public void test() {
    String[] args;
    drive = new Driver();
    drive.main(null);
    
  }

}
