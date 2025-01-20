public record Denomination(String name,double amt, String form, String img)
{
    //Done.
    //Note: Records automatically create many functions for the final variables above.
    //Final Variables description below
    //name: String // name of the denomination. E.g. Ten Note, Five Note, Dime, Nickle, etc.
    //amt: double // The amount of money this denomination represents
    //form: String // “bill” or “coin”; This could be an enum, if you know them.
    //img: String // The string containing the image name for an image of the type of money
}
