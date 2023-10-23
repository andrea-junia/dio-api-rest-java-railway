package dio.desafio.apirestjavarailway.domain.controller;

import dio.desafio.apirestjavarailway.domain.controller.dto.DoctorDto;
import dio.desafio.apirestjavarailway.domain.services.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/doctors")
@Tag(name = "Doctors Controller", description = "RESTful API for managing doctors.")
public record DoctorController (DoctorService doctorService) {
    @GetMapping
    @Operation(summary = "Get all doctors", description = "Retrieve a list of all registered doctors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<DoctorDto>> findAll() {
        var doctor = doctorService.findAll();
        var doctorDto = doctor.stream().map(DoctorDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(doctorDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a doctor by ID", description = "Retrieve a specific doctor based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<DoctorDto> findById(@PathVariable Long id) {
        var doctor = doctorService.findById(id);
        return ResponseEntity.ok(new DoctorDto(doctor));
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user and return the created user's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid user data provided")
    })
    public ResponseEntity<DoctorDto> create(@RequestBody DoctorDto doctorDto) {
        var doctor = doctorService.create(doctorDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(doctor.getId())
                .toUri();
        return ResponseEntity.created(location).body(new DoctorDto(doctor));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user", description = "Update the data of an existing user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "422", description = "Invalid user data provided")
    })
    public ResponseEntity<DoctorDto> update(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        var doctor = doctorService.update(id, doctorDto.toModel());
        return ResponseEntity.ok(new DoctorDto(doctor));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Delete an existing user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
