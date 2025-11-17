package cita;
class ConfiguracionInvalida extends Exception {
    public ConfiguracionInvalida(){}
    public ConfiguracionInvalida(String mensaje)
    {
        super(mensaje);
    }
}