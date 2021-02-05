package animal;

/**
 * Represents an Amphibian which inherits from the abstract animal class.
 *
 * @author quaydragon
 *
 */
public class Amphibian extends AbstractAnimal {
  
  /**
   * Constructs an amphibian.
   * 
   * @param size this size of the amphibian
   * @param temperatureLow the lowest temperature the amphibian can tolerate
   * @param temperatureHigh the highest temperature the amphibian can tolerate
   * @param naturalFeature the preferred natural feature of the amphibian
   * @param poisonous whether the amphibian is poisonous
   * @param endangerment the endangerment status of the amphibian
   * @param canShareSpace whether the amphibian can share space
   * @param species the species of the amphibian
   * @param name the amphbians name
   */
  public Amphibian(Size size,
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
