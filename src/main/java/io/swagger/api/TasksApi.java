/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.57).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Task;
import io.swagger.model.TaskPage;
import io.swagger.model.TaskResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-07-03T04:30:42.818554393Z[GMT]")
@Validated
public interface TasksApi {

    @Operation(summary = "Adds a new task", description = "Adds a new task", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "task" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
        
        @ApiResponse(responseCode = "422", description = "Validation exception") })
    @RequestMapping(value = "/tasks",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.POST)
    ResponseEntity<TaskResponse> addTask(@Parameter(in = ParameterIn.DEFAULT, description = "Adds a new task", required=true, schema=@Schema()) @Valid @RequestBody Task body
);


    @Operation(summary = "Deletes a task", description = "delete a task", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "task" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid task value"),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid") })
    @RequestMapping(value = "/tasks/{taskId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTask(@Parameter(in = ParameterIn.PATH, description = "Task id to delete", required=true, schema=@Schema()) @PathVariable("taskId") Long taskId
);


    @Operation(summary = "Find task by ID", description = "Returns a single task", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "task" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
        
        @ApiResponse(responseCode = "404", description = "Task not found") })
    @RequestMapping(value = "/tasks/{taskId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<TaskResponse> getTaskById(@Parameter(in = ParameterIn.PATH, description = "ID of task to return", required=true, schema=@Schema()) @PathVariable("taskId") Long taskId
);


    @Operation(summary = "Lists tasks", description = "Lists tasks", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "task" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskPage.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
        
        @ApiResponse(responseCode = "422", description = "Validation exception") })
    @RequestMapping(value = "/tasks",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<TaskPage> listTasks(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Current page of list" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "page", required = true) Long page
, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Size of the page" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "size", required = true) Long size
, @Parameter(in = ParameterIn.QUERY, description = "Title of the task to filter" ,schema=@Schema()) @Valid @RequestParam(value = "title", required = false) String title
, @Parameter(in = ParameterIn.QUERY, description = "Description of the task to filter" ,schema=@Schema()) @Valid @RequestParam(value = "description", required = false) String description
, @Parameter(in = ParameterIn.QUERY, description = "Status of tasks to return" ,schema=@Schema()) @Valid @RequestParam(value = "status", required = false) Long status
);


    @Operation(summary = "Updates a task with form data", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "task" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid") })
    @RequestMapping(value = "/tasks/{taskId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.PATCH)
    ResponseEntity<TaskResponse> updateTaskWithForm(@Parameter(in = ParameterIn.PATH, description = "ID of task that needs to be updated", required=true, schema=@Schema()) @PathVariable("taskId") Long taskId
, @Parameter(in = ParameterIn.QUERY, description = "Title of task that needs to be updated" ,schema=@Schema()) @Valid @RequestParam(value = "title", required = false) String title
, @Parameter(in = ParameterIn.QUERY, description = "Description of task that needs to be updated" ,schema=@Schema()) @Valid @RequestParam(value = "description", required = false) String description
, @Parameter(in = ParameterIn.QUERY, description = "Status of task that needs to be updated" ,schema=@Schema()) @Valid @RequestParam(value = "status", required = false) Long status
);


    @Operation(summary = "Update an existing task", description = "Update an existing task by Id", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "task" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
        
        @ApiResponse(responseCode = "404", description = "Task not found"),
        
        @ApiResponse(responseCode = "422", description = "Validation exception") })
    @RequestMapping(value = "/tasks/{taskId}",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.PUT)
    ResponseEntity<TaskResponse> updateTask(@Parameter(in = ParameterIn.PATH, description = "ID of task to return", required=true, schema=@Schema()) @PathVariable("taskId") Long taskId
, @Parameter(in = ParameterIn.DEFAULT, description = "Update an existent task", required=true, schema=@Schema()) @Valid @RequestBody Task body
);

}

