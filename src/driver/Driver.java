package driver;


import animal.Amphibian;
import animal.Endangerment;
import animal.NaturalFeature;
import animal.Reptile;
import animal.Size;
import house.Conservatory;
import house.ReptileHouseClass;

public class Driver {
  
  public static void main(String[] args) { 

    Reptile lilyLizard = new Reptile(Size.SMALL,
        40,
        80,
        NaturalFeature.LILYPOOL,
        false,
        Endangerment.FINE,
        true,
        "lily lizard",
        "Cynthia");
    
    Reptile komododragon = new Reptile(Size.SMALL,
        30,
        60,
        NaturalFeature.FALLENLOG,
        true,
        Endangerment.FINE,
        true,
        "Komodo Dragon",
        "Drago");
    
    Amphibian toady = new Amphibian(Size.SMALL,
        75,
        90,
        NaturalFeature.FLOWINGWATER,
        true,
        Endangerment.FINE,
        true,
        "Bull Toad",
        "Mr. Frowny");
    
    
    ReptileHouseClass rh = new ReptileHouseClass(3);
    
    rh.addAnimal(lilyLizard);
    
    rh.addAnimal(komododragon);
    rh.addAnimal(toady);
    
    rh.printSpecies();
    rh.printHabitatSigns();
    rh.checkForHabitat();
    rh.printNaturalFeatures();
    
    rh.printMap();
    
  } 

}
