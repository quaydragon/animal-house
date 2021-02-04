package habitat;

import animal.NaturalFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Habitat {
  
  
  //TODO: Add For Location
  
  public int subtractSizeForAnimal();
  
  public int changeTemperature();
  
  public NaturalFeature[] addNaturalFeature();
  
  public NaturalFeature[] deleteNaturalFeature();
  
  
  public List<NaturalFeature> getNaturalFeatures();
  
//  public int getHabitatSize();
//  
//  public int getTemperatureOfHabitat();
//  
//  public String getLocation();
  
  public HashMap<String, Object> habitatInfo();
  
}
