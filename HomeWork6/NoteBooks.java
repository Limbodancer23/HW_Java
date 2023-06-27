public class NoteBooks {
    private String Name;
    private int RAM; //GB
    private int HDSize; // GB
    private String Color; // Green, Blue, Red
    private String OS; // Windows, macOS, Linux
    private Boolean SecondHand = false;


    public NoteBooks(String name, int ram, int hd, String color, String OS, boolean SecondHand){
       this.Name = name; this.RAM = ram; this.HDSize = hd; this.Color = color; 
        this.OS = OS; this.SecondHand = SecondHand;
    }

    @Override
    public String toString() {
        return "RAM=" + RAM + "," + "Hard Disc=" + HDSize;
    }

    public String getName() {
        return Name;
    }

    public String getColor() {
        return Color;
    }

    public int getHDSize() {
        return HDSize;
    }

    public String getOS() {
        return OS;
    }
    public int getRAM() {
        return RAM;
    }
    public Boolean getSecondHand() {
        return SecondHand;
    }

}


