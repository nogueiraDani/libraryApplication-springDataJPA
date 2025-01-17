package com.project.dani.library_app.controller.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Tag(name = "Address", description = "Endpoints of Address")
public class AddressReadController {

        @Autowired
        private AddressService addressService;

        // -----------------------------
        // READ Endpoints
        // -----------------------------
        @Operation(summary = "Read all addresses by Id",
                        description = "Read all address by id")
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
        public Optional<Address> readById(@Valid @PathVariable Long id) {
                return addressService.findById(id);
        }

        @Operation(summary = "Read all addresses by street",
                        description = "Read all address by street")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("street")
        public List<Address> readByStreet(@RequestParam String street,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByStreetEquals(street);
                }

                return addressService.findByStreetContains(street);
        }

        @Operation(summary = "Read all addresses by neighborhood",
                        description = "Read all address by neighborhood")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("neighborhood")
        public List<Address> readByNeighborhood(@RequestParam String neighborhood,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByNeighborhoodEquals(neighborhood);
                }
                return addressService.findByNeighborhoodContains(neighborhood);
        }

        @Operation(summary = "Read all addresses by zip code",
                        description = "Read all address by zip code")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("zipCode")
        public List<Address> readByZipCode(@RequestParam String zipCode,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByZipCodeEquals(zipCode);
                }
                return addressService.findByZipCodeContains(zipCode);
        }

        @Operation(summary = "Read all addresses by number",
                        description = "Read all address by number")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("number")
        public List<Address> readByNumber(@RequestParam String number,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByNumberEquals(number);
                }
                return addressService.findByNumberContains(number);
        }

        @Operation(summary = "Read all addresses by complement",
                        description = "Read all address by complement")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("complement")
        public List<Address> readByComplement(@RequestParam String complement,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByComplementEquals(complement);
                }
                return addressService.findByComplementContains(complement);
        }

        // -----------------------------
        // READ All by city - Endpoints
        // -----------------------------
        @Operation(summary = "Read all addresses by city id",
                        description = "Read all address by city id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("city-id/{id}")
        public List<Address> readByCityId(@Valid @PathVariable Long id) {
                return addressService.findByCityId(id);
        }

        @Operation(summary = "Read all addresses by city name",
                        description = "Read all address by city name")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("city/{city}")
        public List<Address> readByCity(@PathVariable String city,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByCityNameEquals(city);
                }
                return addressService.findByCityNameContains(city);
        }

        // -----------------------------
        // READ All by state - Endpoints
        // -----------------------------
        @Operation(summary = "Read all addresses by state id",
                        description = "Read all address by state id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("state-id/{id}")
        public List<Address> readByStateId(@PathVariable Long id) {
                return addressService.findByStateId(id);
        }

        @Operation(summary = "Read all addresses by state name",
                        description = "Read all address by state name")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("state/{state}")
        public List<Address> readByStateContains(@PathVariable String state,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByStateNameEquals(state);
                }
                return addressService.findByStateNameContains(state);
        }


        // -----------------------------
        // READ All by city - Endpoints
        // -----------------------------
        @Operation(summary = "Read all addresses by city id",
                        description = "Read all address by city id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("country-id/{id}")
        public List<Address> readByCountryId(@Valid @PathVariable Long id) {
                return addressService.findByCountryId(id);
        }

        @Operation(summary = "Read all addresses by city name",
                        description = "Read all address by city name")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("country-contains/{country}")
        public List<Address> readByCountryContains(@PathVariable String country,
                        @RequestParam(required = false) Boolean exactMatch) {
                if (Boolean.TRUE.equals(exactMatch)) {
                        return addressService.findByCountryNameEquals(country);
                }
                return addressService.findByCountryNameContains(country);
        }

        // -----------------------------
        // READ All - Endpoints
        // -----------------------------
        @Operation(summary = "Read all addresses", description = "Read all address")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all")
        public List<Address> readAll() {
                return addressService.findAll();
        }

        // -----------------------------
        // READ All by order by Asc / Desc - Endpoints
        // -----------------------------

        // by street
        @Operation(summary = "Read all addresses order by Street Asc", description = "Read all addresses order by Street Asc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-street-asc")
        public List<Address> readAllOrderByStreetAsc() {
                return addressService.findAllOrderByStreetAsc();
        }

        @Operation(summary = "Read all addresses order by Street Desc", description = "Read all addresses order by Street Desc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-street-desc")
        public List<Address> readAllOrderByStreetDesc() {
                return addressService.findAllOrderByStreetDesc();
        }

        // by number
        @Operation(summary = "Read all addresses order by Number Asc", description = "Read all addresses order by Number Asc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-number-asc")
        public List<Address> readAllOrderByNumberAsc() {
                return addressService.findAllByOrderByNumberAsc();
        }

        @Operation(summary = "Read all addresses order by Number Desc", description = "Read all addresses order by Number Desc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-number-desc")
        public List<Address> readAllOrderByNumberDesc() {
                return addressService.findAllOrderByNumberDesc();
        }

        // by neighborhood
        @Operation(summary = "Read all addresses order by Neighborhood Asc", description = "Read all addresses order by Neighborhood Asc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-neighnorhood-asc")
        public List<Address> readAllOrderByNeighborhoodAsc() {
                return addressService.findAllOrderByNeighborhoodAsc();
        }

        @Operation(summary = "Read all addresses order by Neighborhood Desc", description = "Read all addresses order by Neighborhood Desc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-neighborhood-desc")
        public List<Address> readAllOrderByNeighborhoodDesc() {
                return addressService.findAllOrderByNeighborhoodDesc();
        }

        // by zip code
        @Operation(summary = "Read all addresses order by zip code Asc", description = "Read all addresses order by zip code Asc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-zipCode-asc")
        public List<Address> readAllOrderByZipCodeAsc() {
                return addressService.findAllOrderByZipCodeAsc();
        }

        @Operation(summary = "Read all addresses order by zip code Desc", description = "Read all addresses order by zip code Desc")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "204", description = "no content",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @GetMapping("all-by-zipCode-desc")
        public List<Address> readAllOrderByZipCodeDesc() {
                return addressService.findAllOrderByZipCodeDesc();
        }



}
