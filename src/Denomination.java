//Updated to just return my image file name

public record Denomination(String name, double amt, String form, String img) {

    //This is what actually returns the path
    public String iconName() {
        return img;
    }
}
