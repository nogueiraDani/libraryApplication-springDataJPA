package com.project.dani.library_app.controller.locality;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.project.dani.library_app.entity.locality.Address;
import com.project.dani.library_app.service.locality.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/address")
@Validated
@Tag(name = "Address", description = "Address API")
public class AddressModificationController {

        @Autowired
        private AddressService addressService;

        // ------------------
        // CREATE ENDPOINT
        // ------------------

        @Operation(summary = "Create a new Address", description = "Create a new address")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @PostMapping()
        public Address createAddress(@Valid @RequestBody Address address) {
                addressService.save(address);
                return address;
        }

        // ------------------
        // UPDATE ENDPOINTS
        // ------------------
        @Operation(summary = "Update street by id", description = "Update street by id")
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
        @PutMapping("update-street/id/{id}")
        public Optional<Address> updateStreetById(@Valid @PathVariable Long id,
                        @RequestParam String street) {
                addressService.updateStreetById(id, street);
                return addressService.findById(id);
        }

        @Operation(summary = "Update number by id", description = "Update number by id")
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
        @PutMapping("update-number/id/{id}")
        public Optional<Address> updateNumberById(@Valid @PathVariable Long id,
                        @RequestParam String number) {
                addressService.updateNumberById(id, number);
                return addressService.findById(id);
        }

        @Operation(summary = "Update complement by id",
                        description = "Update complement by id")
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
        @PutMapping("update-complement/id/{id}")
        public Optional<Address> updateComplementById(@Valid @PathVariable Long id,
                        @RequestParam String complement) {
                addressService.updateComplementById(id, complement);
                return addressService.findById(id);
        }

        @Operation(summary = "Update neighborhood by id",
                        description = "Update neighborhood by id")
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
        @PutMapping("update-neighborhood/id/{id}")
        public Optional<Address> updateNeighborhoodById(@Valid @PathVariable Long id,
                        @RequestParam String neighborhood) {
                addressService.updateNeighborhoodById(id, neighborhood);
                return addressService.findById(id);
        }

        @Operation(summary = "Update zip code by id", description = "Update zip code by id")
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
        @PutMapping("update-zipCode/id/{id}")
        public Optional<Address> updateZipCodeById(@Valid @PathVariable Long id,
                        @RequestParam String zipCode) {
                addressService.updateZipCodeById(id, zipCode);
                return addressService.findById(id);
        }

        // ------------------
        // DELETE ENDPOINTS
        // ------------------
        @Operation(summary = "Delete address by id", description = "Delete address by id")
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
        public void deleteAddressById(@Valid @PathVariable Long id) {
                addressService.deleteById(id);
        }

        @Operation(summary = "Delete all addresses", description = "Delete all addresses")
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
        @DeleteMapping("all")
        public void deleteAllAddress() {
                addressService.deleteAll();
        }

}
