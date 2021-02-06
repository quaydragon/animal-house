package test;

import static org.junit.Assert.assertEquals;

import animal.Amphibian;
import animal.Animal;
import animal.Endangerment;
import animal.NaturalFeature;
import animal.Reptile;
import animal.Size;  
import house.ReptileHouseClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;





public class HouseTest {
  public ReptileHouseClass house;
  public Animal alligator;
  public Animal komodo;
  public Animal frog;
  public Animal lilyLizard;
  public Animal king;
  public Animal queen;

  /**
   * Sets up a reptile house.
   * 
   * @throws Exception if house not set up correctly
   */
  @Before
  public void setUp() throws Exception {
    house = new ReptileHouseClass(2);
    
    alligator = new Reptile(Size.LARGE,
        75,
        90,
        NaturalFeature.SANDYBEACH,
        true,
        Endangerment.ENDANGERED,
        false,
        "Aligator",
        "Ally");
    
    lilyLizard = new Reptile(Size.SMALL,
        40,
        80,
        NaturalFeature.FALLENLOG,
        false,
        Endangerment.FINE,
        true,
        "lily lizard",
        "Cynthia");
    
    komodo = new Reptile(Size.MEDIUM,
        40,
        80,
        NaturalFeature.LILYPOOL,
        false,
        Endangerment.EXTINCT,
        true,
        "komo komodo",
        "rupert");
    
    frog = new Amphibian(Size.MEDIUM,
        40,
        50,
        NaturalFeature.POND,
        false,
        Endangerment.FINE,
        true,
        "frogy wog",
        "shelia");
    
    king = new Reptile(Size.LARGE,
        85,
        90,
        NaturalFeature.DESSERT,
        false,
        Endangerment.FINE,
        false,
        "KING LIZARD",
        "wilbur");
    queen = new Amphibian(Size.MEDIUM,
        120,
        130,
        NaturalFeature.POND,
        false,
        Endangerment.FINE,
        false,
        "Queen Toad",
        "Franny");

  }
  

  

  @Test
  public void testAddAnimal() {
    
    house.addAnimal(alligator);
    
  }
  
  @Test
  public void testPrintSpecies() {
    house.addAnimal(alligator);
    house.addAnimal(lilyLizard);

    
    house.printSpecies();
  }
  
  @Test
  public void testPrintHabitatSign() {
    house.addAnimal(alligator);
    house.addAnimal(lilyLizard);
    house.printHabitatSigns();;
  }
  
  @Test
  public void testPrintNaturalFeatures() {
    house.addAnimal(alligator);
    house.addAnimal(lilyLizard);
    house.printNaturalFeatures();;
  }
  
  @Test
  public void testCheckForHabitat() {
    house.addAnimal(alligator);
    house.addAnimal(lilyLizard);
    house.checkForHabitat();;
  }
  
  
  
  @Test
  public void testFindHabitatForSpies() {
    house.addAnimal(alligator);
    house.addAnimal(lilyLizard);
    house.findHabitatForSpecies("lily lizard");
    house.findHabitatForSpecies("doge");
  }
  
  @Test
  public void testPrintMap() {
    house.addAnimal(alligator);
    house.addAnimal(lilyLizard);
    house.printMap();
  }
  
  

}
