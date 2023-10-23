package dio.desafio.apirestjavarailway.domain.controller.dto;

import dio.desafio.apirestjavarailway.domain.model.Item;

public record ItemDto(
        Long id,
        String code,
        String description) {

    public ItemDto(Item model) {
        this(
                model.getId(),
                model.getCode(),
                model.getDescription()
        );
    }

    public Item toModel() {
        Item model = new Item();
        model.setId(this.id);
        model.getCode();
        model.setDescription(this.description);
        return model;
    }

}