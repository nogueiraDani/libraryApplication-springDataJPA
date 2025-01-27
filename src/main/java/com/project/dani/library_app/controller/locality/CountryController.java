package com.project.dani.library_app.controller.locality;

import java.util.List;
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
import com.project.dani.library_app.entity.locality.Country;
import com.project.dani.library_app.service.locality.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/country")
@Validated
@Tag(name = "Country", description = "Endpoints of Country")
public class CountryController {

        @Autowired
        private CountryService countryService;

        // ------------------
        // CREATE ENDPOINT
        // ------------------
        @Operation(summary = "Create a new country", description = "Create a new country")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @PostMapping
        public Country createCountry(@Valid @RequestBody Country country) {
                countryService.save(country);
                return country;
        }

        // ------------------
        // READ ENDPOINTS
        // ------------------
        @Operation(summary = "Get country by id", description = "Get country by id")
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
        public Country readById(@Valid @PathVariable Long id) {
                return countryService.findById(id);
        }

        @Operation(summary = "Get country by name", description = "Get country by name")
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
        public List<Country> readByName(@PathVariable String name) {
                return countryService.findByNameContains(name);
        }

        @Operation(summary = "Get all countries", description = "Get all countries")
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
        public List<Country> readAll() {
                return countryService.findAll();
        }

        @Operation(summary = "Get all countries sorted ascending by name",
                        description = "Get all countries sorted ascending by name")
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
        public List<Country> readAllOrderByNameAsc() {
                return countryService.findAllOrderByNameAsc();
        }

        @Operation(summary = "Get all countries sorted descending by name",
                        description = "Get all countries sorted descending by name")
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
        public List<Country> readAllOrderByNameDesc() {
                return countryService.findAllOrderByNameDesc();
        }

        // ------------------
        // UPDATE ENDPOINT
        // ------------------
        @Operation(summary = "Update country by id", description = "Update country by id")
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
        public Country updateCountry(@Valid @PathVariable Long id,
                        @RequestBody String name) {
                countryService.updateCountryNameById(id, name);
                return countryService.findById(id);
        }

        // ------------------
        // DELETE ENDPOINTS
        // ------------------
        @Operation(summary = "Delete country by id", description = "Delete country by id")
        @ApiResponses(value = {
                        @ApiResponse(description = "No content", responseCode = "204",
                                        content = {@Content}),
                        @ApiResponse(description = "Bad request", responseCode = "400",
                                        content = {@Content}),
                        @ApiResponse(description = "Unauthorized", responseCode = "401",
                                        content = {@Content}),
                        @ApiResponse(description = "Internal error", responseCode = "500",
                                        content = {@Content})})
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("id/{id}")
        public void deleteCountryById(@Valid @PathVariable Long id) {
                countryService.deleteById(id);
        }

}
