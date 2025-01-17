package com.project.dani.library_app.controller.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.project.dani.library_app.entity.locality.City;
import com.project.dani.library_app.service.locality.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/city")
@Validated
@Tag(name = "City", description = "Endpoints of City")
public class CityController {

    @Autowired
    private CityService cityService;

    // ------------------
    // CREATE ENDPOINT
    // ------------------
    @Operation(summary = "Create a new City", description = "Create a new city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success",
                    content = {@Content}),
            @ApiResponse(responseCode = "400", description = "bad request",
                    content = {@Content}),
            @ApiResponse(responseCode = "401", description = "unauthorized",
                    content = {@Content})})
    @PostMapping
    public City createCity(@Valid @RequestBody City city) {
        return cityService.save(city);
    }

    // ------------------
    // READ ENDPOINTS
    // ------------------
    @Operation(summary = "Get city by id", description = "Get city by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success",
                    content = {@Content}),
            @ApiResponse(responseCode = "204", description = "no content",
                    content = {@Content}),
            @ApiResponse(responseCode = "400", description = "bad request",
                    content = {@Content}),
            @ApiResponse(responseCode = "401", description = "unauthorized",
                    content = {@Content})})
    @GetMapping("id/{id}")
    public Optional<City> readById(@Valid @PathVariable Long id) {
        return cityService.findById(id);
    }

    @Operation(summary = "Get city by name", description = "Get city by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success",
                    content = {@Content}),
            @ApiResponse(responseCode = "204", description = "no content",
                    content = {@Content}),
            @ApiResponse(responseCode = "400", description = "bad request",
                    content = {@Content}),
            @ApiResponse(responseCode = "401", description = "unauthorized",
                    content = {@Content})})
    @GetMapping("name/{name}")
    public List<City> readByName(@PathVariable String name) {
        return cityService.findByNameContains(name);
    }

    @Operation(summary = "Get all cities", description = "Get all cities")
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400",
                    content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401",
                    content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = {@Content}),
            @ApiResponse(description = "Internal error", responseCode = "500",
                    content = {@Content})})
    @GetMapping("all")
    public List<City> readAll() {
        return cityService.findAll();
    }

    @Operation(summary = "Get all cities sorted ascending by name",
            description = "Get all cities sorted ascending by name")
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400",
                    content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401",
                    content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = {@Content}),
            @ApiResponse(description = "Internal error", responseCode = "500",
                    content = {@Content})})
    @GetMapping("all-asc")
    public List<City> readAllOrderByNameAsc() {
        return cityService.findAllOrderByNameAsc();
    }

    @Operation(summary = "Get all cities sorted descending by name",
            description = "Get all cities sorted descending by name")
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400",
                    content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401",
                    content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = {@Content}),
            @ApiResponse(description = "Internal error", responseCode = "500",
                    content = {@Content})})
    @GetMapping("all-desc")
    public List<City> readAllOrderByNameDesc() {
        return cityService.findAllOrderByNameDesc();
    }

    // ------------------
    // UPDATE ENDPOINT
    // ------------------
    @Operation(summary = "Update city by id", description = "Update city by id")
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400",
                    content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401",
                    content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = {@Content}),
            @ApiResponse(description = "Internal error", responseCode = "500",
                    content = {@Content})})
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("id/{id}")
    public Optional<City> updateCity(@Valid @PathVariable Long id, @RequestBody String name) {
        cityService.updateById(id, name);
        return cityService.findById(id);
    }

    // ------------------
    // DELETE ENDPOINTS
    // ------------------
    @Operation(summary = "Delete city by id", description = "Delete city by id")
    @ApiResponses(value = {
            @ApiResponse(description = "Bad request", responseCode = "400",
                    content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401",
                    content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = {@Content}),
            @ApiResponse(description = "Internal error", responseCode = "500",
                    content = {@Content})})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("id/{id}")
    public void deleteCityById(@Valid @PathVariable Long id) {
        cityService.deleteById(id);
    }

    @Operation(summary = "Delete all cities", description = "Delete all cities")
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400",
                    content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401",
                    content = {@Content}),
            @ApiResponse(description = "Internal error", responseCode = "500",
                    content = {@Content})})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("all")
    public void deleteAllCity() {
        cityService.deleteAll();
    }

}
