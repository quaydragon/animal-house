package habitat;

import animal.NaturalFeature;

public interface Habitat {
  
  
  //TODO: Add For Location
  
  public int subtractSizeForAnimal();
  
  public int changeTemperature();
  
  public NaturalFeature[] addNaturalFeature();
  
  public NaturalFeature[] deleteNaturalFeature();
  
  
}
