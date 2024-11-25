package org.paurus.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.paurus.models.TaxationRequest;
import org.paurus.models.TaxationResponse;
import org.paurus.service.TaxationService;

@Path("/taxation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaxationResource {

    @Inject
    TaxationService taxationService;

    /**
     * Calculate general taxation for the request.
     * @param request TaxationRequest containing details.
     * @return TaxationResponse with results.
     */
    @POST
    @Operation(summary = "Calculate general taxation")
    @APIResponse(description = "Returns the general taxation calculation result")
    @Path("/general")
    public TaxationResponse calculateGeneralTaxation(TaxationRequest request) {
        return taxationService.calculateGeneralTaxation(request);
    }

    /**
     * Calculate winnings taxation for the request.
     * @param request TaxationRequest containing details.
     * @return TaxationResponse with results.
     */
    @POST
    @Path("/winnings")
    @Operation(summary = "Calculate winnings taxation")
    @APIResponse(description = "Returns the winnings taxation calculation result")
    public TaxationResponse calculateWinningsTaxation(TaxationRequest request) {
        return taxationService.calculateWinningsTaxation(request);
    }
}
