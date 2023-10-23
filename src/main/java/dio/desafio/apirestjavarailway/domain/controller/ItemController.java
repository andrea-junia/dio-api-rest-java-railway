package dio.desafio.apirestjavarailway.domain.controller;

import dio.desafio.apirestjavarailway.domain.controller.dto.ItemDto;
import dio.desafio.apirestjavarailway.domain.services.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/itens")
@Tag(name = "Itens Controller", description = "RESTful API for managing itens.")
public record ItemController (ItemService itemService) {
    @GetMapping
    @Operation(summary = "Get all itens", description = "Retrieve a list of all registered itens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<ItemDto>> findAll() {
        var item = itemService.findAll();
        var itemDto = item.stream().map(ItemDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(itemDto);
    }


}
