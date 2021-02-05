package animal;

public class Amphibian extends AbstractAnimal {
  
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
