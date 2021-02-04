package animal;

import animal.AbstractAnimal;
import animal.Endangerment;
import animal.NaturalFeature;
import animal.Size;

public class Reptile extends AbstractAnimal {

  public Reptile(Size size,
      int temperatureLow,
      int temperatureHigh,
      NaturalFeature naturalFeature,
      boolean poisonous,
      Endangerment endangerment, 
      boolean canShareSpace) {
    
    super(size,
         temperatureLow,
         temperatureHigh,
         naturalFeature,
         poisonous,
         endangerment,
         canShareSpace);
  }
  

  
}



