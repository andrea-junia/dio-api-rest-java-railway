package dio.desafio.apirestjavarailway.domain.controller.dto;
import dio.desafio.apirestjavarailway.domain.model.User;

public record UserDto(
        Long id,
        String name) {

    public UserDto(User model) {
        this(
                model.getId(),
                model.getName()
        );
    }

    public User toModel() {
        User model = new User();
        model.setId(this.id);
        model.setName(this.name);
        return model;
    }

}