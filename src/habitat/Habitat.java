package habitat;

import animal.NaturalFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Habitat {
  
  //TODO: Must designate if a species cannot share a space
  
  
  //TODO: Add For Location
  
  public void subtractSizeForAnimal(int animalSize);
  
  public int changeTemperature();
  
  public void addNaturalFeature(NaturalFeature naturalFeature);
  
  public NaturalFeature[] deleteNaturalFeature();
  
  
  public List<NaturalFeature> getNaturalFeatures();
  
//  public int getHabitatSize();
//  
//  public int getTemperatureOfHabitat();
//  
//  public String getLocation();
  
  public HashMap<String, Object> habitatInfo();
  
}
