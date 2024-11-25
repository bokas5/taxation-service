package org.paurus.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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
    public TaxationResponse calculateWinningsTaxation(TaxationRequest request) {
        return taxationService.calculateWinningsTaxation(request);
    }
}
