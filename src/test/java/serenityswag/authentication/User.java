package serenityswag.authentication;

//Una "enum" es una clase especial que representa un grupo de constantes
//Limitan la creación de objetos a los explicitamente instanciados en la clase
public enum User {
    //Las constantes van en mayúsculas separadas por comas y pasamos el constructor
    STANDARD_USER("standard_user", "secret_sauce"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce"),
    PROBLEM_USER("problem_user", "secret_sauce"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce");

    //Creamos variables 'private final' para que no puedan ser modificables
    private final String username;
    private final String password;

    //Creamos el constructor de las variables
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Añadimos los getters, no se pueden añadir setters porque son constantes que no se pueden modificar
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
