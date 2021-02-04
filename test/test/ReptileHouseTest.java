package test;

import static org.junit.Assert.assertEquals;

import animal.Animal;
import animal.Endangerment;
import animal.NaturalFeature;
import animal.Reptile;
import animal.Size;
import org.junit.Before;
import org.junit.Test;



public class ReptileHouseTest {
  public Animal lilyLizard;
  
  
  
  @Before
  public void setUp() {
    lilyLizard = new Reptile(Size.SMALL,
        40,
        80,
        NaturalFeature.LILYPOOL,
        false,
        Endangerment.FINE,
        true);
  }
  
  //TODO: Remove getter tests
  
  @Test
  public void testTempLow() {
    assertEquals(40, lilyLizard.getTemperatureLow(), .0000004);
  }
  
  @Test
  public void testTempHigh() {
    assertEquals(80, lilyLizard.getTemperatureHigh(), .0000004);
  }
  
  @Test
  public void testNaturalFeature() {
    assertEquals(NaturalFeature.LILYPOOL, lilyLizard.getNaturalFeature());
  }
  
  @Test
  public void testPoisonous() {
    assertEquals(false, lilyLizard.getPoisonous());
  }
  
  @Test
  public void testEndangerment() {
    assertEquals(Endangerment.FINE, lilyLizard.getEndangerment());
  }
  
  @Test
  public void testSpaceSharing() {
    assertEquals(true, lilyLizard.getCanShareSpace());
  }
  
  @Test
  public void testSize() {
    assertEquals(Size.SMALL, lilyLizard.getSize());
  }
  

}
