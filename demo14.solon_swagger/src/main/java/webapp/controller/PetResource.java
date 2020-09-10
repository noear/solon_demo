package webapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/pet")
@Produces({"application/json","application/xml"})
public class PetResource {
    static PetData petData = new PetData();

    @GET
    @Path("/{petId}")
    @Operation(summary = "aaa", tags = {"pets"}, description = "bbb", responses = {
            @ApiResponse(description = "The pet", content = @Content(schema = @Schema(implementation = Pet.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Pet not found")
    })
    public Response getPetById(@Parameter(description = "ID of pet that needs to be fatched",
            schema = @Schema(type = "integer", format = "int64", allowableValues = {"1", "2", "3"}),
            required = true) Long petId) {
        Pet tmp = null;

        if (tmp == null) {
            throw new NotFoundException("Pet not found");
        } else {
            return Response.ok().entity(tmp).build();
        }
    }
}
