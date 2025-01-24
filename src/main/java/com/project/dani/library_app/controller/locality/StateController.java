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
import com.project.dani.library_app.entity.locality.State;
import com.project.dani.library_app.service.locality.StateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/state")
@Validated
@Tag(name = "State", description = "Endpoints of State")
public class StateController {

        @Autowired
        private StateService stateService;

        // ------------------
        // CREATE ENDPOINT
        // ------------------
        @Operation(summary = "Create a new state", description = "Create a new state")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "success",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "400", description = "bad request",
                                        content = {@Content}),
                        @ApiResponse(responseCode = "401", description = "unauthorized",
                                        content = {@Content})})
        @PostMapping
        public State createState(@Valid @RequestBody State state) {
                stateService.save(state);
                return state;
        }

        // ------------------
        // READ ENDPOINTS
        // ------------------
        @Operation(summary = "Get state by id", description = "Get state by id",
                        tags = "State")
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
        public State readById(@Valid @PathVariable Long id) {
                return stateService.findById(id);
        }

        @Operation(summary = "Get state by name", description = "Get state by name",
                        tags = "State")
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
        public List<State> readByName(@PathVariable String name) {
                return stateService.findByNameContains(name);
        }

        @Operation(summary = "Get all states", description = "Get all states")
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
        public List<State> readAll() {
                return stateService.findAll();
        }

        @Operation(summary = "Get all states sorted ascending by name",
                        description = "Get all states sorted ascending by name")
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
        public List<State> readAllOrderByNameAsc() {
                return stateService.findAllOrderByNameAsc();
        }

        @Operation(summary = "Get all states sorted descending by name",
                        description = "Get all states sorted descending by name")
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
        public List<State> readAllOrderByNameDesc() {
                return stateService.findAllOrderByNameDesc();
        }

        // ------------------
        // UPDATE ENDPOINT
        // ------------------
        @Operation(summary = "Update state by id", description = "Update state by id")
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
        public State updateState(@Valid @PathVariable Long id, @RequestBody String name) {
                stateService.updateById(id, name);
                return stateService.findById(id);
        }

        // ------------------
        // DELETE ENDPOINTS
        // ------------------
        @Operation(summary = "Delete state by id", description = "Delete state by id")
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
        public void deleteStateById(@Valid @PathVariable Long id) {
                stateService.deleteById(id);
        }

}
