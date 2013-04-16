package extrabiomes.lib;

public enum DecorationSettings$Decoration
{
    WATERLILY(".waterlily", 0),
    TREES(".trees", 0),
    FLOWERS(".flowers", 2),
    GRASS(".grass", 1),
    DEADBUSH(".deadBush", 0),
    MUSHROOMS(".mushrooms", 0),
    REEDS(".reeds", 0),
    CACTI(".cacti", 0),
    SAND(".sand", 1),
    SAND2(".sandTwo", 3),
    CLAY(".clay", 1),
    BIGMUSHROOMS(".bigMushrooms", 0);
    public final String key;
    public final int def;

    private DecorationSettings$Decoration(String var3, int var4)
    {
        this.key = var3;
        this.def = var4;
    }
}
