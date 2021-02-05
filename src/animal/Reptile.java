package animal;

import animal.AbstractAnimal;
import animal.Endangerment;
import animal.NaturalFeature;
import animal.Size;

/**
 * Represents a reptile which inherits from the Abstract Animal class.
 * 
 * @author quaydragon
 *
 */
public class Reptile extends AbstractAnimal {
  
  /**
   * Constructs a reptile.
   * 
   * @param size of the reptile from Size enum
   * @param temperatureLow lowest temperature reptile can tolerate
   * @param temperatureHigh highest temperature reptile can tolerate
   * @param naturalFeature the preferred natural feature of the reptile
   * @param poisonous the boolean of whether the reptile is poisonous
   * @param endangerment the endangerment status of the reptile
   * @param canShareSpace the boolean if the reptile can share space
   * @param species what type of species the reptile is
   * @param name the name of the reptile
   */
  public Reptile(Size size,
      int temperatureLow,
      int temperatureHigh,
      NaturalFeature naturalFeature,
      boolean poisonous,
      Endangerment endangerment, 
      boolean canShareSpace,
      String species,
      String name) {
    
    super(size,
         temperatureLow,
         temperatureHigh,
         naturalFeature,
         poisonous,
         endangerment,
         canShareSpace,
         species,
         name);
  }
  

  
}



