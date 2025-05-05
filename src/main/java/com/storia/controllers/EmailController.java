package com.storia.controllers;


import com.storia.services.EmailService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmailController {


    @Inject
    EmailService emailService;

    @GET
    public Response findAll(){
        return Response.ok(emailService.findAll()).build();
    }
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")long id){
        return Response.ok(emailService.findById(id)).build();
    }

    @GET
    @Path("/read/{filter}")
    public Response readEmails(@PathParam("filter")String filter){
        return Response.ok(emailService.readEmail(filter)).build();
    }

}
