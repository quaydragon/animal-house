package habitat;

import animal.NaturalFeature;
import java.util.HashMap;

/**
 * Specifies habitat interface.
 * 
 * @author quaydragon
 *
 */
public interface Habitat {
  
  /**
   * Takes in animal size and subtracts it from the habitat.
   * 
   * @param animalSize subtracts the meters required for an animal
   */
  public void subtractSizeForAnimal(int animalSize);
  
  /** 
   * Adds a natural feature to the habitat.
   * 
   * @param naturalFeature the natural feature to add to the habitat.
   */
  public void addNaturalFeature(NaturalFeature naturalFeature);
 
  /**
   * Returns information about the habitat. 
   * 
   * @return information about the habitat
   */
  public HashMap<String, Object> habitatInfo();
  
}
