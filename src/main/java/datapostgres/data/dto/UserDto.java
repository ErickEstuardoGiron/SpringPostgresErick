package datapostgres.data.dto;

public class UserDto {

    private String name;
    private String email;
    private String edad;

    public UserDto() {}

    public UserDto(String name, String email, String edad) {
        this.name = name;
        this.email = email;
        this.edad = edad;
    }

    // Getters and setters
}