package animal;

import animal.Endangerment;
import animal.NaturalFeature;
import habitat.Habitat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Specifies operations used by animals.
 * 
 * @author quaydragon
 *
 */
public interface Animal {
    
  /**
   * Returns the preferred natural features of the animal. 
   * 
   * @return the preferred natural features of the animal
   */
  public NaturalFeature getNaturalFeature();

  /**
   * Returns the size in meters the animal needs.
   * 
   * @return the size in meters the animal needs
   */
  public int getSizeMeters();

  /**
   * Takes in the size and location of a habitat and returns the perfect habitat for the animal.
   * 
   * @param size needed for habitat
   * @param location the habitat should be in (Based off of animal type)
   * @return the perfect habitat for the animal
   */
  public Habitat makePerfectHabitat(int size, String location);
  
  /**
   * Returns an int that signifies the viability of a habit from its information.
   * 
   * @param habInfo gives unique habitat information.
   * @return int that signifies the viability of a habit from its information
   */
  public int habitAnimalFit(HashMap<String, Object> habInfo);
  
  /**
   * Returns the animals unique information.
   * 
   * @return the animals unique information
   */
  public HashMap<String, Object> animalInfo();

}
