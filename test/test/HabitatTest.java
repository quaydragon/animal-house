package test;

import static org.junit.Assert.assertEquals;

import animal.NaturalFeature;
import habitat.Habitat;
import habitat.HabitatClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class HabitatTest {
  public Habitat habitat1;

  /**
   * Creates the habitats to be tested.
   * 
   * @throws Exception if habitat not created correctly
   */
  @Before
  public void setUp() throws Exception {
    
    habitat1 = new HabitatClass(NaturalFeature.GRASS,
        100,
        87,
        "The Grass Lands",
        true);
    
  }

  
  
  
  @Test
  public void testSubtractForAnimal() {
    assertEquals(99, habitat1.subtractSizeForAnimal(1));
  }
  
  @Test
  public void testAddNaturalFeature() {
    List<NaturalFeature> naturalFeatures = new ArrayList<NaturalFeature>();
    naturalFeatures.add(NaturalFeature.GRASS);
    naturalFeatures.add(NaturalFeature.SALTWATER);
    
    assertEquals(naturalFeatures, habitat1.addNaturalFeature(NaturalFeature.SALTWATER));
  }
  
  
  
  
  @Test
  public void testHabitatInfo() {
    
    HashMap<String, Object> habInfo = new HashMap<String, Object>();
    List<NaturalFeature> naturalFeatures = new ArrayList<NaturalFeature>();
    
    naturalFeatures.add(NaturalFeature.GRASS);
    
    habInfo.put("NaturalFeature", naturalFeatures);
    habInfo.put("Location", "The Grass Lands");
    habInfo.put("HabitatSize", 100);
    habInfo.put("Temperature", 87);
    habInfo.put("Sharing", true);
    
    assertEquals(habInfo, habitat1.habitatInfo());
  }
  
  @Test(expected = IllegalStateException.class)
  public void testTooManyNaturalFeatures() {
    habitat1.addNaturalFeature(NaturalFeature.SALTWATER);
    habitat1.addNaturalFeature(NaturalFeature.DESSERT);
    habitat1.addNaturalFeature(NaturalFeature.FLOWINGWATER);
  }
  
  

}
