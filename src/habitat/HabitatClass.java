package habitat;

import animal.NaturalFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a habitat.
 * 
 * @author quaydragon
 *
 */
public class HabitatClass implements Habitat {
  private List<NaturalFeature> naturalFeatures = new ArrayList<NaturalFeature>();
  private int habitatSize;
  private int temperatureOfHabitat;
  private String location;
  private boolean sharing;
  
  /**
   * Constructs a habitat.
   *  
   * @param naturalFeature natural feature to be added to natural feature list
   * @param habitatSize the size of the habitat
   * @param temperatureOfHabitat the temperature of the habitat
   * @param location the location of the habitat
   * @param sharing whether it is a shared habitat
   */
  public HabitatClass(NaturalFeature naturalFeature, 
      int habitatSize, 
      int temperatureOfHabitat,
      String location,
      boolean sharing) {
    this.habitatSize = habitatSize;
    this.temperatureOfHabitat = temperatureOfHabitat;
    this.location = location;
    this.sharing = sharing;
    
    naturalFeatures.add(naturalFeature);
  }
  
  @Override
  public HashMap<String, Object> habitatInfo() {
    
    // Create a habit info getter that will give information to the main house
    HashMap<String, Object> habInfo = new HashMap<String, Object>();
    
    habInfo.put("NaturalFeature", naturalFeatures);
    habInfo.put("Location", this.location);
    habInfo.put("HabitatSize", this.habitatSize);
    habInfo.put("Temperature", this.temperatureOfHabitat);
    habInfo.put("Sharing", this.sharing);
    
    return habInfo;
  }

  @Override
  public void subtractSizeForAnimal(int animalSize) {
    // reduce the size of the habitat
    int habSize = this.habitatSize - animalSize;
    this.habitatSize = habSize;
  }


  @Override
  public void addNaturalFeature(NaturalFeature naturalFeature) throws IllegalArgumentException {
    
    // Cannot have more than 3 natural features
    if (this.naturalFeatures.size() >= 3) {
      throw new IllegalStateException("Cannot have a Habitat with more than 3 features.");
    }
    
    this.naturalFeatures.add(naturalFeature);
  
  }




}
