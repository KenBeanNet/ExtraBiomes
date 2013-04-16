package extrabiomes.localization;

public enum Localization
{
    US("en_US"),
    GERMAN("de_DE"),
    FRENCH("fr_FR"),
    PORTUGAL("pt_PT"),
    BRAZIL("pt_BR"),
    ITALIAN("it_IT"),
    RUSSIAN("ru_RU");
    private final String locale;

    private Localization(String var3)
    {
        this.locale = var3;
    }

    public String filename()
    {
        return String.format("/extrabiomes/lang/%s.xml", new Object[] {this.locale});
    }

    public String locale()
    {
        return this.locale;
    }
}
