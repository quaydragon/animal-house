package habitat;

import animal.NaturalFeature;

public class HabitatClass implements Habitat {
  
  private NaturalFeature[] naturalFeatures;
  private int habitatSize;
  private int temperatureOfHabitat;
  private String location;
  
  
  
  
  //TODO: Some of these methods are really unnecessary

  @Override
  public int subtractSizeForAnimal() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int changeTemperature() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public NaturalFeature[] addNaturalFeature() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public NaturalFeature[] deleteNaturalFeature() {
    // TODO Auto-generated method stub
    return null;
  }

}
